/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Tree.Statemens.Assign;
import java.util.ArrayList;

/**
 *
 * @author SergioJavier
 */
public class TypeDecl extends Declarations{
    
    ArrayList<Assign> lass;

    public TypeDecl(ArrayList<Assign> lass, Declarations next) {
        super(next);
        this.lass = lass;
    }

    public ArrayList<Assign> getLass() {
        return lass;
    }

    public void setLass(ArrayList<Assign> lass) {
        this.lass = lass;
    }
    
}
