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
public class Return extends Statement{

    Expression e;

    public Return(Expression e) {
        this.e = e;
    }  
    
    @Override
    public void semanticValidation() {
        e.semantic();
    }

    @Override
    public String codeGenerationStament() {
        return e.codeGeneration()+"ret\n";
    }
    
}
