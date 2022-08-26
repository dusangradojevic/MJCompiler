// generated with ast extension for cup
// version 0.8
// 25/7/2022 16:58:3


package rs.ac.bg.etf.pp1.ast;

public class FactorNew extends Factor {

    private Type Type;
    private ArrayExprOpt ArrayExprOpt;

    public FactorNew (Type Type, ArrayExprOpt ArrayExprOpt) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ArrayExprOpt=ArrayExprOpt;
        if(ArrayExprOpt!=null) ArrayExprOpt.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ArrayExprOpt getArrayExprOpt() {
        return ArrayExprOpt;
    }

    public void setArrayExprOpt(ArrayExprOpt ArrayExprOpt) {
        this.ArrayExprOpt=ArrayExprOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ArrayExprOpt!=null) ArrayExprOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ArrayExprOpt!=null) ArrayExprOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ArrayExprOpt!=null) ArrayExprOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNew(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ArrayExprOpt!=null)
            buffer.append(ArrayExprOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNew]");
        return buffer.toString();
    }
}
