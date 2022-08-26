package rs.ac.bg.etf.pp1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.util.StructLinkedList;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.structure.SymbolDataStructure;

public class SemanticAnalyzer extends VisitorAdaptor {

	public class MethodParsNum {
		public int formParsNum = 0;
		public int optArgsNum = 0;
		public List<Integer> defaultValuesList = new LinkedList<>();
		
		public MethodParsNum() {}
		
		public MethodParsNum(int formParsNum, int optArgsNum) {
			this.formParsNum = formParsNum;
			this.optArgsNum = optArgsNum;
		}
	}

	// Bool type init
	public static final int Bool = 5;
	public static final Struct boolType = new Struct(Bool);

	private Logger log = Logger.getLogger(getClass());

	private boolean errorDetected = false;

	private Obj currentTypeObj = Tab.noObj;

	private Struct currentTypeStruct = Tab.noType;

	private Obj currentMethod = Tab.noObj;

	private Obj designatorFirstItemObj = Tab.noObj;

	private boolean mainMethodDefined = false;

	private boolean returnInMethod = false;

	private int insideLoop = 0;

	private int ifLevel = 0;

	public static HashMap<String, MethodParsNum> methodFormParsOptArgsMap = new HashMap<>();

	/****************************************************************************
	 **************************** CONSTANTS ********************************
	 ****************************************************************************/

	private static final int MAX_LOCAL_VARS = 256;

	private static final int MAX_GLOBAL_VARS = 65536;

	private static final int MAX_CLASS_FIELDS = 65536;

	/****************************************************************************
	 ****************** CONSTRUCTOR AND PUBLIC METHODS *********************
	 ****************************************************************************/

	public SemanticAnalyzer() {
		methodFormParsOptArgsMap.put("chr", new MethodParsNum(1, 0));
		methodFormParsOptArgsMap.put("ord", new MethodParsNum(1, 0));
		methodFormParsOptArgsMap.put("len", new MethodParsNum(1, 0));
		Tab.init();
		Tab.currentScope().addToLocals(new Obj(Obj.Type, "bool", boolType));
	}

	/****************************************************************************
	 ************************* PRIVATE METHODS ****************************
	 ****************************************************************************/

	private void reportError(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" On line ").append(line);
		log.error(msg.toString());
	}

	private void reportInfo(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" On line ").append(line);
		log.info(msg.toString());
	}

	private String kindToString(int kind) {
		String strVal;

		switch (kind) {
		case Obj.Con:
			strVal = "Con";
			break;
		case Obj.Elem:
			strVal = "Elem";
			break;
		case Obj.Fld:
			strVal = "Fld";
			break;
		case Obj.Meth:
			strVal = "Meth";
			break;
		case Obj.Prog:
			strVal = "Prog";
			break;
		case Obj.Type:
			strVal = "Type";
			break;
		case Obj.Var:
			strVal = "Var";
			break;
		default:
			strVal = "Unknown";
			break;
		}

		return strVal;
	}

	private String typeToString(int type) {
		String strVal;

		switch (type) {
		case Struct.Array:
			strVal = "Array";
			break;
		case Struct.Char:
			strVal = "Char";
			break;
		case Struct.Int:
			strVal = "Int";
			break;
		case Struct.None:
			strVal = "None";
			break;
		case Bool:
			strVal = "Bool";
			break;
		default:
			strVal = "Unknown";
			break;
		}

		return strVal;
	}

	private boolean checkMethodParameters(StructLinkedList actualParsList, Obj methodObj, SyntaxNode node) {
		String methodNameString = methodObj.getName();

		MethodParsNum methodParsNum = methodFormParsOptArgsMap.get(methodNameString);

		int formParsNum = methodParsNum.formParsNum;
		int optArgsNum = methodParsNum.optArgsNum;
		int actParsNum = actualParsList.size();

		if (actParsNum < formParsNum || actParsNum > formParsNum + optArgsNum) {
			reportError("Number of parameters in function call does not match a number in function definition.", node);
			return false;
		}

		Iterator<Obj> formalParsIt = methodObj.getLocalSymbols().iterator();

		boolean compatible = true;

		for (int i = 0; i < actParsNum; ++i) {
			Struct methodCallParType = formalParsIt.next().getType();
			Struct actualParType = actualParsList.get(i);

			if (!methodCallParType.assignableTo(actualParType)) {
				reportError("Parameter type on " + (i + 1) + ". position is not compatible with actual parameter type.",
						node);
				compatible = false;
			}
		}

		return compatible;
	}
	
	private static boolean isIntegralType(Struct structType) {
		return structType.equals(Tab.intType) || structType.equals(Tab.charType);
	}

	private Struct checkIfValidExpr(Struct leftOperandType, Struct rightOperandType, SyntaxNode visitedNode) {
		Struct returnType = Tab.intType;

		if (leftOperandType == null && rightOperandType == null) {
			System.err.println("FATAL ERROR!!! Function checkIfValidExpr has null left and right parameter");
			return returnType;
		}

		if (rightOperandType == null)
			return leftOperandType;
		else if (leftOperandType == null)
			return rightOperandType;

		if (isIntegralType(leftOperandType) && isIntegralType(rightOperandType))
			return leftOperandType;
		else if (!leftOperandType.equals(Tab.noType) || !rightOperandType.equals(Tab.noType))
			reportError("Arithmetic expressions require both operands to be of type Int", visitedNode);

		return returnType;
	}

	/****************************************************************************
	 ************ VISIT METHODS FOR PROGRAM, CONSTANTS AND VARIABLES ************
	 ****************************************************************************/

	@Override
	public void visit(Program program) {
		Obj programObj = Tab.find(program.getProgramName().getProgramName());

		if (!mainMethodDefined) {
			reportError("Main method not defined.", program);
		}

		Tab.chainLocalSymbols(programObj);

		int globalVarCnt = Tab.currentScope.getnVars();

		if (globalVarCnt > MAX_GLOBAL_VARS) {
			reportError("Maximum number of allowed global variables (" + MAX_GLOBAL_VARS + ") exceeded.", program);
		}

		Tab.closeScope();
	}

	@Override
	public void visit(ProgramName programName) {
		Tab.insert(Obj.Prog, programName.getProgramName(), Tab.noType);
		Tab.openScope();
	}

	@Override
	public void visit(ConstDef constDef) {
		if (currentTypeObj == Tab.noObj) {
			return;
		}

		String constName = constDef.getConstName();

		if (Tab.find(constName) != Tab.noObj) {
			reportError("Symbol '" + constName + "' already defined.", constDef);
			return;
		}

		Struct objType = currentTypeObj.getType();
		ConstValue constValue = constDef.getConstValue();
		Struct assigningType = Tab.noType;
		int assigningValue = 0;

		if (constValue instanceof NumConst) {
			assigningType = Tab.intType;
			assigningValue = ((NumConst) constValue).getNumConst();
		} else if (constValue instanceof CharConst) {
			assigningType = Tab.charType;
			assigningValue = ((CharConst) constValue).getCharConst();
		} else if (constValue instanceof BoolConst) {
			assigningType = boolType;
			assigningValue = ((BoolConst) constValue).getBoolConst() ? 1 : 0;
		}

		if (!objType.assignableTo(assigningType)) {
			reportError("Type '" + typeToString(assigningType.getKind()) + "' not assignable to '"
					+ currentTypeObj.getName() + "'.", constDef);
			return;
		}

		Obj constObj = Tab.insert(Obj.Con, constName, objType);
		constObj.setAdr(assigningValue);
	}

	@Override
	public void visit(VarIdent varIdent) {
		String varName = varIdent.getVarName();

		if (Tab.currentScope().findSymbol(varName) != null
				|| (currentMethod != Tab.noObj && varName.equals(currentMethod.getName()))) {
			reportError("Symbol '" + varName + "' is already defined in current scope.", varIdent);
			return;
		}

		boolean isArray = (varIdent.getArrayOpt() instanceof ArrayOptNext);
		Struct objType = null;

		if (isArray) {
			objType = new Struct(Struct.Array, currentTypeObj.getType());
		} else {
			objType = currentTypeObj.getType();
		}

		Tab.insert(Obj.Var, varName, objType);
	}

	@Override
	public void visit(Type type) {
		currentTypeObj = Tab.noObj;

		String typeName = type.getTypeName();
		Obj typeObj = Tab.find(typeName);

		if (typeObj == Tab.noObj) {
			reportError("Type '" + typeName + "' not found in symbol table.", type);
			return;
		}

		if (typeObj.getKind() == Obj.Type) {
			currentTypeObj = typeObj;
		} else {
			reportError("'" + typeName + "' is not a type.", type);
		}

		currentTypeStruct = currentTypeObj.getType();
	}

	/****************************************************************************
	 ************* VISIT METHODS FOR METHODS AND PARAMETERS ***************
	 ****************************************************************************/

	@Override
	public void visit(MethodDecl methodDecl) {

		if (currentMethod != Tab.noObj) {
			Tab.chainLocalSymbols(currentMethod);
			MethodParsNum methodParsNum = methodFormParsOptArgsMap.get(currentMethod.getName());
			int currentMethodFormParsNum = methodParsNum.formParsNum + methodParsNum.optArgsNum;
			currentMethod.setLevel(currentMethodFormParsNum);
			boolean isMainMethod = currentMethod.getName().equals("main");

			if (isMainMethod && currentMethodFormParsNum != 0) {
				reportError("Main method must not have formal parameters.", methodDecl);
			}

			if (isMainMethod && currentMethod.getType() != Tab.noType) {
				reportError("Main method must return type void.", methodDecl);
			}

			if (currentMethod.getType() != Tab.noType && !returnInMethod) {
				reportError("Return statement missing.", methodDecl);
			}

			if (currentMethod.getLocalSymbols().size() > MAX_LOCAL_VARS) {
				reportError("Maximum number (" + MAX_LOCAL_VARS + ") of local variables exceeded.", methodDecl);
			}
		}

		currentMethod = Tab.noObj;
		Tab.closeScope();
	}

	@Override
	public void visit(MethodName methodName) {
		currentMethod = Tab.noObj;
		returnInMethod = false;

		String methodNameString = methodName.getMethodName();

		methodFormParsOptArgsMap.put(methodNameString, new MethodParsNum());

		if (Tab.find(methodNameString) != Tab.noObj) {
			reportError("Method name '" + methodNameString + "' already defined.", methodName);
		} else {
			currentMethod = Tab.insert(Obj.Meth, methodNameString, currentTypeStruct);
		}

		if (currentMethod != Tab.noObj) {
			mainMethodDefined = methodNameString.equals("main");
		}

		Tab.openScope();
	}

	@Override
	public void visit(ReturnTypeVoid returnTypeVoid) {
		currentTypeStruct = Tab.noType;
	}

	@Override
	public void visit(FormParsOptArgsListAll formParsOptArgsListAll) {
		if (currentMethod != Tab.noObj) {
			MethodParsNum methodParsNum = methodFormParsOptArgsMap.get(currentMethod.getName());
			int parsNum = methodParsNum.formParsNum + methodParsNum.optArgsNum;

			currentMethod.setLevel(parsNum);
			currentMethod.setLocals(Tab.currentScope.getLocals());
		}
	}

	@Override
	public void visit(FormParsIdent formParsIdent) {
		String formParName = formParsIdent.getFormParName();

		if (Tab.currentScope().findSymbol(formParName) != null || formParName.equals(currentMethod.getName())) {
			reportError("Symbol '" + formParName + "' is already defined in current scope.", formParsIdent);
			return;
		}

		boolean isArray = (formParsIdent.getArrayOpt() instanceof ArrayOptNext);
		Struct structType = null;

		if (isArray) {
			structType = new Struct(Struct.Array, currentTypeStruct);
		} else {
			structType = currentTypeStruct;
		}

		Tab.insert(Obj.Var, formParName, structType);

		String methodNameString = currentMethod.getName();

		MethodParsNum methodParsNum = methodFormParsOptArgsMap.get(methodNameString);
		methodParsNum.formParsNum++;
		methodFormParsOptArgsMap.put(methodNameString, methodParsNum);
	}

	@Override
	public void visit(OptArgsIdent optArgsIdent) {
		String optArgName = optArgsIdent.getOptArgsName();

		if (Tab.currentScope().findSymbol(optArgName) != null || optArgName.equals(currentMethod.getName())) {
			reportError("Symbol '" + optArgName + "' is already defined in current scope.", optArgsIdent);
			return;
		}

		Struct objType = currentTypeStruct;
		ConstValue constValue = optArgsIdent.getConstValue();
		Struct assigningType = Tab.noType;
		int assigningValue = 0;

		if (constValue instanceof NumConst) {
			assigningType = Tab.intType;
			assigningValue = ((NumConst) constValue).getNumConst();
		} else if (constValue instanceof CharConst) {
			assigningType = Tab.charType;
			assigningValue = ((CharConst) constValue).getCharConst();
		} else if (constValue instanceof BoolConst) {
			assigningType = boolType;
			assigningValue = ((BoolConst) constValue).getBoolConst() ? 1 : 0;
		}

		if (!objType.assignableTo(assigningType)) {
			reportError("Type '" + typeToString(assigningType.getKind()) + "' not assignable to '"
					+ currentTypeObj.getName() + "'.", optArgsIdent);
			return;
		}

		Tab.insert(Obj.Var, optArgName, objType);

		String methodNameString = currentMethod.getName();

		MethodParsNum methodParsNum = methodFormParsOptArgsMap.get(methodNameString);
		methodParsNum.optArgsNum++;
		methodParsNum.defaultValuesList.add(assigningValue);
		methodFormParsOptArgsMap.put(methodNameString, methodParsNum);
	}

	/****************************************************************************
	 ******************** VISIT METHODS FOR VARIABLE ACCESS *********************
	 ****************************************************************************/

	@Override
	public void visit(Designator designator) {
		designator.obj = designator.getDesignatorList().obj;
	}

	@Override
	public void visit(DesignatorFirst designatorFirst) {
		String designatorName = designatorFirst.getDesignatorName();

		if (Tab.find(designatorName) == Tab.noObj) {
			reportError("Symbol '" + designatorName + "' is not defined.", designatorFirst);
			return;
		}

		designatorFirstItemObj = Tab.find(designatorName);

		if (designatorFirstItemObj == Tab.noObj) {
			reportError("Symbol '" + designatorName + "' is not defined.", designatorFirst);
		}

	}

	@Override
	public void visit(DesignatorListNext designatorListNext) {
		designatorListNext.obj = Tab.noObj;

		Obj designatorObj = designatorListNext.getDesignatorList().obj;
		DesignatorListItem designatorListItem = designatorListNext.getDesignatorListItem();

		if (designatorListItem instanceof DesignatorListItemIdent) {

			if (designatorObj.getType().getKind() != Struct.Class) {
				reportError("Symbol '" + designatorObj.getName() + "' is not Class type.", designatorListNext);
				return;
			}

			String fieldName = ((DesignatorListItemIdent) designatorListItem).getDesignatorName();

			SymbolDataStructure classMembers = designatorObj.getType().getMembers();
			Obj fieldObj = classMembers.searchKey(fieldName);

			if (fieldObj == null) {
				reportError("Field '" + fieldName + "' does not exist in class '" + designatorObj.getName() + "' .",
						designatorListNext);
				return;
			}

			designatorListNext.obj = fieldObj;

		} else {

			DesignatorListItemArray designatorListItemArray = (DesignatorListItemArray) designatorListItem;

			boolean error = false;

			if (designatorListItemArray.getExpr().struct.getKind() != Struct.Int) {
				reportError("Array index is not of type Int.", designatorListNext);
				error = true;
			}

			if (designatorObj.getType().getKind() != Struct.Array) {
				reportError("Symbol '" + designatorObj.getName() + "' is not Array type.", designatorListNext);
				error = true;
			}

			if (error == true) {
				designatorListNext.obj = Tab.noObj;
				return;
			}

			String designatorName = designatorObj.getName();
			Struct designatorType = designatorObj.getType().getElemType();

			designatorListNext.obj = new Obj(Obj.Elem, designatorName, designatorType);

		}
	}

	@Override
	public void visit(DesignatorListEpsilon designatorListEpsilon) {
		designatorListEpsilon.obj = designatorFirstItemObj;
	}

	/****************************************************************************
	 **************** VISIT METHODS FOR DESIGNATOR STATEMENTS *******************
	 ****************************************************************************/

	@Override
	public void visit(DesignatorStatementAssignop designatorStatementAssignop) {
		Obj designatorObj = designatorStatementAssignop.getDesignator().obj;
		Struct designatorType = designatorObj.getType();
		Struct exprType = designatorStatementAssignop.getExpr().struct;

		if (!exprType.assignableTo(designatorType)) {
			reportError("Type '" + typeToString(exprType.getKind()) + "' not assignable to type '"
					+ typeToString(designatorType.getKind()) + "'.", designatorStatementAssignop);
		}
	}

	@Override
	public void visit(DesignatorStatementActPars designatorStatementActPars) {
		Obj designatorObj = designatorStatementActPars.getDesignator().obj;
		if (designatorObj.getKind() != Obj.Meth) {
			reportError("Symbol '" + designatorObj.getName() + "' is not a method.", designatorStatementActPars);
		}

		checkMethodParameters(designatorStatementActPars.getActParsOpt().structlinkedlist, designatorObj,
				designatorStatementActPars);
	}

	@Override
	public void visit(DesignatorStatementInc designatorStatementInc) {
		Struct designatorType = designatorStatementInc.getDesignator().obj.getType();

		if (designatorType.getKind() != Struct.Int) {
			reportError(
					"Designator type should be of type Int instead of " + typeToString(designatorType.getKind()) + ".",
					designatorStatementInc);
		}
	}

	@Override
	public void visit(DesignatorStatementDec designatorStatementDec) {
		Obj designatorObj = designatorStatementDec.getDesignator().obj;
		Struct designatorType = designatorObj.getType();

		if (designatorType.getKind() != Struct.Int) {
			reportError("Designator type should be of type Int instead of " + designatorType.getKind() + ".",
					designatorStatementDec);
		}
	}

	/****************************************************************************
	 ********************* VISIT METHODS FOR EXPRESSIONS ************************
	 ****************************************************************************/

	@Override
	public void visit(Expr expr) {
		MinusOpt minus = expr.getMinusOpt();
		expr.struct = Tab.noType;

		Struct leftOperandType = expr.getTerm().struct;

		if (minus instanceof MinusOptNext && !leftOperandType.equals(Tab.intType)) {
			reportError("Unary minus expects type Int.", expr);
			return;
		}

		Struct rightOperandType = expr.getAddopTermList().struct;

		expr.struct = checkIfValidExpr(leftOperandType, rightOperandType, expr.getTerm());
	}

	@Override
	public void visit(AddopTermListItem addopTermListItem) {
		addopTermListItem.struct = addopTermListItem.getTerm().struct;
	}

	@Override
	public void visit(AddopTermListEpsilon addopTermListEpsilon) {
		addopTermListEpsilon.struct = null;
	}

	@Override
	public void visit(AddopTermListNext addopTermListNext) {
		Struct leftOperandType = addopTermListNext.getAddopTermList().struct;
		Struct rightOperandType = addopTermListNext.getAddopTermListItem().struct;

		addopTermListNext.struct = checkIfValidExpr(leftOperandType, rightOperandType,
				addopTermListNext.getAddopTermList());
	}

	@Override
	public void visit(Term term) {
		Struct leftOperandType = term.getFactor().struct;
		Struct rightOperandType = term.getMulopFactorList().struct;
		term.struct = checkIfValidExpr(leftOperandType, rightOperandType, term);
	}

	@Override
	public void visit(MulopFactorListItem mulopFactorListItem) {
		mulopFactorListItem.struct = mulopFactorListItem.getFactor().struct;
	}

	@Override
	public void visit(MulopFactorListEpsilon mulopFactorListEpsilon) {
		mulopFactorListEpsilon.struct = null;
	}

	@Override
	public void visit(MulopFactorListNext mulopFactorListNext) {
		Struct leftOperandType = mulopFactorListNext.getMulopFactorList().struct;
		Struct rightOperandType = mulopFactorListNext.getMulopFactorListItem().struct;

		mulopFactorListNext.struct = checkIfValidExpr(leftOperandType, rightOperandType,
				mulopFactorListNext.getMulopFactorList());
	}

	@Override
	public void visit(FactorDesignatorFuncCallOpt factorDesignatorFuncCallOpt) {
		Obj methObj = factorDesignatorFuncCallOpt.getDesignator().obj;
		factorDesignatorFuncCallOpt.struct = methObj.getType();

		FuncCallOpt funcCallOpt = factorDesignatorFuncCallOpt.getFuncCallOpt();

		if (methObj.getKind() != Obj.Meth && funcCallOpt instanceof FuncCallOptNext) {
			reportError("Expected type is Meth instead of '" + typeToString(methObj.getKind()) + "'.",
					factorDesignatorFuncCallOpt);
			return;
		}

		if (methObj.getKind() != Obj.Meth) {
			return;
		}

		if (funcCallOpt instanceof FuncCallOptEpsilon) {
			int objKind = methObj.getKind();

			if (objKind != Obj.Meth) {
				System.err.println("FATAL ERROR!!! Obj kind is: '" + typeToString(objKind) + "'.");
				return;
			}

			reportError("Method '" + methObj.getName() + "' is called without actual parameters.",
					factorDesignatorFuncCallOpt);
			return;
		}

		StructLinkedList actualParsList = factorDesignatorFuncCallOpt.getFuncCallOpt().structlinkedlist;

		checkMethodParameters(actualParsList, methObj, factorDesignatorFuncCallOpt);
	}

	@Override
	public void visit(FactorConst factorConst) {
		ConstValue constValue = factorConst.getConstValue();

		if (constValue instanceof NumConst) {
			factorConst.struct = Tab.intType;
		} else if (constValue instanceof CharConst) {
			factorConst.struct = Tab.charType;
		} else if (constValue instanceof BoolConst) {
			factorConst.struct = boolType;
		} else {
			factorConst.struct = Tab.noType;
		}
	}

	@Override
	public void visit(FactorNew factorNew) {
		factorNew.struct = currentTypeStruct;
		Struct exprType = factorNew.getArrayExprOpt().struct;

		if (exprType == null) {
			System.out.println("Cao");
			if (currentTypeStruct.getKind() != Struct.Class) {
				reportError("New expects inner class.", factorNew);
			}

			return;
		}

		factorNew.struct = new Struct(Struct.Array, currentTypeStruct);

		if (exprType != Tab.intType) {
			String expectedTypeName = typeToString(Tab.intType.getKind());
			String actualTypeName = typeToString(exprType.getKind());

			if (Tab.intType.getKind() == Struct.Array) {
				expectedTypeName += " of " + typeToString(Tab.intType.getElemType().getKind());
			}
			if (exprType.getKind() == Struct.Array) {
				actualTypeName += " of " + typeToString(exprType.getElemType().getKind());
			}

			reportError("Expected type is '" + expectedTypeName + "' instead of type '" + actualTypeName + "'.",
					factorNew);
		}
	}

	@Override
	public void visit(FactorExpr factorExpr) {
		factorExpr.struct = factorExpr.getExpr().struct;
	}

	@Override
	public void visit(ExprOptNext exprOptNext) {
		exprOptNext.struct = exprOptNext.getExpr().struct;
	}

	@Override
	public void visit(ExprOptEpsilon exprOptEpsilon) {
		exprOptEpsilon.struct = Tab.noType;
	}

	/****************************************************************************
	 ***************** VISIT METHODS FOR LOGICAL EXPRESSIONS ********************
	 ****************************************************************************/

	@Override
	public void visit(Condition condition) {
        Struct leftOperandType = condition.getCondTerm().struct;
        Struct rightOperandType = condition.getCondTermList().struct;

        if (leftOperandType != boolType || rightOperandType != boolType)
            condition.struct = Tab.noType;
        else
            condition.struct = boolType;
	}

	@Override
	public void visit(CondTermListNext condTermListNext) {
		condTermListNext.struct = condTermListNext.getCondTermListItem().struct;
	}

	@Override
	public void visit(CondTermListEpsilon condTermListEpsilon) {
		condTermListEpsilon.struct = null;
	}

	@Override
	public void visit(CondTerm condTerm) {
		condTerm.struct = boolType;

		Struct leftOperandType = condTerm.getCondFact().struct;
		Struct rightOperandType = condTerm.getCondFactList().struct;

		if (rightOperandType == null) {
			return;
		}

		if (!leftOperandType.compatibleWith(rightOperandType)) {
			reportError("Type '" + typeToString(leftOperandType.getKind()) + "' is not compatible with type '"
					+ typeToString(rightOperandType.getKind()) + "'.", condTerm);
			return;
		}

	}

	@Override
	public void visit(CondFactListNext condFactListNext) {
		condFactListNext.struct = condFactListNext.getCondFactListItem().struct;
	}

	@Override
	public void visit(CondFactListEpsilon condFactListEpsilon) {
		condFactListEpsilon.struct = null;
	}

	@Override
	public void visit(CondFact condFact) {
		condFact.struct = boolType;

		Struct leftOperandType = condFact.getExpr().struct;
		Struct rightOperandType = condFact.getExpr().struct;

		if (rightOperandType == null) {
			return;
		}

		if (!leftOperandType.compatibleWith(rightOperandType)) {
			reportError("Type '" + typeToString(leftOperandType.getKind()) + "' is not compatible with type '"
					+ typeToString(rightOperandType.getKind()) + "'.", condFact);
			return;
		}

		if (condFact.getRelopExprOpt() instanceof RelopExprOptNext) {
			Relop relop = ((RelopExprOptNext) condFact.getRelopExprOpt()).getRelop();

			if (leftOperandType.isRefType() && rightOperandType.isRefType()
					&& !((relop instanceof RelopEqualsTo) || (relop instanceof RelopNotEqualsTo))) {

				reportError("Unallowed relational operator for references.", condFact);
			}
		}
	}

	@Override
	public void visit(RelopExprOptNext relopExprOptNext) {
		relopExprOptNext.struct = relopExprOptNext.getExpr().struct;
	}

	@Override
	public void visit(RelopExprOptEpsilon relopExprOptEpsilon) {
		relopExprOptEpsilon.struct = null;
	}

	@Override
	public void visit(ArrayExprOptNext arrayExprOptNext) {
		arrayExprOptNext.struct = arrayExprOptNext.getExpr().struct;
	}

	@Override
	public void visit(ArrayExprOptEpsilon arrayExprOptEpsilon) {
		arrayExprOptEpsilon.struct = null;
	}

	/****************************************************************************
	 ****************** VISIT METHODS FOR ACTUAL PARAMETERS *********************
	 ****************************************************************************/

	@Override
	public void visit(FuncCallOptNext funcCallOptNext) {
		funcCallOptNext.structlinkedlist = funcCallOptNext.getActParsOpt().structlinkedlist;
	}

	@Override
	public void visit(FuncCallOptEpsilon funcCallOptEpsilon) {
		funcCallOptEpsilon.structlinkedlist = new StructLinkedList();
	}

	@Override
	public void visit(ActParsOptNext actParsOptNext) {
		actParsOptNext.structlinkedlist = actParsOptNext.getActPars().structlinkedlist;
	}

	@Override
	public void visit(ActParsOptEpsilon actParsOptEpsilon) {
		actParsOptEpsilon.structlinkedlist = new StructLinkedList();
	}

	@Override
	public void visit(ActPars actPars) {
		Struct paramType = actPars.getExpr().struct;
		(actPars.structlinkedlist = actPars.getActParsList().structlinkedlist).addFirst(paramType);
	}

	@Override
	public void visit(ActParsListNext actParsListNext) {
		actParsListNext.structlinkedlist = actParsListNext.getActParsList().structlinkedlist;
		actParsListNext.structlinkedlist.add(actParsListNext.getActParsListItem().struct);
	}

	@Override
	public void visit(ActParsListEpsilon actParsListEpsilon) {
		actParsListEpsilon.structlinkedlist = new StructLinkedList();
	}

	@Override
	public void visit(ActParsListItem actParsListItem) {
		actParsListItem.struct = actParsListItem.getExpr().struct;
	}

	/****************************************************************************
	 ******************** VISIT METHODS FOR INSTRUCTIONS ************************
	 ****************************************************************************/

	@Override
	public void visit(DoWhileBegin doWhileBegin) {
		++insideLoop;
	}

	@Override
	public void visit(DoWhileEnd doWhileEnd) {
		--insideLoop;
	}

	@Override
	public void visit(SingleStatementBreak singleStatementBreak) {
		if (insideLoop == 0) {
			reportError("Break statement can be used only inside a loop.", singleStatementBreak);
		}
	}

	@Override
	public void visit(SingleStatementContinue singleStatementContinue) {
		if (insideLoop == 0) {
			reportError("Continue statement can be used only inside a loop.", singleStatementContinue);
		}
	}

	@Override
	public void visit(SingleStatementReturn singleStatementReturn) {
		if (currentMethod == Tab.noObj) {
			return;
		}

		Struct methodReturnType = singleStatementReturn.getExprOpt().struct;

		if (!methodReturnType.compatibleWith(currentMethod.getType())) {
			reportError(
					"Method should return type '" + typeToString(currentMethod.getType().getKind())
							+ "' instead of type '" + typeToString(methodReturnType.getKind()) + "'.",
					singleStatementReturn);
		}

		returnInMethod = returnInMethod || (ifLevel == 0);
	}

	@Override
	public void visit(SingleStatementRead singleStatementRead) {
		Obj designatorObj = singleStatementRead.getDesignator().obj;
		int designatorKind = designatorObj.getKind();
		Struct designatorType = designatorObj.getType();

		if (!(designatorKind == Obj.Var || designatorKind == Obj.Fld || designatorKind == Obj.Elem)) {
			reportError("Return should receive parameter of type variable, array or class field.", singleStatementRead);
			return;
		}

		if (!(designatorType == boolType || designatorType == Tab.intType || designatorType == Tab.charType)) {
			reportError("Variable type should be Int, Char or Bool.", singleStatementRead);
		}
	}

	@Override
	public void visit(SingleStatementPrint singleStatementPrint) {
		Struct exprType = singleStatementPrint.getExpr().struct;

		if (exprType != boolType && exprType != Tab.intType && exprType != Tab.charType) {
			reportError("Parameter type should be Int, Char or Bool.", singleStatementPrint);
			return;
		}
	}

	@Override
	public void visit(IfStart ifStart) {
		++ifLevel;
	}

	@Override
	public void visit(SingleStatementIfElse singleStatementIfElse) {
		--ifLevel;
	}

	@Override
	public void visit(SingleStatementIf singleStatementIf) {
		--ifLevel;
	}
}
