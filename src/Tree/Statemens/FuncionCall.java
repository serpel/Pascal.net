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
public class FuncionCall extends Statement{
    String identifier;
    Expression params;

    public FuncionCall(String identifier, Expression params, Statement next) {
        super(next);
        this.identifier = identifier;
        this.params = params;
    }

    public Expression getParams() {
        return params;
    }

    public void setParams(Expression params) {
        this.params = params;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    } 
    
}
