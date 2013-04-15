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
        for (int i = 0; i < 10; i++) {
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
        assertTrue("Ylasivu ei käänny oikein omalla sivullaan",
                this.kaantyykoSivuOmallaSivullaanOikein(0));
        assertTrue("Vasensivu ei käänny oikein omalla sivullaan",
                this.kaantyykoSivuOmallaSivullaanOikein(1));
        assertTrue("Etusivu ei käänny oikein omalla sivullaan",
                this.kaantyykoSivuOmallaSivullaanOikein(2));
        assertTrue("Vasensivu ei käänny oikein omalla sivullaan",
                this.kaantyykoSivuOmallaSivullaanOikein(3));
        assertTrue("Alaivu ei käänny oikein omalla sivullaan",
                this.kaantyykoSivuOmallaSivullaanOikein(4));
        assertTrue("Takaivu ei käänny oikein omalla sivullaan",
                this.kaantyykoSivuOmallaSivullaanOikein(5));
    }

    @Test
    public void siirtyvatkokoHelpotRivitRiviltaToiselleOikein() {
        assertTrue("Ylasivu ei käänny oikein etusivulta vasemmalle sivulle",
                this.siirtyvatkokoHelpotRivitRiviltaToiselleOikein(0, 2, 1, 0));
        assertTrue("Ylasivu ei käänny oikein",
                this.siirtyvatkokoHelpotRivitRiviltaToiselleOikein(0, 3, 2, 0));

        assertTrue("ala -sivu ei käänny oikein",
                this.siirtyvatkokoHelpotRivitRiviltaToiselleOikein(4, 1, 2, 2));
        assertTrue("ala -sivu ei käänny oikein",
                this.siirtyvatkokoHelpotRivitRiviltaToiselleOikein(4, 2, 3, 2));
    }

    @Test
    public void helpotSarakkeetSiirtyvatOikein() {
        assertTrue("vasen -sivu ei käänny oikein",
                this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(1, 4, 5, 0));
        assertTrue("vasen -sivu ei käänny oikein",
                this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(1, 2, 4, 0));
        assertTrue("vasen -sivu ei käänny oikein",
                this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(1, 0, 2, 0));
        assertTrue("vasen -sivu ei käänny oikein",
                this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(1, 5, 0, 0));

        assertTrue("oikea -sivu ei käänny oikein",
                this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(3, 5, 4, 2));
        assertTrue("oikea -sivu ei käänny oikein",
                this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(3, 4, 2, 2));
        assertTrue("oikea -sivu ei käänny oikein",
                this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(3, 2, 0, 2));
        assertTrue("oikea -sivu ei käänny oikein",
                this.siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(3, 0, 5, 2));
    }

    @Test
    public void etuSivunReunaRivitKaantyvätOikein() {
        String[] vanhaYlaRivi = new String[3];
        String[] vanhaAlaRivi = new String[3];
        for (int i = 0; i < 3; i++) {
            vanhaYlaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[0][2][i];
            vanhaAlaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[4][0][i];
        }

        this.rubik.kaannaMyotaTaiVastaPaivaan(1, 2);

        String[] uusiVasenSarake = new String[3];
        String[] uusiOikeaSarake = new String[3];

        for (int rivi = 0; rivi < 3; rivi++) {
            uusiVasenSarake[rivi] = this.rubik.palautaTaulukonTulkintaSivuiksi()[1][rivi][2];
            uusiOikeaSarake[rivi] = this.rubik.palautaTaulukonTulkintaSivuiksi()[3][rivi][0];
        }
        assertTrue("etu -sivun reunat eivät käänny oikein",
                this.ovatkoRivitSamat(vanhaYlaRivi, uusiOikeaSarake));
        assertTrue("etu -sivun reunat eivät käänny oikein",
                this.ovatkoRivitSamat(vanhaAlaRivi, uusiVasenSarake));

    }

    @Test
    public void etuSivunReunaSarakkeetKaantyvätOikein() {
        String[] vanhaVasenSarake = new String[3];
        String[] vanhaOikeaSarake = new String[3];

        for (int rivi = 0; rivi < 3; rivi++) {
            vanhaVasenSarake[rivi] = this.rubik.palautaTaulukonTulkintaSivuiksi()[1][rivi][2];
            vanhaOikeaSarake[rivi] = this.rubik.palautaTaulukonTulkintaSivuiksi()[3][rivi][0];
        }

        this.rubik.kaannaMyotaTaiVastaPaivaan(1, 2);

        String[] uusiYlaRivi = new String[3];
        String[] uusiAlaRivi = new String[3];

        for (int i = 0; i < 3; i++) {
            uusiYlaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[0][2][i];
            uusiAlaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[4][0][i];
        }

        assertTrue("etu -sivun reunat eivät käänny oikein",
                this.ovatkoRivitSamatKaanteisesti(vanhaVasenSarake, uusiYlaRivi));
        assertTrue("etu -sivun reunat eivät käänny oikein",
                this.ovatkoRivitSamatKaanteisesti(vanhaOikeaSarake, uusiAlaRivi));

    }

    @Test
    public void takaSivunReunaRivitKaantyvätOikein() {
        String[] vanhaYlaRivi = new String[3];
        String[] vanhaAlaRivi = new String[3];
        for (int i = 0; i < 3; i++) {
            vanhaYlaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[0][0][i];
            vanhaAlaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[4][2][i];
        }

        this.rubik.kaannaMyotaTaiVastaPaivaan(1, 5);

        String[] uusiVasenSarake = new String[3];
        String[] uusiOikeaSarake = new String[3];

        for (int rivi = 0; rivi < 3; rivi++) {
            uusiVasenSarake[rivi] = this.rubik.palautaTaulukonTulkintaSivuiksi()[1][rivi][0];
            uusiOikeaSarake[rivi] = this.rubik.palautaTaulukonTulkintaSivuiksi()[3][rivi][2];
        }
        assertTrue("taka -sivun reunat eivät käänny oikein",
                this.ovatkoRivitSamatKaanteisesti(vanhaYlaRivi, uusiVasenSarake));
        assertTrue("taka -sivun reunat eivät käänny oikein",
                this.ovatkoRivitSamatKaanteisesti(vanhaAlaRivi, uusiOikeaSarake));

    }

    @Test
    public void takaSivunReunaSarakkeetKaantyvätOikein() {
        String[] vanhaVasenSarake = new String[3];
        String[] vanhaOikeaSarake = new String[3];

        for (int rivi = 0; rivi < 3; rivi++) {
            vanhaVasenSarake[rivi] = this.rubik.palautaTaulukonTulkintaSivuiksi()[1][rivi][0];
            vanhaOikeaSarake[rivi] = this.rubik.palautaTaulukonTulkintaSivuiksi()[3][rivi][2];
        }

        this.rubik.kaannaMyotaTaiVastaPaivaan(1, 5);

        String[] uusiYlaRivi = new String[3];
        String[] uusiAlaRivi = new String[3];

        for (int i = 0; i < 3; i++) {
            uusiYlaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[0][0][i];
            uusiAlaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[4][2][i];
        }

        assertTrue("taka -sivun reunat eivät käänny oikein",
                this.ovatkoRivitSamat(uusiAlaRivi, vanhaVasenSarake));
        assertTrue("taka -sivun reunat eivät käänny oikein",
                this.ovatkoRivitSamat(vanhaOikeaSarake, uusiYlaRivi));

    }

    @Test
    public void ylaSivuKaantyyOikeinVasemmaltaTakaSivulle() {
        String[] vanhatakaRivi = new String[3];
        String[] vanhaVasenRivi = new String[3];
        for (int i = 0; i < 3; i++) {
            vanhatakaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[5][2][i];
            vanhaVasenRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[1][0][i];
        }
        this.rubik.kaannaMyotaTaiVastaPaivaan(1, 0);

        String[] uusiTakaRivi = new String[3];
        String[] uusiOikeaRivi = new String[3];
        for (int i = 0; i < 3; i++) {
            uusiTakaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[5][2][i];
            uusiOikeaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[3][0][i];
        }
        assertTrue("yla -sivun reunat eivät käänny oikein",
                this.ovatkoRivitSamatKaanteisesti(vanhaVasenRivi, uusiTakaRivi));
        assertTrue("yla -sivun reunat eivät käänny oikein",
                this.ovatkoRivitSamatKaanteisesti(vanhatakaRivi, uusiOikeaRivi));
    }
    
    

    @Test
    public void alaSivuKaantyyOikeinTakaaVasemmalle() {
        String[] vanhaOikeaRivi = new String[3];
        String[] vanhaTakaRivi = new String[3];
        for (int i = 0; i < 3; i++) {
            vanhaOikeaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[3][2][i];
            vanhaTakaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[5][0][i];
        }
        this.rubik.kaannaMyotaTaiVastaPaivaan(1, 4);

        String[] uusiTakaRivi = new String[3];
        String[] uusiVasenRivi = new String[3];
        for (int i = 0; i < 3; i++) {
            uusiTakaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[5][0][i];
            uusiVasenRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[1][2][i];
        }
        assertTrue("ala -sivun reunat eivät käänny oikein",
                this.ovatkoRivitSamatKaanteisesti(vanhaTakaRivi, uusiVasenRivi));
        assertTrue("ala -sivun reunat eivät käänny oikein",
                this.ovatkoRivitSamatKaanteisesti(vanhaOikeaRivi, uusiTakaRivi));
    }

    private boolean siirtyvatkokoHelpotRivitRiviltaToiselleOikein(int kaannaSivu, int vanhaSivu, int uusiSivu, int rivi) {
        boolean onkoTotta = true;
        String[] vanhaRivi = new String[3];
        for (int i = 0; i < 3; i++) {
            vanhaRivi[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[vanhaSivu][rivi][i];
        }

        this.rubik.kaannaMyotaTaiVastaPaivaan(1, kaannaSivu);

        String[] uusiRivi = new String[3];
        for (int a = 0; a < 3; a++) {
            uusiRivi[a] = this.rubik.palautaTaulukonTulkintaSivuiksi()[uusiSivu][rivi][a];
        }
        for (int sarake = 0; sarake < 3; sarake++) {
            String vanha = vanhaRivi[sarake];
            String uusi = uusiRivi[sarake];
            if (!vanha.equals(uusi)) {
                onkoTotta = false;
            }
        }
        return onkoTotta;
    }

    private boolean siirtyvatkokoSarakkeetSarakkeeltaToiselleOikein(int kaannaSivu, int vanhaSivu, int uusiSivu, int sarake) {
        boolean onkoTotta = true;
        String[] vanhaSarake = new String[3];
        for (int i = 0; i < 3; i++) {
            vanhaSarake[i] = this.rubik.palautaTaulukonTulkintaSivuiksi()[vanhaSivu][i][sarake];
        }
        this.rubik.kaannaMyotaTaiVastaPaivaan(1, kaannaSivu);

        String[] uusiSarake = new String[3];
        for (int a = 0; a < 3; a++) {
            uusiSarake[a] = this.rubik.palautaTaulukonTulkintaSivuiksi()[uusiSivu][a][sarake];
        }
        return this.ovatkoRivitSamat(vanhaSarake, uusiSarake);
    }

    private boolean kaantyykoSivuOmallaSivullaanOikein(int sivu) {
        String[][] vanhaTaulukko = this.rubik.palautaTaulukonTulkintaSivuiksi()[sivu];
        String[][] kaannettyTaulukko = new String[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                kaannettyTaulukko[y][x] = vanhaTaulukko[2 - x][y];
            }
        }
        this.rubik.kaannaMyotaTaiVastaPaivaan(1, sivu);

        boolean f = true;
        for (int i = 0; i < 3; i++) {
            for (int a = 0; a < 3; a++) {
                if (!kaannettyTaulukko[i][a].equals(this.rubik.palautaTaulukonTulkintaSivuiksi()[sivu][i][a])) {
                    f = false;
                }
            }
        }
        return f;
    }

    private boolean ovatkoRivitSamat(String[] rivi1, String[] rivi2) {
        boolean f = true;
        for (int i = 0; i < 3; i++) {
            if (!rivi1[i].equals(rivi2[i])) {
                f = false;
            }
        }
        return f;
    }

    private boolean ovatkoRivitSamatKaanteisesti(String[] rivi1, String[] rivi2) {
        String[] uusiRivi1 = new String[rivi1.length];
        for (int i = 0; i < rivi1.length; i++) {
            uusiRivi1[i] = rivi1[rivi1.length - i - 1];
        }
        return this.ovatkoRivitSamat(uusiRivi1, rivi2);
    }
}
