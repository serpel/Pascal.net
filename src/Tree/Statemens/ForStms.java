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
public class ForStms extends Statement{
    Expression expr;
    Assign ass;
    Statement stms;

    public ForStms(Expression expr, Assign ass, Statement stms, Statement next) {
        super(next);
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
    
}
