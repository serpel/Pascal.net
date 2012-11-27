/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

/**
 *
 * @author aB
 */
public class Item {
    public Item () {
        
    }
    public Item(String id, String variableName){
        this.id = id;
        this.variableName = variableName;
        this.dot = false;
    }
    
    public boolean isDot() {
        return dot;
    } 

    public void setDot(boolean dot) {
        this.dot = dot;
    }
        
    public String id;
    public String variableName;
    private boolean dot;
}
