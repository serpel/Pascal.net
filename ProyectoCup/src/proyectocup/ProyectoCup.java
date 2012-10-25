/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocup;

import Lexer.Lexer;
import Lexer.Token;

/**
 *
 * @author serpel
 */
public class ProyectoCup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Lexer lex = new Lexer("text.txt");        
        Token t;
        do
        {
            t = lex.getNextToken();
            String output = String.format("(%d,%d)Lexema = [%s] ; Tipo = [%s]", t.getRow(), t.getColumn(), t.getLexema(), t.getTipo());
            System.out.println(output);
        } while(Token.TokenType.EOF != t.getTipo());
    }
}
