// generated with ast extension for cup
// version 0.8
// 8/7/2022 23:26:43


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclaration extends ConstDecl {

    private Type Type;
    private ConstDef ConstDef;
    private ConstDefList ConstDefList;

    public ConstDeclaration (Type Type, ConstDef ConstDef, ConstDefList ConstDefList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstDef=ConstDef;
        if(ConstDef!=null) ConstDef.setParent(this);
        this.ConstDefList=ConstDefList;
        if(ConstDefList!=null) ConstDefList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ConstDef getConstDef() {
        return ConstDef;
    }

    public void setConstDef(ConstDef ConstDef) {
        this.ConstDef=ConstDef;
    }

    public ConstDefList getConstDefList() {
        return ConstDefList;
    }

    public void setConstDefList(ConstDefList ConstDefList) {
        this.ConstDefList=ConstDefList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstDef!=null) ConstDef.accept(visitor);
        if(ConstDefList!=null) ConstDefList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstDef!=null) ConstDef.traverseTopDown(visitor);
        if(ConstDefList!=null) ConstDefList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstDef!=null) ConstDef.traverseBottomUp(visitor);
        if(ConstDefList!=null) ConstDefList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclaration(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDef!=null)
            buffer.append(ConstDef.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDefList!=null)
            buffer.append(ConstDefList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclaration]");
        return buffer.toString();
    }
}
