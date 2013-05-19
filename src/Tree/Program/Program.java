/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Program;

import Tree.Declarations.Declarations;
import Tree.Declarations.VarDecl;
import Tree.Expressions.Id;
import java.util.ArrayList;

/**
 *
 * @author SergioJavier
 */
public class Program {
    Id funName;
    ArrayList<VarDecl> params;
    Block bl;

    public Program(Id funName, ArrayList<VarDecl> params, Block bl) {
        this.funName = funName;
        this.params = params;
        this.bl = bl;
    }

    public Id getFunName() {
        return funName;
    }

    public ArrayList<VarDecl> getParams() {
        return params;
    }

    public Block getBl() {
        return bl;
    }

    public void setFunName(Id funName) {
        this.funName = funName;
    }

    public void setParams(ArrayList<VarDecl> params) {
        this.params = params;
    }

    public void setBl(Block bl) {
        this.bl = bl;
    }
    
}
