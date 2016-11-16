package GeneradorDatos;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;
  /**Importamos nuestras librerias necesarias*/

public class Aleatorios
{
  public void NuevosNombres(){
      int crea=Integer.parseInt(JOptionPane.showInputDialog("cantidad de datos a crear "));
    File n= new File("Nombres.txt");  /**Declaramos la clase file para recibir archivos*/
    File p= new File("aPaternos.txt");
    File m= new File("aMaternos.txt");
    File d=new File("direcciones.txt");
    File e=new File("Edades.txt");
    File nu=new File("Nuevos.csv");  /**Declaramos una mas para almacenar nuestros nombres completos*/
    
      ListaDobleLigada names=new ListaDobleLigada();
      ListaDobleLigada apP=new ListaDobleLigada();
      ListaDobleLigada apM=new ListaDobleLigada(); /**declaramos listas doblemente ligadas para almacenar datos*/
      ListaDobleLigada dir=new ListaDobleLigada();
      ListaDobleLigada eda=new ListaDobleLigada();
      
     String [] nom =new String [1]; /**declaramos unos arreglos auxiliares para almacenar 1 elementos a la vez que estan en los archivos*/
     String [] aP =new String [1];
     String [] aM =new String[1];
     String [] di=new String[1];
     String [] ed=new String[1];
     
     
     int nObj=0; 
     
     try{
       
        BufferedReader le =new BufferedReader(new FileReader(n));
        BufferedReader lee =new BufferedReader(new FileReader(p)); /**instanciamos los buffered 3 para leer los archivos y uno mas para escribir en el nuevo*/
        BufferedReader leer =new BufferedReader(new FileReader(m));
        BufferedReader aa =new BufferedReader(new FileReader(d));
        BufferedReader leeer =new BufferedReader(new FileReader(e));
        BufferedWriter es= new BufferedWriter(new FileWriter(nu));
        
        String aux1=le.readLine();  /**leemos la primera linea de los 3 archivos y almacenamos en una variable String*/
        String aux2=lee.readLine();
        String aux3=leer.readLine();
        String aux4=aa.readLine();
        String aux5=leeer.readLine();
         while(aux1!=null && aux2!=null && aux3!=null && aux4!=null && aux5!=null){  /**iniciamos un ciclo while que termine hasta que no existan mas datos*/
             
           nom= aux1.split(" "); /**guardamos en los arreglos auxiliares lo que leimos en la primera linea de cada archivo*/
           aP= aux2.split(" ");
           aM= aux3.split(" ");
           di=aux4.split("\n");
           ed=aux5.split(" ");
          
           names.AgregarFin(nom[0]);
           apP.AgregarFin(aP[0]); /**ocupamos el metodo de lista ligada agregar al final y agregaremos lo que contenga almacenado el arreglo*/
           apM.AgregarFin(aM[0]);
           dir.AgregarFin(di[0]);
           eda.AgregarFin(ed[0]);
           
           aux1=le.readLine();
           aux2=lee.readLine(); /**le damos la instruccion de leer la siguiente linea con el metodo readline*/
           aux3=leer.readLine();
           aux4=aa.readLine();
           aux5=leeer.readLine();
           }
           
           int cont=0;  /**contador para el ciclo while que nos permita decir donde terminar*/
           String s; /**una variable para almacenar los nombres completos, nombre + apellido paterno + apellido materno*/
           
         while(cont<crea){ /**la condicion del while*/
             
             nObj++; /** contador de nombres creados*/
            int z= (int)(Math.random()*names.getCont()+1 );  /**instanciamos un metodo math.random que nos permita sacar aleatoriamente un numero entre 1 (sumamos +1 porque el conteo inicia en 1) y el limite de elementos de la lista ligada*/
            int x= (int)(Math.random()*apP.getCont()+1 ); /**ya que tenemos el numero aleatorio lo guardamos en una variable de tipo entero */
            int y= (int)(Math.random()*apM.getCont()+1 );
            int w= (int)(Math.random()*dir.getCont()+1 );
            int l= (int)(Math.random()*eda.getCont()+1 );
            //System.out.println("z "+z+" x "+x+" y "+y); //prueba para verificar que los aleatorios no resulten cero y evitar que nos devuelva null la busqueda 
            
             s= names.Buscar(z)+","+apP.Buscar(x)+","+apM.Buscar(y)+","+eda.Buscar(l)+","+dir.Buscar(w); /** finalmente asignamos en la variable string datos aleatorios dentro de la lista ligada usando su metodo buscar por posicion*/
              System.out.println(s); /**imprimimos en consola cada resultado*/
              es.write(s); /**declaramos el metodos write para escribir el contenido de la variable string en el archivo*/
              es.newLine(); /**metodo newline para pasar a la siguiente linea*/
              es.flush(); /**flush por si existen informacion atrapada aun en la clase*/
             cont++; 
            }
           
         es.close(); /**cerramos los archivos una vez terminados los ciclos*/
        le.close();
        lee.close();
        leer.close();
        aa.close();
        leeer.close();
        }
        catch(FileNotFoundException na){  /**colocamos las excepciones*/
        System.out.println("Alguno de los archivos no se encuentra");
      }
      catch(IOException io){
        System.out.println("excepcion inesperada");
        }
     finally{
        System.out.println("\nse agregaron "+nObj+" nombres y apellidos del archivo");
        }
    }
    
     public static void main(String [] args){  /**metodo main*/
       Aleatorios data= new Aleatorios();
       data.NuevosNombres();
        }
}
