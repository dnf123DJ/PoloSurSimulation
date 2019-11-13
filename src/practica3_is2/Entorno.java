/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3_is2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author DNF
 */
public class Entorno implements Serializable{ 
    VentanaMostrarEstado ventana_estado;
    private int KrillyPlancton;
    private float temp_agua;
    private int fecha;
    private String catastrofe;
    ArrayList <Animal>animales ;
    ArrayList <Animal> aux_animales ;
     
    public Entorno() {
        animales = new ArrayList<Animal>();
        aux_animales = new ArrayList<Animal>();
        Ventana ventana = new Ventana();
        ventana_estado= null;
        MiActionListener a = new MiActionListener();
        MiWindowAdapter w = new MiWindowAdapter();
        ventana.addActionListener(a);
        ventana.addWindowListener(w);
        
        leerFichero();//carga la información de la sesion anterior
        
    }
    public int getKrillyPlancton() {
        return KrillyPlancton;
    }

    public void setKrillyPlancton(int KrillyPlancton) {
        this.KrillyPlancton = KrillyPlancton;
    }
    public int getFecha() {
        return fecha;
    }
   
    
    
    public void calentamientoGlobal(){
        temp_agua += 2;
        catastrofe = "Calentamiento Global\n";
    }
    
    public void buquesPescaMayor(){
        Random r = new Random();
        int valorDado = r.nextInt(100-0+1)+0;
        float i = 0;
        if(valorDado < 20){
            for(Animal a : animales){
                if(a instanceof Foca && aux_animales.contains(a)){
                    removeAnimalAux(a);
                    break;
                }
            }
        }
        valorDado = r.nextInt(100-0+1)+0;
        if(valorDado < 15){
            for(Animal a : animales){
                if(a instanceof OsoPolar && aux_animales.contains(a)){
                    removeAnimalAux(a);
                    break;
                }
            }
        }
        catastrofe = "Buques de Pesca Mayor\n";
        animales = aux_animales;
        mostrarEntorno();
    }
    
    public void crearPolo(){
        fecha=1;
        Random r = new Random();
        int max;
        int aux,tipo;
        
        max = r.nextInt(8000-7000+1)+7000;
        for(int i = 1; i <= max;i++ ){ //peces
            aux = r.nextInt(70-55+1)+55;
            tipo = r.nextInt(2-0+1)+0;
            animales.add(new Pez(this,aux,fecha,tipo));
        }
        
        max = r.nextInt(290-260+1)+260;
        for(int i = 1; i <= max;i++ ){ //focas
            aux = r.nextInt(32-25+1)+25;
            animales.add(new Foca(this,aux,fecha));
        }
        
        max = r.nextInt(28-22+1)+22;
        for(int i = 1; i <= max;i++ ){ //osos
            aux = r.nextInt(55-40+1)+40;
            animales.add(new OsoPolar(this,aux,fecha));
        }
        
        max = r.nextInt(48-42+1)+42;
        for(int i = 1; i <= max;i++ ){ //morsas
            aux = r.nextInt(42-30+1)+30;
            animales.add(new Morsa(this,aux,fecha));
        }
        
        max = r.nextInt(14-12+1)+12;
        for(int i = 1; i <= max;i++ ){ //esquimales
            aux = r.nextInt(48-35+1)+35;
            animales.add(new Esquimal(this,aux,fecha));
        }
        
        max = r.nextInt(75000-65000+1)+65000;
        KrillyPlancton = max;
        temp_agua=4;
        aux_animales = animales;
        catastrofe="";
        mostrarEntorno();
        JOptionPane.showMessageDialog(null, "Se ha creado el polo con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostrarEntorno(){
        for(Object o : animales){
            System.out.println(o);
        }
        System.out.println("Temperatura del Agua: "+temp_agua+"ºC\n");
        System.out.println("Krill y Plancton: "+KrillyPlancton+" mil\n");
        System.out.println("[Dia "+fecha+"]\n");
    }
    public void variarTempAgua(){
        Random r = new Random();
        int valorDado = r.nextInt(100-0+1)+0;
        if(temp_agua>=5.0){
            if(valorDado<=45){
                temp_agua+= 0.2;
            }else{
                temp_agua-= 0.2;
            }
        }else if(temp_agua>3){
            
            if(valorDado<=65){
                temp_agua+= 0.2;
            }else if(valorDado>95){
                temp_agua-= 0.2;
            }
        
        }else if(temp_agua<=3){
            if(valorDado<=55){
                temp_agua+= 0.2;
            }else{
                temp_agua-= 0.2;
            }
        }
        
    }
    
    public void variarKrillYPlancton(){
        if(temp_agua<5.5 && temp_agua >= 5){
            KrillyPlancton+=12000;
        }else if(temp_agua<5 && temp_agua >= 4){
            KrillyPlancton+=22000;
        }else if(temp_agua<4 && temp_agua >= 3){
            KrillyPlancton+=18000;
        }  
    }
    
    public void pasar10Dias(){
        for(int i = 0; i < 10;i++)
            if(pasarUnDia()){
                break;
            }
    }
    
    public boolean pasarUnDia(){
        boolean extinguido = false;
        variarTempAgua();
        variarKrillYPlancton();
        fecha++;
        for(int i=0; i < animales.size();i++){
            Animal a = animales.get(i);
            if(aux_animales.contains(a)){
                
                a.comer();
                a.reproducirse();
                a.morir();
                
            }
        }
        animales = aux_animales;
        mostrarEntorno();
        catastrofe = "";
        if(animales.isEmpty()){
            JOptionPane.showMessageDialog(null, "Se han extinguido todos los seres vivos", "Alerta", JOptionPane.WARNING_MESSAGE);
            extinguido= true;
        }
        try{
            ventana_estado.actualizar(this);
        }catch(Exception o){
            System.out.println("No esta creada la ventana "+ o);
        }
        return extinguido;
    }

    void addAnimalAux(Animal a) {
        aux_animales.add(a);
    }

    void removeAnimalAux(Animal a) {
        aux_animales.remove(a);
    }

    public float getTemp_agua() {
        return temp_agua;
    }

    public String getCatastrofe() {
        return catastrofe;
    }
    
    //Al pulsar la "X" de la ventana ejecuta este evento, lo que hace es guardar en ficheros .dat los valores del entorno
    public class MiWindowAdapter extends WindowAdapter{
        @Override
        public void windowClosing(java.awt.event.WindowEvent evt) {
            System.out.println("hola, me cierro");
            
            ventana_estado = null;
            FileOutputStream fos = null;
            ObjectOutputStream salida = null;
            

            try {
                //Se crea el fichero
                fos = new FileOutputStream("animales.dat");
                salida = new ObjectOutputStream(fos);
                    salida.writeObject(animales);

                System.out.println("Se ha creado el fichero con éxito!!\n");
            } catch (FileNotFoundException e) {
                System.out.println("1"+e.getMessage());
            } catch (IOException e) {
                System.out.println("2"+e.getMessage());
            } finally {
                try {
                    if(fos!=null) fos.close();
                    if(salida!=null) salida.close();
                } catch (IOException e) {
                    System.out.println("3"+e.getMessage());
                }
            }
            
            try {
                //Se crea el fichero
                fos = new FileOutputStream("temp_agua.dat");
                salida = new ObjectOutputStream(fos);
                    salida.writeObject(temp_agua);

                System.out.println("Se ha creado el fichero con éxito!!\n");
            } catch (FileNotFoundException e) {
                System.out.println("1"+e.getMessage());
            } catch (IOException e) {
                System.out.println("2"+e.getMessage());
            } finally {
                try {
                    if(fos!=null) fos.close();
                    if(salida!=null) salida.close();
                } catch (IOException e) {
                    System.out.println("3"+e.getMessage());
                }
            }
            
            try {
                //Se crea el fichero
                fos = new FileOutputStream("KrillyPlancton.dat");
                salida = new ObjectOutputStream(fos);
                    salida.writeObject(KrillyPlancton);

                System.out.println("Se ha creado el fichero con éxito!!\n");
            } catch (FileNotFoundException e) {
                System.out.println("1"+e.getMessage());
            } catch (IOException e) {
                System.out.println("2"+e.getMessage());
            } finally {
                try {
                    if(fos!=null) fos.close();
                    if(salida!=null) salida.close();
                } catch (IOException e) {
                    System.out.println("3"+e.getMessage());
                }
            }
            
            try {
                //Se crea el fichero
                fos = new FileOutputStream("fecha.dat");
                salida = new ObjectOutputStream(fos);
                    salida.writeObject(fecha);

                System.out.println("Se ha creado el fichero con éxito!!\n");
            } catch (FileNotFoundException e) {
                System.out.println("1"+e.getMessage());
            } catch (IOException e) {
                System.out.println("2"+e.getMessage());
            } finally {
                try {
                    if(fos!=null) fos.close();
                    if(salida!=null) salida.close();
                } catch (IOException e) {
                    System.out.println("3"+e.getMessage());
                }
            }
   
            System.exit(0);
        }
    }
    
    public void mostrarEstado() {
        ventana_estado = new VentanaMostrarEstado(this);
        MiActionListener a = new MiActionListener();
        ventana_estado.addActionListener(a);
    }
    public class MiActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            String aux = e.getActionCommand();
            switch(aux){
                
                case "Crear Entorno":
                    System.out.println("Crear Entorno");
                    crearPolo();
                    break;
                case "Pasar un día":
                    System.out.println("Pasar un dia\n");
                    pasarUnDia();
                    break;
                case "Pasar 10 dias":
                    System.out.println("Pasar 10 dias\n");
                    pasar10Dias();
                    break;
                case "Mostrar Estado":
                    System.out.println("Mostrar Estado\n");
                    mostrarEstado();
                    break;
                case "Calentamiento Global":
                    System.out.println("Calentamiento Global");
                    calentamientoGlobal();
                    break;
                case "Buques de Pesca Mayor":
                    System.out.println("Buques de Pesca Mayor");
                    buquesPescaMayor();
                    break;  
                default:
                    System.out.println("hola, me cierro");
                    break;
                
            }
        }

    }
    public void leerFichero(){
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        ArrayList animales;

        try {
            fis = new FileInputStream("animales.dat");
            entrada = new ObjectInputStream(fis);
            animales = (ArrayList) entrada.readObject(); //es necesario el casting
            this.aux_animales=this.animales = animales;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            fis = new FileInputStream("temp_agua.dat");
            entrada = new ObjectInputStream(fis);
            float temp_agua = (float) entrada.readObject(); //es necesario el casting
            this.temp_agua= temp_agua;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        
        try {
            fis = new FileInputStream("KrillyPlancton.dat");
            entrada = new ObjectInputStream(fis);
            int KrillyPlancton = (int) entrada.readObject(); //es necesario el casting
            this.KrillyPlancton= KrillyPlancton;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        
        try {
            fis = new FileInputStream("fecha.dat");
            entrada = new ObjectInputStream(fis);
            int fecha = (int) entrada.readObject(); //es necesario el casting
            this.fecha= fecha;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        
        
        
    }
}

