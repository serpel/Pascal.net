/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

import Semantic.ErrorLog;

/**
 *
 * @author SergioJavier
 */
public class Not extends Expression{

   Expression expr;

    public Not(Expression expr) {
        this.expr = expr;
    }

    public Expression getExpr() {
        return expr;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    @Override
    public void semanticValidation() {
        if(!(expr.getType() instanceof Tree.Types.Bool))
        {
            ErrorLog.getInstance().add("Error: Negacion requiere Tipo "+this.expr.getType().toString()+".");
        }
    }
   
}
