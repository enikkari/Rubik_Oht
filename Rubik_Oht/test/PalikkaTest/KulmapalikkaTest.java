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
import rubik_oht.palikat.Kulmapalikka;

/**
 *
 * @author eevanikkari
 */
public class KulmapalikkaTest {
    
    Kulmapalikka kulmaPalikka;
   
    
    @Before
    public void setUp() {
         kulmaPalikka = new Kulmapalikka("K1", "@","%","&");
    }
    
    @After
    public void tearDown() {
    }
    
     @Test
     public void NimiJaVaritOikein() {
         assertEquals("K1" ,kulmaPalikka.haeNimi());
         assertEquals("@" ,kulmaPalikka.haeVari(1));
         assertEquals("%" ,kulmaPalikka.haeVari(2));
         assertEquals("&" ,kulmaPalikka.haeVari(3));
     }
     
     @Test
     public void VarienVaihtoOnnistuu(){
        kulmaPalikka.asetavari(1, "#FFFFFF"); 
        kulmaPalikka.asetavari(2, "#FF0000"); 
        kulmaPalikka.asetavari(3, "#0000FF"); 
        
        assertEquals("#FFFFFF" ,kulmaPalikka.haeVari(1));
        assertEquals("#FF0000" ,kulmaPalikka.haeVari(2));
        assertEquals("#0000FF" ,kulmaPalikka.haeVari(3));
     }
     
     @Test
     public void EiVoidaHakeaVariaJotaEiOle(){
        assertEquals( null ,kulmaPalikka.haeVari(4));
     }
     
     @Test
     public void OnhanKolmeSivua(){
         assertEquals(3, kulmaPalikka.kuinkaMontaSivua());
     }
}
