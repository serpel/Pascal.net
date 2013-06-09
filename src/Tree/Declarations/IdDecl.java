/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Semantic.Env;
import Tree.Expressions.Expression;
import Tree.Expressions.Id;
import Tree.Types.Custom;
import Tree.Types.Type;

/**
 *
 * @author SergioJavier
 */
public class IdDecl extends Declarations{
    
    String name;
    Type t;

    public IdDecl(String name, Type t) {
        this.name = name;
        this.t = t;
        
        Env.getIntance().put(name, t);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getT() {
        return t;
    }

    public void setT(Type t) {
        this.t = t;
    }

    @Override
    public void semanticValidation() {
        
    }
    
}
