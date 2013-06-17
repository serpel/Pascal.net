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
public class Productions implements Cloneable {
    
    public ArrayList<Item> items;
    public String JavaCode= "";
    public int isdot;

    public Productions() {
        isdot = 0;
    } 
    
    public int get_item(String i)
    {
        int count = 0;
        for (Item item : items) {
            
            if(item.id.equals(i))
            {
                return count;
            }
            
            count++;
        }
        
        return -1;
    }
    
    public int get_item(Item i)
    {
        int count = 0;
        for (Item item : items) {
            
            if(item.equals(i))
            {
                return count;
            }
            
            count++;
        }
        
        return -1;
    }
    
    public Item get_item_dot()
    {
        int cont = 0;
        for (Item item : items) {
            if(cont == isdot)
            {
                return item;
            }
            cont++;
        }
        
        return null;
    }
    
    public String toStr()
    {
        String msj = "";
        
        for (Item item : items) {
            msj += item.id + " ";
        }
        
        return msj;
    }
    
    @Override
    public Productions clone() {
        try {
            return (Productions) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error("Clone is not supported by Production\n");
        }
    }
      
}
