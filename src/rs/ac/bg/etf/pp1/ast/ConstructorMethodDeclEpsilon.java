// generated with ast extension for cup
// version 0.8
// 8/7/2022 23:26:43


package rs.ac.bg.etf.pp1.ast;

public class ConstructorMethodDeclEpsilon extends ConstructorMethodDecl {

    public ConstructorMethodDeclEpsilon () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstructorMethodDeclEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [ConstructorMethodDeclEpsilon]");
        return buffer.toString();
    }
}
