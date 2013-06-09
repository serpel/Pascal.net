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
public class RepeatStms extends Statement{
    Expression expr;
    Statement stms;
    

    public RepeatStms(Expression expr, Statement stms) {
        this.expr = expr;
        this.stms = stms;
    }

    public Expression Expr() {
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
              
        Type t = new Bool();
        if(this.expr.getType().getClass() != t.getClass())
        {
            ErrorLog.getInstance().add("Error: While no soporta tipo "+this.expr.getType().toString());
        }    
        
        if (stms != null) {
            Env.newEnv();
            stms.semantic();
            Env.restoreEnv();
        }
        
        this.expr.semantic();
    }

}
