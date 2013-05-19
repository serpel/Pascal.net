/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Types;

import Tree.Statemens.Statement;
import Tree.Declarations.Declarations;

/**
 *
 * @author SergioJavier
 */
public class Record extends Type{
    Declarations decls;

    public Record(Declarations decls) {
        this.decls = decls;
    }

    public Declarations getDecls() {
        return decls;
    }

    public void setDecls(Declarations decls) {
        this.decls = decls;
    }
    
}
