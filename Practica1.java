/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica1;

/**
 *
 * @author JavvBarr262
 */
//utilizo la libreria de scanner para poder leer los datos de la lista de manera sencilla 
import java.util.Scanner;
public class Practica1{
private static final Scanner scanner = new Scanner(System.in);

  private static int Creacionpersonajes=0;
  private static int Cantidadpersonajes=0;
   //Creamos los vecotores que vayan a contener la informacion necesitada
  private static String[] nombres=new String[100];
  private static String[] objetos=new String[100];
  //Nos pidieron como maximo que se pudierna asignar 5 habilidades como maximo
  private static String[][] habilidades=new String[100][5];
  private static int[] nivelpersonaje=new int[100];

  
 
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
  System.out.print("Escoja la opcion que quiera realizar:   ");
try{
    
    validacion=Integer.parseInt(scanner.nextLine());
    if (validacion < 1 || validacion > 8) {
                System.out.println("Seleccione un numero que pertenezca a la lista por favor");
                continue;
            }
    switch(validacion){
        case 1 -> Creacionpersonajes();
        case 2 -> Verinfopersonajes();
        case 3 -> Verlistapersonajes();
        case 4 -> Pelea();
        case 5 -> Editarinfo();
        case 6 -> confirmaciondeeliminacion();
        case 7 -> Verhistorial();
        case 8 -> {
            System.out.println("Javier Antonio Barrios Calderon 202308325");
            System.out.println("Proceso finalizado");
          }
        default -> {
          }
    }
}catch (NumberFormatException error) {
        System.out.println("Seleccione un numero de la lista porfavor");
      }
  } while(validacion!=8);
  }
 

    public static void Creacionpersonajes(){
        if (Cantidadpersonajes >= 100) {
            System.out.println("Limite de personajes alcanzado ");
            return;
        }

        System.out.println("\n***Creacion personajes***");
        String nombrep;
        //usamos un boolean para poder verificar que los nombres no se repitan
       boolean validacionnombres=false;
       do{
           System.out.print("Ingrese nombre del pesonjae:   ");
           nombrep=scanner.nextLine();
           if(nombrep.isEmpty()){
               System.out.println("Porfavor ingrese algun nombre para le personaje que va a ser creado:   ");
               continue;
           }
           validacionnombres=true;
           for(int a=0; a<Cantidadpersonajes; a++){
               if(nombres[a].equalsIgnoreCase(nombrep)){
               System.out.println("***El nombre ya existe ecriba uno diferente porfavor***");
              validacionnombres=false;
              break;
               }
           }
          }while (!validacionnombres);
       
       boolean validacionobjetos=false;
       do{
           System.out.print("Escriba el objeto/arma que quiera asignarle al personaje:   ");
       String objeto=scanner.nextLine();
       if(objeto.isEmpty()){
               System.out.println("Porfavor ingrese algun objeto/arma para le personaje que va a ser creado:   ");
               continue;
           }
           validacionobjetos=true;
       }while (!validacionobjetos);
       
       
       String[] habilidadesP=new String[5];
       System.out.println("Ingrese las habilidades maximo 5 *si no quiere ingresar ninguna habilidad puede dejar el espacio vacio presionando enter*:  ");
       int Cantidadhabilidades=0;
       for(int a=0;a<5;a++){
        System.out.print("Habilidad no."+(a+1)+"   ");
        String habilidad=scanner.nextLine();
        if(!habilidad.isEmpty()){
            habilidadesP[a]=habilidad;
            Cantidadhabilidades++;
        }else{
            break;
        }
    }
       int Nivel=0;
       boolean validacionnivel=false;
       do{
           try{
           System.out.print("ingrese un valor para le nivel del personaje (tiene que estar enre 1-100 para que sea valido):  ");
           Nivel=Integer.parseInt(scanner.nextLine());
           if(Nivel>=1 && Nivel<=100){
           validacionnivel=true;
           }else{
           System.out.print("***El numero escrito no cumple con las condiciones porfavor ingrese uno que si lo haga***");
           }
           
           
           }catch(NumberFormatException e){
           System.out.print("ingrese un valor numerioc valido porfavor");
           }
       }while(!validacionnivel);
       
       nombres[Cantidadpersonajes]=nombrep;
       objetos[Cantidadpersonajes]=objeto;
       for(int a=0;a<5;a++){
           habilidades[Cantidadpersonajes][a]=habilidadesP[a];
       }
       nivelpersonaje[Cantidadpersonajes]=Nivel;
       Cantidadpersonajes++;
       System.out.print("***el personaje que creo se agrego correctamente No. ID: "+Cantidadpersonajes+"***");

    
    }
    
    public static void Verinfopersonajes(){
               if(Cantidadpersonajes==0){
        System.out.println("No hay datos de personajes porfavor registre algun personaje");
        }
        System.out.println("**Info Personajes**");
        int ID=IDpersonajes();
        if (ID==-1)return;
        int lista=ID-1;
        System.out.println("***Informacion de los personajes***");
        System.out.println("ID: "+ID);
        System.out.println("nombre: "+nombres[lista]);
        System.out.println("arma/obejto equipado: "+ objetos[lista]);
        System.out.println("Nivel personaje: "+nivelpersonaje[lista]);
        System.out.println("Habilidades del personaje: ");
        
        boolean Calcularhabilidades=false;
        for(int a=0;a<5;a++){
        if(habilidades[lista][a] !=null && !habilidades[lista][a].isEmpty()){
            System.out.println(" * "+habilidades[lista][a]);
            Calcularhabilidades=true;
        }
        if(!Calcularhabilidades){
            System.out.println("no tiene habilidad asignada");
        }

        }
        

}
   public static int IDpersonajes(){
       try{
           System.out.print("Seleccione el ID del personaje qu quiera ver: ");
           int ID=Integer.parseInt(scanner.nextLine());
           if(ID<1 || ID>Cantidadpersonajes){
           System.out.println("ID erroneo ingrese uno valido nuevamente");
           return -1;
           }
           return ID;
       }catch(NumberFormatException e){
       System.out.println("ingrese un valor valido");
       return -1;
       }
   } 
    public static void Verlistapersonajes(){
        if(Cantidadpersonajes==0){
        System.out.print("No hay personajes creados");
        return;
        }
        System.out.println("***Listado de los personajes***");
         System.out.printf("%-5s %-20s %-20s  %-10s\n","ID", "Nombre", "Objeto/Arma", "Nivel");
        for (int a = 0; a < Cantidadpersonajes; a++) {
        
        System.out.printf("%-5d %-20s %-20s  %-10d\n",(a + 1), nombres[a], objetos[a], nivelpersonaje[a]);
        }
       
                

}
        public static void Pelea(){
    if (Cantidadpersonajes < 2) {
        System.out.println("En este apartado debe ingresar 2 personajes");
        return;
    }
    System.out.println("*** Pelea entre personajes ***");
    int ID1, ID2;
    do {
        System.out.print("Ingrese primer personaje por medio del ID:  ");
        try {
            ID1 = Integer.parseInt(scanner.nextLine());
            if (ID1 < 1 || ID1 > Cantidadpersonajes) {
                System.out.println("Por favor ingrese un ID valido");
                ID1 = -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un ID valido");
            ID1 = -1;
        }
    } while (ID1 == -1);

    do {
        System.out.print("Ingrese segundo personaje por medio del ID: ");
        try {
            ID2 = Integer.parseInt(scanner.nextLine());
            if (ID2 < 1 || ID2 > Cantidadpersonajes || ID2 == ID1) {
                System.out.println("ID inválido o igual al primero. Intente de nuevo.");
                ID2 = -1;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un número válido.");
            ID2 = -1;
        }
    } while (ID2 == -1);

            int nivel1 = nivelpersonaje[ID1 - 1];
            int nivel2 = nivelpersonaje[ID2 - 1];

         System.out.println("Nivel de " + nombres[ID1 - 1] + ": " + nivel1);
         System.out.println("Nivel de " + nombres[ID2 - 1] + ": " + nivel2);

           if (nivel1 > nivel2) {
        System.out.println( nombres[ID1 - 1] + " es el vencedor");
        } else if (nivel2 > nivel1) {
        System.out.println(nombres[ID2 - 1] + " es el vencedor");
          } else {
        System.out.println("Empate debido a que los personajes tienen el mismo nivel");
        }

}
       public static void Editarinfo(){
        if(Cantidadpersonajes==0){
        System.out.println("No hay datos de personajes porfavor registre algun personaje");
        }
        System.out.println("**Info Personajes**");
        int ID=IDeditarpersonajes();
        if (ID==-1)return;
        int editar=ID-1;
      
            boolean validacionnombres=false;
       do{
            System.out.print("Nuevo nombre: ");
            nombres[editar] = scanner.nextLine();
           if(nombres[editar].isEmpty()){
               System.out.println("Porfavor ingrese algun nombre para le personaje que va a ser creado:   ");
               continue;
           }
           validacionnombres=true;
           for(int a=0; a<Cantidadpersonajes; a++){
               if (nombres[a].equalsIgnoreCase(nombres[editar]) && a != editar){
                   System.out.println("***El nombre ya existe ecriba uno diferente porfavor***");
                   validacionnombres=false;
                   break;
               } else {
               }
           }
          }while (!validacionnombres);
              System.out.print("Escriba el nuevo objeto/arma que quiera registrar:   ");
              objetos[editar]=scanner.nextLine();
              
 
       System.out.println("Ingrese las nuevas habilidades  *si no quiere ingresar ninguna habilidad puede dejar el espacio vacio presionando enter*:  ");
      String[] habilidadesP=new String[5];
       int Cantidadhabilidades=0;
       for(int a=0;a<5;a++){
        System.out.print("Habilidad no."+(a+1)+"   ");
        habilidades[editar][a]=scanner.nextLine();
        if(!habilidades[editar][a].isEmpty()){
            habilidadesP[a]=habilidades[editar][a];
            Cantidadhabilidades++;
        }else{
            break;
        }
    } 
       int Nivel=0;
       boolean validacionnivel=false;
       do{
           try{
           System.out.print("ingrese un valor para le nivel del personaje (tiene que estar enre 1-100 para que sea valido):  ");
           Nivel=Integer.parseInt(scanner.nextLine());
           if(Nivel>=1 && Nivel<=100){
           validacionnivel=true;
           }else{
           System.out.print("***El numero escrito no cumple con las condiciones porfavor ingrese uno que si lo haga***");
           }
           
           
           }catch(NumberFormatException e){
           System.out.print("ingrese un valor numerioc valido porfavor");
           }
       }while(!validacionnivel);
       nivelpersonaje[editar]=Nivel;      
}
       
       public static int IDeditarpersonajes(){
       try{
           System.out.print("Seleccione el ID del personaje al que desea aplicar este proceso: ");
           int ID=Integer.parseInt(scanner.nextLine());
           if(ID<1 || ID>Cantidadpersonajes){
           System.out.println("ID erroneo ingrese uno valido nuevamente");
           return -1;
           }
           return ID;
       }catch(NumberFormatException e){
       System.out.println("ingrese un valor valido");
       return -1;
       }
   } 
    public static void confirmaciondeeliminacion(){
       if(Cantidadpersonajes==0){
        System.out.println("No hay datos de personajes porfavor registre algun personaje");
        }
        System.out.println("**Eliminar Personaje**");
        int ID=IDeditarpersonajes();
        if (ID==-1)return;
        int eliminar=ID-1;
                System.out.println("**Info Personajes**");
      
        System.out.println("***Informacion de los personajes***");
        System.out.println("ID: "+ID);
        System.out.println("nombre: "+nombres[eliminar]);
     int confirmacion=0;
    System.out.println("Esta seguro de queerer eliminar a este personaje? si=1 NO=0");   
    System.out.print("Escoja la opcion que quiera realizar:   ");    
    try{
    confirmacion =Integer.parseInt(scanner.nextLine());
    switch(confirmacion){
        case 0:
            System.out.println("Proceso cancelado");
  
        case 1: 
        System.out.println("Eliminando personaje");
        Eliminar();
   
            
          }
    }catch (NumberFormatException error) {
        System.out.println("Seleccione un numero de la lista porfavor");
      }
  }    

public static void Eliminar(){
              
           int EL=IDeditarpersonajes();
    if (EL==-1)return;
        int eliminar2=EL-1;
            System.out.println("el personaje se esta eliminando");
             for (int a=eliminar2; a<Cantidadpersonajes-1; a++){
            nombres[a] = nombres[a + 1];
            objetos[a] = objetos[a + 1];
            nivelpersonaje[a] = nivelpersonaje[a + 1];
            for (int b = 0; b < 5; b++) {
                habilidades[a][b] = habilidades[a + 1][b];
            }
        }

        nombres[Cantidadpersonajes - 1] = null;
        objetos[Cantidadpersonajes - 1] = null;
        nivelpersonaje[Cantidadpersonajes - 1] = 0;
        for (int b = 0; b < 5; b++) {
            habilidades[Cantidadpersonajes - 1][b] = null;
        }
        Cantidadpersonajes--;
        System.out.println("El personaje ha sido eliminado correctamente.");

}


    public static void Verhistorial(){
              System.out.println("*Ver historial*");

}

  
  
  
}

