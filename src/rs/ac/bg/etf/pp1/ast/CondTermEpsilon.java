// generated with ast extension for cup
// version 0.8
// 7/7/2022 17:1:33


package rs.ac.bg.etf.pp1.ast;

public class CondTermEpsilon extends CondTerm {

    public CondTermEpsilon () {
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
        buffer.append("CondTermEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [CondTermEpsilon]");
        return buffer.toString();
    }
}
