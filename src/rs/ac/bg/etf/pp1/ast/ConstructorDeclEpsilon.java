// generated with ast extension for cup
// version 0.8
// 7/7/2022 18:11:34


package rs.ac.bg.etf.pp1.ast;

public class ConstructorDeclEpsilon extends ConstructorDecl {

    public ConstructorDeclEpsilon () {
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
        buffer.append("ConstructorDeclEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [ConstructorDeclEpsilon]");
        return buffer.toString();
    }
}
