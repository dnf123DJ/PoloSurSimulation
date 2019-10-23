/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3_is2;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author DNF
 */
public class Pez extends Animal implements Serializable{
    private int tipo;
    
    public Pez(Entorno entorno1, float masa_corporal1, int fecha,int tipo) {
        this.entorno = entorno1;
        this.masa_corporal = masa_corporal1;
        this.fecha_nacimiento = fecha;
        this.tipo = tipo;
    }
    
    @Override
    public void comer(){
        Random r = new Random();
        int valorDado = r.nextInt(2-1+1)+1;
        boolean muerto = true;
        int aux = entorno.getKrillyPlancton();
        if(aux >= valorDado){
            entorno.setKrillyPlancton(aux-valorDado);
            System.out.println("[Pez] me como "+valorDado+" mil\n");
            muerto = false;
        }
        
        if(muerto){
            entorno.removeAnimalAux(this);
            System.out.println("[Pez] me muero, no hay comida\n");
        }
    }
    
    @Override
    public void reproducirse(){
        Random r = new Random();
        int valorDado = r.nextInt(1000-0+1)+0;
        if(valorDado <185){
            entorno.addAnimalAux(new Pez(this.entorno,this.masa_corporal,this.entorno.getFecha(),tipo));
        }
    }
    
    @Override
    public void morir(){
        Random r = new Random();
        int valorDado = r.nextInt(1000-0+1)+0;
        if(valorDado <163){
            entorno.removeAnimalAux(this);
        }
    }
    
    @Override
    public String toString(){
        return "[Pez]\tFecha_nacimiento: "+fecha_nacimiento+"\tMasa corporal: "+masa_corporal+"\tTipo: "+tipo+"\n";
    }
}
