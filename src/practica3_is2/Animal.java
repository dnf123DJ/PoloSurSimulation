/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3_is2;

import java.io.Serializable;

/**
 *
 * @author DNF
 */
public class Animal implements Serializable{
    protected Entorno entorno;
    protected float masa_corporal;
    protected int fecha_nacimiento;
    
    //Cada Clase qeu hereda de Animal implementa una funcion comer, reproducirse y morir
    
    public void comer(){
        
    }
    
    public void reproducirse(){
        
    }
    
    public void morir(){
        
    }
}
