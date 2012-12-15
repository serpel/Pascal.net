/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LALR;
import LR.*;
import Tree.Definitions;
import Tree.Item;
import Tree.Productions;
import Tree.Program;
import java.util.ArrayList;

/**
 *
 * @author SergioJavier
 */
public class LALR extends LR {

    public LALR(Program p) {
        super(p);
    }

    @Override
    protected ArrayList<Definitions> closure(Definitions i) {
        
        // Se deben de considerar todos los elementos
        ArrayList<Definitions> j = new ArrayList<Definitions>();
        j.add(i);
         
        for (int a = 0; a < j.size(); a++ )
        {
            Definitions definitions = j.get(a);

            for (Productions productions : definitions.getProductions()) {

                Item _t = productions.get_item_dot();
                
                if (_t != null) {
                    //optengo el item que sea no terminal
                    if (!contain(j, _t) && isNonTerminal(_t.id)) {
                        
                        Definitions _fd = find_definitions(_t.id);
                        
                        if(_fd != null)
                        {
                            j.add(_fd);
                        }
                    }
                }
            }       
        }
        
        return j;
    }
    
}
