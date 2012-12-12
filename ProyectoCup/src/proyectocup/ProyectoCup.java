/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocup;

import LR.Action;
import LR.LR;
import LR.State;
import LR.Table;
import Lexer.Lexer;
import Parser.Parser;
import Tree.Program;
import ParserGenerator.ParserGenerator;
/**
 *
 * @author serpel
 */
public class ProyectoCup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        try {
            Lexer lex = new Lexer("src/text.txt");
            Parser p = new Parser(lex);
            Program program = p.Parse();
            ParserGenerator generator = new ParserGenerator(program);
            
            LR lr = new LR(program);            
            
            /* Tabla de acciones */
            
            Table t = new Table(lr);
            // iniciliza la tabla con estados nullos y el tipo en error
            Action [][] action_table = t.genTable();
            
            // Aqui van las acciones en cada posicion de la tabla
            action_table[1][1] = new Action(lr.getSts().get(1), Action.Type.Reduce);
            action_table[1][2] = new Action(lr.getSts().get(2), Action.Type.Shift);
            action_table[1][3] = new Action(lr.getSts().get(3), Action.Type.Reduce); 
            action_table[1][4] = new Action(null, Action.Type.Reduce);  
            
            generator.Generate();
            
            int i = 0;
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
        
        /*
         Token t;
        do
        {
            t = lex.getNextToken();
            String output = String.format("(%d,%d)Lexema = [%s] ; Tipo = [%s]", t.getRow(), t.getColumn(), t.getLexema(), t.getTipo());
            System.out.println(output);
        } while(Token.TokenType.EOF != t.getTipo());
        */     
    }
}
