/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_2_ordenar_collections;

import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author calza
 */
public class EVA3_2_ORDENAR_COLLECTIONS {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
      LinkedList<Integer> lista = new LinkedList<>();
      lista.add(500);
      lista.add(300);
      lista.add(900);
      lista.add(100);
      lista.add(800);
      lista.add(700);
      lista.add(200);
      
      //creamos un comparator
      Comparator comparator = new Comparator(){
         @Override
         public int compare(Object o1, Object o2){
            int val1 = (int)o1;
            int val2 = (int)o2;
            
            //el compare regresa un valor entero, que significa:
            //positivo ---> o1 es mayor 
            //cero ---> 01 y 02 son iguales
            //negativo ---> o2 es mayor
            return val1 - val2;
            
            /*
            if(val1 > val2)
               return 1000;
            else if(val1 == val2)
               return 0;
            else
               return -1;*/
            
         }
      };
      
      lista.sort(comparator);
      System.out.println(lista);
      
     LinkedList<String> datos = new LinkedList<>();
     datos.add("Hola");
     datos.add(" ");
     datos.add("Mundo");
     datos.add("!!!");
     
     Comparator comparator2 = new Comparator(){
         @Override
         public int compare (Object o1, Object o2){
            String cade1 = (String)o1;
            String cade2 = (String)o2;
            return cade1.compareTo(cade2);
         }
     };
     
      datos.sort(comparator2);
      System.out.println(datos);
   }
   
}
