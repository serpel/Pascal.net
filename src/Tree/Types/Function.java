/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Types;

/**
 *
 * @author SergioJavier
 */
public class Function extends Type{

    Field f;
    Type t;

    public Function(Field f, Type t) {
        this.f = f;
        this.t = t;
    }

    public Field getF() {
        return f;
    }

    public void setF(Field f) {
        this.f = f;
    }

    public Type getT() {
        return t;
    }

    public void setT(Type t) {
        this.t = t;
    }
    
    @Override
    public java.lang.String toAssably() {
        return t.toStr();
    }
    
    @Override
    public java.lang.String toStr() {
        return t.toStr();
    }
    
}
