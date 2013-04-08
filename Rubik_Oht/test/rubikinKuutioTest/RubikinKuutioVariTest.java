/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikinKuutioTest;

import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rubik_oht.kuutiot.RubikinKuutio;

/**
 *
 * @author eevanikkari
 */
public class RubikinKuutioVariTest {
    RubikinKuutio rubik;
    
    @Before
    public void setUp() {
        this.rubik = new RubikinKuutio();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void hexVarinMuuttaminenOnnistuu() {
     assertEquals("Väärä hex-koodi", Color.red , Color.decode(rubik.mikaVariSivullaOn(0)));
    }
    
}
