package lab7_jesusr;

import java.util.Scanner;
import java.util.Random;
import javax.swing.JOptionPane;

public class Lab7_JesusR {
    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();
 
    public static void main(String[] args) {
        int opcion=0;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:{
                    int M=0;
                    int N=0;
                    System.out.println("Ingrese M: ");
                    M= leer.nextInt();
                    System.out.println("Ingrese N: ");
                    N =  leer.nextInt();
                    int[][] numeros = new int[M][N];
                    int[][] numero = lectura(M, N);
                    System.out.println(imprimir(numero));
                    Transpuesta(numero);
                       
                }
                break;
                
                case 2:{
                    int M=0;
                    int N=0;
                    System.out.println("Ingrese M: ");
                    M= leer.nextInt();
                    System.out.println("Ingrese N: ");
                    N =  leer.nextInt();
                    int[][] numeros = new int[M][N];
                    int[][] numero = lectura(M, N);
                    System.out.println(imprimir(numero));
                    Multiplicacion(numero);
                }
                break;
                case 3:{
                    String palab1 = "";
                    String palab2 = "";
                    System.out.println("Ingrese una palabara con -: ");
                    palab1= leer.next();
                    System.out.println("Ingrese otra palabra con -: ");
                    palab2= leer.next();
                    subsecuencia (palab1, palab2);
                }
                break;
                case 0:{
                    System.out.println("Saliendo...");
                }
                default:
                {
                    System.out.println("No valido");
                }
                    }
                    
                    
        
               
            
    }while (opcion!=0);
  }
    
    
    public static int menu (){
         System.out.println("1: Portrait ");
            System.out.println("2: Numero magico ");
            System.out.println("3: Subsecuencia ");
            System.out.println("0:Salir");
            System.out.println("Ingrese su desicion");
            int opcion = leer.nextInt();
     return opcion;
    }
    
     public static int[][] lectura(int fila, int columna) {
        int[][] temporal = new int[fila][columna];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                temporal[i][j] = random.nextInt(9);
            }
        }
        return temporal;
    }
      public static String imprimir(int[][] numero) {
        String cadena = "";

        for (int i = 0; i < numero.length; i++) {
            for (int j = 0; j < numero[i].length; j++) {
                cadena += "[" + numero[i][j] + "]" + " ";
            }
            cadena += "\n";
        }

        return cadena;
    }
      
      public static int[][] Transpuesta (int [][] numero){
        int col1 = numero[0].length;
        int fil1= numero.length;
        int ajax;
        int [][] Trans = new int [col1][fil1];
          for (int i = 0; i <= numero.length-1; i++) {
              for (int j = 0; j <= numero[0].length-1; j++) {
                  Trans [j][i]= numero[fil1-1-i][j];
              }
              
          }
          
          System.out.println(imprimir (Trans));
          
      return Trans;
      }
     
      public static int Multiplicacion (int [][]numeros){
          int cont1= 0;
          int cont2=0;
          int mult=1;
          int acum=0;
          int sum=0;
          for (int i = 0; i < numeros.length; i++) {
              for (int j = 0; j <numeros[0].length; j++) {
                  if (i ==0  || j == 0 || i == numeros.length-1 || j== numeros[0].length-1) {
                      cont1= cont1+numeros[i][j];
                      
                      
                      
                  }else{
                      cont2= numeros[i][j];
                      mult = cont2*mult;
                      
                      
                   
                  }
                  
              }
              
          }
          
          sum = mult+cont1;
          System.out.println("La suma es: "+sum);
          return cont1;
      }

      
      public static int[][] subsecuencia (String palab1, String palab2){
         int hola = palab1.length();
         int hola2= palab2.length();
         int [][] hola3 = new int [hola][hola2];
          for (int i = 0; i < hola; i++) {
              for (int j = 0; j < hola2; j++) {
                  if (palab1.charAt(i)== '-' || palab2.charAt(j)== '-') {
                      hola3[i][j]=0;
                  }else 
                      if(palab1.charAt(i)==palab2.charAt(j)){
                          hola3 [i][j]= 1+ hola3[i-1][j-1];
                          
                      
                  }
                      else{
                          hola3[i][j]= Math.max(hola3[i][j-1], hola3 [i-1][j]);
                      }
                  
              }
              
          }
          int bacon =0;
          for (int i = 0; i < hola3.length; i++) {
              
              for (int j = 0; j < hola3[0].length; j++) {
                  bacon= hola3[i][j];
              }
          }
          System.out.println("El size es: "+bacon);
          System.out.println(imprimir(hola3));
        return hola3;
      }
}
   
