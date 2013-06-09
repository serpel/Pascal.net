/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import Tree.Expressions.Expression;

/**
 *
 * @author SergioJavier
 */
public class Switch extends Statement{
    
    Statement c,_else;
    Expression expr;

    public Switch(Expression expr, Statement c, Statement _else) {
        this.c = c;
        this._else = _else;
        this.expr = expr;
    }

    public Statement getC() {
        return c;
    }

    public void setC(Statement c) {
        this.c = c;
    }

    public Statement getElse() {
        return _else;
    }

    public void setElse(Statement _else) {
        this._else = _else;
    }

    public Expression getExpr() {
        return expr;
    }

    public void setExpr(Expression expr) {
        this.expr = expr;
    }
    
    @Override
    public void semanticValidation() {  
        
        this.expr.semantic();
        
        if(this.c != null)
        {
            this.c.semantic();
        }
        
        if(this._else != null)
        {
            this._else.semantic();
        }
    }  
}
