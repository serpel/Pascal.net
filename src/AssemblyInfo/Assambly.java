/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssemblyInfo;

/**
 *
 * @author SergioJavier
 */
public class Assambly {
    
    String name,version;
    String header, body, footer;  

    public Assambly(String name, String version) {
        
        if(name.isEmpty())
        {
            name = "test";
        }
        if(version.isEmpty())
        {
            version = "1:0:1:0";
        }
        this.version = version;
        this.name = name;
        
        StringBuilder head = new StringBuilder("\n"); 
        
        //assamblies
        head.append(".assembly extern mscorlib {}\n");
        head.append(".assembly "); head.append(this.name); 
        head.append("\n{\n");head.append("\t.ver "); head.append(this.version);head.append("\n}\n");
        //module
        head.append(".module ");head.append(this.name);head.append(".exe\n");
        
        this.header = head.toString();
    }

    public String getName() {
        return name;
    }

    public String getHeader() {          
        return header;
    }

    public String getProgram()
    {
        return this.header+this.body+this.footer;
    }
    
    public String getBody() {
        return body;
    }

    public String getFooter() {
        return footer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }   
}
