/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import rubik_oht.kuutiot.RubikinKuutio;

public class Piirtoalusta extends JPanel {

    private RubikinKuutio kuutio;
    
    
    public Piirtoalusta(RubikinKuutio kuutio) {
        super.setBackground(Color.WHITE);
        this.kuutio=kuutio;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        //luodaan taustalle mustat neliöt niin että palikan sivut erottuvat
        graphics.setColor(Color.BLACK);
        int ykoordinaattiNeliot=0;
        graphics.fillRect(65, 1, 64, 257);
        graphics.fillRect(1, 65, 192, 64);
        
        
        // yla
        int ykoordinaatti = 2;
        for(int rivi = 0; rivi<3; rivi++){
            int xkoordinaatti=66;
            for(int sarake = 0; sarake<3; sarake++){
                graphics.setColor(this.kuutio.mikaVariOnPaikalla(0, rivi, sarake));
                graphics.fillRect(xkoordinaatti, ykoordinaatti, 20, 20);
                xkoordinaatti=xkoordinaatti+21;
            }
            ykoordinaatti=ykoordinaatti+21;
        }
        
        ykoordinaatti=ykoordinaatti+1;
        
        //vasen, etu, oikea
        for(int rivi = 0; rivi<3; rivi++){
            int xkoordinaatti=2;
            for(int sivu=1; sivu<4;sivu++){
            for(int sarake = 0; sarake<3; sarake++){
                graphics.setColor(this.kuutio.mikaVariOnPaikalla(sivu, rivi, sarake));
                graphics.fillRect(xkoordinaatti, ykoordinaatti, 20, 20);
                xkoordinaatti=xkoordinaatti+21;
            }
            xkoordinaatti=xkoordinaatti+1;
        }
            ykoordinaatti=ykoordinaatti+21;
        }
        
        ykoordinaatti=ykoordinaatti+1;
        
        //ala,taka
        for(int sivu=4; sivu<6; sivu++){
        for(int rivi = 0; rivi<3; rivi++){
            int xkoordinaatti=66;
            for(int sarake = 0; sarake<3; sarake++){
                graphics.setColor(this.kuutio.mikaVariOnPaikalla(sivu, rivi, sarake));
                graphics.fillRect(xkoordinaatti, ykoordinaatti, 20, 20);
                xkoordinaatti=xkoordinaatti+21;
            }
            ykoordinaatti=ykoordinaatti+21;
        }
        ykoordinaatti=ykoordinaatti+2;
        
        }
        
        graphics.setColor(Color.BLACK);
        graphics.drawString("0", 150, 145);
        graphics.drawString("1 2 3", 140, 160);
        graphics.drawString("4", 150, 175);
        graphics.drawString("5", 150, 190);
        
    }
    
    
}
