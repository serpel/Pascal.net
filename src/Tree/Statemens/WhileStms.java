/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import AssemblyInfo.Assambly;
import Semantic.*;
import Tree.Expressions.Expression;
import Tree.Types.*;

/**
 *
 * @author SergioJavier
 */
public class WhileStms extends Statement{
    Expression expr;
    Statement stms;

    public WhileStms(Expression param, Statement stms) {
        this.expr = param;
        this.stms = stms;
    }

    public Expression getExpr() {
        return expr;
    }

    public Statement getStms() {
        return stms;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    public void setStms(Statement stms) {
        this.stms = stms;
    }
    
    @Override
    public void semanticValidation() {
  
        this.expr.semantic();
        
        Type t = new Tree.Types.Bool();
        if(this.expr.getType().getClass() != t.getClass())
        {
            ErrorLog.getInstance().add("Error: While no soporta tipo "+this.expr.getType().toStr());
        }
        
        if(this.stms != null)
        {
            this.stms.semantic();
        }     
    }

    @Override
    public java.lang.String codeGenerationStament() {
        java.lang.String etiqueta1 = Assambly.getInstance().getLabel("Condicion");
        java.lang.String etiqueta2 = Assambly.getInstance().getLabel("While");

        java.lang.String codeWhile = "";

        if (this.stms != null) {
            codeWhile = this.stms.codeGeneration();
        }

        return "br.s " + etiqueta1 + "\n" + etiqueta2 + ":\n" + codeWhile + etiqueta1 + ":\n" + this.expr.codeGeneration() + "brtrue.s " + etiqueta2+"\n";
        //return etiqueta1+":\n"+this.expr.codeGeneration()+"brzero "+etiqueta2+"\n"+codeWhile+"br "+etiqueta1+"\n"+etiqueta2+":\n";  
    }
    
}
