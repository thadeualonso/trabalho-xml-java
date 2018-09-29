package xml2018s2;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Locacao {
    private long id;
    private long idCliente;
    private long idFilme;
    private String data_locacao;
    private String data_devolucao;
    
    public Locacao() {}
    
     ArrayList<Cliente> clientes;
      public Cliente getcliente(int i){
        return clientes.get(i);
    }
    public void addClientes(Cliente c){
        clientes.add(c);
    }
    public void remove(int i){
        clientes.remove(i);
    }
    
    public Document getXML(){
        Document doc=InterfaceXML.createDocument();
        //Element jogador=getXML(doc);
        doc.appendChild(getXML(doc));
        return doc;
    }
    
    public Element getXML(Document doc){
        
        Element locacao=doc.createElement("Locacao");
        
        
        Element id = doc.createElement("Cod");
        id.setTextContent(this.id + "");
        locacao.appendChild(id);
        
        Element idCliente=doc.createElement("CodC");
        idCliente.setTextContent(this.idCliente+"");
        locacao.appendChild(idCliente);
        
        Element idFilme=doc.createElement("CodF");
        idFilme.setTextContent(this.idFilme+"");
        locacao.appendChild(idFilme);
        
        Element data_locacao=doc.createElement("DataLoc");
        data_locacao.setTextContent(this.data_locacao);
        locacao.appendChild(data_locacao);
        
        Element data_devolucao=doc.createElement("DataDev");
        data_devolucao.setTextContent(this.data_devolucao);
        locacao.appendChild(data_devolucao);
        
        
        Element clientes=doc.createElement("clientes");
        for(Cliente c:this.clientes){
            clientes.appendChild(c.getXml(doc));
        }
        locacao.appendChild(clientes);
        
        return locacao;
    }
    
      public static Locacao loadXML(Element locacao){
        if(!locacao.getNodeName().equals("Locacao")){
            return null;
        }
        Locacao l=new Locacao();
        
        for(int i=0;i<locacao.getChildNodes().getLength();i++){
            Node ni=locacao.getChildNodes().item(i);
            
            if(ni.getNodeName().equals("Cod")){
                l.id=Long.parseLong(ni.getTextContent());
            }
            if(ni.getNodeName().equals("CodC")){
                l.idCliente =Long.parseLong(ni.getTextContent());
            }
            if(ni.getNodeName().equals("CodF")){
                l.idFilme=Long.parseLong(ni.getTextContent());
            }
            if(ni.getNodeName().equals("DataLoc")){
                l.data_locacao = ni.getTextContent();
            }
            if(ni.getNodeName().equals("DataDev")){
                l.data_devolucao = ni.getTextContent();
            }
            if(ni.getNodeName().equals("clientes")){
                for(int k=0;k<ni.getChildNodes().getLength();k++){
                    Element nk=(Element)ni.getChildNodes().item(k);
                    l.addClientes(Cliente.loadXML(nk));
                }
            }
        }
         return l;
    }
}   
      
