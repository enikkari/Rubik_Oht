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
import rubik_oht.palikat.Palikka;

/**
 *
 * @author eevanikkari
 */
public class PalikkaTest {

    Palikka palikka;

    @Before
    public void setUp() {
        palikka = new Palikka("hullunIsoPalikka", 6);
        //Luodaan kuusisivuinen palikka
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void NimiOikein() {
        assertEquals("hullunIsoPalikka", palikka.haeNimi());
    }

    @Test
    public void OikeaMaaraSivuja() {
        assertEquals(6, palikka.kuinkaMontaSivua());
    }

    @Test
    public void kaantyyMyotapaivaanOikein() {
        String[] vanhaJarjestys = this.palikka.haeVarit();
        this.palikka.kaannaMyotapaivaan();
        assertEquals(this.palikka.haeVari(0), vanhaJarjestys[5]);
        assertEquals(this.palikka.haeVari(1), vanhaJarjestys[0]);
        assertEquals(this.palikka.haeVari(2), vanhaJarjestys[1]);
        assertEquals(this.palikka.haeVari(3), vanhaJarjestys[2]);
        assertEquals(this.palikka.haeVari(4), vanhaJarjestys[3]);
        assertEquals(this.palikka.haeVari(5), vanhaJarjestys[4]);
    }

    @Test
    public void kaantyyVastapaivaanOikein() {
        assertEquals(6, palikka.kuinkaMontaSivua());
        String[] vanhaJarjestys = this.palikka.haeVarit();
        this.palikka.kaannaMyotapaivaan();
        assertEquals(this.palikka.haeVari(0), vanhaJarjestys[1]);
        assertEquals(this.palikka.haeVari(1), vanhaJarjestys[2]);
        assertEquals(this.palikka.haeVari(2), vanhaJarjestys[3]);
        assertEquals(this.palikka.haeVari(3), vanhaJarjestys[4]);
        assertEquals(this.palikka.haeVari(4), vanhaJarjestys[5]);
        assertEquals(this.palikka.haeVari(5), vanhaJarjestys[0]);
    }
}
