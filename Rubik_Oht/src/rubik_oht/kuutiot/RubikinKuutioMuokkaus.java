package rubik_oht.kuutiot;

import java.awt.Color;
import java.io.IOException;
import rubik_oht.apuluokat.PalikkaJaAsento;
import rubik_oht.apuluokat.PalikkaJaSivu;
import rubik_oht.palikat.KeskiPalikka;
import rubik_oht.palikat.ReunaPalikka;
import rubik_oht.palikat.KulmaPalikka;
import rubik_oht.palikat.Palikka;

/**
 * Kokeillaan vaihtoehtoista
 *
 * Kuutiolla on kuusi sivua, joiden nimet ovat yla, vasen, etu, oikea, ala ja
 * taka
 *
 * Taulukkojen avulla kuvataan kuution 'koordinaatteja', jotka pysyvät
 * paikallaan. Kuutiota väänneltäessä palikat vaihtavat paikkoja
 */
/**
 *
 * @author eevanikkari
 */
public class RubikinKuutioMuokkaus {

    private KulmaPalikka[] kulmaPalikoidenPaikat;
    private ReunaPalikka[] reunaPalikoidenPaikat;
    private KeskiPalikka[] keskiPalikoidenPaikat;
    private PalikkaJaSivu[][][] taulukonTulkintaKuutionSivuiksi;
    private String yla; //sivujen värit
    private String vasen;
    private String etu;
    private String oikea;
    private String ala;
    private String taka;

    public RubikinKuutioMuokkaus() {

        this.kulmaPalikoidenPaikat = new KulmaPalikka[8];
        this.reunaPalikoidenPaikat = new ReunaPalikka[12];
        this.keskiPalikoidenPaikat = new KeskiPalikka[6];

        this.taulukonTulkintaKuutionSivuiksi = new PalikkaJaSivu[6][3][3];

        this.yla = "#FF0000"; //punainen
        this.vasen = "#008000"; //vihreä
        this.etu = "#FFFF00"; //keltainen
        this.oikea = "#0000FF"; //sininen
        this.ala = "#FFA500"; //oranssi
        this.taka = "#FFFFFF"; //valkoinen
        this.taytaKuutio();
        this.paivitaTaulukonTulkintaKuutionSivuiksi();
        this.varitaSivut();
    }

    public RubikinKuutioMuokkaus(String yla, String vasen, String etu, String oikea, String ala, String taka) {
        this.kulmaPalikoidenPaikat = new KulmaPalikka[8];
        this.reunaPalikoidenPaikat = new ReunaPalikka[12];
        this.keskiPalikoidenPaikat = new KeskiPalikka[6];

        this.taulukonTulkintaKuutionSivuiksi = new PalikkaJaSivu[6][3][3];

        this.yla = yla;
        this.vasen = vasen;
        this.etu = etu;
        this.oikea = oikea;
        this.ala = ala;
        this.taka = taka;
        this.taytaKuutio();
        this.paivitaTaulukonTulkintaKuutionSivuiksi();
        this.varitaSivut();
    }

    /**
     * Täyttää kuution tyhjillä palikoilla
     */
    private void taytaKuutio() {

        for (int r = 0; r < reunaPalikoidenPaikat.length; r++) {
            this.reunaPalikoidenPaikat[r] = new ReunaPalikka("R" + r);
        }
        for (int k = 0; k < kulmaPalikoidenPaikat.length; k++) {
            this.kulmaPalikoidenPaikat[k] = new KulmaPalikka("K" + k);
        }
        for (int e = 0; e < keskiPalikoidenPaikat.length; e++) {
            this.keskiPalikoidenPaikat[e] = new KeskiPalikka("E" + e);
        }
        this.paivitaTaulukonTulkintaKuutionSivuiksi();

    }

    /**
     * Palauttaa RubikinKuution halutun sivun alkuperäisen värin
     */
    public String mikaVariSivullaOn(int mikaSivu) {
        String[] sivujenVarit = new String[]{yla, vasen, etu, oikea, ala, taka};
        return sivujenVarit[mikaSivu];

    }

    public PalikkaJaSivu luoPalikkaJaSivu(char taulukko, int paikalla, int sivu) {
        Palikka palikka = null;
        if (taulukko == 'k') {
            palikka = this.kulmaPalikoidenPaikat[paikalla];
        } else if (taulukko == 'r') {
            palikka = this.reunaPalikoidenPaikat[paikalla];
        } else if (taulukko == 'e') {
            palikka = this.keskiPalikoidenPaikat[paikalla];
        }
        PalikkaJaSivu uusi = new PalikkaJaSivu(palikka, sivu);
        return uusi;
    }

    private void taytaSivu(int mikaSivu, int[][] palikanIndeksitJaSivut) {
        PalikkaJaSivu p00 = luoPalikkaJaSivu('k', palikanIndeksitJaSivut[0][0], palikanIndeksitJaSivut[0][1]);
        PalikkaJaSivu p01 = luoPalikkaJaSivu('r', palikanIndeksitJaSivut[1][0], palikanIndeksitJaSivut[1][1]);
        PalikkaJaSivu p02 = luoPalikkaJaSivu('k', palikanIndeksitJaSivut[2][0], palikanIndeksitJaSivut[2][1]);
        PalikkaJaSivu p10 = luoPalikkaJaSivu('r', palikanIndeksitJaSivut[3][0], palikanIndeksitJaSivut[3][1]);
        PalikkaJaSivu p11 = luoPalikkaJaSivu('e', palikanIndeksitJaSivut[4][0], palikanIndeksitJaSivut[4][1]);
        PalikkaJaSivu p12 = luoPalikkaJaSivu('r', palikanIndeksitJaSivut[5][0], palikanIndeksitJaSivut[5][1]);
        PalikkaJaSivu p20 = luoPalikkaJaSivu('k', palikanIndeksitJaSivut[6][0], palikanIndeksitJaSivut[6][1]);
        PalikkaJaSivu p21 = luoPalikkaJaSivu('r', palikanIndeksitJaSivut[7][0], palikanIndeksitJaSivut[7][1]);
        PalikkaJaSivu p22 = luoPalikkaJaSivu('k', palikanIndeksitJaSivut[8][0], palikanIndeksitJaSivut[8][1]);
      
        this.taulukonTulkintaKuutionSivuiksi[mikaSivu] = new PalikkaJaSivu[][]{{p00,p01,p02},{p10,p11,p12},{p20,p21,p22}};
    }

    /**
     * palikoiden päivittäminen paikoilleen perustuu kuution koordinaatteihin
     * Lisään työhön havainnolistavan kaavion kuution koordinaateista Esim.
     * Yla-sivu on taulukonTulkintaKuutionSivuiksi paikalla 0 siksi ensimmäinen
     * koordinaatti on [0] seuraavat koordinaatit ovat sivun tulkinta
     * tavallisessa koordinaatistossa, johon etsitään tiedot taulukoista
     */
    private void paivitaTaulukonTulkintaKuutionSivuiksi() {
        int[][] ylaSivu =   new int[][]{{0, 2}, {0, 2}, {1, 3}, {1, 1}, {0, 1}, {2, 1}, {2, 3}, {3, 2}, {3, 2}};
        int[][] vasenSivu = new int[][]{{0, 3}, {1, 2}, {2, 2}, {4, 2}, {1, 1}, {5, 2}, {4, 2}, {8, 2}, {5, 3}};
        int[][] etuSivu =   new int[][]{{2, 1}, {3, 1}, {3, 1}, {5, 1}, {2, 1}, {6, 1}, {5, 1}, {9, 1}, {6, 1}};
        int[][] oikeaSivu = new int[][]{{3, 3}, {2, 2}, {1, 2}, {6, 2}, {3, 1}, {7, 2}, {6, 2}, {10, 2}, {7, 3}};
        int[][] alaSivu =   new int[][]{{5, 2}, {9, 2}, {6, 3}, {8, 1}, {4, 1}, {1, 1}, {4, 3}, {11, 2}, {7, 2}};
        int[][] takaSivu =  new int[][]{{4, 1}, {11, 1}, {7, 1}, {4, 1}, {5, 1}, {7, 1}, {0, 1}, {0, 1}, {1, 1}};
        taytaSivu(0, ylaSivu);
        taytaSivu(1, vasenSivu);
        taytaSivu(2, etuSivu);
        taytaSivu(3, oikeaSivu);
        taytaSivu(4, alaSivu);
        taytaSivu(5, takaSivu);
    }

    private void varitaSivut() {
        for(int sivu = 0; sivu<6;sivu++){
            for(int rivi =0; rivi<3;rivi++){
                for(int sarake=0;sarake<3;sarake++){
                    this.taulukonTulkintaKuutionSivuiksi[sivu][rivi][sarake].asetaVari(this.mikaVariSivullaOn(sivu));
                }
            }
        }
    }

    public String tulostaSivu(int mikaSivu) {
        StringBuilder sivuRakentaja = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sivuRakentaja.append("   ");
            for (int a = 0; a < 3; a++) {
                String vari=this.taulukonTulkintaKuutionSivuiksi[mikaSivu][i][a].haeVari();
                sivuRakentaja.append(vari);
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
        String vari = this.taulukonTulkintaKuutionSivuiksi[mikaSivu][rivilla][sarakkeella].haeVari();
        return vari;
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
                    kuutionRakentaja.append(this.taulukonTulkintaKuutionSivuiksi[mikaSivu][i][a].haeVari());
                }
            }
            kuutionRakentaja.append('\n');
        }
        kuutionRakentaja.append(tulostaSivu(4));
        kuutionRakentaja.append(tulostaSivu(5));

        return kuutionRakentaja.toString();
    }

    public String[][][] palautaTaulukonTulkintaSivuiksi() {
        String[][][] tulkintaStringTaulukkona = new String[6][3][3];
        for (int a = 0; a < 6; a++) {
            for (int b = 0; b < 3; b++) {
                for (int c = 0; c < 3; c++) {
                    tulkintaStringTaulukkona[a][b][c] = this.mikaMerkkijonoOnPaikalla(a, b, c);
                }
            }
        }

        return tulkintaStringTaulukkona;
    }
    /**
     * Metodi kääntää haluttua sivua haluttuun suuntaan
     *
     * @param myotaVaiVasta arvo 1 kääntää sivua myötäpäivään ja arvo 0
     * vastapäivään
     * @param mikaSivu mitä sivua halutaan kääntää (Vastapäivään kääntäminen on
     * sama, kuin kääntäisi sivua kolme kertaa myötäpäivään)
     */
//    public void kaannaMyotaTaiVastaPaivaan(int myotaVaiVasta, int mikaSivu){
//        if(myotaVaiVasta==1){
//            this.kaannaSivu(mikaSivu);
//        }else if(myotaVaiVasta==0){
//            this.kaannaSivu(mikaSivu);
//            this.kaannaSivu(mikaSivu);
//            this.kaannaSivu(mikaSivu);
//        }
//    }
//    private void kaannaSivu(int mikaSivu){
//        if(mikaSivu==0){
//            this.kaannaYla();
//        }else if(mikaSivu==1){
//            this.kaannaVasen();
//        }else if(mikaSivu==2){
//            this.kaannaEtu();
//        }else if(mikaSivu==3){
//            this.kaannaOikea();
//        }else if(mikaSivu==4){
//            this.kaannaAla();
//        }else if(mikaSivu==5){
//            this.kaannaTaka();
//        }else{
//            
//        }
//    }
//    
//     private void kaannaEtu(){
//        this.vaihdaKulmapalikkojenPaikat(2, 3, 6, 5);
//        this.vaihdaReunapalikoidenPaikat(3,6,9,5);
//       this.paivitaTaulukonTulkintaKuutionSivuiksi();
//    }
//    private void kaannaTaka(){
//        this.vaihdaKulmapalikkojenPaikat(4,7,1,0);
//        this.vaihdaReunapalikoidenPaikat(11,7,0,4);
//       this.paivitaTaulukonTulkintaKuutionSivuiksi();
//    }
//    private void kaannaYla(){
//        this.vaihdaKulmapalikkojenPaikat(0,1,3,2);
//        this.vaihdaReunapalikoidenPaikat(0,2,3,1);
//        
//        this.kaannaKulmapalikkaa(0, 2,3,1);
//        this.kaannaKulmapalikkaa(1, 3,1,2);
//        this.kaannaKulmapalikkaa(3, 2,3,1);
//        this.kaannaKulmapalikkaa(2, 3,1,2);
//        
//        this.kaannaReunapalikkaa(0);
//        this.kaannaReunapalikkaa(2);
//        this.kaannaReunapalikkaa(3);
//        this.kaannaReunapalikkaa(1);
//       
//       this.paivitaTaulukonTulkintaKuutionSivuiksi();
//    }
//    private void kaannaVasen(){
//        this.vaihdaKulmapalikkojenPaikat(0,2,5,4);
//        this.vaihdaReunapalikoidenPaikat(1,5,8,4);
//       
//        this.kaannaKulmapalikkaa(0,3,1,2);
//        this.kaannaKulmapalikkaa(2,2,3,1);
//        this.kaannaKulmapalikkaa(5,3,1,2);
//        this.kaannaKulmapalikkaa(4,2,3,1);
//       
//       //reunapalikoiden asennot pysyvät tässä siirrossa samoina
//       
//       this.paivitaTaulukonTulkintaKuutionSivuiksi();
//    }
//    private void kaannaOikea(){
//        this.vaihdaKulmapalikkojenPaikat(3,1,7,6);
//        this.vaihdaReunapalikoidenPaikat(2,7,10,6);
//       
//        this.kaannaKulmapalikkaa(3,3,1,2);
//        this.kaannaKulmapalikkaa(1,2,3,1);
//        this.kaannaKulmapalikkaa(7,3,1,2);
//        this.kaannaKulmapalikkaa(6,2,3,1);
//       
//       //reunapalikoiden asennot pysyvät tässä siirrossa samoina
//       
//       this.paivitaTaulukonTulkintaKuutionSivuiksi();
//    }
//    
//    private void kaannaAla(){
//        this.vaihdaKulmapalikkojenPaikat(5,6,7,4);
//        this.vaihdaReunapalikoidenPaikat(9,10,11,8);
//        
//        this.kaannaKulmapalikkaa(5,2,3,1);
//        this.kaannaKulmapalikkaa(6,3,1,2);
//        this.kaannaKulmapalikkaa(7,2,3,1);
//        this.kaannaKulmapalikkaa(4,3,1,2);
//       
//       this.kaannaReunapalikkaa(9);
//       this.kaannaReunapalikkaa(10);
//       this.kaannaReunapalikkaa(11);
//       this.kaannaReunapalikkaa(8);
//       
//       this.paivitaTaulukonTulkintaKuutionSivuiksi();
//    }
//    
////    private void vaihdaKulmapalikkojenPaikat(int palikanNumero1, int palikanNumero2, int palikanNumero3, int palikanNumero4){
////       PalikkaJaAsento vanhaKulma1 = this.kulmaPalikoidenPaikat[palikanNumero1];
////       PalikkaJaAsento vanhaKulma2 = this.kulmaPalikoidenPaikat[palikanNumero2];
////       PalikkaJaAsento vanhaKulma3 = this.kulmaPalikoidenPaikat[palikanNumero3];
////       PalikkaJaAsento vanhaKulma4 = this.kulmaPalikoidenPaikat[palikanNumero4];
////       
////       this.kulmaPalikoidenPaikat[palikanNumero1] = vanhaKulma4;
////       this.kulmaPalikoidenPaikat[palikanNumero2] = vanhaKulma1;
////       this.kulmaPalikoidenPaikat[palikanNumero3] = vanhaKulma2;
////       this.kulmaPalikoidenPaikat[palikanNumero4] = vanhaKulma3;
////    }
////    
////    private void vaihdaReunapalikoidenPaikat(int palikanNumero1, int palikanNumero2, int palikanNumero3, int palikanNumero4){
////       PalikkaJaAsento vanhaReuna1 = this.reunaPalikoidenPaikat[palikanNumero1];
////       PalikkaJaAsento vanhaReuna2 = this.reunaPalikoidenPaikat[palikanNumero2];
////       PalikkaJaAsento vanhaReuna3 = this.reunaPalikoidenPaikat[palikanNumero3];
////       PalikkaJaAsento vanhaReuna4 = this.reunaPalikoidenPaikat[palikanNumero4];
////       
////       this.reunaPalikoidenPaikat[palikanNumero1] = vanhaReuna4;
////       this.reunaPalikoidenPaikat[palikanNumero2] = vanhaReuna1;
////       this.reunaPalikoidenPaikat[palikanNumero3] = vanhaReuna2;
////       this.reunaPalikoidenPaikat[palikanNumero4] = vanhaReuna3;
////       
////    }
//    
//    private void kaannaKulmapalikkaa(int palikanIndeksi,int sivu1,int sivu2,int sivu3){
//        this.kulmaPalikoidenPaikat[palikanIndeksi].muutaAsento(new int[] {sivu1, sivu2, sivu3});
//    }
//    private void kaannaReunapalikkaa(int palikanIndeksi){
//        this.reunaPalikoidenPaikat[palikanIndeksi].muutaAsento(new int[] {2,1});
//    }
//    
//    private void luoKulmapalikkaJaAsetaSePaikalleAsentoon(String PalikanNimi,int paikka,String sivu1vari,String sivu2vari,String sivu3vari){
//        this.kulmaPalikoidenPaikat[paikka]= new PalikkaJaAsento(new KulmaPalikka(PalikanNimi, sivu1vari, sivu2vari, sivu3vari));
//    }
//    private void luoReunapalikkaJaAsetaSePaikalleAsentoon(String PalikanNimi,int paikka,String sivu1vari,String sivu2vari){
//        this.reunaPalikoidenPaikat[paikka]= new PalikkaJaAsento(new ReunaPalikka(PalikanNimi, sivu1vari, sivu2vari));
//    }
}
