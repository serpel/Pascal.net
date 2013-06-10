/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Semantic.Env;
import Tree.Expressions.Id;
import Tree.Types.Field;
import Tree.Types.Type;
/**
 *
 * @author SergioJavier
 */
public class Program extends Declarations{
    Id name;
    Field f;
    Declarations block;

    public Program(Id name, Field f, Declarations block) {
        this.name = name;
        this.f = f;
        this.block = block;
    }

    public Id getName() {
        return name;
    }

    public void setName(Id name) {
        this.name = name;
    }

    public Field getF() {
        return f;
    }

    public void setF(Field f) {
        this.f = f;
    }

    public Declarations getBlock() {
        return block;
    }

    public void setBlock(Declarations block) {      
        this.block = block;
    }

    @Override
    public void semanticValidation() {

        //codigo dentro de la funcion
        Env.newEnv();
        
        if (f != null) {
            for (String i : f.getIds()) {
                Type t = f.get(i);
                Env.getIntance().put(i, t);
            }
        }
        
        if(this.block != null)
        {
            this.block.semantic();
        }
        Env.restoreEnv();
    }
    
}
