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
public class OsoPolar extends Animal implements Serializable{
    
    public OsoPolar(Entorno entorno1, float masa_corporal1, int fecha) {
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
                System.out.println("[Oso Polar] me como "+a+" \n");
                entorno.removeAnimalAux(a);
                i++;
                if(i==valorDado){
                    muerto = false;
                }
            }
            
        }
        valorDado = r.nextInt(2-1+1)+1;
        for(j=0; j < entorno.animales.size();j++){
            Animal a = entorno.animales.get(j);
            if(a instanceof Foca && entorno.aux_animales.contains(a)){
                System.out.println("[Oso Polar] me como "+a+" \n");
                entorno.removeAnimalAux(a);
                i++;
                if(i==valorDado){
                    muerto = false;
                }
            }
        }
        
        if(muerto){
            entorno.removeAnimalAux(this);
            System.out.println("[Oso Polar] me muero, no hay comida\n");
        }
    }
    
    @Override
    public void reproducirse(){
        Random r = new Random();
        int valorDado = r.nextInt(1000-0+1)+0;
        if(valorDado <153){
            entorno.addAnimalAux(new OsoPolar(this.entorno,this.masa_corporal,this.entorno.getFecha()));
        }
    }
    
    @Override
    public void morir(){
        Random r = new Random();
        int valorDado = r.nextInt(1000-0+1)+0;
        if(valorDado <95){
            entorno.removeAnimalAux(this);
        }
    }
    
    @Override
    public String toString(){
        return "[Oso Polar]\tFecha_nacimiento: "+fecha_nacimiento+"\tMasa corporal: "+masa_corporal+"\n";
    }
}
