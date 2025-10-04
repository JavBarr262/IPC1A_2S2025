/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica2;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Practica2 {
     private static Procesos procesos = new Procesos();
     private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
    boolean val=false;
    while(!val){
    menu();
    int opc=validaciones();
    switch(opc){
        case 1:
            agregarp();
            break;
        case 2:
           buscaredit();
            break;
        case 3:
           buscarelminar();
            break;
        case 4:
           verp();
            break;
        case 5:
            Buscarbatalla();
            break;
        case 6:
            Procesos.bitacora();
            break;
        case 7:
            buscarpornombre();
            break;
        case 8:
            break;
        case 9:
            val=true;
            System.out.println("Javier Antonio Barrios Calderon 20238325");
            System.out.println("Saliendo del menu");
            break;
        default:
            System.out.println("****Opcion invalida seleeccione una opcion del menu porfavor****");
            break;
                }
        }       
    }
    public static void menu(){
        System.out.println("\n-----Menu de seleccion escoja una opcion porfavor-----");
        System.out.println("Crear personaje=1");
        System.out.println("Modificar personaje=2");
        System.out.println("Eliminar personaje=3");
        System.out.println("Ver lista de personajes=4");
        System.out.println("Batalla=5");
        System.out.println("ver historial de batallas=6");
        System.out.println("Buscar personaje por nombre=7");
        System.out.println("Guardar o caragar partida=8");
        System.out.println("Salir=9");
        System.out.print("Ingrese la opcion que quiere realizar: ");

    }
    
   public static int validaciones(){
   try {
         return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
         return -1;
        }
   }
   
   public static void agregarp(){
       System.out.println("\n-----Creacion de personajes-----");
       System.out.print("Ingrese nombre de su personaje:");
       String nombre=scanner.nextLine();
        if (procesos.valnombrep(nombre)) {
            System.out.println("***ERROR: Ya hay un personaje registrado con ese nombre eliga uno distinto***");
            return;
        }
        if(procesos.vallet(nombre)) {
            System.out.println("***ERROR: solamente puede tener letras el nombre***");
            return;
        }
        System.out.print("ingrese el arma/objeto del personaje: ");
        String objeto=scanner.nextLine();
        
        int HP = valornum("Ingrese la cantidad de HP del personaje 100-500: ",100,500);
        int ataque = valornum("Ingrese el atque del personajes 10-100: ",10,100);
        int velocidad = valornum("Ingrese la velocidad del personaje 1-10: ",1,10);
        int agilidad = valornum("Ingrese la agilidad del personaje 1-10: ",1,10);
        int defensa = valornum("Ingrese el valor de la defesna 1-50: ",1,50);
        boolean e = procesos.agregarp(nombre,objeto,HP,ataque,velocidad,agilidad,defensa);
        if (e) {
            System.out.println("Personaje agregado exitosamente");
        } else {
            System.out.println("ERROR: No se pudo agregar personaje verifique sus datos");
        }
   
   }
   public static int valornum(String mensaje, int minimo, int maximo){
           int valor;
        while (true) {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(scanner.nextLine());
                if (valor >= minimo && valor <= maximo) {
                    return valor;
                } else {
                    System.out.println("Error: Ingrese un valor que pertenezca al intervalo " + minimo + " y " + maximo);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un valor valido");
            }
        }
   }
   
   public static void verp(){
      System.out.println("\n-----Personajes Registrados------");
        Procesos ver=new Procesos();
        ver.lista();
 
   }
   public static void buscaredit(){
           System.out.println("\n-----Modificar Personaje-----");
           System.out.print("Ingrese el ID o el nombre del personaje que quiera busacar: ");
           String buscar=scanner.nextLine();
           int val=1;
           
         try {
            int id = Integer.parseInt(buscar);
            Procesos ver=new Procesos();
            ver.buscarID(val,id);
         } catch (NumberFormatException e) {
            String nombre=buscar;
            Procesos ver=new Procesos();
            ver.buscarnombre(val,nombre);
        }
   }
 
   public static void buscarpornombre(){
           System.out.println("\n-----bucar Personaje-----");
           System.out.print("Ingrese el nombre del personaje que quiera busacar: ");
           String buscar=scanner.nextLine();
           int val=3;
           if(buscar.matches("[a-zA-Z]+")){
            String nombre=buscar;
            Procesos ver=new Procesos();
            ver.buscarnombre(val,nombre);
            }else{
           System.out.println("***ERROR:Ingrese un valor valido***");
           return;
           }
   
   }
   
   public static void modificar(int i){
       int editar=i;
       System.out.print("Ingrese el nuevo nombre de su personaje:");
       String nombrenv=scanner.nextLine();
        if (procesos.valnombrep(nombrenv)) {
            System.out.println("***ERROR: Ya hay un personaje registrado con ese nombre eliga uno distinto***");
            return;
        }
        if(procesos.vallet(nombrenv)) {
            System.out.println("***ERROR: solamente puede tener letras el nombre***");
            return;
        }
        System.out.print("ingrese el arma/objeto del personaje: ");
        String objetonv=scanner.nextLine();
        
        int HPnv = valornum("Ingrese la nueva cantidad de HP del personaje 100-500: ",100,500);
        int ataquenv = valornum("Ingrese el atque del personajes 10-100: ",10,100);
        int velocidadnv = valornum("Ingrese el nuevo la velocidad del personaje 1-10: ",1,10);
        int agilidadnv = valornum("Ingrese la nueva agilidad del personaje 1-10: ",1,10);
        int defensanv = valornum("Ingrese el nuevo valor de la defesna 1-50: ",1,50);
        boolean e = procesos.modificarp(editar,nombrenv,objetonv,HPnv,ataquenv,velocidadnv,agilidadnv,defensanv);
        if (e) {
            System.out.println("Personaje modificado exitosamente");
        } else {
            System.out.println("ERROR: No se pudo modificar el  personaje verifique sus datos");
        }
   }
   
      public static void buscarelminar(){
           System.out.println("\n-----Eliminar Personaje-----");
           System.out.print("Ingrese el ID o el nombre del personaje que quiera eliminar: ");
           String buscar=scanner.nextLine();
           int val=2;
           
         try {
            int id = Integer.parseInt(buscar);
            Procesos ver=new Procesos();
            ver.buscarID(val,id);
         } catch (NumberFormatException e) {
            String nombre=buscar;
            Procesos ver=new Procesos();
            ver.buscarnombre(val,nombre);
        }
   }
      public static void eliminar(int ID,String nom){
        int elimnar=ID;
        String nombre=nom;
        System.out.println("Desea eliminar el personaje "+nombre+"?     SI=1     NO=2");
        System.out.print("Ingrese la opcion que desea realizar:");
            try{
                 int entrada=validaciones();
                  switch(entrada){
                  case 0:
                   System.out.println("Proceso cancelado");
  
                   case 1: 
                   System.out.println("Eliminando personaje");
                   Procesos ver=new Procesos();
                   ver.eliminarp(elimnar,nombre);
          }
        }catch (NumberFormatException error) {
        System.out.println("Seleccione un numero de la lista porfavor");
      }

      
      }
      
      public static void Buscarbatalla(){
          System.out.println("\n-----Batlla entre presonajes Personaje-----");
          System.out.println("Como minimo deben ser 2");
          System.out.println("NOTA: solo escoja un metodo si el personaje1 lo busco por ID solo buscque por ID");
          System.out.print("Ingrese el ID o el nombre del personaje 1: ");
          String buscar1=scanner.nextLine();
   
          if(buscar1.matches("[0-9]+")){
            System.out.print("Ingrese el ID del personaje 2: ");
            String buscar2=scanner.nextLine();
            if(buscar2.matches("[a-zA-Z]+")){
            System.out.println("***ERROR: Ingrese solamente el ID del personaje 2***");
            return;
            }else{
            if(buscar1.equals(buscar2)){
            System.out.println("***ERROR: NO pude seleccionar 2 veces el mismo perssonaje***");
            return;
            }else{
            int id1 = Integer.parseInt(buscar1);
            int id2 = Integer.parseInt(buscar2);
            Procesos ver=new Procesos();
            ver.buscarbid(id1,id2);
            }
          }
          }
          if(buscar1.matches("[a-zA-Z]+")){
            System.out.print("Ingrese el nombre del personaje 2: ");
            String buscar2=scanner.nextLine();
            if(buscar2.matches("[0-9]+")){
            System.out.println("***ERROR: Ingrese solamente el nombre del personaje 2***");
            return;
            }else{
             if(buscar1.equals(buscar2)){
            System.out.println("***ERROR: NO pude seleccionar 2 veces el mismo perssonaje***");
            return;
            }else{
             String nombre1=buscar1;
             String nombre2=buscar2;
             Procesos ver=new Procesos();
             ver.buscarbnom(nombre1,nombre2);
             }
          }
          }
      }
      





}
