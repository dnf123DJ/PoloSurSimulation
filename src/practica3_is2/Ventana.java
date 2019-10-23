/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3_is2;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.Serializable;
import javax.swing.*;

/**
 *
 * @author DNF
 */
public class Ventana extends JFrame implements Serializable{
    private JButton boton_crear_entorno;
    private JButton pasar_un_dia;
    private JButton pasar_10_dias;
    private JButton calentamiento_global;
    private JButton buques_pesca_mayor;
    private JButton mostrar_estado;
    
    private final JPanelConFondo contenedor = new JPanelConFondo(new ImageIcon(getClass().getResource("fondo.png")).getImage());
 
    public Ventana(){
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setTitle("Polo Sur Simulation");
        this.setSize(800, 650);
        setContentPane(contenedor);
        this.setLayout(null);
        
        
        boton_crear_entorno = new JButton(new ImageIcon(new ImageIcon("tabla1.png").getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
        boton_crear_entorno.setActionCommand("Crear Entorno");
        boton_crear_entorno.setBounds(new Rectangle(235,205,300,50));
        pasar_un_dia = new JButton(new ImageIcon(new ImageIcon("tabla2.png").getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
        pasar_un_dia.setActionCommand("Pasar un día");
        pasar_un_dia.setBounds(new Rectangle(235,265,300,50));
        pasar_10_dias = new JButton(new ImageIcon(new ImageIcon("tabla3.png").getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
        pasar_10_dias.setActionCommand("Pasar 10 dias");
        pasar_10_dias.setBounds(new Rectangle(235,325,300,50));
        mostrar_estado = new JButton(new ImageIcon(new ImageIcon("tabla4.png").getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
        mostrar_estado.setActionCommand("Mostrar Estado");
        mostrar_estado.setBounds(new Rectangle(235,385,300,50));
        calentamiento_global = new JButton(new ImageIcon(new ImageIcon("tabla5.png").getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
        calentamiento_global.setActionCommand("Calentamiento Global");
        calentamiento_global.setBounds(new Rectangle(235,445,300,50));
        buques_pesca_mayor = new JButton(new ImageIcon(new ImageIcon("tabla6.png").getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
        buques_pesca_mayor.setActionCommand("Buques de Pesca Mayor");
        buques_pesca_mayor.setBounds(new Rectangle(235,505,300,50));
        
        this.add(boton_crear_entorno);
        this.add(pasar_un_dia);
        this.add(pasar_10_dias);
        this.add(mostrar_estado);
        this.add(calentamiento_global);
        this.add(buques_pesca_mayor);
            
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
    }

    void addActionListener(Entorno.MiActionListener a) {
        
        boton_crear_entorno.addActionListener(a);
        pasar_un_dia.addActionListener(a);
        pasar_10_dias.addActionListener(a);
        mostrar_estado.addActionListener(a);
        calentamiento_global.addActionListener(a);
        buques_pesca_mayor.addActionListener(a);

    }
    
}
