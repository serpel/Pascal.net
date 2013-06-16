/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AssemblyInfo;

import java.util.Hashtable;

/**
 *
 * @author SergioJavier
 */
public class Assambly {
    
    String name,version;
    String header, body, footer;  
    
    static Assambly instance = null;
    Hashtable<String, Integer> label = new java.util.Hashtable<>();
    
    private Assambly() {
        this.name = "test";
        this.version = "1:0:1:0";
        this.hederInfo();
    }

    public static Assambly getInstance() {
        
        if (instance == null)
        {
            instance = new Assambly();
        }
        return instance;
    }  
    
    public void setInfo(String name, String version)
    {
        this.name = name;
        this.version = version;
        hederInfo();
    }
    
    public String getLabel(String name)
    {
        String tmp;
        if(!label.containsKey(name))
        {
            label.put(name,0);
        }        
        
        tmp = name+label.get(name);        
        label.put(name, label.get(name)+1);
          
        return tmp;
        
    }
    
    private void hederInfo()
    {   
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
