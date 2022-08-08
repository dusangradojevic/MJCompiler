// generated with ast extension for cup
// version 0.8
// 8/7/2022 23:26:43


package rs.ac.bg.etf.pp1.ast;

public class ExtendsOptEpsilon extends ExtendsOpt {

    public ExtendsOptEpsilon () {
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
        buffer.append("ExtendsOptEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [ExtendsOptEpsilon]");
        return buffer.toString();
    }
}
