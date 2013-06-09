/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

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
            Env.newEnv();
            this.stms.semantic();
            Env.restoreEnv();
        }     
    }
    
}
