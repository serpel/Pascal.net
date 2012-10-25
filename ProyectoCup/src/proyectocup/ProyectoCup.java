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
    public static void main(String[] args) throws Exception {
        
        Lexer lex = new Lexer("text.txt");
        
        Token t;
        do
        {
            t = lex.getNextToken();
            System.out.println("Lexema: " + t.getLexema() + " Tipo: " + t.getTipo());

        } while(Token.TokenType.EOF != t.getTipo());
        //Lexer l = new Lexer( "text.txt" );
        // TODO code application logic here
    }
}
