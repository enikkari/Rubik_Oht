/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikinKuutioTest;

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
public class RubikinKuutionKaantelyTest {
    
    RubikinKuutio rubik;
    
    @Before
    public void setUp() {
        this.rubik = new RubikinKuutio();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void kaannaSivuaMetodiToimii() {
    rubik.kaannaMyotaTaiVastaPaivaan(1, 0);
    RubikinKuutio testiKuutio = new RubikinKuutio();
    
    }
}
