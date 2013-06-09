/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import Semantic.Env;
import Semantic.ErrorLog;
import Tree.Expressions.Expression;
import Tree.Types.Bool;
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
    
}
