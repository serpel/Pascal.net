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
public class Write extends Statement{
    Expression param;

    public Write(Expression param, Statement next) {
        super(next);
        this.param = param;
    }
    
}
