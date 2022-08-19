// generated with ast extension for cup
// version 0.8
// 19/7/2022 13:10:28


package rs.ac.bg.etf.pp1.ast;

public class CondTermListNext extends CondTermList {

    private CondTermList CondTermList;
    private CondTermListItem CondTermListItem;

    public CondTermListNext (CondTermList CondTermList, CondTermListItem CondTermListItem) {
        this.CondTermList=CondTermList;
        if(CondTermList!=null) CondTermList.setParent(this);
        this.CondTermListItem=CondTermListItem;
        if(CondTermListItem!=null) CondTermListItem.setParent(this);
    }

    public CondTermList getCondTermList() {
        return CondTermList;
    }

    public void setCondTermList(CondTermList CondTermList) {
        this.CondTermList=CondTermList;
    }

    public CondTermListItem getCondTermListItem() {
        return CondTermListItem;
    }

    public void setCondTermListItem(CondTermListItem CondTermListItem) {
        this.CondTermListItem=CondTermListItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondTermList!=null) CondTermList.accept(visitor);
        if(CondTermListItem!=null) CondTermListItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTermList!=null) CondTermList.traverseTopDown(visitor);
        if(CondTermListItem!=null) CondTermListItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTermList!=null) CondTermList.traverseBottomUp(visitor);
        if(CondTermListItem!=null) CondTermListItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTermListNext(\n");

        if(CondTermList!=null)
            buffer.append(CondTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTermListItem!=null)
            buffer.append(CondTermListItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTermListNext]");
        return buffer.toString();
    }
}
