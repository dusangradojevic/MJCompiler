// generated with ast extension for cup
// version 0.8
// 26/7/2022 11:20:58


package rs.ac.bg.etf.pp1.ast;

public class CondFact implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private Expr Expr;
    private RelopExprOpt RelopExprOpt;

    public CondFact (Expr Expr, RelopExprOpt RelopExprOpt) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.RelopExprOpt=RelopExprOpt;
        if(RelopExprOpt!=null) RelopExprOpt.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public RelopExprOpt getRelopExprOpt() {
        return RelopExprOpt;
    }

    public void setRelopExprOpt(RelopExprOpt RelopExprOpt) {
        this.RelopExprOpt=RelopExprOpt;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(RelopExprOpt!=null) RelopExprOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(RelopExprOpt!=null) RelopExprOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(RelopExprOpt!=null) RelopExprOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFact(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(RelopExprOpt!=null)
            buffer.append(RelopExprOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFact]");
        return buffer.toString();
    }
}
