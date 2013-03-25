/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PalikkaJaAsentoTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rubik_oht.palikat.Kulmapalikka;
import rubik_oht.palikat.Palikka;
import rubik_oht.apuluokat.PalikkaJaAsento;
import rubik_oht.palikat.Reunapalikka;

/**
 *
 * @author eevanikkari
 */
public class PalikkaJaAsentoTest {

    PalikkaJaAsento sailo;
    Kulmapalikka kulmapalikka;
    
    public PalikkaJaAsentoTest(){
        
    }
    
    @Before
    public void setUp() {
        this.kulmapalikka = new Kulmapalikka("K", "a", "b", "c");
        this.sailo = new PalikkaJaAsento(kulmapalikka);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test 
    public void OnkoOikeaPalikka(){
        assertEquals(this.kulmapalikka, sailo.haePalikka());
    }
    
    @Test
    public void onkoListaAlussaOikein(){
        int[] asento = {1,2,3};
        assertEquals(asento[0], sailo.haeAsento()[0]);
        assertEquals(asento[1], sailo.haeAsento()[1]);
        assertEquals(asento[2], sailo.haeAsento()[2]);
        
    }
    
    @Test
    public void palauttaakoVarit() {
        assertEquals("a", sailo.haeMikaVariPaikallaOn(1));
        assertEquals("b", sailo.haeMikaVariPaikallaOn(2));
        assertEquals("c", sailo.haeMikaVariPaikallaOn(3));
    }
    
    @Test
    public void voikoPaikkojaMuuttaa(){
        int[] uusiAsento = {2,3,1};
        this.sailo.muutaAsento(uusiAsento);
        
        assertEquals(uusiAsento[0], sailo.haeAsento()[0]);
        assertEquals(uusiAsento[1], sailo.haeAsento()[1]);
        assertEquals(uusiAsento[2], sailo.haeAsento()[2]);
    }
    
    @Test
    public void PalauttaakoVaritOikeinMuutoksenJalkeen(){
        int[] uusiAsento = {2,3,1};
        this.sailo.muutaAsento(uusiAsento);
        
        assertEquals("b", sailo.haeMikaVariPaikallaOn(1));
        assertEquals("c", sailo.haeMikaVariPaikallaOn(2));
        assertEquals("a", sailo.haeMikaVariPaikallaOn(3));
    }
}
