/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica1;

/**
 *
 * @author USUARIO
 */

import java.util.Scanner;
public class Practica1{
private static final Scanner scanner = new Scanner(System.in);

   //Creamos los vecotores que vayan a contener la informacion necesitada
  private static String[] nombrep = new String[100];
  private static String[] arma = new String[100];
  //Nos pidieron como maximo que se pudierna asignar 5 habilidades como maximo
  private static String[][] habilidades = new String[100][5];
  private static int[] nivelpersonaje = new int[100];
  private static int Creacionpersonajes= 0;
 
  public static void main(String[] args){
  Menu();
  }
  
  public static void Menu(){
  int validacion=0;
  do{
  System.out.println("\n *****Menu*****");
  System.out.println("Crear un personaje=1");
  System.out.println("ver datos de algun personaje=2");
  System.out.println("ver listado de los personajes=3");
  System.out.println("Hacer una pelea=4");
  System.out.println("Modificar datos=5");
  System.out.println("Eliminar personaje=6");
  System.out.println("Ver historial de las peleas realizadas=7");
  System.out.println("Terminar proceso=8");
try{
    validacion = Integer.parseInt(scanner.nextLine());
    switch(validacion){
        case 1:
            Creacionpersonajes();
            break;
        case 2:
            Verinfopersonajes();
            break;
        case 3:
             Verlistapersonajes();
            break;
        case 4:
            Pelea();
            break;
        case 5:
            Editarinfo();
            break;
        case 6:
            Eliminar();
            break;
        case 7:
            Verhistorial();
            break;
        case 8:
            System.out.println("Javier Antonio Barrios Calderon");
            System.out.println("Proceso finalizado");
            break;
        default:
    }
}catch (NumberFormatException error) {
        System.out.println("Seleccione un numero de la lista porfavor");
      }
  } while(validacion !=8);
  }
 

    public static void Creacionpersonajes(){
              System.out.println("Creacion de personajes");

}
    public static void Verinfopersonajes(){
              System.out.println("ver info personajes");

}
    public static void Verlistapersonajes(){
              System.out.println("ver lista personajes");

}
    public static void Pelea(){
              System.out.println("Pelea");

}
       public static void Editarinfo(){
              System.out.println("Editar informacion");

}
    public static void Eliminar(){
              System.out.println("Eliminar");

}
    public static void Verhistorial(){
              System.out.println("Eliminar");

}
  
  
}

