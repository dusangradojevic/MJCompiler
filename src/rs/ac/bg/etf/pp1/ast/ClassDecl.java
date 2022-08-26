// generated with ast extension for cup
// version 0.8
// 26/7/2022 11:20:58


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String className;
    private ExtendsOpt ExtendsOpt;
    private VarDeclList VarDeclList;
    private ConstructorMethodDecl ConstructorMethodDecl;

    public ClassDecl (String className, ExtendsOpt ExtendsOpt, VarDeclList VarDeclList, ConstructorMethodDecl ConstructorMethodDecl) {
        this.className=className;
        this.ExtendsOpt=ExtendsOpt;
        if(ExtendsOpt!=null) ExtendsOpt.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.ConstructorMethodDecl=ConstructorMethodDecl;
        if(ConstructorMethodDecl!=null) ConstructorMethodDecl.setParent(this);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className=className;
    }

    public ExtendsOpt getExtendsOpt() {
        return ExtendsOpt;
    }

    public void setExtendsOpt(ExtendsOpt ExtendsOpt) {
        this.ExtendsOpt=ExtendsOpt;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public ConstructorMethodDecl getConstructorMethodDecl() {
        return ConstructorMethodDecl;
    }

    public void setConstructorMethodDecl(ConstructorMethodDecl ConstructorMethodDecl) {
        this.ConstructorMethodDecl=ConstructorMethodDecl;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExtendsOpt!=null) ExtendsOpt.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(ConstructorMethodDecl!=null) ConstructorMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExtendsOpt!=null) ExtendsOpt.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(ConstructorMethodDecl!=null) ConstructorMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExtendsOpt!=null) ExtendsOpt.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(ConstructorMethodDecl!=null) ConstructorMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

        buffer.append(" "+tab+className);
        buffer.append("\n");

        if(ExtendsOpt!=null)
            buffer.append(ExtendsOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstructorMethodDecl!=null)
            buffer.append(ConstructorMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}
