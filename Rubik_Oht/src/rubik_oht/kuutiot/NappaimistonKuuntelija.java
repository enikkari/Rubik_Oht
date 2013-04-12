/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rubik_oht.kuutiot;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NappaimistonKuuntelija implements KeyListener {

    private RubikinKuutio kuutio;

    public NappaimistonKuuntelija(RubikinKuutio kuutio) {
        this.kuutio = kuutio;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.CHAR_UNDEFINED) {
            
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
