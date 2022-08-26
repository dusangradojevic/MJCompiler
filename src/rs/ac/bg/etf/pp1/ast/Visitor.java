// generated with ast extension for cup
// version 0.8
// 25/7/2022 16:58:3


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(ActParsOpt ActParsOpt);
    public void visit(FormPars FormPars);
    public void visit(MinusOpt MinusOpt);
    public void visit(Factor Factor);
    public void visit(Statement Statement);
    public void visit(ConstructorMethodDecl ConstructorMethodDecl);
    public void visit(Relop Relop);
    public void visit(CondFactList CondFactList);
    public void visit(OptArgs OptArgs);
    public void visit(MulopFactorList MulopFactorList);
    public void visit(AddopTermList AddopTermList);
    public void visit(ConstructorMethodDeclList ConstructorMethodDeclList);
    public void visit(ArrayOpt ArrayOpt);
    public void visit(NumConstOpt NumConstOpt);
    public void visit(DesignatorList DesignatorList);
    public void visit(Mulop Mulop);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(DesignatorListItem DesignatorListItem);
    public void visit(Addop Addop);
    public void visit(StatementList StatementList);
    public void visit(FuncCallOpt FuncCallOpt);
    public void visit(ReturnType ReturnType);
    public void visit(CondTermList CondTermList);
    public void visit(VarIdentList VarIdentList);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(ArrayExprOpt ArrayExprOpt);
    public void visit(ConstValue ConstValue);
    public void visit(ExtendsOpt ExtendsOpt);
    public void visit(ProgramDeclList ProgramDeclList);
    public void visit(RelopExprOpt RelopExprOpt);
    public void visit(VarDeclList VarDeclList);
    public void visit(FormParsOptArgsList FormParsOptArgsList);
    public void visit(ConstDefList ConstDefList);
    public void visit(ActParsList ActParsList);
    public void visit(SingleStatement SingleStatement);
    public void visit(ExprOpt ExprOpt);
    public void visit(MulopMod MulopMod);
    public void visit(MulopDiv MulopDiv);
    public void visit(MulopMul MulopMul);
    public void visit(AddopSub AddopSub);
    public void visit(AddopAdd AddopAdd);
    public void visit(RelopLessOrEqual RelopLessOrEqual);
    public void visit(RelopLessThan RelopLessThan);
    public void visit(RelopGrtOrEqual RelopGrtOrEqual);
    public void visit(RelopGreaterThan RelopGreaterThan);
    public void visit(RelopNotEqualsTo RelopNotEqualsTo);
    public void visit(RelopEqualsTo RelopEqualsTo);
    public void visit(Assignop Assignop);
    public void visit(Label Label);
    public void visit(DesignatorFirst DesignatorFirst);
    public void visit(DesignatorListItemArray DesignatorListItemArray);
    public void visit(DesignatorListItemIdent DesignatorListItemIdent);
    public void visit(DesignatorListEpsilon DesignatorListEpsilon);
    public void visit(DesignatorListNext DesignatorListNext);
    public void visit(Designator Designator);
    public void visit(ArrayExprOptEpsilon ArrayExprOptEpsilon);
    public void visit(ArrayExprOptNext ArrayExprOptNext);
    public void visit(FuncCallOptEpsilon FuncCallOptEpsilon);
    public void visit(FuncCallOptNext FuncCallOptNext);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorNew FactorNew);
    public void visit(FactorConst FactorConst);
    public void visit(FactorDesignatorFuncCallOpt FactorDesignatorFuncCallOpt);
    public void visit(MulopFactorListItem MulopFactorListItem);
    public void visit(MulopFactorListEpsilon MulopFactorListEpsilon);
    public void visit(MulopFactorListNext MulopFactorListNext);
    public void visit(Term Term);
    public void visit(AddopTermListItem AddopTermListItem);
    public void visit(AddopTermListEpsilon AddopTermListEpsilon);
    public void visit(AddopTermListNext AddopTermListNext);
    public void visit(MinusOptEpsilon MinusOptEpsilon);
    public void visit(MinusOptNext MinusOptNext);
    public void visit(ExprOptEpsilon ExprOptEpsilon);
    public void visit(ExprOptNext ExprOptNext);
    public void visit(Expr Expr);
    public void visit(RelopExprOptEpsilon RelopExprOptEpsilon);
    public void visit(RelopExprOptNext RelopExprOptNext);
    public void visit(LogicalAnd LogicalAnd);
    public void visit(LogicalOr LogicalOr);
    public void visit(CondFact CondFact);
    public void visit(CondFactListItem CondFactListItem);
    public void visit(CondFactListEpsilon CondFactListEpsilon);
    public void visit(CondFactListNext CondFactListNext);
    public void visit(CondTerm CondTerm);
    public void visit(CondTermListItem CondTermListItem);
    public void visit(CondTermListEpsilon CondTermListEpsilon);
    public void visit(CondTermListNext CondTermListNext);
    public void visit(Condition Condition);
    public void visit(ActParsOptEpsilon ActParsOptEpsilon);
    public void visit(ActParsOptNext ActParsOptNext);
    public void visit(ActParsListItem ActParsListItem);
    public void visit(ActParsListEpsilon ActParsListEpsilon);
    public void visit(ActParsListNext ActParsListNext);
    public void visit(ActPars ActPars);
    public void visit(DoWhileEnd DoWhileEnd);
    public void visit(DoWhileBegin DoWhileBegin);
    public void visit(ThenStart ThenStart);
    public void visit(IfStart IfStart);
    public void visit(DesignatorStatementDec DesignatorStatementDec);
    public void visit(DesignatorStatementInc DesignatorStatementInc);
    public void visit(DesignatorStatementActPars DesignatorStatementActPars);
    public void visit(DesignatorStatementAssignop DesignatorStatementAssignop);
    public void visit(NumConstOptEpsilon NumConstOptEpsilon);
    public void visit(NumConstOptNext NumConstOptNext);
    public void visit(ElseStart ElseStart);
    public void visit(Statements Statements);
    public void visit(SingleStatementGoto SingleStatementGoto);
    public void visit(SingleStatementPrint SingleStatementPrint);
    public void visit(SingleStatementRead SingleStatementRead);
    public void visit(SingleStatementReturn SingleStatementReturn);
    public void visit(SingleStatementContinue SingleStatementContinue);
    public void visit(SingleStatementBreak SingleStatementBreak);
    public void visit(SingleStatementDoWhile SingleStatementDoWhile);
    public void visit(SingleStatementIf SingleStatementIf);
    public void visit(SingleStatementIfElse SingleStatementIfElse);
    public void visit(SingleStatementDesignatorStatement SingleStatementDesignatorStatement);
    public void visit(StatementListEpsilon StatementListEpsilon);
    public void visit(StatementListNext StatementListNext);
    public void visit(StatementStatements StatementStatements);
    public void visit(StatementSingleStatement StatementSingleStatement);
    public void visit(StatementLabel StatementLabel);
    public void visit(Type Type);
    public void visit(OptArgsIdent OptArgsIdent);
    public void visit(OptArgsFirst OptArgsFirst);
    public void visit(OptArgsNext OptArgsNext);
    public void visit(FormParsIdent FormParsIdent);
    public void visit(FormParsFirst FormParsFirst);
    public void visit(FormParsNext FormParsNext);
    public void visit(FormParsOptArgsListEpsilon FormParsOptArgsListEpsilon);
    public void visit(FormParsOptArgsListOptArgs FormParsOptArgsListOptArgs);
    public void visit(FormParsOptArgsListFormPars FormParsOptArgsListFormPars);
    public void visit(FormParsOptArgsListAll FormParsOptArgsListAll);
    public void visit(ReturnTypeVoid ReturnTypeVoid);
    public void visit(ReturnTypeNonVoid ReturnTypeNonVoid);
    public void visit(MethodName MethodName);
    public void visit(MethodDecl MethodDecl);
    public void visit(MethodDeclListEpsilon MethodDeclListEpsilon);
    public void visit(MethodDeclListNext MethodDeclListNext);
    public void visit(ConstructorDecl ConstructorDecl);
    public void visit(ConstructorMethodDeclListMethod ConstructorMethodDeclListMethod);
    public void visit(ConstructorMethodDeclListConstructor ConstructorMethodDeclListConstructor);
    public void visit(ConstructorMethodDeclListMultiple ConstructorMethodDeclListMultiple);
    public void visit(ConstructorMethodDeclEpsilon ConstructorMethodDeclEpsilon);
    public void visit(ConstructorMethodDeclEmpty ConstructorMethodDeclEmpty);
    public void visit(ConstructorMethodDeclNonEmpty ConstructorMethodDeclNonEmpty);
    public void visit(ExtendsOptEpsilon ExtendsOptEpsilon);
    public void visit(ExtendsOptNext ExtendsOptNext);
    public void visit(ClassDecl ClassDecl);
    public void visit(ArrayOptEpsilon ArrayOptEpsilon);
    public void visit(ArrayOptNext ArrayOptNext);
    public void visit(VarDeclListEpsilon VarDeclListEpsilon);
    public void visit(VarDeclListDeclared VarDeclListDeclared);
    public void visit(VarIdentListEpsilon VarIdentListEpsilon);
    public void visit(VarIdentListDeclared VarIdentListDeclared);
    public void visit(VarIdent VarIdent);
    public void visit(VarDecl VarDecl);
    public void visit(ConstValueDerived1 ConstValueDerived1);
    public void visit(BoolConst BoolConst);
    public void visit(CharConst CharConst);
    public void visit(NumConst NumConst);
    public void visit(ConstDefListEpsilon ConstDefListEpsilon);
    public void visit(ConstDefListNext ConstDefListNext);
    public void visit(ConstDef ConstDef);
    public void visit(ConstDecl ConstDecl);
    public void visit(ProgramDeclListEpsilon ProgramDeclListEpsilon);
    public void visit(ProgramDeclListClassDecl ProgramDeclListClassDecl);
    public void visit(ProgramDeclListVarDecl ProgramDeclListVarDecl);
    public void visit(ProgramDeclListConstDecl ProgramDeclListConstDecl);
    public void visit(ProgramName ProgramName);
    public void visit(Program Program);

}
