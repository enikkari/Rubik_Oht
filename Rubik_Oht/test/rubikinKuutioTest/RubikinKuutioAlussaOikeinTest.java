/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikinKuutioTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rubik_oht.kuutiot.RubikinKuutio;

/**
 *
 * @author eevanikkari
 */
public class RubikinKuutioAlussaOikeinTest {
    RubikinKuutio rubik;
    
    @Before
    public void setUp() {
        this.rubik = new RubikinKuutio("@","#","€","%","&","?");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void alussaYlaOikein() {
        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                assertEquals("Yla-sivussa on alussa vaaria vareja. Taulukon tulkinta saattaa olla väärä.","@", this.rubik.mikaMerkkijonoOnPaikalla(0, i, a));
            }
        }
    }
    
    
    @Test
    public void alussaVasenOikein() {
        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                assertEquals("Vasen-sivussa on alussa vaaria vareja. Taulukon tulkinta saattaa olla väärä.","#", this.rubik.mikaMerkkijonoOnPaikalla(1, i, a));
            }
        }
    }
    
    @Test
    public void alussaEtuOikein() {
        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                assertEquals("Etu-sivussa on alussa vaaria vareja. Taulukon tulkinta saattaa olla väärä.","€", this.rubik.mikaMerkkijonoOnPaikalla(2, i, a));
            }
        }
    }
    
    @Test
    public void alussaOikeaOikein() {
        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                assertEquals("Oikea-sivussa on alussa vaaria vareja. Taulukon tulkinta saattaa olla väärä.","%", this.rubik.mikaMerkkijonoOnPaikalla(3, i, a));
            }
        }
    }
    @Test
    public void alussaAlaOikein() {
        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                assertEquals("Ala-sivussa on alussa vaaria vareja. Taulukon tulkinta saattaa olla väärä.","&", this.rubik.mikaMerkkijonoOnPaikalla(4, i, a));
            }
        }
    }
    @Test
    public void alussaTakaOikein() {
        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                assertEquals("Taka-sivussa on alussa vaaria vareja. Taulukon tulkinta saattaa olla väärä.","?", this.rubik.mikaMerkkijonoOnPaikalla(5, i, a));
            }
        }
    }
}
