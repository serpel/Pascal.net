/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Semantic.Env;
import Tree.Expressions.Expression;
import Tree.Expressions.Id;
import Tree.Types.Custom;
import Tree.Types.Record;
import Tree.Types.Type;

/**
 *
 * @author SergioJavier
 */
public class TypeDecl extends Declarations{
    
    Id id;
    Type t;

    public TypeDecl(Id id, Type t) {
        this.id = id;
        this.t = t;
    }

    public Expression getId() {
        return id;
    }

    public Type getT() {
        return t;
    }

    public void setIds(Id id) {
        this.id = id;
    }

    public void setT(Type t) {
        this.t = t;
    }
    
    public Id find(String id)
    {
        if(this.id.getIdentifier().equals(id))
        {
            return this.id;
        }
        
        return null;
    }

    @Override
    public void semanticValidation() {
        //id.setType(t);
        
        if(t instanceof Record )
        {
            
        }
        Env.getIntance().put(id.getIdentifier(), t);
    }

    @Override
    public String codeGenerationStament() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
