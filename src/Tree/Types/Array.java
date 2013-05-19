/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Types;

/**
 *
 * @author SergioJavier
 */
public class Array extends Type{
    int size;
    Type t;

    public Array(int size, Type t) {
        this.size = size;
        this.t = t;
    }

    public int getSize() {
        return size;
    }

    public Type getT() {
        return t;
    }

    public void setT(Type t) {
        this.t = t;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
