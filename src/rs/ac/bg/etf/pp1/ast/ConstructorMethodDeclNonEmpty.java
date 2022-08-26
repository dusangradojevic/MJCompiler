// generated with ast extension for cup
// version 0.8
// 25/7/2022 16:58:3


package rs.ac.bg.etf.pp1.ast;

public class ConstructorMethodDeclNonEmpty extends ConstructorMethodDecl {

    private ConstructorMethodDeclList ConstructorMethodDeclList;

    public ConstructorMethodDeclNonEmpty (ConstructorMethodDeclList ConstructorMethodDeclList) {
        this.ConstructorMethodDeclList=ConstructorMethodDeclList;
        if(ConstructorMethodDeclList!=null) ConstructorMethodDeclList.setParent(this);
    }

    public ConstructorMethodDeclList getConstructorMethodDeclList() {
        return ConstructorMethodDeclList;
    }

    public void setConstructorMethodDeclList(ConstructorMethodDeclList ConstructorMethodDeclList) {
        this.ConstructorMethodDeclList=ConstructorMethodDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstructorMethodDeclList!=null) ConstructorMethodDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstructorMethodDeclList!=null) ConstructorMethodDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstructorMethodDeclList!=null) ConstructorMethodDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstructorMethodDeclNonEmpty(\n");

        if(ConstructorMethodDeclList!=null)
            buffer.append(ConstructorMethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstructorMethodDeclNonEmpty]");
        return buffer.toString();
    }
}
