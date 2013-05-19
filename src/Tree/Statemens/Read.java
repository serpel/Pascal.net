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
public class Read extends Statement{
    Expression param;

    public Read(Expression param, Statement next) {
        super(next);
        this.param = param;
    }

    public void setParam(Expression param) {
        this.param = param;
    }

    public Expression getParam() {
        return param;
    }
    
}
