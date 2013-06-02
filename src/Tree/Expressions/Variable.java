/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

import Semantic.Env;
import Semantic.ErrorLog;

/**
 *
 * @author SergioJavier
 */
public class Variable extends Expression{
    
    Id identifier;
    Expression right;

    public Variable(Id identifier, Expression right) {
        this.identifier = identifier;
        this.right = right;
    }

    public Id getIdentifier() {
        return identifier;
    }

    public Expression getRight() {
        return right;
    }

    public void setIdentifier(Id identifier) {
        this.identifier = identifier;
    }

    public void setRight(Expression right) {
        this.right = right;
    }  

    @Override
    public void semanticValidation() {
        
        this.identifier.semanticValidation();
        
        if(this.right == null)
        {
            if(Env.getIntance().get(this.identifier.getIdentifier())== null)
            {
                ErrorLog.getInstance().add("Error: Variable no existe '"+this.identifier.getIdentifier()+"'.");         
            }
        }else
        {
//            if(Env.getIntance().getType(this.identifier.getIdentifier()) != this.right.getType())
//            {
//                ErrorLog.getInstance().add("Error: No se pueden asignar tipos  "+this.expr.getType().toString()+".");
//            }    
        }
    }
    
}
