/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;
import java.util.ArrayList;
/**
 *
 * @author aB
 */
public class Terminals {

    private String type;
    private ArrayList<String> id;

    public Terminals(){
        
    }
    
    public Terminals(String type, ArrayList<String> id) {
        this.type = type;
        this.id = id;
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the id
     */
    public ArrayList<String> getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ArrayList<String> id) {
        this.id = id;
    }
    
    public void AddValue(String id){
        this.id.add(id);
    }
    
}
