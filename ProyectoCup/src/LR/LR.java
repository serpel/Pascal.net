/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package LR;
import Tree.*;
import java.util.ArrayList;
import java.util.Stack;
/**
 *
 * @author SergioJavier
 */
public class LR {
    
    Program p;
    
    ArrayList<States> sts;

    public LR(Program p) {
        this.p = p;
        
        sts = elementsLR();
    }

    public void setP(Program p) {
        this.p = p;
    }

    public void setSts(ArrayList<States> sts) {
        this.sts = sts;
    }

    public Program getP() {
        return p;
    }

    public ArrayList<States> getSts() {
        return sts;
    }
       
    private Item isTerminal(Item i)
    {
        return null;
    }
    
    private Definitions find_definitions(String i)
    {        
        for (Definitions definitions : p.getDefinitions()) {
            
            if (definitions.getId().equals(i))
            {
                return definitions;
            }          
        }       
        return null; 
    }   
    
    
    // OK
    private ArrayList<Definitions> closure(Definitions i)
    {
        ArrayList<Definitions> j = new ArrayList<Definitions>();
        j.add(i);

        for (int a = 0; a < j.size(); a++ )
        {
            Definitions definitions = j.get(a);

            for (Productions productions : definitions.getProductions()) {

                Item _t = productions.get_item_dot();
                
                if (_t != null) {
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
    
    
    // OK
    private boolean isNonTerminal(String ID)
    {
        
        for (Terminals t: p.getTerminals()) {
            
            if(t.getId().contains(ID))
            {
                return true;
            }    
        }
        
        return false;
    }
    
    
    // OK
    private ArrayList<Definitions> ir_a(ArrayList<Definitions> i, String symbol)
    {     
        ArrayList<Definitions> elements = new ArrayList<Definitions>();
        Definitions _j;
        Productions _pr;
        
        for (Definitions j : i) { 
            
            _j = j.clone();
            ArrayList<Productions> new_prs = new ArrayList<Productions>();
            for (Productions pr : j.getProductions()) {
                 
                Item it = pr.get_item_dot();
                
                if( it != null)
                {
                    if (it.id.equals(symbol)) {
                        
                        // Se desplaza el punto
                        pr.isdot++;

                        //necesario para no generar conflictos de apuntadores de java
                        _pr = pr.clone();

                        // Se re definen las producciones con el simbolo X
                        new_prs.add(_pr);
                    }
                }
            } 
            /* Nota***
             * Se optinen el closure de las producciones con el simbolo X
             * */
            if (!new_prs.isEmpty()) {     
                
                // Se obtiene la cerradura del elemento desplazado (copia de la definicion) 
                _j.setProductions(new_prs);
                elements.addAll(closure(_j));
            }     
        }  
        
        return elements;
    }
    
      // OK
    private ArrayList<Definitions> ir_a2(ArrayList<Definitions> i, String symbol)
    {     
        ArrayList<Definitions> elements = new ArrayList<Definitions>();
        
        for (Definitions j : i) { 
            
            ArrayList<Productions> _p = new ArrayList<Productions>();
            
            for (Productions p : j.getProductions()) {
                 
                int pos = p.get_item(symbol);
                if( pos >= 0)
                {
                    // Se desplaza el punto
                    p.isdot = pos+1;
                    // Se re definen las producciones con el simbolo X
                    _p.add(p);
                }
            } 
            /* Nota***
             * Se optinen el closure de las producciones con el simbolo X
             * */
            if (!_p.isEmpty()) {               
                // Se obtiene la cerradura del elemento desplazado
                j.setProductions(_p);
                elements.addAll(closure(j));
            }     
        }  
        
        return elements;
    }
    
    /* por cada conjunto de elementos, y cada definicion
     * obtengo las producciones cuyo elemento X es deplazable y 
     * no sea parte del elemento.
     * */
    
    private void elements()
    {
        int count = 0;
        ArrayList<States> sts = new ArrayList<States>();
        ArrayList<Definitions> c;

        // cerradura({[S' -> .S]})
        c = closure(p.getDefinitions().get(0));

        //add items to LR States
        sts.add(new States(count, c));
        
        // X cada conjunto de elementos I en C
        for (int j=0; j<c.size(); j++) {
            
            Definitions i = c.get(j);        
            ArrayList<String> symbol = getSymbols();
            
            // Y cada symbolo Gramatical X 
            for (String x : symbol) {
                
                ArrayList<Definitions> _i = new ArrayList<Definitions>();
                _i.add(i);
                
                ArrayList<Definitions> ira = ir_a(_i, x);
                
                //tal que ir_a no este vacio e ir_a no este en C
                if(!ira.isEmpty())
                {
                    sts.add(new States(count++, ira));
                    
//                    if(!c.containsAll(ira))
//                    {
//                        c.addAll(ira);
//                    }
                } 
            }
        }
    }
    
    
    private ArrayList<States> elementsLR()
    {
        int count = 0;
        Stack  work_stack = new Stack();
        States st;
        States new_st;
        ArrayList<Definitions> new_defs = new ArrayList<Definitions>();
        ArrayList<States> sts = new ArrayList<States>();
        ArrayList<Definitions> c;

        // cerradura({[S' -> .S]})
        Definitions first_definiton = p.getDefinitions().get(0);
        c = closure(first_definiton);

        //create LR States from the closure of firts element
        States start_st = new States(count++, c);       
        start_st.getRefs().put(0, c.get(0).getProductions().get(0).get_item_dot().id);
        
        sts.add(start_st);
        work_stack.push(start_st);
        
        
        while(!work_stack.isEmpty())
        {
            // sacamos el estado a usar
            st = (States)work_stack.pop();
            
            // Todos los simbolos antes del punto
            ArrayList<String> symbols = new ArrayList<String>();
            
            for (Definitions s : st.getDefs()) {               
                for (Productions pr : s.getProductions()) { 
                    
                    Item sym = pr.get_item_dot();  
                    if(sym != null)
                    {
                        if(!symbols.contains(sym.id))
                        {
                            symbols.add(sym.id); 
                        }
                    }
                }
            }            
            
            // X cada simbolo de la gramtica se generan el resto de estados
            for (String x : symbols) {
                
                new_defs = ir_a(st.getDefs(), x);
                        
                if(!new_defs.isEmpty())
                {
                    new_st = new States(count++, new_defs);
                    new_st.getRefs().put(0, x);
                    
                    sts.add(new_st);
                    work_stack.push(new_st);    
                }
            }     
        }
        
        return sts;
    }

    
    boolean contain(ArrayList<Definitions> j, Item i)
    {
        for (Definitions definitions : j) {
            
            if(definitions.getId().equals(i.id))
            {
                return true;
            } 
        }
        
        return false;
    } 
    
    public ArrayList<String> getSymbols()
    {
        ArrayList<String> i = new ArrayList<String>();
        
        for (Terminals t : p.getTerminals() ) {           
            i.addAll(t.getId());
        }
        
        for (Terminals t : p.getNonTerminals() ) {           
            i.addAll(t.getId());
        }
        
        return i;        
    }
    
    public void toStr()
    {
        System.out.println("\t---- States ----\t");
        
        String msj = "";
        for (States state : sts) { 
            msj += state.printState()+"\n";
        }   
        
        System.out.println(msj);
    }
}
