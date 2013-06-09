/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Tree.Expressions.Id;
/**
 *
 * @author SergioJavier
 */
public class Program extends Declarations{
    Id name;
    Declarations params;
    Declarations block;

    public Program(Id name, Declarations params, Declarations block) {
        this.name = name;
        this.params = params;
        this.block = block;
    }

    public Id getName() {
        return name;
    }

    public Declarations getParams() {
        return params;
    }

    public Declarations getBlock() {
        return block;
    }

    public void setName(Id name) {
        this.name = name;
    }

    public void setParams(Declarations params) {
        this.params = params;
    }

    public void setBllock(Block bl) {
        this.block = bl;
    }

    @Override
    public void semanticValidation() {   
        this.block.semantic();
    }
    
}
