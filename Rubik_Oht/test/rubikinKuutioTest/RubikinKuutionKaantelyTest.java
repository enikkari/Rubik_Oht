/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rubikinKuutioTest;

import java.util.Random;
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
        for(int i =0; i<10; i++){
            int kaannettavaSivu = new Random().nextInt(5);
            int myotaVaiVastaPaivaan = new Random().nextInt(1);
            rubik.kaannaMyotaTaiVastaPaivaan(myotaVaiVastaPaivaan, i);
        }
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void sivutKaantyvatOmallaSivullaanOikein() {
        assertTrue("Ylasivu ei käänny oikein omalla sivullaan",this.kaantyykoSivuOmallaSivullaanOikein(0));
        assertTrue("Vasensivu ei käänny oikein omalla sivullaan",this.kaantyykoSivuOmallaSivullaanOikein(1));
        assertTrue("Etusivu ei käänny oikein omalla sivullaan",this.kaantyykoSivuOmallaSivullaanOikein(2));
        assertTrue("Vasensivu ei käänny oikein omalla sivullaan",this.kaantyykoSivuOmallaSivullaanOikein(3));
        assertTrue("Alaivu ei käänny oikein omalla sivullaan",this.kaantyykoSivuOmallaSivullaanOikein(4));
        assertTrue("Takaivu ei käänny oikein omalla sivullaan",this.kaantyykoSivuOmallaSivullaanOikein(5));
    }
    
    @Test
    public void siirtyvatkokoHelpotRivitRiviltaToiselleOikein(){
        assertTrue("Ylasivu ei käänny oikein etusivulta vasemmalle sivulle",this.siirtyvatkokoHelpotRivitRiviltaToiselleOikein( 0, 2, 1, 0));
        assertTrue("Ylasivu ei käänny oikein",this.siirtyvatkokoHelpotRivitRiviltaToiselleOikein(0, 3, 2, 0));
        
        assertTrue("ala -sivu ei käänny oikein",this.siirtyvatkokoHelpotRivitRiviltaToiselleOikein(4, 1, 2, 2));
        assertTrue("ala -sivu ei käänny oikein",this.siirtyvatkokoHelpotRivitRiviltaToiselleOikein(4, 2, 3, 2));
    }
    
    @Test
    public void helpotSarakkeetSiirtyvatOikein(){
        assertTrue("vasen -sivu ei käänny oikein",this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(1, 4, 5,  0));
        assertTrue("vasen -sivu ei käänny oikein",this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(1, 2, 4, 0));
        assertTrue("vasen -sivu ei käänny oikein",this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(1, 0, 2, 0));
        assertTrue("vasen -sivu ei käänny oikein",this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(1, 5, 0, 0));
        
        assertTrue("oikea -sivu ei käänny oikein",this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(3, 5, 4, 2));
        assertTrue("oikea -sivu ei käänny oikein",this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(3, 4, 2, 2));
        assertTrue("oikea -sivu ei käänny oikein",this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(3, 2, 0, 2));
        assertTrue("oikea -sivu ei käänny oikein",this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(3, 0, 5, 2));
    }
    
    
    private boolean siirtyvatkokoHelpotRivitRiviltaToiselleOikein(int kaannaSivu,int vanhaSivu,int uusiSivu,int rivi){
        boolean onkoTotta = true;
        String[] vanhaRivi =new String[3];
        for(int i = 0; i<3; i++){
            vanhaRivi[i]=this.rubik.palautaTaulukonTulkintaSivuiksi()[vanhaSivu][rivi][i];
        }
        
        this.rubik.kaannaMyotaTaiVastaPaivaan(1, kaannaSivu);
        
        String[] uusiRivi =new String[3];
        for(int a=0;a<3;a++){
            uusiRivi[a] = this.rubik.palautaTaulukonTulkintaSivuiksi()[uusiSivu][rivi][a];
        }
        for(int sarake =0; sarake<3; sarake++){
            String vanha =vanhaRivi[sarake];
            String uusi = uusiRivi[sarake];
            if(!vanha.equals(uusi)){
                onkoTotta = false;
            }
        }
        return onkoTotta;
    }
    
    private boolean siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(int kaannaSivu,int vanhaSivu,int uusiSivu,int sarake){
        boolean onkoTotta=true;
        String[] vanhaSarake =new String[3];
        for(int i = 0; i<3; i++){
            vanhaSarake[i]=this.rubik.palautaTaulukonTulkintaSivuiksi()[vanhaSivu][i][sarake];
        }
        this.rubik.kaannaMyotaTaiVastaPaivaan(1, kaannaSivu);
        
        String[] uusiSarake =new String[3];
        for(int a=0;a<3;a++){
            uusiSarake[a] = this.rubik.palautaTaulukonTulkintaSivuiksi()[uusiSivu][a][sarake];
        }
        for(int rivi =0; rivi<3; rivi++){
            String vanha =vanhaSarake[rivi];
            String uusi = uusiSarake[rivi];
            if(!vanha.equals(uusi)){
                onkoTotta = false;
            }
        }
        return onkoTotta;
    }

    private boolean kaantyykoSivuOmallaSivullaanOikein(int sivu){
        String[][] vanhaTaulukko = this.rubik.palautaTaulukonTulkintaSivuiksi()[sivu];
        String[][] kaannettyTaulukko = new String[3][3];
        for(int x = 0; x<3; x++){
            for(int y = 0; y<3;y++){
                kaannettyTaulukko[y][x]=vanhaTaulukko[2-x][y];
            }
        }
        this.rubik.kaannaMyotaTaiVastaPaivaan(1, sivu);
        
        boolean f = true;
        for(int i = 0; i <3; i++){
            for(int a = 0; a <3; a++){
            if(!kaannettyTaulukko[i][a].equals(this.rubik.palautaTaulukonTulkintaSivuiksi()[sivu][i][a])){
               f=false; 
            }
        }
        }
        return f;
    }
}
