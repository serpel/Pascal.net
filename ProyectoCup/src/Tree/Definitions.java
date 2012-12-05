/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;
import java.util.ArrayList;
/**
 *
 * @author SergioJavier
 */
public class Definitions implements Cloneable {
    private String id;
    private ArrayList<Productions> productions;
    
    public Definitions(){
        
    }

    public Definitions(String id, ArrayList<Productions> productions) {
        this.id = id;
        this.productions = productions;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the productions
     */
    public ArrayList<Productions> getProductions() {
        return productions;
    }

    /**
     * @param productions the productions to set
     */
    public void setProductions(ArrayList<Productions> productions) {
        this.productions = productions;
    }
    
    public String toStr() {

        String msj = this.id + " ::= ";
        
        int size_msj = msj.length()-1;
        
        String msj_space = "";
        for (int i = 0; i < (size_msj-1); i++) {
            msj_space += " ";
        }
        msj_space += "| ";
        
        int size_prs = this.productions.size();
        
        int cont = 0;
        for (Productions pr : this.productions) {
            
            if(cont > 0 && cont < size_prs)
            {
                msj += msj_space;
            }
            msj += pr.toStr() + "\n";   
            cont++;
        }
        
        return msj;
    }
    
    @Override
    public Definitions clone() {
        try {
            return (Definitions) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error("Clone is not supported by Definition\n");
        }
    }
    
}
