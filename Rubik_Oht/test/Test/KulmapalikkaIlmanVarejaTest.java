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
    
    Kulmapalikka palikka;
    
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
        palikka =new Kulmapalikka("K2");
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void AlussaEiVareja() {
        assertEquals(null ,palikka.haeVari(1));
        assertEquals(null ,palikka.haeVari(2));
        assertEquals(null ,palikka.haeVari(3));
     }
     @Test
     public void NimiOnOikein(){
         
     } 
}
