/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Semantic.Env;
import Tree.Expressions.Id;
import Tree.Statemens.Statement;
import Tree.Types.Field;
import Tree.Types.Type;
import java.util.ArrayList;
/**
 *
 * @author SergioJavier
 */
public class Program extends Declarations{
    Id name;
    Field f;
    ArrayList<Declarations> decls;
    Statement stms;

    public Program(Id name, Field f, ArrayList<Declarations> decl, Statement stms) {
        this.name = name;
        this.f = f;
        this.decls = decl;
        this.stms = stms;
    }
    
    @Override
    public void semanticValidation() {
        
        //nombre de la funcion
        if (f != null) {
            for (String i : f.getIds()) {
                Type t = f.get(i);
                Env.getIntance().put(i, t);
            }
        }

        //declaraciones typos, variables
        for (Declarations d : decls) {
            d.semantic();
        }

        //compound
        if (stms != null) {
            this.stms.semantic();
        }
    }

    @Override
    public String codeGenerationStament() {
        
        String main = "", funcion = "";

        main += ".method static void  Main() cil managed {\n";

        for (Declarations d : decls) {

            if (d instanceof FunctionDecl) {
                funcion += d.codeGeneration();
            } else {
                main += d.codeGeneration();
            }
        }

        if (stms != null) {
            main += this.stms.codeGeneration();
        }

        main += "}\n";

        return funcion + main;
    }
    
}
