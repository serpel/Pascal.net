/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Expressions;

/**
 *
 * @author SergioJavier
 */
public class LitString extends Literal {
    
    String value;

    public LitString(String value) {
        this.value = value;
        this.setType(new Tree.Types.String());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String codeGen() {
        return "ldstr " +this.value+"\n";
    }
       
}
