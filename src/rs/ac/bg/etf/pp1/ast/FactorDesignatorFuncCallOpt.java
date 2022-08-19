// generated with ast extension for cup
// version 0.8
// 19/7/2022 13:10:28


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignatorFuncCallOpt extends Factor {

    private Designator Designator;
    private FuncCallOpt FuncCallOpt;

    public FactorDesignatorFuncCallOpt (Designator Designator, FuncCallOpt FuncCallOpt) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.FuncCallOpt=FuncCallOpt;
        if(FuncCallOpt!=null) FuncCallOpt.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public FuncCallOpt getFuncCallOpt() {
        return FuncCallOpt;
    }

    public void setFuncCallOpt(FuncCallOpt FuncCallOpt) {
        this.FuncCallOpt=FuncCallOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(FuncCallOpt!=null) FuncCallOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(FuncCallOpt!=null) FuncCallOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(FuncCallOpt!=null) FuncCallOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignatorFuncCallOpt(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FuncCallOpt!=null)
            buffer.append(FuncCallOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignatorFuncCallOpt]");
        return buffer.toString();
    }
}
