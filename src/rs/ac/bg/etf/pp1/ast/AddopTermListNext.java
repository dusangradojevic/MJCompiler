// generated with ast extension for cup
// version 0.8
// 26/7/2022 11:20:58


package rs.ac.bg.etf.pp1.ast;

public class AddopTermListNext extends AddopTermList {

    private AddopTermList AddopTermList;
    private AddopTermListItem AddopTermListItem;

    public AddopTermListNext (AddopTermList AddopTermList, AddopTermListItem AddopTermListItem) {
        this.AddopTermList=AddopTermList;
        if(AddopTermList!=null) AddopTermList.setParent(this);
        this.AddopTermListItem=AddopTermListItem;
        if(AddopTermListItem!=null) AddopTermListItem.setParent(this);
    }

    public AddopTermList getAddopTermList() {
        return AddopTermList;
    }

    public void setAddopTermList(AddopTermList AddopTermList) {
        this.AddopTermList=AddopTermList;
    }

    public AddopTermListItem getAddopTermListItem() {
        return AddopTermListItem;
    }

    public void setAddopTermListItem(AddopTermListItem AddopTermListItem) {
        this.AddopTermListItem=AddopTermListItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AddopTermList!=null) AddopTermList.accept(visitor);
        if(AddopTermListItem!=null) AddopTermListItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AddopTermList!=null) AddopTermList.traverseTopDown(visitor);
        if(AddopTermListItem!=null) AddopTermListItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AddopTermList!=null) AddopTermList.traverseBottomUp(visitor);
        if(AddopTermListItem!=null) AddopTermListItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("AddopTermListNext(\n");

        if(AddopTermList!=null)
            buffer.append(AddopTermList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddopTermListItem!=null)
            buffer.append(AddopTermListItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AddopTermListNext]");
        return buffer.toString();
    }
}
