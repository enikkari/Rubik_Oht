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
import rubik_oht.Palikka;

/**
 *
 * @author eevanikkari
 */
public class PalikkaTest {
    
    Palikka palikka;

    
    @Before
    public void setUp() {
        palikka =new Palikka("hullunIsoPalikka", 6);
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
    public void OikeaMaaraSivuja(){
        assertEquals(6, palikka.kuinkaMontaSivua());
    }
}
