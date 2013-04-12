/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PalikkaTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rubik_oht.palikat.KulmaPalikka;

/**
 *
 * @author eevanikkari
 */
public class KulmapalikkaIlmanVarejaTest {
    
    KulmaPalikka kulmaPalikka;
    
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
        kulmaPalikka =new KulmaPalikka("K2");
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void EiVoidaHakeaVariaJotaEiOle(){
        assertEquals( null ,kulmaPalikka.haeVari(3));
     }
      
    
     @Test
     public void NimiOnOikein(){
         assertEquals("K2", kulmaPalikka.haeNimi());
     } 
     
     @Test
     public void sivuilleVoidaanAsettaaVariJaHakeaSe(){
     this.kulmaPalikka.asetavari(2, "#FFFFFF");
         assertEquals("#FFFFFF", kulmaPalikka.haeVari(2));
     } 
     
}
