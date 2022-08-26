// generated with ast extension for cup
// version 0.8
// 25/7/2022 16:58:3


package rs.ac.bg.etf.pp1.ast;

public class MulopFactorListNext extends MulopFactorList {

    private MulopFactorList MulopFactorList;
    private MulopFactorListItem MulopFactorListItem;

    public MulopFactorListNext (MulopFactorList MulopFactorList, MulopFactorListItem MulopFactorListItem) {
        this.MulopFactorList=MulopFactorList;
        if(MulopFactorList!=null) MulopFactorList.setParent(this);
        this.MulopFactorListItem=MulopFactorListItem;
        if(MulopFactorListItem!=null) MulopFactorListItem.setParent(this);
    }

    public MulopFactorList getMulopFactorList() {
        return MulopFactorList;
    }

    public void setMulopFactorList(MulopFactorList MulopFactorList) {
        this.MulopFactorList=MulopFactorList;
    }

    public MulopFactorListItem getMulopFactorListItem() {
        return MulopFactorListItem;
    }

    public void setMulopFactorListItem(MulopFactorListItem MulopFactorListItem) {
        this.MulopFactorListItem=MulopFactorListItem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MulopFactorList!=null) MulopFactorList.accept(visitor);
        if(MulopFactorListItem!=null) MulopFactorListItem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MulopFactorList!=null) MulopFactorList.traverseTopDown(visitor);
        if(MulopFactorListItem!=null) MulopFactorListItem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MulopFactorList!=null) MulopFactorList.traverseBottomUp(visitor);
        if(MulopFactorListItem!=null) MulopFactorListItem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulopFactorListNext(\n");

        if(MulopFactorList!=null)
            buffer.append(MulopFactorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MulopFactorListItem!=null)
            buffer.append(MulopFactorListItem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MulopFactorListNext]");
        return buffer.toString();
    }
}
