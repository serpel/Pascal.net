/*
  This example comes from a short article series in the Linux 
  Gazette by Richard A. Sevenich and Christopher Lopes, titled
  "Compiler Construction Tools". The article series starts at

  http://www.linuxgazette.com/issue39/sevenich.html

  Small changes and updates to newest JFlex+Cup versions 
  by Gerwin Klein
*/

import Semantic.Env;
import Semantic.ErrorLog;
import Tree.Declarations.Declarations;
import Tree.Declarations.Program;
import java.io.*;
   
public class Main {
    static public void main(String argv[]) {
        /* Start the parser */
        try {
            parser p = new parser(new Lexer(new FileReader("src/potencia.pas")));
            Declarations result = (Declarations) p.parse().value;

            //validacion semantica
            result.semantic();
            ErrorLog.getInstance().print();

            //generacion de codigo
            String code = result.codeGeneration();
            System.out.println(code);
            //escribir en archivo il
            File file = new File("C:\\Users\\SergioJavier\\Documents\\ejercicios\\" + 
                                ((Program) result).getName().getIdentifier() + ".il");
            
                file.setExecutable(true);
	        file.setReadable(true);
	        file.setWritable(true);
            // if file doesnt exists, then create it
            if (!file.exists()) {

                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(code);
            bw.flush();
            bw.close();

            int value = 1;
            //System.out.println(result);
        } catch (Exception e) {
      /* do cleanup here -- possibly rethrow e */
      e.printStackTrace();
    }
  }
}