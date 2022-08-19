// generated with ast extension for cup
// version 0.8
// 19/7/2022 13:10:28


package rs.ac.bg.etf.pp1.ast;

public class ActParsListNext extends ActParsList {

    private ActParsList ActParsList;
    private ActParsListItem ActParsListItem;

    public ActParsListNext (ActParsList ActParsList, ActParsListItem ActParsListItem) {
        this.ActParsList=ActParsList;
        if(ActParsList!=null) ActParsList.setParent(this);
        this.ActParsListItem=ActParsListItem;
        if(ActParsListItem!=null) ActParsListItem.setParent(this);
    }

    public ActParsList getActParsList() {
        return ActParsList;
    }

    public void setActParsList(ActParsList ActParsList) {
        this.ActParsList=ActParsList;
    }

    public ActParsListItem getActParsListItem() {
        return ActParsListItem;
    }

    public void setActParsListItem(ActParsListItem ActParsListItem) {
        this.ActParsListItem=ActParsListItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsList!=null) ActParsList.accept(visitor);
        if(ActParsListItem!=null) ActParsListItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsList!=null) ActParsList.traverseTopDown(visitor);
        if(ActParsListItem!=null) ActParsListItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsList!=null) ActParsList.traverseBottomUp(visitor);
        if(ActParsListItem!=null) ActParsListItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsListNext(\n");

        if(ActParsList!=null)
            buffer.append(ActParsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsListItem!=null)
            buffer.append(ActParsListItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsListNext]");
        return buffer.toString();
    }
}
