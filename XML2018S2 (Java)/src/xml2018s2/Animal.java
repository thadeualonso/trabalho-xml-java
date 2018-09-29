package xml2018s2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Animal 
{
    private long id;
    private String nome;
    private String raca;
    private String sexo;
    private String cor;
    private String nascimento;
    private long peso;
    private long altura;
    private String tipo;
    private Usuario usuario;
    
    public Animal() { }

    public Animal(long id, String nome, String raca, String sexo, String cor, String nascimento, long peso, long altura, String tipo, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.sexo = sexo;
        this.cor = cor;
        this.nascimento = nascimento;
        this.peso = peso;
        this.altura = altura;
        this.tipo = tipo;
        this.usuario = usuario;
    }
    
    public Document getXml()
    {
        Document doc = InterfaceXML.createDocument();
        doc.appendChild(getXml(doc));
        
        return doc;
    }
    
    public Element getXml(Document doc)
    {
        Element animal = doc.createElement("Animal");
        
        Element id = doc.createElement("Id");
        id.setTextContent(this.id + "");
        
        Element nome = doc.createElement("Nome");
        nome.setTextContent(this.nome);
        
        Element raca = doc.createElement("Raca");
        raca.setTextContent(this.raca);
        
        Element sexo = doc.createElement("Sexo");
        sexo.setTextContent(this.sexo);
        
        Element cor = doc.createElement("Cor");
        cor.setTextContent(this.cor);
        
        Element nascimento = doc.createElement("Nascimento");
        nascimento.setTextContent(this.nascimento);
        
        Element peso = doc.createElement("Peso");
        peso.setTextContent(this.peso + "");
        
        Element altura = doc.createElement("Altura");
        altura.setTextContent(this.altura + "");
        
        Element tipo = doc.createElement("Tipo");
        tipo.setTextContent(this.tipo);
        
        Element usuario = this.usuario.getXml(doc);
        
        animal.appendChild(id);
        animal.appendChild(nome);
        animal.appendChild(raca);
        animal.appendChild(sexo);
        animal.appendChild(cor);
        animal.appendChild(nascimento);
        animal.appendChild(peso);
        animal.appendChild(altura);
        animal.appendChild(tipo);
        animal.appendChild(usuario);
        
        return animal;
    }
}