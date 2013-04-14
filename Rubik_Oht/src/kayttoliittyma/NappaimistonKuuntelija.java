/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import rubik_oht.kuutiot.RubikinKuutio;

public class NappaimistonKuuntelija implements KeyListener {

    private RubikinKuutio kuutio;
    private Component component;

    public NappaimistonKuuntelija(RubikinKuutio kuutio, Component component) {
        this.kuutio = kuutio;
        this.component = component;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() == KeyEvent.VK_Y || e.getKeyCode() == KeyEvent.VK_0){
            kuutio.kaannaMyotaTaiVastaPaivaan(1, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_V || e.getKeyCode() == KeyEvent.VK_1) {
            kuutio.kaannaMyotaTaiVastaPaivaan(1, 1);
        } else if (e.getKeyCode() == KeyEvent.VK_E || e.getKeyCode() == KeyEvent.VK_2) {
            kuutio.kaannaMyotaTaiVastaPaivaan(1, 2);
        } else if (e.getKeyCode() == KeyEvent.VK_O || e.getKeyCode() == KeyEvent.VK_3) {
            kuutio.kaannaMyotaTaiVastaPaivaan(1, 3);
        } else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_4) {
            kuutio.kaannaMyotaTaiVastaPaivaan(1, 4);
        } else if (e.getKeyCode() == KeyEvent.VK_T || e.getKeyCode() == KeyEvent.VK_5) {
            kuutio.kaannaMyotaTaiVastaPaivaan(1, 5);
        }
        component.repaint();
        }
        

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }
}
