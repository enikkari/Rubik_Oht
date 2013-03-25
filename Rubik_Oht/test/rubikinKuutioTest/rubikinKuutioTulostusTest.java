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
public class rubikinKuutioTulostusTest {
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
        String[][] yla = this.rubik.haeTaulukonTulkintaSivuiksi(0);
        
        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                assertEquals("@", yla[i][a]);
            }
        }
    }
    
    
    @Test
    public void alussaVasenOikein() {
        String[][] vasen = this.rubik.haeTaulukonTulkintaSivuiksi(1);
        
        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                assertEquals("#", vasen[i][a]);
            }
        }
    }
    
    @Test
    public void alussaEtuOikein() {
        String[][] etu = this.rubik.haeTaulukonTulkintaSivuiksi(2);
        
        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                assertEquals("€", etu[i][a]);
            }
        }
    }
    
    @Test
    public void alussaOikeaOikein() {
        String[][] oikea = this.rubik.haeTaulukonTulkintaSivuiksi(3);
        
        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                assertEquals("%", oikea[i][a]);
            }
        }
    }
    @Test
    public void alussaAlaOikein() {
        String[][] ala = this.rubik.haeTaulukonTulkintaSivuiksi(4);
        
        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                assertEquals("&", ala[i][a]);
            }
        }
    }
    @Test
    public void alussaTakaOikein() {
        String[][] taka = this.rubik.haeTaulukonTulkintaSivuiksi(5);
        
        for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                assertEquals("?", taka[i][a]);
            }
        }
    }
}
