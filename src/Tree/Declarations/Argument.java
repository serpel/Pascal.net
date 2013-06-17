/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Semantic.Env;
import Tree.Expressions.Id;
import Tree.Types.Type;

/**
 *
 * @author SergioJavier
 */
public class Argument extends Declarations{
    
    Id name;
    Type t;

    public Argument(Id name, Type t) {
        this.name = name;
        this.t = t;
    }
    
    @Override
    public void semanticValidation() {
        Env.getIntance().putArg(name.getIdentifier(), t);
    }

    @Override
    public String codeGenerationStament() {
        //return Env.getIntance().getTable().getArgs();
        return "";
    }
    
    
    
}
