/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml2018s2;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Joao
 */
public class Jogador {

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
    int vida;
    String nome;
    double x,y,z;
    ArrayList<Arma> armas;
    
    public Arma getArma(int i){
        return armas.get(i);
    }
    public void addArma(Arma a){
        armas.add(a);
    }
    public void remove(int i){
        armas.remove(i);
    }
    
    public Jogador(){
        vida=100;
        nome="Esqueci";
        x=y=z=10.5;
        armas=new ArrayList<>();
    }
    
    public Document getXML(){
        Document doc=InterfaceXML.createDocument();
        //Element jogador=getXML(doc);
        doc.appendChild(getXML(doc));
        return doc;
    }
    public Element getXML(Document doc){
        Element jogador=doc.createElement("Jogador");
        
        jogador.setAttribute("vida",this.vida+"");
        
        Element nome=doc.createElement("nome");
        nome.setTextContent(this.nome);
        jogador.appendChild(nome);
        
        Element x=doc.createElement("x");
        x.setTextContent(this.x+"");
        jogador.appendChild(x);
        
        Element y=doc.createElement("y");
        y.setTextContent(this.y+"");
        jogador.appendChild(y);
        
        Element z=doc.createElement("z");
        z.setTextContent(this.z+"");
        jogador.appendChild(z);
        
        Element armas=doc.createElement("armas");
        for(Arma a:this.armas){
            armas.appendChild(a.getXML(doc));
        }
        jogador.appendChild(armas);
        
        return jogador;
    }
    
    public static Jogador loadXML(Element jogador){
        if(!jogador.getNodeName().equals("Jogador")){
            return null;
        }
        Jogador j=new Jogador();
        
        j.vida=Integer.parseInt(jogador.getAttribute("vida"));
        
        for(int i=0;i<jogador.getChildNodes().getLength();i++){
            Node ni=jogador.getChildNodes().item(i);
            
            if(ni.getNodeName().equals("x")){
                j.x=Double.parseDouble(ni.getTextContent());
            }
            if(ni.getNodeName().equals("y")){
                j.y=Double.parseDouble(ni.getTextContent());
            }
            if(ni.getNodeName().equals("z")){
                j.z=Double.parseDouble(ni.getTextContent());
            }
            if(ni.getNodeName().equals("nome")){
                j.nome=ni.getTextContent();
            }
            if(ni.getNodeName().equals("armas")){
                for(int k=0;k<ni.getChildNodes().getLength();k++){
                    Element nk=(Element)ni.getChildNodes().item(k);
                    j.addArma(Arma.loadXML(nk));
                }
            }
        }
        
        return j;
    }
    
    
    
    
    
    
}
