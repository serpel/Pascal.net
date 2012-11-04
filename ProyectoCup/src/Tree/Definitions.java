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
public class Definitions {
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
    
    
    
}
