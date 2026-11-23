
package eva3_1_ordenamientos;
public class EVA3_1_ORDENAMIENTOS {

   public static void main(String[] args) {
      // TODO code application logic here
      int[] original, selection, insertion, bubble, quick;
      long ini, fin, tiempo;
      original = new int[10];
      //+++++++ARREGLO ORIGINAL+++++++
      llenar(original);
      System.out.println("+++++++ARREGLO ORIGINAL+++++++");
      imprimir(original);
      //SELECCION SORT
      System.out.println("+++++++++++Selection Sort+++++++++++++");
      selection = copiar(original);
      ini = System.nanoTime();
      selectionSort(selection);
      fin = System.nanoTime();
      tiempo = fin - ini;
      imprimir(selection);
      System.out.println("Selection Sort = " + tiempo);
      //INSERTION SORT
      System.out.println("+++++++++++Insertion Sort+++++++++++++");
      insertion = copiar(original);
      ini = System.nanoTime();
      insertionSort(insertion);
      fin = System.nanoTime();
      tiempo = fin - ini;
      imprimir(insertion);
      System.out.println("Insertion Sort = " + tiempo);
      System.out.println("+++++++++++Bubble Sort+++++++++++++");
      bubble = copiar(original);
      ini = System.nanoTime();
      bubbleSort(bubble);
      fin = System.nanoTime();
      tiempo = fin - ini;
      imprimir(bubble);
      System.out.println("Bubble Sort = " + tiempo);
      //QUICK SORT
      System.out.println("+++++++++++Quick Sort+++++++++++++");
      quick = copiar(original);
      ini = System.nanoTime();
      quickSort(quick);
      fin = System.nanoTime();
      tiempo = fin - ini;
      imprimir(quick);
      System.out.println("Quick Sort = " + tiempo);
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
   
   public static int[] copiar(int[] arreglo){
      int resu[] = new int[arreglo.length];
      for (int i = 0; i < arreglo.length; i++) {
         resu[i] = arreglo[i];
      }
      return resu;
   }
   //metodos de ordenamiento
   //selection sort
   //O(N2)
   //O(N2) COMPARA MAS
   //O(N) INTERCAMBIA MENOS
   public static void selectionSort(int[] arreglo){//JORGEEEEEEEEEE
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
   
   public static void insertionSort(int[] arreglo){//CCHEEMS
      for (int i = 1; i < arreglo.length; i++) {
        int temp = arreglo[i]; // VALOR QUE VAMOS A INSERTAR
        int j = i - 1; // COMENZAMOS COMPARANDO HACIA ATRAS
        for (; j >= 0 && arreglo[j] > temp; j--) {
            arreglo[j + 1] = arreglo[j]; // RECORRER HACIA LA DERECHA
        }
        arreglo[j + 1] = temp; // INSERTAR EN SU POSICION
    }
   }
   //EL PEOR DE TODOS
   //O(N2)
   //TIENE LOS PEORES ATRIBUTOS DE LOS ALGORITMOS ANTERIORES:
   //COMPARA MUCHO
   //INTERCAMBIA MUCHO
   //TENTADOR: ES EL MAS SENCILLO
   public static void bubbleSort(int[] arreglo){//LEONARDO
      for (int i = 0; i < arreglo.length; i++) {
         for (int j = 0; j < arreglo.length - 1; j++) {
            if(arreglo[j] > arreglo[j + 1]){
               int temp = arreglo[j];
               arreglo[j] = arreglo[j + 1];
               arreglo[j + 1] = temp;
            }
         }
      }
   }
   
   public static void quickSort(int[] arreglo){
      quickSortRec(arreglo, 0, arreglo.length - 1);
   }
   
   private static void quickSortRec(int[] arreglo, int ini, int fin){//DANIEL
      //condicion para evitar la recursividad
      //seleccionar pivote ---> cualquiera, nosostros el primer elemento
      //un ciclo que se repite mientras los indices no se crucen
         //un ciclo que busque los mas grandes que el pivote
         //un cilo que busque los mas pequeños
         //si no se han cruzado, pero se detuvieron
            //intercambiar
         //si se cruzaron:
            //intercambiar small con pivote ---> small es nuevo pivote
            //terminar ciclo principal
         //llamadas (2 izq y der de pivote) recursivas
         if(ini < fin){
            int pivote = arreglo[ini];
            
            int izq = ini + 1;
            int der = fin;
               
               while(izq <= der){
                  while(izq <= der && arreglo[izq] <= pivote){
                     izq++;
                  }
                  while(izq <= der && arreglo[der] > pivote){
                     der--;
                  }
                  if(izq < der){
                     int temp = arreglo[izq];
                     arreglo[izq] = arreglo[der];
                     arreglo[der] = temp;
                  }
               }
               
               int small = der;
               int temp = arreglo[ini];
               arreglo[ini] = arreglo[small];
               arreglo[small] = temp;
               
               quickSortRec(arreglo, ini, small - 1);
               quickSortRec(arreglo, small + 1, fin);
         }
   }
}
