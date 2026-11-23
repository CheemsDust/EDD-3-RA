/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package eva3_3_busqueda_binaria;

import java.util.Scanner;

/**
 *
 * @author calza
 */
public class EVA3_3_BUSQUEDA_BINARIA {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
      int[] original;
      original = new int[10];
      //+++++++ARREGLO ORIGINAL+++++++
      llenar(original);
      System.out.println("+++++++ARREGLO ORIGINAL+++++++");
      imprimir(original);
      //ORDENADO
      selectionSort(original);
      System.out.println("ARREGLO ORDENADO");
      imprimir(original);
      //VALOR A BUSCAR
      Scanner captu = new Scanner(System.in);
      System.out.println("Valor a buscar : ");
      int valor = captu.nextInt();
      System.out.println("Valor en posicion: " + busquedaBinaria(original, valor));
   }
   public static void llenar(int[] arreglo){
      for (int i = 0; i < arreglo.length; i++) {
         arreglo[i] = (int)(Math.random() * 100);
      }
   }
   
   public static void imprimir(int[] arreglo){
      for (int i = 0; i < arreglo.length; i++) {
         System.out.print("[" + arreglo[i] + "]");
      }
      System.out.println("");
   }
   public static void selectionSort(int[] arreglo){
      for (int i = 0; i < arreglo.length; i++) {//controla las pasadas
         int min = i;//cuando empiezo, el más pequeño es el primer elemento
         for (int j = i + 1; j < arreglo.length; j++) {//busca el valor mas pequeño
            if(arreglo[min] > arreglo[j]){//NUEVO MINIMO
               min = j;
            }
         }
         //intercambio o swap
            int temp = arreglo[min];
            arreglo[min] = arreglo[i];
            arreglo[i] = temp;
      }
   }
   
   public static int busquedaBinaria(int[] arreglo, int valor){
      return busquedaBinariaRecu(arreglo,valor, 0, arreglo.length - 1);
   }
   
   private static int busquedaBinariaRecu(int[] arreglo, int valor, int ini, int fin){
      int mitad = ini + ((fin - ini) / 2);//determina la posicion intermedia
      int posicion = -1; //por defaul ---> no encontrado (-1 no es posicion valida)
      if(ini <= fin){
      if(valor > arreglo[mitad])
        posicion = busquedaBinariaRecu(arreglo, valor,mitad + 1, fin);
      else if(valor < arreglo[mitad])
        posicion = busquedaBinariaRecu(arreglo, valor, ini, mitad - 1);
      else
         posicion = mitad;
      }
      return posicion;//regreso la posicion del elemento
   }
}
