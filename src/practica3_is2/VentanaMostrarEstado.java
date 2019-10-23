/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3_is2;

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author DNF
 */
public class VentanaMostrarEstado extends JFrame{
    private JLabel n_esquimal,n_osopolar,n_morsa,n_foca,n_pez,n_plancton,temp_agua,catastrofe,n_fecha;
    private JTextArea a_esquimal,a_osopolar,a_morsa,a_foca,a_pez;
    private Entorno entorno;
    private ArrayList cont_esquimal,cont_osopolar,cont_morsa,cont_foca,cont_pez;
    private JButton pasar_un_dia;
    private JButton pasar_10_dias;
    private JButton calentamiento_global;
    private JButton buques_pesca_mayor;
    
    private final JPanelConFondo contenedor = new JPanelConFondo(new ImageIcon(getClass().getResource("fondo2.png")).getImage());
    VentanaMostrarEstado(Entorno entorno){
        cont_esquimal= new ArrayList();
        cont_osopolar= new ArrayList();
        cont_morsa= new ArrayList();
        cont_foca= new ArrayList();
        cont_pez= new ArrayList();
        this.entorno = entorno;
        this.setTitle("Estado");
        this.setSize(1000, 650);
        setContentPane(contenedor);
        this.setLayout(null);
        int i;
        for(i=0;i<entorno.animales.size();i++){
            Animal a = entorno.animales.get(i);
            if(a instanceof Esquimal){
                cont_esquimal.add(a);
            }else if(a instanceof OsoPolar){
                cont_osopolar.add(a);
            }else if(a instanceof Morsa){
                cont_morsa.add(a);
            }else if(a instanceof Foca){
                cont_foca.add(a);
            }else if(a instanceof Pez){
                cont_pez.add(a);
            }
        }
        n_esquimal=new JLabel(cont_esquimal.size()+"");
        n_esquimal.setFont(new Font("Serif", Font.PLAIN, 30));
        n_esquimal.setBounds(new Rectangle(180,80,300,50));
        
        a_esquimal=new JTextArea(cont_esquimal.toString());
        JScrollPane sp_esquimal = new JScrollPane(a_esquimal);
        sp_esquimal.setBounds(new Rectangle(300,80,470,50));
        a_esquimal.setEnabled(false);
        n_morsa=new JLabel(cont_morsa.size()+"");
        n_morsa.setFont(new Font("Serif", Font.PLAIN, 30));
        n_morsa.setBounds(new Rectangle(180,150,300,50));
        
        a_morsa=new JTextArea(cont_morsa.toString());
        JScrollPane sp_morsa = new JScrollPane(a_morsa);
        sp_morsa.setBounds(new Rectangle(300,150,470,50));
        a_morsa.setEnabled(false);
        
        n_pez=new JLabel(cont_pez.size()+"");
        n_pez.setFont(new Font("Serif", Font.PLAIN, 30));
        n_pez.setBounds(new Rectangle(180,220,300,50));
        
        a_pez=new JTextArea(cont_pez.toString());
        JScrollPane sp_pez = new JScrollPane(a_pez);
        sp_pez.setBounds(new Rectangle(300,220,470,50));
        a_pez.setEnabled(false);
        
        n_foca=new JLabel(cont_foca.size()+"");
        n_foca.setFont(new Font("Serif", Font.PLAIN, 30));
        n_foca.setBounds(new Rectangle(180,290,300,50));
        
        a_foca=new JTextArea(cont_foca.toString());
        JScrollPane sp_foca = new JScrollPane(a_foca);
        sp_foca.setBounds(new Rectangle(300,290,470,50));
        a_foca.setEnabled(false);
        
        n_osopolar=new JLabel(cont_osopolar.size()+"");
        n_osopolar.setFont(new Font("Serif", Font.PLAIN, 30));
        n_osopolar.setBounds(new Rectangle(180,360,300,50));
        
        
        a_osopolar=new JTextArea(cont_osopolar.toString());
        a_osopolar.setFont(new Font("Serif", Font.PLAIN, 12));
        JScrollPane sp_osopolar = new JScrollPane(a_osopolar);
        sp_osopolar.setBounds(new Rectangle(300,360,470,50));
        a_osopolar.setEnabled(false);
        
        temp_agua=new JLabel(entorno.getTemp_agua()+"");
        temp_agua.setFont(new Font("Serif", Font.PLAIN, 30));
        temp_agua.setBounds(new Rectangle(180,440,300,50));
        
        n_plancton=new JLabel(entorno.getKrillyPlancton()+" mil");
        n_plancton.setFont(new Font("Serif", Font.PLAIN, 30));
        n_plancton.setBounds(new Rectangle(180,510,300,50));
        
        n_fecha=new JLabel(entorno.getFecha()+"");
        n_fecha.setFont(new Font("Serif", Font.PLAIN, 50));
        n_fecha.setBounds(new Rectangle(390,475,300,50));
        
        catastrofe=new JLabel(entorno.getCatastrofe());
        catastrofe.setFont(new Font("Serif", Font.PLAIN, 15));
        catastrofe.setBounds(new Rectangle(600,470,500,50));
        
        pasar_un_dia = new JButton(new ImageIcon(new ImageIcon("tabla2.png").getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
        pasar_un_dia.setActionCommand("Pasar un día");
        pasar_un_dia.setBounds(new Rectangle(800,165,150,50));
        
        pasar_10_dias = new JButton(new ImageIcon(new ImageIcon("tabla3.png").getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
        pasar_10_dias.setActionCommand("Pasar 10 dias");
        pasar_10_dias.setBounds(new Rectangle(800,225,150,50));
        
        calentamiento_global = new JButton(new ImageIcon(new ImageIcon("tabla5.png").getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
        calentamiento_global.setActionCommand("Calentamiento Global");
        calentamiento_global.setBounds(new Rectangle(800,345,150,50));
        
        buques_pesca_mayor = new JButton(new ImageIcon(new ImageIcon("tabla6.png").getImage().getScaledInstance(300, 50, Image.SCALE_DEFAULT)));
        buques_pesca_mayor.setActionCommand("Buques de Pesca Mayor");
        buques_pesca_mayor.setBounds(new Rectangle(800,405,150,50));
        
        this.add(n_esquimal);
        this.add(sp_esquimal);
        this.add(n_osopolar);
        this.add(sp_osopolar);
        this.add(n_morsa);
        this.add(sp_morsa);
        this.add(n_foca);
        this.add(sp_foca);
        this.add(n_pez);
        this.add(sp_pez);
        this.add(n_plancton);
        this.add(temp_agua);
        this.add(n_fecha);
        this.add(catastrofe);
        this.add(pasar_un_dia);
        this.add(pasar_10_dias);
        this.add(calentamiento_global);
        this.add(buques_pesca_mayor);
        
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null); 
    }

    void addActionListener(Entorno.MiActionListener a) {
        pasar_un_dia.addActionListener(a);
        pasar_10_dias.addActionListener(a);
        calentamiento_global.addActionListener(a);
        buques_pesca_mayor.addActionListener(a);
    }

    void actualizar(Entorno entorno) {
        this.entorno = entorno;
        cont_esquimal.clear();
        cont_osopolar.clear();
        cont_morsa.clear();
        cont_foca.clear();
        cont_pez.clear();
        
        int i;
        for(i=0;i<entorno.animales.size();i++){
            Animal a = entorno.animales.get(i);
            if(a instanceof Esquimal){
                cont_esquimal.add(a);
            }else if(a instanceof OsoPolar){
                cont_osopolar.add(a);
            }else if(a instanceof Morsa){
                cont_morsa.add(a);
            }else if(a instanceof Foca){
                cont_foca.add(a);
            }else if(a instanceof Pez){
                cont_pez.add(a);
            }
        }
        n_esquimal.setText(cont_esquimal.size()+"");      
        a_esquimal.setText(cont_esquimal.toString());
        n_morsa.setText(cont_morsa.size()+"");
        a_morsa.setText(cont_morsa.toString());
        n_pez.setText(cont_pez.size()+"");
        a_pez.setText(cont_pez.toString());
        n_foca.setText(cont_foca.size()+"");
        a_foca.setText(cont_foca.toString());
        n_osopolar.setText(cont_osopolar.size()+"");
        a_osopolar.setText(cont_osopolar.toString());
        temp_agua.setText(entorno.getTemp_agua()+"");        
        n_plancton.setText(entorno.getKrillyPlancton()+" mil");
        n_fecha.setText(entorno.getFecha()+"");
        catastrofe.setText(entorno.getCatastrofe());

    }
}
