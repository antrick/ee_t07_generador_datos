package GeneradorDatos;/**
 * Write a description of class Nodo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nodo
{
    
    private String o;
    private Nodo sig;
    private Nodo ant;

    public Nodo(String o, Nodo ant, Nodo sig)
    {
        this.o = o;
        this.sig = sig;
        this.ant = ant;
    }
    
    public void setDato(String o){
        this.o = o;
    }
    
    public void setSig(Nodo sig){
        this.sig = sig;
    }
    
    public void setAnt(Nodo ant){
        this.ant = ant;
    }
    
    public String getDato(){
        return o;
    }
    
    public Nodo getSig(){
        return sig;
    }
    
    public Nodo getAnt(){
        return ant;
    }
    
    public String toString(){
     String s=o;
     // s+=o;
     return s;
    }
}
