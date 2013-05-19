/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Tree.Expressions.Id;
import java.util.ArrayList;
import Tree.Types.*;

/**
 *
 * @author SergioJavier
 */
public class VarDecl extends Declarations{
    ArrayList<Id> ids;
    Type t;

    public VarDecl(ArrayList<Id> ids, Type t, Declarations next) {
        super(next);
        this.ids = ids;
        this.t = t;
    }

    public ArrayList<Id> getIds() {
        return ids;
    }

    public Type getT() {
        return t;
    }

    public void setIds(ArrayList<Id> ids) {
        this.ids = ids;
    }

    public void setT(Type t) {
        this.t = t;
    }
    
}
