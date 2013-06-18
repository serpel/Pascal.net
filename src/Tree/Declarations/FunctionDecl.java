/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Declarations;

import Semantic.Env;
import Tree.Expressions.Id;
import Tree.Statemens.Statement;
import Tree.Types.Field;
import Tree.Types.Function;
import Tree.Types.Type;
import java.util.ArrayList;

/**
 *
 * @author SergioJavier
 */
public class FunctionDecl extends Declarations{
    
    Id name;
    ArrayList<Argument> args;
    Type t;
    Declarations vars;
    Statement stms;

    public FunctionDecl(Id name, ArrayList<Argument> args, Type t, Declarations vars, Statement stms) {
        this.name = name;
        this.args = args;
        this.t = t;
        this.vars = vars;
        this.stms = stms;
    }  
    
    @Override
    public void semanticValidation() {
          
        Env.getIntance().putFunction(this.name.getIdentifier(), this.t);
        //Nuevo environtment
        Env.newEnv();  
        
        //validacion de argumentos dentro del entorno
        if (this.args != null) {
            
            for(int i = this.args.size()-1; i >= 0; i--)
            {
                Declarations d = this.args.get(i);
                d.semantic();
            }
        }
        
        //variables locales
        if (this.vars != null) {
            this.vars.semantic();
        }
        
        if (this.stms != null) {
            this.stms.semantic();
        }       
        super.environtment = Env.getIntance();
        Env.restoreEnv();
    }

    @Override
    public String codeGenerationStament() {
        
        Env te = Env.getIntance();
        Env.setInstance(super.environtment);
        String tmp = "", ret = "";
        
        tmp += ".method public static "+this.t.toAssembly()+" "+this.name.getIdentifier()+"("+Env.getIntance().getTable().getArgs()+") cil managed\n";
        tmp += "{\n";
        tmp += ".maxstack  100\n";
        tmp += Env.getIntance().getTable().getLocals() +"\n"+ this.stms.codeGeneration();
        
        tmp += "ret\n}\n";
        
        Env.setInstance(te);
        
        return tmp;
    }
    
}
