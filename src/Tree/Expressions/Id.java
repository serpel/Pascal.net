/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

import Semantic.Env;
import Semantic.ErrorLog;
import Tree.Types.Null;
import Tree.Types.Type;

/**
 *
 * @author SergioJavier
 */
public class Id extends Expression {
    String identifier;
    Expression right;

    public Id(String Identifier) {
        this.identifier = Identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Expression getRight() {
        return right;
    }

    public void setRight(Expression right) {
        this.right = right;
    }

    public void setIdentifier(String Identifier) {
        this.identifier = Identifier;
    }

    @Override
    public void semanticValidation() {
        
        //validacion de identificadores
        Type t = Env.getIntance().getType(identifier);
        super.setType(t);
        
        if (t == null) {
            ErrorLog.getInstance().add("Error: Variable '" + this.identifier + "' no existe.");
        } 
        
        if(this.right != null)
        {   
            this.right.semantic();
            //if(this.right instanceof Array)
        }
    }
}
