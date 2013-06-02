/*
  This example comes from a short article series in the Linux 
  Gazette by Richard A. Sevenich and Christopher Lopes, titled
  "Compiler Construction Tools". The article series starts at

  http://www.linuxgazette.com/issue39/sevenich.html

  Small changes and updates to newest JFlex+Cup versions 
  by Gerwin Klein
*/

import Tree.Declarations.Declarations;
import java.io.*;
   
public class Main {
  static public void main(String argv[]) {    
    /* Start the parser */
    try {      
      parser p = new parser(new Lexer(new FileReader("src/raiz.pas")));
      Declarations result = (Declarations)p.parse().value;
      
      int value=1;
      //System.out.println(result);
    } catch (Exception e) {
      /* do cleanup here -- possibly rethrow e */
      e.printStackTrace();
    }
  }
}