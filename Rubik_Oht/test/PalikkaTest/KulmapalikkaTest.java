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
public class KulmapalikkaTest {
    
    KulmaPalikka kulmaPalikka;
   
    
    @Before
    public void setUp() {
         kulmaPalikka = new KulmaPalikka("K1", "@","%","&");
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
        
        assertEquals(new String[] {"#FFFFFF","#FF0000","#0000FF"},new String[] {kulmaPalikka.haeVari(1),kulmaPalikka.haeVari(2),kulmaPalikka.haeVari(3)});
      
     }
     
     @Test
     public void EiVoidaHakeaVariaJotaEiOle(){
        assertEquals("voidaan hakea väri, jota ei pitäisi olla", null ,kulmaPalikka.haeVari(4));
     }
     
     @Test
     public void EiVoidaHakeaNegatiivistaVaria(){
        assertEquals("voidaan hakea väri, jota ei pitäisi olla", null ,kulmaPalikka.haeVari(-3));
     }
     
     @Test
     public void OnhanKolmeSivua(){
         assertEquals("Kulmapalikalla on väärä määrä sivuja",3, kulmaPalikka.kuinkaMontaSivua());
     }
}
