// generated with ast extension for cup
// version 0.8
// 19/7/2022 13:10:28


package rs.ac.bg.etf.pp1.ast;

public class ActParsOptEpsilon extends ActParsOpt {

    public ActParsOptEpsilon () {
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
        buffer.append("ActParsOptEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [ActParsOptEpsilon]");
        return buffer.toString();
    }
}
