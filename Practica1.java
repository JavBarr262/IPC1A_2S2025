/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica1;

/**
 *
 * @author USUARIO
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
try{
    validacion=Integer.parseInt(scanner.nextLine());
    switch(validacion){
        case 1 -> Creacionpersonajes();
        case 2 -> Verinfopersonajes();
        case 3 -> Verlistapersonajes();
        case 4 -> Pelea();
        case 5 -> Editarinfo();
        case 6 -> Eliminar();
        case 7 -> Verhistorial();
        case 8 -> {
            System.out.println("Javier Antonio Barrios Calderon");
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
       
       System.out.print("Escriba el objeto/arma que quiera asignarle al personaje:   ");
       String objeto=scanner.nextLine();
       
       String[] habilidadesP=new String[5];
       System.out.println("Ingrese las habilidades puen ser hasta  *si no quiere ingresar ninguna habilidad puede dejar el espacio vacio presionando enter*:  ");
       int Cantidadhabilidades=0;
       for(int a=0;a<5;a++){
        System.out.print("Habilidad no."+(a+1));
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
       System.out.print("***el personaje que creo se agrego correctamente No."+Cantidadpersonajes+"***");

    
    }
    
    public static void Verinfopersonajes(){
              System.out.println("*ver info personajes*");

}
    public static void Verlistapersonajes(){
              System.out.println("*ver lista personajes*");

}
    public static void Pelea(){
              System.out.println("*Pelea*");

}
       public static void Editarinfo(){
              System.out.println("*Editar informacion*");

}
    public static void Eliminar(){
              System.out.println("*Eliminar*");

}
    public static void Verhistorial(){
              System.out.println("*Ver historial*");

}
  
  
}

