/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Statemens;

import Semantic.Env;
import Semantic.ErrorLog;
import Tree.Expressions.Expression;
import Tree.Expressions.Id;

/**
 *
 * @author SergioJavier
 */
public class Read extends Statement{
    Id i;

    public Read(Id i) {
        this.i = i;
    }

    @Override
    public void semanticValidation() {
        i.semanticValidation();
    }

    @Override
    public String codeGenerationStament() {
        
        String tmp;
        tmp = "call " + i.getType().toStr() + " [mscorlib]System.Console::Read()\n";
        tmp += "stloc "+Env.getIntance().getNumber(i.getIdentifier())+"\n";
        
        return tmp;
      }
    
}
