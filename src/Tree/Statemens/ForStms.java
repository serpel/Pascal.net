/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import Semantic.Env;
import Semantic.Environment;
import Semantic.ErrorLog;
import Tree.Expressions.Expression;
import Tree.Types.Bool;

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
        Env.newEnv();   
        
        this.ass.semanticValidation();
        
        if(this.ass.getRight().getType() != this.expr.getType())
        {
             ErrorLog.getInstance().add("Error: El rango de la intruccion FOR debe poseer tipos iguales, se encontro: "+this.ass.right.getType().toString()+", "+this.expr.getType().toString());
        }
        
        stms.semanticValidation();
            
        Env.restoreEnv();
    }
    
}
