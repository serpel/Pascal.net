/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LR;

/**
 *
 * @author SergioJavier
 */
public class Table {
    
    /* Tabla de acciones */
    private Action LR_table[][];
    
    /*Instancia de objetos LR*/
    private LR lr;

    public Table(LR lr_items) {
        
        this.lr = lr_items;
        
        /* Size of table actions */
        int column = lr.getSymbols().size();
        int row = lr.getSts().size();
                
        LR_table = new Action[row][column];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                LR_table[i][j] = new Action(null, Action.Type.Error);
            }
        }
    }

    public Table(Action[][] LR_table, LR lr) {
        this.LR_table = LR_table;
        this.lr = lr;
    }
    
    public Action[][] genTable()
    {
        int column = lr.getSymbols().size();
        int row = lr.getSts().size();
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
            
                LR_table[i][j] = new Action(null, Action.Type.Error);     
            }
        }
        
        return this.LR_table;
    }
       
}
