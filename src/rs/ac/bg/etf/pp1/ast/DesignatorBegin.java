// generated with ast extension for cup
// version 0.8
// 8/7/2022 23:26:43


package rs.ac.bg.etf.pp1.ast;

public class DesignatorBegin extends Designator {

    private DesignatorFirst DesignatorFirst;

    public DesignatorBegin (DesignatorFirst DesignatorFirst) {
        this.DesignatorFirst=DesignatorFirst;
        if(DesignatorFirst!=null) DesignatorFirst.setParent(this);
    }

    public DesignatorFirst getDesignatorFirst() {
        return DesignatorFirst;
    }

    public void setDesignatorFirst(DesignatorFirst DesignatorFirst) {
        this.DesignatorFirst=DesignatorFirst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorFirst!=null) DesignatorFirst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorFirst!=null) DesignatorFirst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorFirst!=null) DesignatorFirst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorBegin(\n");

        if(DesignatorFirst!=null)
            buffer.append(DesignatorFirst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorBegin]");
        return buffer.toString();
    }
}
