/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik_oht.kuutiot;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
            kuutio.kaannaYla();
        } else if (e.getKeyCode() == KeyEvent.VK_V || e.getKeyCode() == KeyEvent.VK_1) {
            kuutio.kaannaVasen();
        } else if (e.getKeyCode() == KeyEvent.VK_E || e.getKeyCode() == KeyEvent.VK_2) {
            kuutio.kaannaEtu();
        } else if (e.getKeyCode() == KeyEvent.VK_O || e.getKeyCode() == KeyEvent.VK_3) {
            kuutio.kaannaOikea();
        } else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_4) {
            kuutio.kaannaAla();
        } else if (e.getKeyCode() == KeyEvent.VK_T || e.getKeyCode() == KeyEvent.VK_5) {
            kuutio.kaannaTaka();
        }
        
        else if(e.getKeyCode()== KeyEvent.ALT_DOWN_MASK){
            if (e.getKeyCode() == KeyEvent.VK_Y || e.getKeyCode() == KeyEvent.VK_0){
            kuutio.kaannaYla();
            kuutio.kaannaYla();
            kuutio.kaannaYla();
        } 
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
