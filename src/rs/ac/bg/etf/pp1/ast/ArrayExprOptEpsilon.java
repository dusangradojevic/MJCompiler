// generated with ast extension for cup
// version 0.8
// 19/7/2022 13:10:28


package rs.ac.bg.etf.pp1.ast;

public class ArrayExprOptEpsilon extends ArrayExprOpt {

    public ArrayExprOptEpsilon () {
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
        buffer.append("ArrayExprOptEpsilon(\n");

        buffer.append(tab);
        buffer.append(") [ArrayExprOptEpsilon]");
        return buffer.toString();
    }
}