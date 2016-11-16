package GeneradorDatos;
public class ListaDobleLigada
{
    private Nodo cab,fin;
    private int cont;
    
    public ListaDobleLigada()
    {
        cont = 0;
        cab = fin =null;
    }
    
    public boolean vacia()
    {
        return cab == null;
    }

   public boolean AgregarIni(String o)
   {  
         Nodo n= new Nodo(o,null,null);
   if(n==null)return false;
    if(vacia()){
        cab = n;
        fin = cab;
        cont ++;
    }else{
        n.setSig(cab);
        cab.setAnt(n);
        cab = n;
        cont ++;
    }
    return true;    
  }


   public boolean AgregarFin(String o)
   {  
          Nodo n= new Nodo(o,null,null);
   if(n==null)return false;
    if(vacia()) AgregarIni(o);
    else{
        fin.setSig(n);
        n.setAnt(fin);
        fin = n;
        cont ++;
    }
    return true;    
  }
  
  public boolean AgregarDes(String o,String bus)
  {
      Nodo n= new Nodo(o,null,null);
      if(n == null) return false;
      if(vacia() && cont <3) AgregarFin(o);
      else{
            Nodo aux = cab;
             Nodo ant = cab;   
            while(aux.getSig()!=null && !ant.getDato().equals(bus)){
                ant = aux;
                aux = aux.getSig();
            }
            if(aux == null) AgregarFin(o);
            else{
                ant.setSig(n);
                n.setAnt(ant);
                n.setSig(aux);
                aux.setAnt(n);
                cont ++;
            }
        }
        return true;
    } 
   
    
    public boolean AgregarPos(String o, int pos){
        Nodo n = new Nodo(o,null,null);
        if(n == null) return false;
        if(vacia())
            AgregarIni(o);
        else{
            if(pos>cont)AgregarFin(o);
            if(pos<=1)
                    AgregarIni(o);
            else{
                Nodo aux = cab;
                Nodo ant = null;
                for(int i = 0; i < pos-1; i++){
                    ant = aux;
                    aux = aux.getSig();
                }   
                ant.setSig(n);
                n.setAnt(ant);
                n.setSig(aux);
                aux.setAnt(n);
                cont ++;
            }
        }
        return true;
    }
    
    public String Eliminar(){
        Nodo e = cab;
        fin = null;
        cab = null;
        cont --;
        return e.getDato();
    }
    
      public String EliminarIni(){
        if(vacia())return null;
        if(cont == 0)return null;
        if(cont  == 1) return Eliminar();
            Nodo aux = cab;
        cab = cab.getSig();
        cab.setAnt(null);
        cont--;
        return aux.getDato();        
    }
    
       public String EliminarFin(){
           if(cont == 0)return null;
        if(vacia())return null;
         if(cont  == 1) return Eliminar();
           Nodo aux = cab;
       while(aux.getSig()!=fin)
            aux = aux.getSig();
          Nodo e = aux;
          aux.setSig(null);
          fin = aux;
          cont --;
          return e.getDato();
    }
    
     public String EliminarAnt(String bus){
         if(cont == 0)return null;
        if(vacia())return null;
        if(cont < 3)EliminarIni();
        else{
           Nodo aux = cab;
           Nodo ant = null;
           Nodo p = aux.getSig();
            while(aux.getSig()!=null && !p.getDato().equals(bus)){
                ant = aux;
                aux = aux.getSig();
                p = aux.getSig();
            }
            Nodo e = aux;
            ant.setSig(aux.getSig());
            p.setAnt(ant);
            cont --;
            return e.getDato();
        }
          return bus;
    }
    
     public String EliminarDes(String bus){
         if(cont == 0)return null;
        if(vacia())return null;
           Nodo aux = cab;
           Nodo ant = cab;
           Nodo e = null;
            while(aux.getSig()!=null && !ant.getDato().equals(bus)){
                ant = aux;
                aux = aux.getSig();               
            }
            if(aux.getSig()== null) EliminarFin();
            else{
           e = aux;
            Nodo p = aux.getSig();
            ant.setSig(p);
            p.setAnt(ant);
            cont --;
          return e.getDato();
        }
         return e.getDato();
    }
    
    public String Buscar(int pos){
       if(cont == 0)return null;
            if(vacia())return null;
            String obj=null;
                Nodo aux = cab;
           if(pos>cont){return null;}
           else{    
           for(int i = 0; i < pos; i++){
               obj = aux.getDato();
               aux = aux.getSig();
           }}
            
           return obj;
    }
    
    public Object EliminarPos(int pos){
       if(cont == 0)return null;
            if(vacia())return null;
            if(cont < pos) EliminarFin();
            if(pos<=1)EliminarIni();
                Nodo aux = cab;
                Nodo ant = null;
           for(int i = 0; i < pos-1; i++){
               ant = aux;
               aux = aux.getSig();
           }
            Nodo e,p;
            p = aux.getSig();
            e = aux;
            ant.setSig(p);
            p.setAnt(ant);
           cont --;
           return e.getDato();
    }
    public void recorre(){
      Nodo temp;
      temp=cab;
      while(temp.getSig()!=null){
        System.out.print(temp.getDato()+"->");
        temp=temp.getSig();
        }
    }
    public int getCont(){
     return cont;
    }
}
