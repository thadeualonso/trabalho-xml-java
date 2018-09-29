package xml2018s2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Usuario 
{
    private String login;
    private String senha;
    private String email;
    
    public Usuario() { }

    public Usuario(String login, String senha, String email) {
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public Document getXml()
    {
        Document doc = InterfaceXML.createDocument();
        
        doc.appendChild(getXml(doc));
        return doc;
    }
    
    public Element getXml(Document doc) 
    {
        Element usuario = doc.createElement("Usuario");
        
        Element login = doc.createElement("Login");
        login.setTextContent(this.login);
        
        Element senha = doc.createElement("Senha");
        senha.setTextContent(this.senha);
        
        Element email = doc.createElement("Email");
        email.setTextContent(this.email);
        
        usuario.appendChild(login);
        usuario.appendChild(senha);
        usuario.appendChild(email);
        
        return usuario;
    }
}