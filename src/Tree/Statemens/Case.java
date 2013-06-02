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
public class Case extends Statement {
    
    Expression exprs;
    Statement stms;

    public Case(Expression exprs, Statement stms) {
        this.exprs = exprs;
        this.stms = stms;
    }

    public Expression getExprs() {
        return exprs;
    }

    public Statement getStms() {
        return stms;
    }

    public void setExprs(Expression exprs) {
        this.exprs = exprs;
    }

    public void setStms(Statement stms) {
        this.stms = stms;
    }    

    @Override
    public void semanticValidation() {
        this.stms.semanticValidation();
    }
}
