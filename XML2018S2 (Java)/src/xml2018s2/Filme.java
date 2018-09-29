package xml2018s2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import xml2018s2.Cliente;
import xml2018s2.InterfaceXML;

public class Filme {
    
    private long id;
    private String nome;
    private String categoria;
    private String sinopse;
    private long ano;
    
    
    public Filme(){ }
    
    public Filme (long id, String nome, String categoria, String sinopse, Long ano) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.sinopse = sinopse; 
        this.ano = ano;
        
        
    }
     public Document getXml()
    {
        Document doc = InterfaceXML.createDocument();
        doc.appendChild(getXml(doc));
        
        return doc;
    }
       public Element getXml(Document doc)
    {
        Element filme = doc.createElement("Filme");
        
        filme.setAttribute("categoria",this.categoria+"");
        
        Element id = doc.createElement("Cod");
        id.setTextContent(this.id + "");
        
        Element nome = doc.createElement("Nome");
        nome.setTextContent(this.nome);
        
        Element sinopse = doc.createElement("Sinopse");
        sinopse.setTextContent(this.sinopse);
        
        Element ano = doc.createElement("Ano");
        ano.setTextContent(this.ano+ "");
        
        filme.appendChild(id);
        filme.appendChild(nome);
        filme.appendChild(sinopse);
        filme.appendChild(ano);
        
        return filme;
    }
       public static Filme loadXML(Element filme){
        if(!filme.getNodeName().equals("Filme")){
            return null;
        }
        Filme f = new Filme();
        
        
        for(int i=0;i<filme.getChildNodes().getLength();i++){
            Node ni=filme.getChildNodes().item(i);
            
             f.categoria= filme.getAttribute("categoria");
            
            if(ni.getNodeName().equals("Cod")){
                f.id=Long.parseLong(ni.getTextContent());
            }
             if(ni.getNodeName().equals("Nome")){
                f.nome=ni.getTextContent();
            }
            if(ni.getNodeName().equals("Sinopse")){
                f.sinopse=ni.getTextContent();
            }
             if(ni.getNodeName().equals("Ano")){
               f.ano=Long.parseLong(ni.getTextContent());
            } 
        }
        
        return f;
    }
}
