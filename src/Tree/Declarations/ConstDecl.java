/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Semantic.Env;
import Tree.Expressions.*;

/**
 *
 * @author SergioJavier
 */
public class ConstDecl extends Declarations{
    
    Id name;
    Expression expr;

    public ConstDecl(Id name, Expression expr) {
        this.name = name;
        this.expr = expr;
    } 

    @Override
    public void semanticValidation() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //Env.getIntance().put(name.getIdentifier(), null);
    }
}
