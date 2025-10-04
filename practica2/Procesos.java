/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author USUARIO
 */
public class Procesos {
  private static int Cantidadpersonajes=0;
  private static int numpeleas=0;
  private static String[] nombres=new String[100];
  private static String[] objetos=new String[100];
  private static int[] healtpoints=new int[100];
  private static int[] ataques=new int[100];
  private static int[] velocidades=new int[100];
  private static int[] agilidades=new int[100];
  private static int[] defensas=new int[100];
  private static int[] Batallasganadas=new int[100];
  private static int[] Batallasperdidas=new int[100];
  private static int totalBitacora = 0;
  private static int bitacoraMax = 1000;
  private static String  accionesBitacora [] = new String[bitacoraMax];





    public boolean valnombrep(String nombrep) {
        for (int i = 0; i < Cantidadpersonajes; i++) {
            if (nombres[i].equalsIgnoreCase(nombrep)) {
                return true;
            }
        }
      return false;
    }
    
    public boolean vallet(String nombrep){
    if(!nombrep.isEmpty() && nombrep.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")){
        return false;
        }
      return true;
    }
    
    public boolean agregarp(String nombre, String objeto, int HP, int ataque, int velocidad, int agilidad, int defensa){
    nombres[Cantidadpersonajes]=nombre;
    objetos[Cantidadpersonajes]=objeto;
    healtpoints[Cantidadpersonajes]=HP;
    ataques[Cantidadpersonajes]=ataque;
    velocidades[Cantidadpersonajes]=velocidad;
    agilidades[Cantidadpersonajes]=agilidad;
    defensas[Cantidadpersonajes]=defensa;
    Batallasganadas[Cantidadpersonajes]=0;
    Batallasperdidas[Cantidadpersonajes]=0;
    Cantidadpersonajes++;
    System.out.println("Personaje agregado con No. ID: "+Cantidadpersonajes);
    return true;
    }
    
    public void lista(){
        if(Cantidadpersonajes==0){
        System.out.print("***No hay personajes creados***");
        return;
        }
        System.out.println("***Listado de los personajes***");
         System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-20s\n","ID", "Nombre", "objeto", "HP","ataque","velocidad","agilidad","defensa","Batallas_ganadas","Batllas_perdidas");
        for (int a = 0; a < Cantidadpersonajes; a++) {
        
        System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-20s\n",(a + 1), nombres[a],objetos[a],healtpoints[a],ataques[a],velocidades[a],agilidades[a],defensas[a],Batallasganadas[a],Batallasperdidas[a]);
        }
    }
    
    public String buscarID(int Val,int ID){
        int lista = ID-1;
        int validacion=Val;   
        if(nombres[lista]==null){
        System.out.println("***Pesonaje no encontrado por ID revise que ingreso correctamente los datos***");
        }else{
        System.out.println("***Personaje seleccionado***");
         System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-20s\n","ID", "Nombre", "objeto", "HP","ataque","velocidad","agilidad","defensa","Batallas_ganadas","Batllas_perdidas");
        System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-20s\n",(ID), nombres[lista],objetos[lista],healtpoints[lista],ataques[lista],velocidades[lista],agilidades[lista],defensas[lista],Batallasganadas[lista],Batallasperdidas[lista]);
        
        if(validacion==1){
        Practica2.modificar(ID-1);}
        if(validacion==2){
        Practica2.eliminar(ID-1, nombres[lista]);
        }
        }
      return null;
        

    }
    
    public boolean buscarnombre(int Val,String nombre){
       for (int i = 0; i < Cantidadpersonajes; i++) {
            if (nombres[i].equalsIgnoreCase(nombre)) {
                String a = nombres[i];
                int validacion=Val;
                System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-20s\n","ID", "Nombre", "objeto", "HP","ataque","velocidad","agilidad","defensa","Batallas_ganadas","Batllas_perdidas");
                System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-20s\n",(i+1), nombres[i],objetos[i],healtpoints[i],ataques[i],velocidades[i],agilidades[i],defensas[i],Batallasganadas[i],Batallasperdidas[i]);
               if(validacion==1){
                Practica2.modificar(i);
               }
               if(validacion==2){
               Practica2.eliminar(i,nombres[i]);
               }
               if(validacion==3){
               
               }
                return true;
            }
        }   
      System.out.println("***Personaje no encontrado revise si escribio bien el nombre***");
      return false;
    }
    public boolean modificarp(int ID, String nom,String obj,int hp, int ataq,int vel, int agil,int def){
    int editar=ID;
    nombres[editar]=nom;
    objetos[editar]=obj;
    healtpoints[editar]=hp;
    ataques[editar]=ataq;
    velocidades[editar]=vel;
    agilidades[editar]=agil;
    defensas[editar]=def;
    System.out.println("Personaje modificadocon exito");
    System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-20s\n","ID", "Nombre", "objeto", "HP","ataque","velocidad","agilidad","defensa","Batallas_ganadas","Batllas_perdidas");
    System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-20s\n",(editar+1), nombres[editar],objetos[editar],healtpoints[editar],ataques[editar],velocidades[editar],agilidades[editar],defensas[editar],Batallasganadas[editar],Batallasperdidas[editar]);
    return true;
    }
    
    public boolean eliminarp(int elim, String nom){
        int posicion=elim;
        String nome=nom;
    for(int i=posicion; i<Cantidadpersonajes-1; i++){
            nombres[i]=nombres[i+1];
            objetos[i]=objetos[i+1];
            healtpoints[i]=healtpoints[i+1];
            ataques[i]=ataques[i];
            velocidades[i]=velocidades[i+1];
            agilidades[i]=agilidades[i+1];
            defensas[i]=defensas[i+1];
            Batallasganadas[i]=Batallasganadas[i+1];
            Batallasperdidas[i]=Batallasganadas[i+1];
        }
            nombres[Cantidadpersonajes]=null;
            objetos[Cantidadpersonajes]=null;
            healtpoints[Cantidadpersonajes]=0;
            ataques[Cantidadpersonajes]=0;
            velocidades[Cantidadpersonajes]=0;
            agilidades[Cantidadpersonajes]=0;
            defensas[Cantidadpersonajes]=0;
            Batallasganadas[Cantidadpersonajes]=0;
            Batallasperdidas[Cantidadpersonajes]=0;
            Cantidadpersonajes --;

        System.out.println("***El personaje "+nome+" se  elimino con exito***");
    return true;
    }
    
    public String buscarbid(int id1, int id2){
        int lista1=id1-1;
        int lista2=id2-1;
        if(nombres[lista1]==null){
        System.out.println("***Pesonaje 1 no encontrado por ID revise que ingreso correctamente los datos***");
        }
        if(nombres[lista2]==null){
        System.out.println("***Pesonaje 2 encontrado por ID revise que ingreso correctamente los datos***");
        }else{
        System.out.println("***Personaje 1 seleccionado***");
        System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-20s\n","ID", "Nombre", "objeto", "HP","ataque","velocidad","agilidad","defensa","Batallas_ganadas","Batllas_perdidas");
        System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s\n",(id1), nombres[lista1],objetos[lista1],healtpoints[lista1],ataques[lista1],velocidades[lista1],agilidades[lista1],defensas[lista1]);
        
        System.out.println("***Personaje 2 seleccionado***");
        System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-20s\n","ID", "Nombre", "objeto", "HP","ataque","velocidad","agilidad","defensa","Batallas_ganadas","Batllas_perdidas");
        System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s\n",(id2), nombres[lista2],objetos[lista2],healtpoints[lista2],ataques[lista2],velocidades[lista2],agilidades[lista2],defensas[lista2]);
        
        InicioBatalla(id1-1,id2-1,nombres[lista1],nombres[lista2],objetos[lista1],objetos[lista2],healtpoints[lista1],healtpoints[lista2],ataques[lista1],ataques[lista2],velocidades[lista1],velocidades[lista2],agilidades[lista1],agilidades[lista2],defensas[lista1],defensas[lista2]);
        }
      return null;
      }
    
    public boolean buscarbnom(String nom1,String nom2){
          int id1 = -1;
          int id2 = -1;
          for (int i = 0; i < Cantidadpersonajes; i++) {    
          if (nombres[i].equalsIgnoreCase(nom1)) {
          id1 = i; 
          } else if (nombres[i].equalsIgnoreCase(nom2)) {
         id2 = i; 
          }
         }
         if (id1 != -1 && id2 != -1) {
          revisionnmob(id1, id2, nombres, objetos, healtpoints, ataques, velocidades, agilidades, defensas, Batallasganadas,Batallasperdidas);
          } else {
         System.out.println("no existe algun personaje");
          }
      return false;
    }
    
    public static void revisionnmob(int id1, int id2,String[] nombres, String[] objetos, int[] healtpoints, int[] ataques,int[] velocidades, int[] agilidades, int[] defensas, int[] Batallasganadas,int[] Batallasperdidas) {

     System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-20s\n","ID", "Nombre", "objeto", "HP","ataque","velocidad","agilidad","defensa","Batallas_ganadas","Batllas_perdidas");

    System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-20s\n",(id1 + 1), nombres[id1], objetos[id1], healtpoints[id1],ataques[id1], velocidades[id1], agilidades[id1], defensas[id1],Batallasganadas[id1],Batallasperdidas[id1]);

    System.out.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-20s\n",(id2 + 1), nombres[id2], objetos[id2], healtpoints[id2],ataques[id2], velocidades[id2], agilidades[id2], defensas[id2],Batallasganadas[id2],Batallasperdidas[id2]);

    InicioBatalla(id1,id2,nombres[id1],nombres[id2],objetos[id1],objetos[id2],healtpoints[id1],healtpoints[id2],ataques[id1],ataques[id2],velocidades[id1],velocidades[id2],agilidades[id1],agilidades[id2],defensas[id1],defensas[id2]);
}

    public static void InicioBatalla(int id1,int id2, String nom1,String nom2, String obj1, String obj2, int hp1,int hp2,int ataq1, int ataq2,int vel1,int vel2,int agil1, int agil2, int def1, int def2){
    if(hp1==0 ){
    System.out.println("***El personaje "+nom1+" esta debilitado no puede combatir***");
    return;
    }
    if(hp2==0){
        System.out.println("***El personaje "+nom2+" esta debilitado no puede combatir***");
        return;
    } else { 
    registrarAccion("Inicio del combate entre "+nom1+" vs "+nom2+" pelea No."+numpeleas);

    boolean personaje1=true,personaje2=true;
    int daño;
        
    Personaje p1 = new Personaje();
    p1.setID(id1);
    p1.setNombre(nom1);
    p1.setArma(obj1);
    p1.setHp(hp1);
    p1.setAtaque(ataq1);
    p1.setVelocidad(vel1);
    p1.setAgilidad(agil1);
    p1.setDefensa(def1);
    
    Personaje p2 = new Personaje();
    p2.setID(id2);
    p2.setNombre(nom2);
    p2.setArma(obj2);
    p2.setHp(hp2);
    p2.setAtaque(ataq2);
    p2.setVelocidad(vel2);
    p2.setAgilidad(agil2);
    p2.setDefensa(def2);
    
    System.out.println(p1.getNombre()+"tiene una vida de: "+p1.getHp());
    System.out.println(p2.getNombre()+"tiene una vida de: "+p2.getHp());
    System.out.println();
    
    do{
        double probEsquiva2 = p2.getAgilidad() / 20.0; 
        if (Math.random() < probEsquiva2) {
            System.out.println(p1.getNombre() + " ataca a " + p2.getNombre() + " ataque fallo (esquiva)");
        }else{
        daño= p1.Ataque();
        System.out.println(p1.getNombre()+" ha realizado un ataque de : "+daño);
        p2.dañorealizado(daño);
        }
        
        try {
            Thread.sleep(1000 / p1.getVelocidad());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
                double probEsquiva1 = p1.getAgilidad() / 20.0; 
        if (Math.random() < probEsquiva1) {
            System.out.println(p2.getNombre() + " ataca a " + p1.getNombre() + " ataque fallo (esquiva)");
        } else{
        if(p2.getHp()>0){
        daño= p2.Ataque();
        System.out.println(p2.getNombre()+" ha realizado un ataque de : "+daño);
        p1.dañorealizado(daño);
        }
        }
        try {
            Thread.sleep(1000 / p2.getVelocidad());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if(p1.getHp()<=0){
            System.out.println("***Perosnaje 2  "+p2.getNombre()+" es el ganador***");
            registrarAccion("Batalla finalizada  Ganador:"+p2.getNombre());
            Batallasganadas[id2] ++;
            Batallasperdidas[id1] ++;       
            p1.setHp(0);
            personaje1=false;
        }
        if(p2.getHp()<=0){
            System.out.println("***Perosnaje 1  "+p1.getNombre()+" es el ganador***");
            registrarAccion("Batalla finalizada  Ganador:"+p1.getNombre());
            p2.setHp(0);
            Batallasganadas[id1] ++;
            Batallasperdidas[id2] ++;  
            personaje2=false;
        }
        System.out.println(p1.getNombre()+" tiene una vida de: "+p1.getHp());
        System.out.println(p2.getNombre()+" tiene una vida de: "+p2.getHp());
        System.out.println();
    }while(personaje1 && personaje2);
     numpeleas ++;
     healtpoints[id1]=p1.getHp();
     healtpoints[id2]=p2.getHp();  
    }

        
             
    }
  
    
public boolean guardarEstado(String archivo) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
        // Guardar cantidad de personajes
        oos.writeInt(Cantidadpersonajes);
        
        // Guardar datos de cada personaje
        for (int i = 0; i < Cantidadpersonajes; i++) {
            oos.writeObject(nombres[i]);
            oos.writeObject(objetos[i]);
            oos.writeInt(healtpoints[i]);
            oos.writeInt(ataques[i]);
            oos.writeInt(velocidades[i]);
            oos.writeInt(agilidades[i]);
            oos.writeInt(defensas[i]);
            oos.writeInt(Batallasganadas[i]);
            oos.writeInt(Batallasperdidas[i]);
        }
                // Guardar bitácora
        oos.writeInt(totalBitacora);
        for (int i = 0; i < totalBitacora; i++) {
            oos.writeObject(accionesBitacora[i]);
        }
        
        System.out.println("Estado guardado correctamente en binario: " + archivo);
        return true;
        
    } catch (IOException e) {
        System.err.println("Error al guardar el estado binario: " + e.getMessage());
        return false;
    }
}
     public void guardarEstadoTexto(String archivo) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(archivo))) {
        writer.println("===== PERSONAJES =====");
        writer.println("*** Listado de los personajes ***");
        writer.printf("%-5s %-20s %-20s %-10s %-10s %-10s %-10s %-10s %-20s %-20s%n","ID", "Nombre", "Objeto", "HP", "Ataque", "Velocidad", "Agilidad", "Defensa", "Batallas_ganadas", "Batallas_perdidas");
        
        for (int a = 0; a < Cantidadpersonajes; a++) {
            writer.printf("%-5d %-20s %-20s %-10d %-10d %-10d %-10d %-10d %-20d %-20d%n",(a + 1), nombres[a], objetos[a], healtpoints[a], ataques[a], velocidades[a], agilidades[a], defensas[a],Batallasganadas[a], Batallasperdidas[a]);
        }
        
        writer.println();
        writer.println("===== BATALLAS =====");
        writer.println("*** Bitácora de acciones ***");
               for (int i = 0; i < totalBitacora; i++) {
            writer.println((i + 1) + ". " + accionesBitacora[i]);
        }
        writer.println("=== Fin de la bitácora ===");
        
        System.out.println("Estado guardado correctamente en: " + archivo);
        
    } catch (IOException e) {
        System.err.println("Error al guardar el estado en texto: " + e.getMessage());
    }
}
 public boolean cargarEstado(String archivo) {
    try {
        // Obtener la ruta del directorio actual de trabajo
        String directorioActual = System.getProperty("user.dir");
        File file = new File(directorioActual, archivo);
        
        System.out.println("Buscando archivo en: " + file.getAbsolutePath());
        
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        
        // Cargar cantidad de personajes
        Cantidadpersonajes = ois.readInt();
        
        // Inicializar arrays si es necesario
        if (nombres == null || nombres.length < Cantidadpersonajes) {
            nombres = new String[Math.max(50, Cantidadpersonajes * 2)];
            objetos = new String[Math.max(50, Cantidadpersonajes * 2)];
            healtpoints = new int[Math.max(50, Cantidadpersonajes * 2)];
            ataques = new int[Math.max(50, Cantidadpersonajes * 2)];
            velocidades = new int[Math.max(50, Cantidadpersonajes * 2)];
            agilidades = new int[Math.max(50, Cantidadpersonajes * 2)];
            defensas = new int[Math.max(50, Cantidadpersonajes * 2)];
            Batallasganadas = new int[Math.max(50, Cantidadpersonajes * 2)];
            Batallasperdidas = new int[Math.max(50, Cantidadpersonajes * 2)];
        }
        
        // Cargar datos de cada personaje (coherente con guardarEstado)
        for (int i = 0; i < Cantidadpersonajes; i++) {
            nombres[i] = (String) ois.readObject();
            objetos[i] = (String) ois.readObject();
            healtpoints[i] = ois.readInt();
            ataques[i] = ois.readInt();
            velocidades[i] = ois.readInt();
            agilidades[i] = ois.readInt();
            defensas[i] = ois.readInt();
            Batallasganadas[i] = ois.readInt();
            Batallasperdidas[i] = ois.readInt();
        }
        
        // Cargar bitácora
        totalBitacora = ois.readInt();
        if (accionesBitacora == null || accionesBitacora.length < totalBitacora) {
            accionesBitacora = new String[Math.max(100, totalBitacora * 2)];
        }
        for (int i = 0; i < totalBitacora; i++) {
            accionesBitacora[i] = (String) ois.readObject();
        }
        
        ois.close();
        System.out.println("Estado cargado correctamente desde: " + archivo);
        return true;
        
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Error al cargar el archivo: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}
     

        

        
    public static void registrarAccion(String accion) {
        if (totalBitacora < bitacoraMax) {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        accionesBitacora[totalBitacora] = "[" + ahora.format(formato) + "] " + accion;
        totalBitacora++;
        } else {
        System.out.println("*** La bitacora está llena, no se pueden registrar más acciones ***");
         }
    }
    public static void bitacora() {
    if (totalBitacora == 0) {
        System.out.println("*** La bitacora está vacía ***");
        return;
    }
    System.out.println("\n*****Bitacora de acciones*****");
    for (int i = 0; i < totalBitacora; i++) {
        System.out.println((i+1) + ". " + accionesBitacora[i]);
    }
}
    
    
}
