/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import AssemblyInfo.Assambly;
import Semantic.Env;
import Semantic.ErrorLog;
import Tree.Expressions.Expression;
import Tree.Expressions.Id;

/**
 *
 * @author SergioJavier
 */
public class ForStms extends Statement{
    Expression expr;
    Assign ass;
    Statement stms;

    public ForStms(Assign ass, Expression expr, Statement stms) {
        this.expr = expr;
        this.ass = ass;
        this.stms = stms;
    }

    public Expression getExpr() {
        return expr;
    }

    public Assign getAss() {
        return ass;
    }

    public Statement getStms() {
        return stms;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    public void setAss(Assign ass) {
        this.ass = ass;
    }

    public void setStms(Statement stms) {
        this.stms = stms;
    }    

    @Override
    public void semanticValidation() {
       
        //Env.newEnv();  
         
        Id i = this.ass.i;
        Expression j = this.ass.right;
        if(i instanceof Id)
        {
            Env.getIntance().put(i.getIdentifier(), j.getType()); 
        }else
        {
             ErrorLog.getInstance().add("Error: For esperaba Id pero se encontro: "+i.getType().toStr());
        }       

        this.ass.semantic();
        this.expr.semantic();
        
        if(this.ass.getRight().getType().getClass() != this.expr.getType().getClass())
        {
             ErrorLog.getInstance().add("Error: El rango de la intruccion FOR debe poseer tipos iguales, se encontro: "+this.ass.right.getType().toStr()+" y "+this.expr.getType().toStr());
        }
        
        if(stms != null)
        {
            stms.semantic();
        }
            
        //Env.restoreEnv();
    }

    @Override
    public String codeGenerationStament() {
        String etiqueta1 = Assambly.getInstance().getLabel("For");
        String etiqueta2 = Assambly.getInstance().getLabel("EndFor");
        
        String asignacion, condicion, incrementar;
        int n = Env.getIntance().getNumber(ass.i.getIdentifier());     
        
        asignacion = this.ass.getRight().codeGeneration()+"ldloc."+ n+ "\n"+"stloc."+n+ "\n";;
        
        condicion = etiqueta1+":\n"+"ldloc."+n+"\n"+this.expr.codeGeneration()+"bgt "+etiqueta2+"\n";
        
        incrementar = "ldloc."+n+"\nldc.i4 1\nadd\n"+"stloc."+n+"\nbr "+etiqueta1;
        
        return asignacion+condicion+this.stms.codeGeneration()+incrementar+"\n"+etiqueta2+":\n";
    
    }
    
}
