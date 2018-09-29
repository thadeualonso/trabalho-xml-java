/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml2018s2;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 *
 * @author Joao
 */
public class Arma {
    
    String nome;
    int municao;
    int dano;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMunicao() {
        return municao;
    }

    public void setMunicao(int municao) {
        this.municao = municao;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
    public Arma(){
        nome="Arma 1";
        dano=1;
        municao=10;
    }
    
    public Document getXML(){
        
        Document doc=InterfaceXML.createDocument();
        Element arma=getXML(doc);
        doc.appendChild(arma);
        return doc;
    } 
    public Element getXML(Document doc){
        Element arma=doc.createElement("Arma");
        
        Element nome=doc.createElement("nome");
        nome.setTextContent(this.nome);
        
        Element dano=doc.createElement("dano");
        dano.setTextContent(this.dano+"");
        
        Element municao=doc.createElement("municao");
        municao.setTextContent(this.municao+"");
        
        arma.appendChild(nome);
        arma.appendChild(dano);
        arma.appendChild(municao);
        
        return arma;
        
        
    }
    
    
    public static Arma loadXML(Element arma){
        if(!arma.getNodeName().equals("Arma")){
            return null;
        }
        Arma a=new Arma();
        
        for(int i=0;i<arma.getChildNodes().getLength();i++){
            Node ni=arma.getChildNodes().item(i);
            if(ni.getNodeName().equals("nome")){
                a.nome=ni.getTextContent();
            }
            if(ni.getNodeName().equals("municao")){
                a.municao=Integer.parseInt(ni.getTextContent());
            }
            if(ni.getNodeName().equals("dano")){
                a.dano=Integer.parseInt(ni.getTextContent());
            }
        }
        
        return a;
    }
    
    
    
}
