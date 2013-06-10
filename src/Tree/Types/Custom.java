/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Types;

import Semantic.Env;

/**
 *
 * @author SergioJavier
 */
public class Custom extends Type{

    java.lang.String id;

    public Custom() {
    }

    public Custom(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getId() {
        return id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }
    
    @Override
    public java.lang.String toAssably() {
        //return Env.getIntance().getType(id);
        return id;
    }
    
    @Override
    public java.lang.String toStr() {
        return id;
    }
    
}
