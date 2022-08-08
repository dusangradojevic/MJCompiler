// generated with ast extension for cup
// version 0.8
// 8/7/2022 23:26:43


package rs.ac.bg.etf.pp1.ast;

public class OptArgsNext extends OptArgs {

    private OptArgs OptArgs;
    private Type Type;
    private OptArgsIdent OptArgsIdent;

    public OptArgsNext (OptArgs OptArgs, Type Type, OptArgsIdent OptArgsIdent) {
        this.OptArgs=OptArgs;
        if(OptArgs!=null) OptArgs.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.OptArgsIdent=OptArgsIdent;
        if(OptArgsIdent!=null) OptArgsIdent.setParent(this);
    }

    public OptArgs getOptArgs() {
        return OptArgs;
    }

    public void setOptArgs(OptArgs OptArgs) {
        this.OptArgs=OptArgs;
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
        if(OptArgs!=null) OptArgs.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(OptArgsIdent!=null) OptArgsIdent.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptArgs!=null) OptArgs.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(OptArgsIdent!=null) OptArgsIdent.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptArgs!=null) OptArgs.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(OptArgsIdent!=null) OptArgsIdent.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptArgsNext(\n");

        if(OptArgs!=null)
            buffer.append(OptArgs.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
        buffer.append(") [OptArgsNext]");
        return buffer.toString();
    }
}
