/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Types;

/**
 *
 * @author SergioJavier
 */
public class Float extends Type{

    @Override
    public java.lang.String toAssembly() {
        return "r4";
    }
    
    @Override
    public java.lang.String toStr() {
        return "Float";
    }
    
}
