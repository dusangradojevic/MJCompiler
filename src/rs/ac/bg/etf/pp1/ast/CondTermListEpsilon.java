// generated with ast extension for cup
// version 0.8
// 7/7/2022 21:10:5


package rs.ac.bg.etf.pp1.ast;

public class CondTermListEpsilon extends CondTermList {

    public CondTermListEpsilon () {
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
        buffer.append("CondTermListEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [CondTermListEpsilon]");
        return buffer.toString();
    }
}