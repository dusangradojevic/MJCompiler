// generated with ast extension for cup
// version 0.8
// 25/7/2022 16:58:3


package rs.ac.bg.etf.pp1.ast;

public class CondFactListNext extends CondFactList {

    private CondFactList CondFactList;
    private CondFactListItem CondFactListItem;

    public CondFactListNext (CondFactList CondFactList, CondFactListItem CondFactListItem) {
        this.CondFactList=CondFactList;
        if(CondFactList!=null) CondFactList.setParent(this);
        this.CondFactListItem=CondFactListItem;
        if(CondFactListItem!=null) CondFactListItem.setParent(this);
    }

    public CondFactList getCondFactList() {
        return CondFactList;
    }

    public void setCondFactList(CondFactList CondFactList) {
        this.CondFactList=CondFactList;
    }

    public CondFactListItem getCondFactListItem() {
        return CondFactListItem;
    }

    public void setCondFactListItem(CondFactListItem CondFactListItem) {
        this.CondFactListItem=CondFactListItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFactList!=null) CondFactList.accept(visitor);
        if(CondFactListItem!=null) CondFactListItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFactList!=null) CondFactList.traverseTopDown(visitor);
        if(CondFactListItem!=null) CondFactListItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFactList!=null) CondFactList.traverseBottomUp(visitor);
        if(CondFactListItem!=null) CondFactListItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFactListNext(\n");

        if(CondFactList!=null)
            buffer.append(CondFactList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFactListItem!=null)
            buffer.append(CondFactListItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFactListNext]");
        return buffer.toString();
    }
}
