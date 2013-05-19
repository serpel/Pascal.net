/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Program;

import Tree.Declarations.Declarations;
import Tree.Statemens.Statement;

/**
 *
 * @author SergioJavier
 */
public class Block {
    Declarations decls;
    Statement stms;

    public Block(Declarations decls, Statement stms) {
        this.decls = decls;
        this.stms = stms;
    }

    public Declarations getDecls() {
        return decls;
    }

    public Statement getStms() {
        return stms;
    }

    public void setDecls(Declarations decls) {
        this.decls = decls;
    }

    public void setStms(Statement stms) {
        this.stms = stms;
    }  
    
}
