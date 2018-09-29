/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml2018s2;
import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
/**
 *
 * @author Joao
 */

public class InterfaceXML {
    
    public static Document  createDocument(){
        try{
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            return db.newDocument();
        }catch(Exception e){
            return null;
        }
    }
    
    public static Document loadFromFile(String path){
        try{
            File f=new File(path);
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            return db.parse(f);
        }catch(Exception e){
            return null;
        }
    }
    public static Document loadFromString(String XML){
        try{
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db=dbf.newDocumentBuilder();
            return db.parse(new InputSource(new StringReader(XML)));
        }catch(Exception e){
            return null;
        }
    }
    
    public static String XmlToString(Document doc){
        DOMImplementationLS dls=(DOMImplementationLS)doc.getImplementation();
        LSSerializer ls=dls.createLSSerializer();
        LSOutput lso=dls.createLSOutput();
        
        lso.setEncoding("UTF-8");
        
        StringWriter sw=new StringWriter();
        
        lso.setCharacterStream(sw);
        
        ls.write(doc, lso);
        
        return sw.toString();
        
        
    }
    
    public static void saveXML(Document doc,String path){
        DOMImplementationLS dls=(DOMImplementationLS)doc.getImplementation();
        LSSerializer ls=dls.createLSSerializer();
        LSOutput lso=dls.createLSOutput();
        
        lso.setEncoding("UTF-8");
        
        try{
            FileWriter fw=new FileWriter(path,false);
            
            lso.setCharacterStream(fw);

            ls.write(doc, lso);
            fw.close();
        
        }catch(Exception e){
            System.err.println(e.toString());
        }
        
    }
    
    
}
