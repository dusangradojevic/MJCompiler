// generated with ast extension for cup
// version 0.8
// 7/7/2022 21:10:5


package rs.ac.bg.etf.pp1.ast;

public class FormParsNoList extends FormPars {

    private Type Type;
    private FormParsIdent FormParsIdent;

    public FormParsNoList (Type Type, FormParsIdent FormParsIdent) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FormParsIdent=FormParsIdent;
        if(FormParsIdent!=null) FormParsIdent.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FormParsIdent getFormParsIdent() {
        return FormParsIdent;
    }

    public void setFormParsIdent(FormParsIdent FormParsIdent) {
        this.FormParsIdent=FormParsIdent;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FormParsIdent!=null) FormParsIdent.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FormParsIdent!=null) FormParsIdent.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FormParsIdent!=null) FormParsIdent.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsNoList(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParsIdent!=null)
            buffer.append(FormParsIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsNoList]");
        return buffer.toString();
    }
}
