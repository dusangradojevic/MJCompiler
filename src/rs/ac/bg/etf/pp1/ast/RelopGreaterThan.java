// generated with ast extension for cup
// version 0.8
// 25/7/2022 16:58:3


package rs.ac.bg.etf.pp1.ast;

public class RelopGreaterThan extends Relop {

    public RelopGreaterThan () {
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
        buffer.append("RelopGreaterThan(\n");

        buffer.append(tab);
        buffer.append(") [RelopGreaterThan]");
        return buffer.toString();
    }
}
