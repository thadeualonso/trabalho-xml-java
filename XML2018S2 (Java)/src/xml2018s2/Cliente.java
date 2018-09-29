
package xml2018s2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Cliente {
    
    private long id;
    private String nome;
    private String email;
    private String cpf;
    private String data_nascimento;
    private String login;
    private long senha;
    private long permissao;
    
    
    public Cliente(){ }
    
    public Cliente (long id, String nome, String email, String cpf, String data_nascimento, String login, long senha, long permissao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.login = login;
        this.senha = senha;
        this.permissao = permissao;
    }
     public Document getXml()
    {
        Document doc = InterfaceXML.createDocument();
        doc.appendChild(getXml(doc));
        
        return doc;
    }
     
    public Element getXml(Document doc)
    {
        Element cliente = doc.createElement("Cliente");
        
        Element id = doc.createElement("Cod");
        id.setTextContent(this.id + "");
        
        Element nome = doc.createElement("Nome");
        nome.setTextContent(this.nome);
        
        Element email = doc.createElement("Email");
        email.setTextContent(this.email);
        
        Element cpf = doc.createElement("CPF");
        cpf.setTextContent(this.cpf);
        
        Element data_nascimento = doc.createElement("Nascimento");
        data_nascimento.setTextContent(this.data_nascimento);
        
        Element login = doc.createElement("Login");
        login.setTextContent(this.login + "");
        
        Element senha = doc.createElement("Senha");
        senha.setTextContent(this.senha + "");
        
        Element permissao = doc.createElement("Permissao");
        permissao.setTextContent(this.permissao + "");
        
        cliente.appendChild(id);
        cliente.appendChild(nome);
        cliente.appendChild(email);
        cliente.appendChild(cpf);
        cliente.appendChild(data_nascimento);
        cliente.appendChild(login);
        cliente.appendChild(senha);
        cliente.appendChild(permissao);
        
        return cliente;
    }
        
    public static Cliente loadXML(Element cliente){
        if(!cliente.getNodeName().equals("Cliente")){
            return null;
        }
        Cliente c=new Cliente();
        
        
        for(int i=0;i<cliente.getChildNodes().getLength();i++){
            Node ni=cliente.getChildNodes().item(i);
            
            if(ni.getNodeName().equals("Cod")){
                c.id=Long.parseLong(ni.getTextContent());
            }
             if(ni.getNodeName().equals("Nome")){
                c.nome=ni.getTextContent();
            }
            if(ni.getNodeName().equals("Email")){
                c.email=ni.getTextContent();
            }
             if(ni.getNodeName().equals("CPF")){
                c.cpf=ni.getTextContent();
            }
              if(ni.getNodeName().equals("Nascimento")){
                c.data_nascimento=ni.getTextContent();
            }
            if(ni.getNodeName().equals("Login")){
                c.login=ni.getTextContent();
            }
            if(ni.getNodeName().equals("Senha")){
                c.senha=Long.parseLong(ni.getTextContent());
            }
            if(ni.getNodeName().equals("Permissao")){
                c.permissao=Long.parseLong(ni.getTextContent());
            }  
        }
        
        return c;
    }
    
}




