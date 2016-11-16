package GeneradorDatos;
/**
 * Write a description of class CreacionEdades here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.Random;
public class CreacionEdades
{
  public static void main(String [] args){
        File n=new File("Edades.txt");
        try{
        Random r=new Random();
        BufferedWriter es= new BufferedWriter(new FileWriter(n));
       for(int i=0; i<100; i++){
        int edad= (r.nextInt(50)+10);
        String aux=""+edad;
        System.out.println(aux);
        es.write(aux);
        es.newLine();
        es.flush();
       
      }
      es.close();
     }catch(IOException e){
       e.getMessage();
      }finally{
          System.out.println("Edades aleatorias creadas con exito!");
          }  
  }
}
