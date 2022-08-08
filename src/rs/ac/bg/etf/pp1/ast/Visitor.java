// generated with ast extension for cup
// version 0.8
// 8/7/2022 23:26:43


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(ReturnType ReturnType);
    public void visit(Mulop Mulop);
    public void visit(ConstructorDecl ConstructorDecl);
    public void visit(ConstructorMethodDecl ConstructorMethodDecl);
    public void visit(Relop Relop);
    public void visit(ActParsOpt ActParsOpt);
    public void visit(MulopFactorList MulopFactorList);
    public void visit(ConditionList ConditionList);
    public void visit(CondTermList CondTermList);
    public void visit(ProgramDeclList ProgramDeclList);
    public void visit(ConstDefList ConstDefList);
    public void visit(StatementList StatementList);
    public void visit(Addop Addop);
    public void visit(NumConstOpt NumConstOpt);
    public void visit(Factor Factor);
    public void visit(ExprOpt ExprOpt);
    public void visit(OptArgsIdentList OptArgsIdentList);
    public void visit(Designator Designator);
    public void visit(ConstValue ConstValue);
    public void visit(ExtendsOpt ExtendsOpt);
    public void visit(ActParsList ActParsList);
    public void visit(FormParsIdentList FormParsIdentList);
    public void visit(ArrayDecl ArrayDecl);
    public void visit(VarDeclList VarDeclList);
    public void visit(ConstructorMethodDeclList ConstructorMethodDeclList);
    public void visit(Expr Expr);
    public void visit(FormParsOptArgsList FormParsOptArgsList);
    public void visit(DesignatorList DesignatorList);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(DesignatorFirst DesignatorFirst);
    public void visit(Statement Statement);
    public void visit(VarDecl VarDecl);
    public void visit(FormParsIdent FormParsIdent);
    public void visit(VarIdentList VarIdentList);
    public void visit(ConstDecl ConstDecl);
    public void visit(CondFact CondFact);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(OptArgs OptArgs);
    public void visit(SingleStatement SingleStatement);
    public void visit(FormPars FormPars);
    public void visit(AddopTermList AddopTermList);
    public void visit(ElseOpt ElseOpt);
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
    public void visit(DesignatorFirstSuper DesignatorFirstSuper);
    public void visit(DesignatorFirstThis DesignatorFirstThis);
    public void visit(DesignatorFirstIdent DesignatorFirstIdent);
    public void visit(DesignatorListExpr DesignatorListExpr);
    public void visit(DesignatorListField DesignatorListField);
    public void visit(DesignatorBegin DesignatorBegin);
    public void visit(DesignatorChain DesignatorChain);
    public void visit(FactorExpr FactorExpr);
    public void visit(FactorNewType FactorNewType);
    public void visit(FactorNewTypeExpr FactorNewTypeExpr);
    public void visit(FactorConst FactorConst);
    public void visit(FactorDesignatorNoActPars FactorDesignatorNoActPars);
    public void visit(FactorDesignatorActPars FactorDesignatorActPars);
    public void visit(MulopFactorListEpsilon MulopFactorListEpsilon);
    public void visit(MulopFactorListNext MulopFactorListNext);
    public void visit(Term Term);
    public void visit(AddopTermListEpsilon AddopTermListEpsilon);
    public void visit(AddopTermListNext AddopTermListNext);
    public void visit(ExprOptEpsilon ExprOptEpsilon);
    public void visit(ExprOptNext ExprOptNext);
    public void visit(ExprNoMinus ExprNoMinus);
    public void visit(ExprMinus ExprMinus);
    public void visit(CondFactNoRelop CondFactNoRelop);
    public void visit(CondFactRelop CondFactRelop);
    public void visit(CondTermListEpsilon CondTermListEpsilon);
    public void visit(CondTermListNext CondTermListNext);
    public void visit(CondTerm CondTerm);
    public void visit(ConditionListEpsilon ConditionListEpsilon);
    public void visit(ConditionListNext ConditionListNext);
    public void visit(Condition Condition);
    public void visit(ActParsOptEpsilon ActParsOptEpsilon);
    public void visit(ActParsOptNext ActParsOptNext);
    public void visit(ActParsListEpsilon ActParsListEpsilon);
    public void visit(ActParsListNext ActParsListNext);
    public void visit(ActPars ActPars);
    public void visit(DesignatorStatementDec DesignatorStatementDec);
    public void visit(DesignatorStatementInc DesignatorStatementInc);
    public void visit(DesignatorStatementActPars DesignatorStatementActPars);
    public void visit(DesignatorStatementAssignop DesignatorStatementAssignop);
    public void visit(NumConstOptEpsilon NumConstOptEpsilon);
    public void visit(NumConstOptNext NumConstOptNext);
    public void visit(ElseOptEpsilon ElseOptEpsilon);
    public void visit(ElseOptNext ElseOptNext);
    public void visit(Statements Statements);
    public void visit(SingleStatementGoto SingleStatementGoto);
    public void visit(SingleStatementPrint SingleStatementPrint);
    public void visit(SingleStatementRead SingleStatementRead);
    public void visit(SingleStatementReturn SingleStatementReturn);
    public void visit(SingleStatementContinue SingleStatementContinue);
    public void visit(SingleStatementBreak SingleStatementBreak);
    public void visit(SingleStatementDoWhile SingleStatementDoWhile);
    public void visit(SingleStatementIf SingleStatementIf);
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
    public void visit(FormParsIdentifier FormParsIdentifier);
    public void visit(FormParsFirst FormParsFirst);
    public void visit(FormParsNext FormParsNext);
    public void visit(FormParsOptArgsListEpsilon FormParsOptArgsListEpsilon);
    public void visit(FormParsOptArgsListOptArgs FormParsOptArgsListOptArgs);
    public void visit(FormParsOptArgsListFormPars FormParsOptArgsListFormPars);
    public void visit(FormParsOptArgsListAll FormParsOptArgsListAll);
    public void visit(ReturnTypeVoid ReturnTypeVoid);
    public void visit(ReturnTypeNonVoid ReturnTypeNonVoid);
    public void visit(MethodDecl MethodDecl);
    public void visit(MethodDeclListEpsilon MethodDeclListEpsilon);
    public void visit(MethodDeclListNext MethodDeclListNext);
    public void visit(ConstructorDeclaration ConstructorDeclaration);
    public void visit(ConstructorMethodDeclListMethod ConstructorMethodDeclListMethod);
    public void visit(ConstructorMethodDeclListConstructor ConstructorMethodDeclListConstructor);
    public void visit(ConstructorMethodDeclListMultiple ConstructorMethodDeclListMultiple);
    public void visit(ConstructorMethodDeclEpsilon ConstructorMethodDeclEpsilon);
    public void visit(ConstructorMethodDeclEmpty ConstructorMethodDeclEmpty);
    public void visit(ConstructorMethodDeclNonEmpty ConstructorMethodDeclNonEmpty);
    public void visit(ExtendsOptEpsilon ExtendsOptEpsilon);
    public void visit(ExtendsOptNext ExtendsOptNext);
    public void visit(ClassDecl ClassDecl);
    public void visit(ArrayDeclarationEpsilon ArrayDeclarationEpsilon);
    public void visit(ArrayDeclaration ArrayDeclaration);
    public void visit(VarDeclListEpsilon VarDeclListEpsilon);
    public void visit(VarDeclListDeclared VarDeclListDeclared);
    public void visit(VarIdentListEpsilon VarIdentListEpsilon);
    public void visit(VarIdentListDeclared VarIdentListDeclared);
    public void visit(VarIdent VarIdent);
    public void visit(VarDeclaration VarDeclaration);
    public void visit(ConstValueDerived1 ConstValueDerived1);
    public void visit(BoolConst BoolConst);
    public void visit(CharConst CharConst);
    public void visit(NumConst NumConst);
    public void visit(ConstDefListEpsilon ConstDefListEpsilon);
    public void visit(ConstDefListNext ConstDefListNext);
    public void visit(ConstDef ConstDef);
    public void visit(ConstDeclaration ConstDeclaration);
    public void visit(ProgramDeclListEpsilon ProgramDeclListEpsilon);
    public void visit(ProgramDeclListClassDecl ProgramDeclListClassDecl);
    public void visit(ProgramDeclListVarDecl ProgramDeclListVarDecl);
    public void visit(ProgramDeclListConstDecl ProgramDeclListConstDecl);
    public void visit(Program Program);

}
