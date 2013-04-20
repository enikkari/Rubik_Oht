package rubik_oht.kuutiot;

import java.awt.Color;
import rubik_oht.apuluokat.PalikkaJaAsento;
import rubik_oht.palikat.KulmaPalikka;
import rubik_oht.palikat.ReunaPalikka;

/**
 * RubikinKuutio on olio, joka sisältää tiedot Palikka -olentojen sijainneista
 * ja asennoista kuutiossa.
 *
 * Kuutiolla on kuusi sivua, joiden nimet ovat yla, vasen, etu, oikea, ala ja
 * taka.
 *
 * Taulukkojen avulla kuvataan kuution 'koordinaatteja', jotka pysyvät
 * paikallaan. Kuutiota väänneltäessä palikat vaihtavat paikkoja
 */
public class RubikinKuutio {

    private PalikkaJaAsento[] kulmaPalikoidenPaikat;
    private PalikkaJaAsento[] reunaPalikoidenPaikat;
    private String[][][] taulukonTulkintaKuutionSivuiksi;
    private String yla; //sivujen värit
    private String vasen;
    private String etu;
    private String oikea;
    private String ala;
    private String taka;

    /**
     * Tämä konstruktori luo kuution, jonka on väritetty hex-koodeilla
     */
    public RubikinKuutio() {

        this.kulmaPalikoidenPaikat = new PalikkaJaAsento[8];
        this.reunaPalikoidenPaikat = new PalikkaJaAsento[12];

        this.taulukonTulkintaKuutionSivuiksi = new String[6][3][3];

        this.yla = "#FF0000"; //punainen
        this.vasen = "#008000"; //vihreä
        this.etu = "#FFFF00"; //keltainen
        this.oikea = "#0000FF"; //sininen
        this.ala = "#FFA500"; //oranssi
        this.taka = "#FFFFFF"; //valkoinen
        this.taytaKuutio();
        this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }

    public RubikinKuutio(String yla, String vasen, String etu, String oikea, String ala, String taka) {
        this.kulmaPalikoidenPaikat = new PalikkaJaAsento[8];
        this.reunaPalikoidenPaikat = new PalikkaJaAsento[12];

        this.taulukonTulkintaKuutionSivuiksi = new String[6][3][3];

        this.yla = yla;
        this.vasen = vasen;
        this.etu = etu;
        this.oikea = oikea;
        this.ala = ala;
        this.taka = taka;
        this.taytaKuutio();
        this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }

    /**
     * Luo palikat oikean värisinä taulukkoon niin että kuutio on alussa
     * ratkaistuna
     */
    private void taytaKuutio() {
        this.luoKulmapalikatJaAsetaNePaikalleAsentoon(
                new String[][]{{taka, yla, vasen}, {taka, oikea, yla}, {etu, vasen, yla},
                    {etu, yla, oikea}, {taka, vasen, ala}, {etu, ala, vasen},
                    {etu, oikea, ala}, {taka, ala, oikea}});

        this.luoReunapalikatJaAsetaNePaikalleAsentoon(
                new String[][]{{taka, yla}, {yla, vasen}, {yla, oikea},
                    {etu, yla}, {taka, vasen}, {etu, vasen},
                    {etu, oikea}, {taka, oikea}, {ala, vasen},
                    {etu, ala}, {ala, oikea}, {taka, ala}});

        this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }

    /**
     * Metodille annetaan lista, jossa on kahdeksan kolmen string olennon
     * listaa, joiden perusteella luodaan kulmapalikat kuutioon siten että
     * ensimmäisellä paikalla olevat värit tulevat KulmpaPalikka K0:n sivujen
     * väreiksi annetussa järjestyksessä ja seuraavat K1:n jne.
     */
    private void luoKulmapalikatJaAsetaNePaikalleAsentoon(String[][] varit) {
        for (int palikka = 0; palikka < 8; palikka++) {
            this.kulmaPalikoidenPaikat[palikka] =
                    new PalikkaJaAsento(new KulmaPalikka("K" + palikka, varit[palikka][0], varit[palikka][1], varit[palikka][2]));
        }
    }

    /**
     * Metodille annetaan lista, jossa on 12 kahden string olennon listaa,
     * joiden perusteella luodaan reunapalikat kuutioon siten että ensimmäisellä
     * paikalla olevat värit tulevat ReunaPalikka K0:n sivujen väreiksi
     * annetussa järjestyksessä ja seuraavat K1:n jne.
     */
    private void luoReunapalikatJaAsetaNePaikalleAsentoon(String[][] varit) {
        for (int palikka = 0; palikka < varit.length; palikka++) {
            this.reunaPalikoidenPaikat[palikka] =
                    new PalikkaJaAsento(new ReunaPalikka("R" + palikka, varit[palikka][0], varit[palikka][1]));
        }
    }

    /**
     * palikoiden päivittäminen paikoilleen perustuu kuution koordinaatteihin
     * Lisään työhön havainnolistavan kaavion kuution koordinaateista.
     * taulukonTulkintaKuutionSivuiksi pitää päivittää aina siirtoja tehdessä:
     * muuten ne eivät näy tulostuksessa.
     */
    private void paivitaTaulukonTulkintaKuutionSivuiksi() {
        this.paivitaSivu(0, new int[][]{{0, 2}, {0, 2}, {1, 3}, {1, 1}, {2, 1}, {2, 3}, {3, 2}, {3, 2}});
        this.paivitaSivu(1, new int[][]{{0, 3}, {1, 2}, {2, 2}, {4, 2}, {5, 2}, {4, 2}, {8, 2}, {5, 3}});
        this.paivitaSivu(2, new int[][]{{2, 1}, {3, 1}, {3, 1}, {5, 1}, {6, 1}, {5, 1}, {9, 1}, {6, 1}});
        this.paivitaSivu(3, new int[][]{{3, 3}, {2, 2}, {1, 2}, {6, 2}, {7, 2}, {6, 2}, {10, 2}, {7, 3}});
        this.paivitaSivu(4, new int[][]{{5, 2}, {9, 2}, {6, 3}, {8, 1}, {10, 1}, {4, 3}, {11, 2}, {7, 2}});
        this.paivitaSivu(5, new int[][]{{4, 1}, {11, 1}, {7, 1}, {4, 1}, {7, 1}, {0, 1}, {0, 1}, {1, 1}});
    }

    /**
     * Metodille annetaan 7 alkion pituinen taulukko 2 int olennon taulukkoja
     * Taulukon seitsemän alkiota kuvaavat kuution tietyllä sivulla olevia
     * Palikoiden sivuja. Keskipalikan 'vari' tiedetään jo, joten sivuja on 7.
     * Taulukon sisällä olevien taulukkojen 0. indeksi on Palikan indeksi ja 1.
     * indeksi haluttu Palikan sivun numero.
     *
     * Metodi päivittää annettussa järjestyksessä halutulle sivulle halutun
     * Palikan halutun 'varin'
     */
    private void paivitaSivu(int mikaSivu, int[][] paikkaJaVari) {
        int indeksi = 0;
        for (int rivi = 0; rivi < 3; rivi++) {
            for (int sarake = 0; sarake < 3; sarake++) {
                if (rivi + sarake == 1 || rivi + sarake == 3) {
                    this.taulukonTulkintaKuutionSivuiksi[mikaSivu][rivi][sarake] =
                            this.reunaPalikoidenPaikat[paikkaJaVari[indeksi][0]].haeMikaVariPaikallaOn(paikkaJaVari[indeksi][1]);
                    indeksi = indeksi + 1;
                } else if (!(rivi == 1 && sarake == 1)) {
                    this.taulukonTulkintaKuutionSivuiksi[mikaSivu][rivi][sarake] =
                            this.kulmaPalikoidenPaikat[paikkaJaVari[indeksi][0]].haeMikaVariPaikallaOn(paikkaJaVari[indeksi][1]);
                    indeksi = indeksi + 1;
                }
            }
        }
        this.taulukonTulkintaKuutionSivuiksi[mikaSivu][1][1] = this.mikaVariSivullaOn(mikaSivu);
    }

    /**
     * Metodi kääntää haluttua sivua haluttuun suuntaan
     *
     * @param myotaVaiVasta arvo 1 kääntää sivua myötäpäivään ja arvo 0
     * vastapäivään
     * @param mikaSivu mitä sivua halutaan kääntää (Vastapäivään kääntäminen on
     * sama, kuin kääntäisi sivua kolme kertaa myötäpäivään)
     */
    public void kaannaMyotaTaiVastaPaivaan(int myotaVaiVasta, int mikaSivu) {
        if (myotaVaiVasta == 1) {
            this.kaannaSivu(mikaSivu);
        } else if (myotaVaiVasta == 0) {
            for (int i = 0; i < 3; i++) {
                this.kaannaSivu(mikaSivu);
            }
        }
    }

    /**
     * Metodi kääntää haluttua sivua myötäpäivään
     */
    private void kaannaSivu(int mikaSivu) {
        if (mikaSivu == 0) {
            this.kaannaYla();
        } else if (mikaSivu == 1) {
            this.kaannaVasen();
        } else if (mikaSivu == 2) {
            this.kaannaEtu();
        } else if (mikaSivu == 3) {
            this.kaannaOikea();
        } else if (mikaSivu == 4) {
            this.kaannaAla();
        } else if (mikaSivu == 5) {
            this.kaannaTaka();
        } else {
        }
        this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }

    private void kaannaEtu() {
        this.vaihdaKulmaJaReunaPaikat(new int[]{2, 3, 6, 5}, new int[]{3, 6, 9, 5});
    }

    private void kaannaTaka() {
        this.vaihdaKulmaJaReunaPaikat(new int[]{4, 7, 1, 0}, new int[]{11, 7, 0, 4});
    }

    private void kaannaYla() {
        this.vaihdaKulmaJaReunaPaikat(new int[]{0, 1, 3, 2}, new int[]{0, 2, 3, 1});

        this.kaannaKulmapalikatMyotaPaivaan(new int[]{1, 2});
        this.kaannaKulmapalikatVastaPaivaan(new int[]{0, 3});

        this.kaannaReunapalikat(new int[]{0, 2, 3, 1});
    }

    private void kaannaVasen() {
        this.vaihdaKulmaJaReunaPaikat(new int[]{0, 2, 5, 4}, new int[]{1, 5, 8, 4});

        this.kaannaKulmapalikatMyotaPaivaan(new int[]{0, 5});
        this.kaannaKulmapalikatVastaPaivaan(new int[]{2, 4});

        //reunapalikoiden asennot pysyvät tässä siirrossa samoina
    }

    private void kaannaOikea() {
        this.vaihdaKulmaJaReunaPaikat(new int[]{3, 1, 7, 6}, new int[]{2, 7, 10, 6});

        this.kaannaKulmapalikatMyotaPaivaan(new int[]{3, 7});
        this.kaannaKulmapalikatVastaPaivaan(new int[]{1, 6});

        //reunapalikoiden asennot pysyvät tässä siirrossa samoina
    }

    private void kaannaAla() {
        this.vaihdaKulmaJaReunaPaikat(new int[]{5, 6, 7, 4}, new int[]{9, 10, 11, 8});

        this.kaannaKulmapalikatMyotaPaivaan(new int[]{6, 4});
        this.kaannaKulmapalikatVastaPaivaan(new int[]{5, 7});
        this.kaannaReunapalikat(new int[]{9, 10, 11, 8});
    }

    private void vaihdaKulmaJaReunaPaikat(int[] kulmapalikat, int[] reunapalikat) {
        this.vaihdaKulmapalikkojenPaikat(kulmapalikat[0], kulmapalikat[1], kulmapalikat[2], kulmapalikat[3]);
        this.vaihdaReunapalikoidenPaikat(reunapalikat[0], reunapalikat[1], reunapalikat[2], reunapalikat[3]);
    }

    /**
     * Vaihtaa haluttujen KulmaPalikoiden indeksien perusteella Palikoiden pikat
     * siten että edellinen Palikka hyppää aina seuraavan paikalle.
     */
    private void vaihdaKulmapalikkojenPaikat(int palikanNumero1, int palikanNumero2, int palikanNumero3, int palikanNumero4) {
        PalikkaJaAsento vanhaKulma1 = this.kulmaPalikoidenPaikat[palikanNumero1];
        PalikkaJaAsento vanhaKulma2 = this.kulmaPalikoidenPaikat[palikanNumero2];
        PalikkaJaAsento vanhaKulma3 = this.kulmaPalikoidenPaikat[palikanNumero3];
        PalikkaJaAsento vanhaKulma4 = this.kulmaPalikoidenPaikat[palikanNumero4];

        this.kulmaPalikoidenPaikat[palikanNumero1] = vanhaKulma4;
        this.kulmaPalikoidenPaikat[palikanNumero2] = vanhaKulma1;
        this.kulmaPalikoidenPaikat[palikanNumero3] = vanhaKulma2;
        this.kulmaPalikoidenPaikat[palikanNumero4] = vanhaKulma3;
    }

    /**
     * Vaihtaa haluttujen ReunaPalikoiden indeksien perusteella Palikoiden pikat
     * siten että edellinen Palikka hyppää aina seuraavan paikalle.
     */
    private void vaihdaReunapalikoidenPaikat(int palikanNumero1, int palikanNumero2, int palikanNumero3, int palikanNumero4) {
        PalikkaJaAsento vanhaReuna1 = this.reunaPalikoidenPaikat[palikanNumero1];
        PalikkaJaAsento vanhaReuna2 = this.reunaPalikoidenPaikat[palikanNumero2];
        PalikkaJaAsento vanhaReuna3 = this.reunaPalikoidenPaikat[palikanNumero3];
        PalikkaJaAsento vanhaReuna4 = this.reunaPalikoidenPaikat[palikanNumero4];

        this.reunaPalikoidenPaikat[palikanNumero1] = vanhaReuna4;
        this.reunaPalikoidenPaikat[palikanNumero2] = vanhaReuna1;
        this.reunaPalikoidenPaikat[palikanNumero3] = vanhaReuna2;
        this.reunaPalikoidenPaikat[palikanNumero4] = vanhaReuna3;

    }

    /**
     * Kääntää haluttujen KulmpaPalikoiden asentoa niin että jokainen väri hyppää seuraavan paikalle
     */
    private void kaannaKulmapalikatMyotaPaivaan(int[] palikat) {
        for (int i = 0; i < palikat.length; i++) {
            this.kulmaPalikoidenPaikat[palikat[i]].muutaAsento(new int[]{3, 1, 2});
        }

    }
    /**
     * Kääntää haluttujen KulmpaPalikoiden asentoa niin että jokainen väri hyppää edellisen paikalle
     */

    private void kaannaKulmapalikatVastaPaivaan(int[] palikat) {
        for (int i = 0; i < palikat.length; i++) {
            this.kulmaPalikoidenPaikat[palikat[i]].muutaAsento(new int[]{2, 3, 1});
        }
    }

    /**
     * Vaihtaa halutut ReunaPalikat niiden toiseen mahdolliseen asentoon
     */
    private void kaannaReunapalikat(int[] palikat) {
        for (int i = 0; i < palikat.length; i++) {
            this.reunaPalikoidenPaikat[palikat[i]].muutaAsento(new int[]{2, 1});
        }

    }

    /**
     * Palauttaa RubikinKuution halutun sivun alkuperäisen värin
     */
    public String mikaVariSivullaOn(int mikaSivu) {
        if (mikaSivu > -1 && mikaSivu < 6) {
            String[] sivujenVarit = new String[]{yla, vasen, etu, oikea, ala, taka};
            return sivujenVarit[mikaSivu];
        } else {
            return null;
        }

    }

    private String tulostaSivu(int mikaSivu) {
        StringBuilder sivuRakentaja = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sivuRakentaja.append("   ");
            for (int a = 0; a < 3; a++) {
                sivuRakentaja.append(this.taulukonTulkintaKuutionSivuiksi[mikaSivu][i][a]);
            }
            sivuRakentaja.append('\n');
        }
        return sivuRakentaja.toString();
    }

    /**
     * Palauttaa merkkijonona mikä 'väri' taulukonTulkintaSivuiksi-taulukossa on
     * eli minkä värinen sivu tietyllä kuution paikalla on
     *
     * @param mikaSivu Halutun kuution sivun indeksi
     * @param rivilla halutun rivin indeksi sivulla
     * @param sarakkeella halutun sarakkeen indeksi sivulla
     */
    public String mikaMerkkijonoOnPaikalla(int mikaSivu, int rivilla, int sarakkeella) {
        return this.taulukonTulkintaKuutionSivuiksi[mikaSivu][rivilla][sarakkeella];
    }

    /**
     * Palauttaa Color -oliona mikä 'väri' taulukonTulkintaSivuiksi-taulukossa
     * on eli minkä värinen sivu tietyllä kuution paikalla on
     *
     * @param mikaSivu Halutun kuution sivun indeksi
     * @param rivilla halutun rivin indeksi sivulla
     * @param sarakkeella halutun sarakkeen indeksi sivulla
     */
    public Color mikaVariOnPaikalla(int mikaSivu, int rivilla, int sarakkeella) {
        return Color.decode(this.mikaMerkkijonoOnPaikalla(mikaSivu, rivilla, sarakkeella));
    }

    public String palautaStringKuutio() {
        StringBuilder kuutionRakentaja = new StringBuilder();
        kuutionRakentaja.append(tulostaSivu(0));
        for (int i = 0; i < 3; i++) {
            for (int mikaSivu = 1; mikaSivu <= 3; mikaSivu++) {
                for (int a = 0; a < 3; a++) {
                    kuutionRakentaja.append(this.taulukonTulkintaKuutionSivuiksi[mikaSivu][i][a]);
                }
            }
            kuutionRakentaja.append('\n');
        }
        kuutionRakentaja.append(tulostaSivu(4));
        kuutionRakentaja.append(tulostaSivu(5));

        return kuutionRakentaja.toString();
    }

    public String[][][] palautaTaulukonTulkintaSivuiksi() {
        return this.taulukonTulkintaKuutionSivuiksi;
    }
}
