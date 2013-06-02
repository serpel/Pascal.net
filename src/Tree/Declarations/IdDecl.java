/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Tree.Expressions.Expression;

/**
 *
 * @author SergioJavier
 */
public class IdDecl extends Declarations{
    
    Expression ids;

    public IdDecl(Expression ids) {
        this.ids = ids;
    }

    public Expression getIds() {
        return ids;
    }

    public void setIds(Expression ids) {
        this.ids = ids;
    }
    
}
