package rs.ac.bg.etf.pp1;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import rs.ac.bg.etf.pp1.SemanticAnalyzer.MethodParsNum;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.mj.runtime.Code;

public class CodeGenerator extends VisitorAdaptor {

	private Obj designatorFirstItemObj = Tab.noObj;

	private Stack<List<Integer>> truePatchStack = new Stack<>();

	private Stack<List<Integer>> falsePatchStack = new Stack<>();

	private Stack<Integer> thenJumpPatchStack = new Stack<>();

	private Stack<Integer> whileBeginStack = new Stack<>();

	private Stack<Integer> whileEndStack = new Stack<>();

	private Stack<List<Integer>> breakStatementAdrStack = new Stack<>();

	private Stack<List<Integer>> continueStatementAdrStack = new Stack<>();

	private HashMap<String, Obj> programSymbols = new HashMap<>();

	private static final Obj minus1ConstObj = new Obj(Obj.Con, "constMinusOne", Tab.intType, -1, 0);

	private static final Obj num1ConstObj = new Obj(Obj.Con, "constOne", Tab.intType, 1, 0);

	private static final Obj num0ConstObj = new Obj(Obj.Con, "constZero", Tab.intType, 0, 0);

	private static void addOptArgsOnStack(String methodNameString, Object node) {
		ActPars actPars = null;
		ActParsOpt actParsOpt = null;

		if (node instanceof FactorDesignatorFuncCallOpt) {
			FuncCallOpt funcCallOpt = ((FactorDesignatorFuncCallOpt) node).getFuncCallOpt();
			if (funcCallOpt instanceof FuncCallOptNext) {
				actParsOpt = ((FuncCallOptNext) funcCallOpt).getActParsOpt();
			}
		} else if (node instanceof DesignatorStatementActPars) {
			actParsOpt = ((DesignatorStatementActPars) node).getActParsOpt();
		}

		if (actParsOpt != null && actParsOpt instanceof ActParsOptNext) {
			actPars = ((ActParsOptNext) actParsOpt).getActPars();
		}

		int argsAlreadyOnStack = 0;
		if (actPars != null) {
			argsAlreadyOnStack = 1;
			ActParsList actParsList = actPars.getActParsList();
			while (!(actParsList instanceof ActParsListEpsilon)) {
				argsAlreadyOnStack++;
				actParsList = ((ActParsListNext) actParsList).getActParsList();
			}
		}		

		MethodParsNum methodParsNum = SemanticAnalyzer.methodFormParsOptArgsMap.get(methodNameString);
		

		int argPos = argsAlreadyOnStack - methodParsNum.formParsNum;
		for (int i = argPos; i < methodParsNum.defaultValuesList.size(); ++i) {
			Code.loadConst(methodParsNum.defaultValuesList.get(i));
		}
	}

	private void generateCodeForPredefinedMethods() {
		Collection<Obj> allSymbols = Tab.currentScope.getLocals().symbols();

		for (Obj symbol : allSymbols) {

			if (symbol.getKind() != Obj.Meth) {
				continue;
			}

			symbol.setAdr(Code.pc);
			Code.put(Code.enter);
			Code.put(symbol.getLevel());
			Code.put(symbol.getLocalSymbols().size());
			Code.put(Code.load_n);

			if (symbol.getName().equals("len")) {
				Code.put(Code.arraylength);
			}

			Code.put(Code.exit);
			Code.put(Code.return_);
		}
	}

	private void storeDesignator(Obj designatorObj) {
		if (designatorObj.getKind() != Obj.Elem) {
			Code.store(designatorObj);
		} else if (designatorObj.getType() == Tab.intType) {
			Code.put(Code.astore);
		} else {
			Code.put(Code.bastore);
		}
	}

	private void loadDesignator(Obj designatorObj) {
		if (designatorObj.getKind() != Obj.Elem) {
			Code.load(designatorObj);
		} else if (designatorObj.getType() == Tab.intType) {
			Code.put(Code.aload);
		} else {
			Code.put(Code.baload);
		}
	}

	private int getRelopCode(Relop relop) {
		if (relop instanceof RelopEqualsTo) {
			return Code.eq;
		} else if (relop instanceof RelopNotEqualsTo) {
			return Code.ne;
		} else if (relop instanceof RelopGreaterThan) {
			return Code.gt;
		} else if (relop instanceof RelopGrtOrEqual) {
			return Code.ge;
		} else if (relop instanceof RelopLessThan) {
			return Code.lt;
		} else if (relop instanceof RelopLessOrEqual) {
			return Code.le;
		}

		return Code.eq;
	}

	private void fixupAddresses(List<Integer> adrsToFixupList) {
		for (Integer adrToFixup : adrsToFixupList)
			Code.fixup(adrToFixup);
	}

	private void doWhileFixup(List<Integer> adrsToPatchList, int doWhileStartAdr) {
		for (int adrToPatch : adrsToPatchList) {
			Code.put2(adrToPatch, doWhileStartAdr - Code.pc + 1);
		}
	}

	private void doWhileFixup(int adrToPatch) {
		Code.put2(adrToPatch, adrToPatch - Code.pc + 1);
	}

	@Override
	public void visit(Program program) {
		Tab.closeScope();
	}

	@Override
	public void visit(ProgramName programName) {
		generateCodeForPredefinedMethods();
		Obj programObj = Tab.find(programName.getProgramName());
		Collection<Obj> programSymbols = programObj.getLocalSymbols();

		Tab.openScope();

		for (Obj symbol : programSymbols) {
			Tab.currentScope().addToLocals(symbol);
			if (symbol.getKind() == Obj.Var) {
				Code.dataSize++;
			}
		}
	}

	@Override
	public void visit(MethodDecl methodDecl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	@Override
	public void visit(MethodName methodName) {
		String methodNameString = methodName.getMethodName();

		if (methodNameString.equals("main")) {
			Code.mainPc = Code.pc;
		}

		Obj methodObj = Tab.find(methodNameString);
		methodObj.setAdr(Code.pc);
		Code.put(Code.enter);
		Code.put(methodObj.getLevel());
		Code.put(methodObj.getLocalSymbols().size());

		Tab.openScope();

		Collection<Obj> methodSymbols = methodObj.getLocalSymbols();

		for (Obj symbol : methodSymbols) {
			Tab.currentScope.addToLocals(symbol);
		}
	}

	@Override
	public void visit(Expr expr) {
		expr.struct = expr.getTerm().struct;
	}

	@Override
	public void visit(Term term) {
		Expr termParent = null;

		if (term.getParent() instanceof Expr) {
			termParent = (Expr) term.getParent();
		}

		if (termParent != null && termParent.getMinusOpt() instanceof MinusOptNext) {
			Code.put(Code.neg);
		}

		term.struct = term.getFactor().struct;
	}

	@Override
	public void visit(AddopTermListNext addopTermListNext) {
		AddopTermListItem addopTermListItem = addopTermListNext.getAddopTermListItem();
		Addop addop = addopTermListItem.getAddop();

		if (addop instanceof AddopAdd) {
			Code.put(Code.add);
		} else if (addop instanceof AddopSub) {
			Code.put(Code.sub);
		}

		addopTermListNext.struct = addopTermListItem.struct;
	}

	@Override
	public void visit(AddopTermListItem addopTermListItem) {
		addopTermListItem.struct = addopTermListItem.getTerm().struct;
	}

	@Override
	public void visit(MulopFactorListNext mulopFactorListNext) {
		MulopFactorListItem mulopFactorListItem = mulopFactorListNext.getMulopFactorListItem();
		Mulop mulop = mulopFactorListItem.getMulop();

		if (mulop instanceof MulopMul) {
			Code.put(Code.mul);
		} else if (mulop instanceof MulopDiv) {
			Code.put(Code.div);
		} else if (mulop instanceof MulopMod) {
			Code.put(Code.rem);
		}

		mulopFactorListNext.struct = mulopFactorListItem.struct;
	}

	@Override
	public void visit(MulopFactorListItem mulopFactorListItem) {
		mulopFactorListItem.struct = mulopFactorListItem.getFactor().struct;
	}

	@Override
	public void visit(FactorDesignatorFuncCallOpt factorDesignatorFuncCallOpt) {
		Obj designatorObj = factorDesignatorFuncCallOpt.getDesignator().obj;

		if (designatorObj.getKind() == Obj.Meth) {
			String methodNameString = factorDesignatorFuncCallOpt.getDesignator().getDesignatorFirst()
					.getDesignatorName();

			addOptArgsOnStack(methodNameString, factorDesignatorFuncCallOpt);
			Code.put(Code.call);
			Code.put2(designatorObj.getAdr() - Code.pc + 1);
		} else {
			loadDesignator(designatorObj);
		}

		factorDesignatorFuncCallOpt.struct = factorDesignatorFuncCallOpt.getDesignator().obj.getType();
	}

	@Override
	public void visit(FactorConst factorConst) {
		ConstValue constValue = factorConst.getConstValue();

		Obj constObj = null;

		if (constValue instanceof NumConst) {
			constObj = new Obj(Obj.Con, "numConst", Tab.intType, ((NumConst) constValue).getNumConst(), 0);
		} else if (constValue instanceof CharConst) {
			constObj = new Obj(Obj.Con, "charConst", Tab.charType, ((CharConst) constValue).getCharConst(), 0);
		} else if (constValue instanceof BoolConst) {
			constObj = new Obj(Obj.Con, "boolConst", SemanticAnalyzer.boolType,
					((BoolConst) constValue).getBoolConst() ? 1 : 0, 0);
		}

		Code.load(constObj);

		factorConst.struct = constObj.getType();
	}

	@Override
	public void visit(FactorNew factorNew) {
		Struct newType = Tab.find(factorNew.getType().getTypeName()).getType();

		Code.put(Code.newarray);

		if (newType == Tab.intType) {
			Code.put(1);
		} else {
			Code.put(0);
		}

		factorNew.struct = newType;
	}

	@Override
	public void visit(FactorExpr factorExpr) {
		factorExpr.struct = factorExpr.getExpr().struct;
	}

	/****************************************************************************
	 ***************** VISIT METHODS FOR LOGICAL EXPRESSIONS ********************
	 ****************************************************************************/

	@Override
	public void visit(CondFact condFact) {
		int relopCode = Code.ne;

		if (condFact.getRelopExprOpt() instanceof RelopExprOptNext) {
			relopCode = getRelopCode(((RelopExprOptNext) condFact.getRelopExprOpt()).getRelop());
		}

		Code.putFalseJump(relopCode, 0);

		falsePatchStack.peek().add(Code.pc - 2);
	}

	@Override
	public void visit(LogicalOr logicalOr) {
		Code.putJump(0);
		truePatchStack.peek().add(Code.pc - 2);

		for (Integer adrForPatching : falsePatchStack.peek()) {
			Code.fixup(adrForPatching);
		}

		falsePatchStack.peek().clear();
	}

	@Override
	public void visit(RelopExprOptEpsilon RelopExprOptEpsilon) {
		loadDesignator(num0ConstObj);
	}

	/****************************************************************************
	 ******************** VISIT METHODS FOR VARIABLE ACCESS *********************
	 ****************************************************************************/

	@Override
	public void visit(Designator designator) {
		designator.obj = Tab.find(designator.getDesignatorFirst().getDesignatorName());

		if (designator.obj.getType().getKind() != Struct.Array) {
			return;
		}

		boolean isElemAccess = designator.getDesignatorList() instanceof DesignatorListNext;

		if (isElemAccess) {
			designator.obj = new Obj(Obj.Elem, "designatorElem", designator.obj.getType().getElemType());
		}
	}

	@Override
	public void visit(DesignatorStatementActPars designatorStatementActPars) {
		String methodNameString = designatorStatementActPars.getDesignator().getDesignatorFirst().getDesignatorName();
		addOptArgsOnStack(methodNameString, designatorStatementActPars);
		Code.put(Code.call);
		Code.put2(designatorStatementActPars.getDesignator().obj.getAdr() - Code.pc + 1);
	}

	@Override
	public void visit(DesignatorFirst designatorFirst) {
		String designatorName = designatorFirst.getDesignatorName();
		designatorFirstItemObj = Tab.find(designatorName);

		boolean isElemAccess = ((Designator) designatorFirst.getParent())
				.getDesignatorList() instanceof DesignatorListNext;

		if (isElemAccess) {
			loadDesignator(designatorFirstItemObj);
		}
	}

	/****************************************************************************
	 ******************** VISIT METHODS FOR INSTRUCTIONS ************************
	 ****************************************************************************/

	@Override
	public void visit(SingleStatementPrint singleStatementPrint) {
		if (singleStatementPrint.getExpr().struct == Tab.charType) {
			Code.put(Code.bprint);
		} else {
			Code.put(Code.print);
		}
	}

	@Override
	public void visit(NumConstOptNext numConstOptNext) {
		Code.load(new Obj(Obj.Con, "printNumConstNext", Tab.intType, numConstOptNext.getNumConst(), 0));
	}

	@Override
	public void visit(NumConstOptEpsilon numConstOptEpsilon) {
		Code.load(new Obj(Obj.Con, "printNumConstEpsilon", Tab.intType, 1, 0));
	}

	@Override
	public void visit(DesignatorStatementAssignop designatorStatementAssignop) {
		Obj designatorObj = designatorStatementAssignop.getDesignator().obj;
		storeDesignator(designatorObj);
	}

	@Override
	public void visit(DesignatorStatementInc designatorStatementInc) {
		if (designatorStatementInc.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}

		loadDesignator(designatorStatementInc.getDesignator().obj);
		Code.load(num1ConstObj);
		Code.put(Code.add);
		storeDesignator(designatorStatementInc.getDesignator().obj);
	}

	@Override
	public void visit(DesignatorStatementDec designatorStatementDec) {
		if (designatorStatementDec.getDesignator().obj.getKind() == Obj.Elem) {
			Code.put(Code.dup2);
		}

		loadDesignator(designatorStatementDec.getDesignator().obj);
		Code.load(num1ConstObj);
		Code.put(Code.sub);
		storeDesignator(designatorStatementDec.getDesignator().obj);
	}

	@Override
	public void visit(IfStart ifStart) {
		truePatchStack.add(new LinkedList<>());
		falsePatchStack.add(new LinkedList<>());
	}

	@Override
	public void visit(SingleStatementIfElse singleStatementIfElse) {
		Code.fixup(thenJumpPatchStack.pop());
		truePatchStack.pop();
		falsePatchStack.pop();
	}

	@Override
	public void visit(ElseStart elseStart) {
		List<Integer> adrsToPatchList = falsePatchStack.peek();
		Code.putJump(0);
		thenJumpPatchStack.push(Code.pc - 2);
		fixupAddresses(adrsToPatchList);

	}

	@Override
	public void visit(SingleStatementIf singleStatementIf) {
		List<Integer> adrsToPatchList = falsePatchStack.peek();
		fixupAddresses(adrsToPatchList);
		truePatchStack.pop();
		falsePatchStack.pop();
	}

	@Override
	public void visit(ThenStart thenStart) {
		List<Integer> adrsToPatchList = truePatchStack.peek();
		fixupAddresses(adrsToPatchList);
	}

	@Override
	public void visit(SingleStatementDoWhile singleStatementDoWhile) {
		Code.putJump(whileBeginStack.peek());
		List<Integer> adrsToPatchList = truePatchStack.pop();
		doWhileFixup(adrsToPatchList, whileBeginStack.peek());
		fixupAddresses(falsePatchStack.pop());
		fixupAddresses(breakStatementAdrStack.pop());
		continueStatementAdrStack.pop();
		whileBeginStack.pop();
		whileEndStack.pop();
	}

	@Override
	public void visit(DoWhileBegin doWhileBegin) {
		whileBeginStack.push(Code.pc);
		breakStatementAdrStack.push(new LinkedList<>());
		continueStatementAdrStack.push(new LinkedList<>());
		truePatchStack.push(new LinkedList<>());
		falsePatchStack.push(new LinkedList<>());
	}

	@Override
	public void visit(DoWhileEnd doWhileEnd) {
		whileEndStack.push(Code.pc);
		List<Integer> adrsToPatchList = continueStatementAdrStack.peek();
		fixupAddresses(adrsToPatchList);
		adrsToPatchList.clear();
	}

	@Override
	public void visit(SingleStatementBreak singleStatementBreak) {
		Code.putJump(Code.pc);
		breakStatementAdrStack.peek().add(Code.pc - 2);
	}

	@Override
	public void visit(SingleStatementContinue singleStatementContinue) {
		Code.putJump(Code.pc);
		continueStatementAdrStack.peek().add(Code.pc - 2);
	}

	@Override
	public void visit(SingleStatementReturn singleStatementReturn) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}

	@Override
	public void visit(SingleStatementRead singleStatementRead) {
		Obj designatorObj = singleStatementRead.getDesignator().obj;
		if (designatorObj.getType() == Tab.intType) {
			Code.put(Code.read);
		} else {
			Code.put(Code.bread);
		}
		storeDesignator(designatorObj);
	}
}
