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
public class KulmapalikkaTest {
    
    Kulmapalikka palikka;
    
    public KulmapalikkaTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         palikka = new Kulmapalikka("K1", "@","%","&");
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void NimiJaVaritOikein() {
         assertEquals("K1" ,palikka.haeNimi());
         assertEquals("@" ,palikka.haeVari(1));
         assertEquals("%" ,palikka.haeVari(2));
         assertEquals("&" ,palikka.haeVari(3));
     }
     
     @Test
     public void VarienVaihtoOnnistuu(){
        palikka.asetavari(1, "#FFFFFF"); 
        palikka.asetavari(2, "#FF0000"); 
        palikka.asetavari(3, "#0000FF"); 
        
        assertEquals("#FFFFFF" ,palikka.haeVari(1));
        assertEquals("#FF0000" ,palikka.haeVari(2));
        assertEquals("#0000FF" ,palikka.haeVari(3));
     }
}
