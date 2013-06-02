/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import Semantic.Env;
import Semantic.ErrorLog;
import Tree.Expressions.Expression;
import Tree.Types.Bool;

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
  
        if(!(this.expr.getType() instanceof Bool) || !(this.expr.getType() instanceof Tree.Types.Integer))
        {
            ErrorLog.getInstance().add("Error: Instruccion If no soporta tipo "+this.expr.getType().toString());
        }    
        Env.newEnv();
        this.ifst.semanticValidation();
        Env.restoreEnv();
        
        Env.newEnv();
        this.elsest.semanticValidation();
        Env.restoreEnv();
        
    }
    
}
