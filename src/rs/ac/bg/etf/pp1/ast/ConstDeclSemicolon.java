// generated with ast extension for cup
// version 0.8
// 7/7/2022 17:3:18


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclSemicolon extends ConstDecl {

    public ConstDeclSemicolon () {
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
        buffer.append("ConstDeclSemicolon(\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclSemicolon]");
        return buffer.toString();
    }
}
