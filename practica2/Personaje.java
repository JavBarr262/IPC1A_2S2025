package com.mycompany.practica2;

import java.io.Serializable;

public class Personaje implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int id,hp,ataque,velocidad,agilidad,defensa,hpActual,daño;
    private String nombre;
    private String arma;
   
    // Getters y setters
    public int getId() {
        return id;
    }
    public void setID(int id){
     this.id=id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getArma() {
        return arma;
    }
    
    public void setArma(String arma) {
        this.arma = arma;
    }
    
    public int getHp() {
        return hp;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
        this.hpActual = hp;
    }
    
    public int getHpActual() {
        return hpActual;
    }
    
    public void setHpActual(int hpActual) {
        this.hpActual = hpActual;
    }
    
    public int getAtaque() {
        return ataque;
    }
    
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    
    public int getVelocidad() {
        return velocidad;
    }
    
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    
    public int getAgilidad() {
        return agilidad;
    }
    
    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }
    
    public int getDefensa() {
        return defensa;
    }
    
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    
    public void setDaño(){
     this.daño=daño;
    }
    public int getDaño(){
    return daño;
    }
    
    
    public int Ataque(){
         if (hp > 0) {
        double dañoBase = (ataque * ataque) / (double)(ataque + defensa);
        double crit = 0.20;

        double aleatorio = Math.random();

        if (aleatorio < crit) {
            double bonus = 1.5 + Math.random(); 
            dañoBase *= bonus;
            System.out.println(nombre+"  realizo un ataque critico");
        }

        return (int) dañoBase;
    } else {
        return 0;
    }
    }
    
    public void dañorealizado(int daño){
        this.hp -=daño;
    }
    

}