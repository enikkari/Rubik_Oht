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
import rubik_oht.Reunapalikka;

/**
 *
 * @author eevanikkari
 */
public class ReunaPalikkaTest {
   Reunapalikka reunapalikka;
   
    @Before
    public void setUp() {
        reunapalikka = new Reunapalikka("R1","","");
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void OnhanKaksiSivua() {
     assertEquals(2, reunapalikka.kuinkaMontaSivua());
     }
     
     @Test
     public void asetetaanVaritOikein(){
         reunapalikka.asetavari(1, "#00FF00");
         reunapalikka.asetavari(2, "#FF0000");
         
         assertEquals("#00FF00", reunapalikka.haeVari(1));
         assertEquals("#FF0000", reunapalikka.haeVari(2));
     }
}
