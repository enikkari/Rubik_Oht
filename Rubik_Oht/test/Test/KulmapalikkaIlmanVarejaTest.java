/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rubik_oht.Kulmapalikka;

/**
 *
 * @author eevanikkari
 */
public class KulmapalikkaIlmanVarejaTest {
    
    Kulmapalikka kulmaPalikka;
    
    public KulmapalikkaIlmanVarejaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kulmaPalikka =new Kulmapalikka("K2");
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void AlussaEiVareja() {
        assertEquals(null ,kulmaPalikka.haeVari(1));
        assertEquals(null ,kulmaPalikka.haeVari(2));
        assertEquals(null ,kulmaPalikka.haeVari(3));
     }
     @Test
     public void NimiOnOikein(){
         assertEquals("K2", kulmaPalikka.haeNimi());
     } 
}
