// generated with ast extension for cup
// version 0.8
// 26/7/2022 11:20:58


package rs.ac.bg.etf.pp1.ast;

public class ConstDefListNext extends ConstDefList {

    private ConstDefList ConstDefList;
    private ConstDef ConstDef;

    public ConstDefListNext (ConstDefList ConstDefList, ConstDef ConstDef) {
        this.ConstDefList=ConstDefList;
        if(ConstDefList!=null) ConstDefList.setParent(this);
        this.ConstDef=ConstDef;
        if(ConstDef!=null) ConstDef.setParent(this);
    }

    public ConstDefList getConstDefList() {
        return ConstDefList;
    }

    public void setConstDefList(ConstDefList ConstDefList) {
        this.ConstDefList=ConstDefList;
    }

    public ConstDef getConstDef() {
        return ConstDef;
    }

    public void setConstDef(ConstDef ConstDef) {
        this.ConstDef=ConstDef;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDefList!=null) ConstDefList.accept(visitor);
        if(ConstDef!=null) ConstDef.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDefList!=null) ConstDefList.traverseTopDown(visitor);
        if(ConstDef!=null) ConstDef.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDefList!=null) ConstDefList.traverseBottomUp(visitor);
        if(ConstDef!=null) ConstDef.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDefListNext(\n");

        if(ConstDefList!=null)
            buffer.append(ConstDefList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDef!=null)
            buffer.append(ConstDef.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDefListNext]");
        return buffer.toString();
    }
}
