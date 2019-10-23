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
public class Esquimal extends Animal implements Serializable{


    public Esquimal(Entorno entorno1, float masa_corporal1, int fecha) {
        this.entorno = entorno1;
        this.masa_corporal = masa_corporal1;
        this.fecha_nacimiento = fecha;
    }
    
    @Override
    public void comer(){
        Random r = new Random();
        int valorDado = r.nextInt(4-2+1)+2;
        int i = 0,j;
        boolean muerto = true;
        for(j=0; j < entorno.animales.size();j++){
            Animal a = entorno.animales.get(j);
            if(a instanceof Pez && entorno.aux_animales.contains(a)){
                System.out.println("[Esquimal] me como "+a+" \n");
                entorno.removeAnimalAux(a);
                i++;
                if(i==valorDado){
                    muerto = false;
                }
            }
            
        }
        valorDado = r.nextInt(1-0+1)+0;
        if(valorDado >0){
            for(j=0; j < entorno.animales.size();j++){
                Animal a = entorno.animales.get(j);
                if(a instanceof Foca && entorno.aux_animales.contains(a)){
                    System.out.println("[Esquimal] me como "+a+" \n");
                    entorno.removeAnimalAux(a);
                    i++;
                    if(i==valorDado){
                        muerto = false;
                    }
                }
            }
        }
        
        if(muerto){
            entorno.removeAnimalAux(this);
            System.out.println("[Esquimal] me muero, no hay comida\n");
        }
    }
    
    
    @Override
    public void reproducirse(){
        Random r = new Random();
        int valorDado = r.nextInt(1000-0+1)+0;
        if(valorDado <32){
            entorno.addAnimalAux(new Esquimal(this.entorno,this.masa_corporal,this.entorno.getFecha()));
            System.out.println("creado");
        }
    }
    
    @Override
    public void morir(){
        Random r = new Random();
        int valorDado = r.nextInt(1000-0+1)+0;
        if(valorDado <24){
            entorno.removeAnimalAux(this);
        }
    }
    
    @Override
    public String toString(){
        return "[Esqimal]\tFecha_nacimiento: "+fecha_nacimiento+"\tMasa corporal: "+masa_corporal+"\n";
    }
    
    
}
