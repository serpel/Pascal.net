/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import AssemblyInfo.Assambly;
import Semantic.Env;
import Semantic.ErrorLog;
import Tree.Expressions.Expression;
import Tree.Types.Type;

/**
 *
 * @author SergioJavier
 */
public class IfStms extends Statement{
    Expression expr;
    Statement ifst,elsest;

    public IfStms(Expression expr, Statement ifst, Statement elsest) {
        this.expr = expr;
        this.ifst = ifst;
        this.elsest = elsest;
    }

    public Expression getExpr() {
        return expr;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    public Statement getIfst() {
        return ifst;
    }

    public Statement getElsest() {
        return elsest;
    }

    public void setIfst(Statement ifst) {
        this.ifst = ifst;
    }

    public void setElsest(Statement elsest) {
        this.elsest = elsest;
    }
    
    @Override
    public void semanticValidation() {
  
        this.expr.semantic();
        
        Type t = new Tree.Types.Bool();
        if(this.expr.getType().getClass() != t.getClass())
        {
            ErrorLog.getInstance().add("Error: Instruccion If no soporta tipo "+this.expr.getType().toString());
        }
        
        if(this.ifst != null)
        {
            Env.newEnv();
            this.ifst.semantic();
            Env.restoreEnv();
        }     
        
        if(this.elsest != null)
        {
            Env.newEnv();
            this.elsest.semantic();
            Env.restoreEnv();
        }       
        
    }

    @Override
    public String codeGenerationStament() {
        String etiqueta1 = Assambly.getInstance().getLabel("else");
        String etiqueta2 = Assambly.getInstance().getLabel("fin_else");
         
        String cVerdadero = this.ifst != null ? ifst.codeGeneration() : "";
        String cFalso = this.elsest!=null ? elsest.codeGeneration(): "";
        //       
        //return this.expr.codeGeneration()+"brzero "+etiqueta1+"\n"+cFalso+"\nbr "+etiqueta2+"\n"+etiqueta1+":\n"+cVerdadero+"\n"+etiqueta2+":\n";   
        return expr.codeGeneration()+"ldc.i4.0\nceq\nbrtrue "+etiqueta1+"\n"+cVerdadero+"br "+etiqueta2+"\n"+etiqueta1+":\n"+cFalso+etiqueta2+":\n"; 
    }
    
}
