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
    
    }
}catch (NumberFormatException e) {
    
                System.out.println("Error: Debe ingresar un número válido.");
                
                
             }

  } while(validacion !=8);
  

      
  }
  
  
  
}

