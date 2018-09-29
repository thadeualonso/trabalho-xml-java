/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml2018s2;

import org.w3c.dom.Document;

/**
 *
 * @author Joao
 */
public class XML2018s2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jogador j=new Jogador();
        Arma a=new Arma();
        j.addArma(a);
        
        a=new Arma();
        
        a.setNome("Arma 2 de teste");
        
        j.addArma(a);
        
        Document d=j.getXML();
        
        JFrame1 f=new JFrame1();
        f.setVisible(true);
        
        System.out.println(InterfaceXML.XmlToString(d));
        
    }
    
}
