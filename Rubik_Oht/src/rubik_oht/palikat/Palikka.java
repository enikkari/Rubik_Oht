package rubik_oht.palikat;

/**
 * Palikka-luokka kuvaa palikkaa, joista Rubikin kuutio muodostuu. Tavallisessa
 * Rubikin kuutiossa on reuna- ja kulmapalikoita
 *
 * "Keskipalikoita" ei ole tavallisessa rubikin kuutiossa (3x3-kuutiossa), sillä
 * keskellä olevat palikat pysyvät koko ajan toisiinsa nähden paikoillaan.
 */
public class Palikka {

    private String Nimi;
    private String[] vari;//Tähän taulukko sisältää palikan sivujen värit oikeassa järjestyksessä.
    //"värit" ovat merkkijonoja 

    public Palikka(String Nimi, int KuinkaMontaSivuaPalikassaOn) {
        this.Nimi = Nimi;
        this.vari = new String[KuinkaMontaSivuaPalikassaOn];
    }
    /**
     * muuttaa palikan varien indeksöintiä niin että kaikki palikat liikkuvat 
     * yhden indeksin eteenpäin ja viimeinen palikka hyppää ensimmäisen paikalle
     */

    public void kaannaMyotapaivaan() {
        String[] vanhaVari = this.vari;
        for (int i = 0; i < vari.length - 1; i++) {
            this.vari[i] = vanhaVari[i + 1];
        }
        this.vari[0] = vanhaVari[vari.length - 1];
    }
    /**
     * muuttaa palikan värien indeksöintiä niin että kaikki palikat liikkuvat 
     * yhden indeksin taaksepäin ja ensimmäinen palikka hyppää viimeisen paikalle
     */

    public void kaannaVastapaivaan() {
        String[] vanhaVari = this.vari;
        for (int i = 1; i < vari.length; i++) {
            this.vari[i] = vanhaVari[i - 1];
        }
        this.vari[vari.length - 1] = vanhaVari[0];
    }

    public String[] haeVarit() {
        return this.vari;
    }

    /**
     * Metodilla voidaan asettaa palikan tietylle sivulle tietty väri Sivujen
     * indeksöinti alkaa ykkösestä
     */
    public void asetavari(int monesVari, String Vari) {
        if (1 <= monesVari && monesVari <= vari.length) {
            this.vari[monesVari - 1] = Vari;              //Taulukon indeksöinti alkaa 0:sta, joten
        }                                               //n:ännes sivu on taulukossa
    }                                               //paikalla n-1

    /**
     * Palauttaa halutun sivun värin Sivujen indeksöinti alkaa ykkösestä
     */
    public String haeVari(int monesVari) {
        if (1 <= monesVari && monesVari <= vari.length) {
            return this.vari[monesVari - 1];
        } else {
            return null;
        }
    }

    public String haeNimi() {
        return this.Nimi;
    }

    /**
     * Metodilla voidaan selvittää millainen palikka on kyseessä eli kuinka
     * monta sivua sillä on
     */
    public int kuinkaMontaSivua() {
        return vari.length;
    }

    /**
     * Palauttaa Palikan sivut merkkijonona
     */
    @Override
    public String toString() {
        String palikanSivut = "";
        for (int i = 0; i < this.vari.length; i++) {
            palikanSivut = palikanSivut + vari[i];
        }
        return palikanSivut;
    }
}
