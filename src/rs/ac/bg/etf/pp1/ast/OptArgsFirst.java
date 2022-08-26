// generated with ast extension for cup
// version 0.8
// 26/7/2022 11:20:58


package rs.ac.bg.etf.pp1.ast;

public class OptArgsFirst extends OptArgs {

    private Type Type;
    private OptArgsIdent OptArgsIdent;

    public OptArgsFirst (Type Type, OptArgsIdent OptArgsIdent) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.OptArgsIdent=OptArgsIdent;
        if(OptArgsIdent!=null) OptArgsIdent.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public OptArgsIdent getOptArgsIdent() {
        return OptArgsIdent;
    }

    public void setOptArgsIdent(OptArgsIdent OptArgsIdent) {
        this.OptArgsIdent=OptArgsIdent;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(OptArgsIdent!=null) OptArgsIdent.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(OptArgsIdent!=null) OptArgsIdent.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(OptArgsIdent!=null) OptArgsIdent.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptArgsFirst(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptArgsIdent!=null)
            buffer.append(OptArgsIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptArgsFirst]");
        return buffer.toString();
    }
}
