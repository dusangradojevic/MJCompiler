// generated with ast extension for cup
// version 0.8
// 7/7/2022 21:10:5


package rs.ac.bg.etf.pp1.ast;

public class ConstructorMethodDeclListMultiple extends ConstructorMethodDeclList {

    private ConstructorMethodDeclList ConstructorMethodDeclList;
    private MethodDecl MethodDecl;

    public ConstructorMethodDeclListMultiple (ConstructorMethodDeclList ConstructorMethodDeclList, MethodDecl MethodDecl) {
        this.ConstructorMethodDeclList=ConstructorMethodDeclList;
        if(ConstructorMethodDeclList!=null) ConstructorMethodDeclList.setParent(this);
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
    }

    public ConstructorMethodDeclList getConstructorMethodDeclList() {
        return ConstructorMethodDeclList;
    }

    public void setConstructorMethodDeclList(ConstructorMethodDeclList ConstructorMethodDeclList) {
        this.ConstructorMethodDeclList=ConstructorMethodDeclList;
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstructorMethodDeclList!=null) ConstructorMethodDeclList.accept(visitor);
        if(MethodDecl!=null) MethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstructorMethodDeclList!=null) ConstructorMethodDeclList.traverseTopDown(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstructorMethodDeclList!=null) ConstructorMethodDeclList.traverseBottomUp(visitor);
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstructorMethodDeclListMultiple(\n");

        if(ConstructorMethodDeclList!=null)
            buffer.append(ConstructorMethodDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstructorMethodDeclListMultiple]");
        return buffer.toString();
    }
}
