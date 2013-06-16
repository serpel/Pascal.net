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
public class VarDecl extends Declarations{
    Expression ids;
    Type t;

    public VarDecl(Expression ids, Type t) {
        this.ids = ids;
        this.t = t;
    }

    public Expression getIds() {
        return ids;
    }

    public Type getT() {
        return t;
    }

    public void setIds(Expression ids) {
        this.ids = ids;
    }

    public void setT(Type t) {
        this.t = t;
    }
    
    public Id find(String id)
    {
        Expression e = ids;
        while (e != null) {
            Id i = (Id) e;

            if(i.getIdentifier().contains(id))
            {
                return i;
            }

            e = e.getNext();
        }
        
        return null;
    }

    @Override
    public void semanticValidation() {
        
        Expression e=ids;
        while (e != null) {
            Id i = (Id) e;

            //parte obscura
            Type _t = new Custom();
            if (_t.getClass() == t.getClass()) {
                t = Env.getIntance().getType(((Custom)t).getId());
            }

            Env.getIntance().put(i.getIdentifier(), t);

            e = e.getNext();
        }
    }

    @Override
    public String codeGenerationStament() {
        return Env.getIntance().getTable().getLocals();
    }
    
}
