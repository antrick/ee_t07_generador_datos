package GeneradorDatos;
/**
 * Write a description of class CreacionEdades here.
 * 
 * @author (andy mota moreno) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.Random; /**declaramos librerias*/
public class CreacionEdades  /**metodo para crear edades aleatoriamente*/
{
  public static void main(String [] args){
        File n=new File("Edades.txt");  /**colocamos un nuevo archivo*/
        try{
        Random r=new Random(); /**declaramos un random*/
        BufferedWriter es= new BufferedWriter(new FileWriter(n)); /**declaramos un bufferedwriter para escribir en el archivo*/
       for(int i=0; i<100; i++){ /**el for nos permite crear 100 edades*/
        int edad= (r.nextInt(50)+10); /**el nextInt le agregamos 50 +10 para que nos cree edades en un rango entre 10 y 50, y las guardamos en una variable int*/
        String aux=""+edad; /**para evitar que al escribir en el archivo nos guarde con otros caracteres lo agregamos a una cadena*/
        System.out.println(aux); /**imprimimos consola*/
        es.write(aux);/**escribimos archivo*/
        es.newLine();/**pasamos a la siguiente linea*/
        es.flush();/**nos permite evitar que se quede informacion perdida y escriba todo en archivo*/
       
      }
      es.close(); /**cerramos el archivo*/
     }catch(IOException e){ /**excepciones*/
       e.getMessage();
      }finally{
          System.out.println("Edades aleatorias creadas con exito!");
          }  
  }
}
