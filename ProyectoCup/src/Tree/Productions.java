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
public class Productions {
    
    public ArrayList<Item> items;
    public String JavaCode= "";
    
    public Item get_item_dot()
    {
        Item tmp = null;
        for (Item item : items) {           
            if(item.isDot())
            {
                tmp = item;
                continue;
            }     
        }
        
        if(tmp == null)
        {
            int index = 0;
            items.get(index).setDot(true);
            tmp = items.get(index);
        }
        
        return tmp;
    }
}
