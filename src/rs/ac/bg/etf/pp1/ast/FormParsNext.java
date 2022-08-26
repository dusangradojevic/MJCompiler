// generated with ast extension for cup
// version 0.8
// 25/7/2022 16:58:3


package rs.ac.bg.etf.pp1.ast;

public class FormParsNext extends FormPars {

    private FormPars FormPars;
    private Type Type;
    private FormParsIdent FormParsIdent;

    public FormParsNext (FormPars FormPars, Type Type, FormParsIdent FormParsIdent) {
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FormParsIdent=FormParsIdent;
        if(FormParsIdent!=null) FormParsIdent.setParent(this);
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
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
        if(FormPars!=null) FormPars.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(FormParsIdent!=null) FormParsIdent.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FormParsIdent!=null) FormParsIdent.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FormParsIdent!=null) FormParsIdent.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsNext(\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
        buffer.append(") [FormParsNext]");
        return buffer.toString();
    }
}
