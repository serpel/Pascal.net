/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Tree.Expressions.Expression;
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
    
}
