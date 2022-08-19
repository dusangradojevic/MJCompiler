// generated with ast extension for cup
// version 0.8
// 19/7/2022 13:10:28


package rs.ac.bg.etf.pp1.ast;

public class DesignatorListNext extends DesignatorList {

    private DesignatorList DesignatorList;
    private DesignatorListItem DesignatorListItem;

    public DesignatorListNext (DesignatorList DesignatorList, DesignatorListItem DesignatorListItem) {
        this.DesignatorList=DesignatorList;
        if(DesignatorList!=null) DesignatorList.setParent(this);
        this.DesignatorListItem=DesignatorListItem;
        if(DesignatorListItem!=null) DesignatorListItem.setParent(this);
    }

    public DesignatorList getDesignatorList() {
        return DesignatorList;
    }

    public void setDesignatorList(DesignatorList DesignatorList) {
        this.DesignatorList=DesignatorList;
    }

    public DesignatorListItem getDesignatorListItem() {
        return DesignatorListItem;
    }

    public void setDesignatorListItem(DesignatorListItem DesignatorListItem) {
        this.DesignatorListItem=DesignatorListItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.accept(visitor);
        if(DesignatorListItem!=null) DesignatorListItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorList!=null) DesignatorList.traverseTopDown(visitor);
        if(DesignatorListItem!=null) DesignatorListItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorList!=null) DesignatorList.traverseBottomUp(visitor);
        if(DesignatorListItem!=null) DesignatorListItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorListNext(\n");

        if(DesignatorList!=null)
            buffer.append(DesignatorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorListItem!=null)
            buffer.append(DesignatorListItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorListNext]");
        return buffer.toString();
    }
}
