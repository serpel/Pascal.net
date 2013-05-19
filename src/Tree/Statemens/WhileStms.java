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
public class WhileStms extends Statement{
    Expression param;
    Statement stms;

    public WhileStms(Expression param, Statement stms, Statement next) {
        super(next);
        this.param = param;
        this.stms = stms;
    }

    public Expression getParam() {
        return param;
    }

    public Statement getStms() {
        return stms;
    }

    public void setParam(Expression param) {
        this.param = param;
    }

    public void setStms(Statement stms) {
        this.stms = stms;
    }
    
}
