// generated with ast extension for cup
// version 0.8
// 7/7/2022 21:10:5


package rs.ac.bg.etf.pp1.ast;

public class ActParsRepeatListNext extends ActParsRepeatList {

    private ActParsRepeatList ActParsRepeatList;
    private Expr Expr;

    public ActParsRepeatListNext (ActParsRepeatList ActParsRepeatList, Expr Expr) {
        this.ActParsRepeatList=ActParsRepeatList;
        if(ActParsRepeatList!=null) ActParsRepeatList.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ActParsRepeatList getActParsRepeatList() {
        return ActParsRepeatList;
    }

    public void setActParsRepeatList(ActParsRepeatList ActParsRepeatList) {
        this.ActParsRepeatList=ActParsRepeatList;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsRepeatList!=null) ActParsRepeatList.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsRepeatList!=null) ActParsRepeatList.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsRepeatList!=null) ActParsRepeatList.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsRepeatListNext(\n");

        if(ActParsRepeatList!=null)
            buffer.append(ActParsRepeatList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsRepeatListNext]");
        return buffer.toString();
    }
}
