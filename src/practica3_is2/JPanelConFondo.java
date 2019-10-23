/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3_is2;

/**
 *
 * @author DNF
 */
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;
import javax.swing.JPanel;
//...
 
public class JPanelConFondo extends JPanel implements Serializable{
 
    private Image imagen;
 
    //...
    public JPanelConFondo(Image imagenInicial) {
    if (imagenInicial != null) {
        imagen = imagenInicial;
    }
}
 
    @Override
    public void paint(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), 
                             this);

            setOpaque(false);
        } else {
            setOpaque(true);
        }

        super.paint(g);
    }
 
    //...
}