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
        assertEquals("Väärä Palikka",this.kulmapalikka, sailo.haePalikka());
    }
    
    @Test
    public void onkoListaAlussaOikein(){
        int[] asento = {1,2,3};
        assertArrayEquals("Lista ei ole alussa {1,2,3}",asento, sailo.haeAsento());
        
    }
    
    @Test
    public void palauttaakoVaritAluss() {
        assertArrayEquals("Värit ovat alussa väärin",new String[] {sailo.haeMikaVariPaikallaOn(1),sailo.haeMikaVariPaikallaOn(2),sailo.haeMikaVariPaikallaOn(3)}, new String[] {"a","b","c"});
    }
    
    @Test
    public void voikoPaikkojaMuuttaa(){
        int[] uusiAsento = {2,3,1};
        this.sailo.muutaAsento(uusiAsento);
        
        assertArrayEquals("Asento ei muutu oikein kerran muutettaessa",new int[] {2,3,1}, sailo.haeAsento());
    }
    
    @Test
    public void voikoPaikkojaMuuttaaMontaKertaa(){
        this.sailo.muutaAsento(new int[] {3,2,1});
        this.sailo.muutaAsento(new int[] {3,2,1});
        this.sailo.muutaAsento(new int[] {2,1,3});
        
        assertArrayEquals("Asento ei muutu oikein useamman kerran muutettaessa", new int[] {2,1,3}, sailo.haeAsento());
    }
    
    
    @Test
    public void PalauttaakoVaritOikeinMuutoksenJalkeen(){
        
        this.sailo.muutaAsento(new int[] {2,3,1});
        this.sailo.muutaAsento(new int[]{1,3,2});
        assertArrayEquals("Värit muutoksen jälkeen väärin",new String[] {sailo.haeMikaVariPaikallaOn(1),sailo.haeMikaVariPaikallaOn(2),sailo.haeMikaVariPaikallaOn(3)}, new String[] {"b","a","c"});
    }
}
