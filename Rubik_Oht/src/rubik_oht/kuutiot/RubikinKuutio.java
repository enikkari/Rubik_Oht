
package rubik_oht.kuutiot;

import rubik_oht.apuluokat.PalikkaJaAsento;
import rubik_oht.palikat.Reunapalikka;
import rubik_oht.palikat.Kulmapalikka;
/**Kuutiolla on kuusi sivua, joiden nimet ovat yla, vasen, etu, oikea, ala ja taka
    
    *Taulukkojen avulla kuvataan kuution 'koordinaatteja', jotka pysyvät paikallaan.
    *Kuutiota väänneltäessä palikat vaihtavat paikkoja
    */ 

/**
 *
 * @author eevanikkari
 */
public class RubikinKuutio{
    
    private PalikkaJaAsento[] kulmapalikoidenPaikat;//Taulukossa on (numeroiduilla) paikoilla tieto mikä palikka paikalla on ja
                                                   //(numeroitu) lista sen sivuista. Apuna käytetään apuluokkaa 'PalikkaJaAsento'
    private PalikkaJaAsento[] reunapalikoidenPaikat;
    
    public String[][][] taulukonTulkintaKuutionSivuiksi;
    
    private String yla; //sivujen värit
    private String vasen;
    private String etu;
    private String oikea;
    private String ala;
    private String taka;
    
    public RubikinKuutio(){
        
        this.kulmapalikoidenPaikat = new PalikkaJaAsento[8];
        this.reunapalikoidenPaikat = new PalikkaJaAsento[12];
        
        this.taulukonTulkintaKuutionSivuiksi = new String[6][3][3];
        
        this.yla ="#FF0000"; //punainen
        this.vasen ="#008000"; //vihreä
        this.etu ="#FFFF00"; //keltainen
        this.oikea="#0000FF"; //sininen
        this.ala ="#FFA500"; //oranssi
        this.taka ="#FFFFFF"; //valkoinen
        this.taytaKuutio();
        this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }
    
    public RubikinKuutio(String yla, String vasen,String etu,String oikea,String ala,String taka){
        this.kulmapalikoidenPaikat = new PalikkaJaAsento[8];
        this.reunapalikoidenPaikat = new PalikkaJaAsento[12];
        
        this.taulukonTulkintaKuutionSivuiksi = new String[6][3][3];
        
        this.yla =yla;
        this.vasen =vasen;
        this.etu =etu;
        this.oikea=oikea; 
        this.ala =ala;
        this.taka =taka;
        this.taytaKuutio();
        this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }

    /**Luodaan palikat oikean värisinä niin että kuutio on alussa ratkaistuna
             */ 
    private void taytaKuutio(){
            this.luoKulmapalikkaJaAsetaSePaikalleAsentoon("K0",0, taka, yla, vasen);
            this.luoKulmapalikkaJaAsetaSePaikalleAsentoon("K1",1, taka, oikea, yla);
            this.luoKulmapalikkaJaAsetaSePaikalleAsentoon("K2",2, etu, vasen, yla);
            this.luoKulmapalikkaJaAsetaSePaikalleAsentoon("K3",3, etu, yla, oikea);
            this.luoKulmapalikkaJaAsetaSePaikalleAsentoon("K4",4, taka, vasen, ala);
            this.luoKulmapalikkaJaAsetaSePaikalleAsentoon("K5",5, etu, ala, vasen);
            this.luoKulmapalikkaJaAsetaSePaikalleAsentoon("K6",6, etu, oikea, ala);
            this.luoKulmapalikkaJaAsetaSePaikalleAsentoon("K7",7,taka, ala, oikea);
            
            this.luoReunapalikkaJaAsetaSePaikalleAsentoon("R0",0, taka, yla);
            this.luoReunapalikkaJaAsetaSePaikalleAsentoon("R1",1, yla, vasen);
            this.luoReunapalikkaJaAsetaSePaikalleAsentoon("R2",2, yla, oikea);
            this.luoReunapalikkaJaAsetaSePaikalleAsentoon("R3",3, etu, yla);
            this.luoReunapalikkaJaAsetaSePaikalleAsentoon("R4",4, taka, vasen);
            this.luoReunapalikkaJaAsetaSePaikalleAsentoon("R5",5, etu, vasen);
            this.luoReunapalikkaJaAsetaSePaikalleAsentoon("R6",6, etu, oikea);
            this.luoReunapalikkaJaAsetaSePaikalleAsentoon("R7",7, taka, oikea);
            this.luoReunapalikkaJaAsetaSePaikalleAsentoon("R8",8, ala, vasen);
            this.luoReunapalikkaJaAsetaSePaikalleAsentoon("R9",9, etu, ala);
            this.luoReunapalikkaJaAsetaSePaikalleAsentoon("R10",10, ala, oikea);
            this.luoReunapalikkaJaAsetaSePaikalleAsentoon("R11",11, taka, ala);
       
            this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }
    /**palikoiden päivittäminen paikoilleen perustuu kuution koordinaatteihin
       *Lisään työhön havainnolistavan kaavion kuution koordinaateista
       *Esim. Yla-sivu on taulukonTulkintaKuutionSivuiksi paikalla 0 siksi ensimmäinen koordinaatti on [0]
       *seuraavat koordinaatit ovat sivun tulkinta tavallisessa koordinaatistossa, johon etsitään tiedot taulukoista

        *Taulukoista haetaan tiedot toiminnolla
        *this.mikaTaulukko[PalikanNumero-1](varinNumero);
        */
    private void paivitaTaulukonTulkintaKuutionSivuiksi(){
        this.paivitaYla();
        this.paivitaVasen();
        this.paivitaEtu();
        this.paivitaOikea();
        this.paivitaAla();
        this.paivitaTaka();
    }
    /**
     * metodi kääntää 'etu'-sivua myötäpäivään
     * Kuution koordinaatit on valittu siten että etu- ja takakäännöt eivät muuta palikkojen asentoja
     */
    public void kaannaEtu(){
        this.vaihdaKulmapalikkojenPaikat(2, 3, 6, 5);
        this.vaihdaReunapalikoidenPaikat(3,6,9,5);
       this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }
    /**
     * metodi kääntää 'taka'-sivua myötäpäivään
     * Kuution koordinaatit on valittu siten että etu- ja takakäännöt eivät muuta palikkojen asentoja
     */
    public void kaannaTaka(){
        this.vaihdaKulmapalikkojenPaikat(4,7,1,0);
        this.vaihdaReunapalikoidenPaikat(11,7,0,4);
       this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }
    /**
     * metodi kääntää 'yla'-sivua myötäpäivään. Se muuttaa sekä palikoiden paikkoja että asentoja
     */
    public void kaannaYla(){
        this.vaihdaKulmapalikkojenPaikat(0,1,3,2);
        this.vaihdaReunapalikoidenPaikat(0,2,3,1);
        
        this.kaannaKulmapalikkaa(0, 2, 3, 1);
        this.kaannaKulmapalikkaa(1, 3,1,2);
        this.kaannaKulmapalikkaa(3, 2,3,1);
        this.kaannaKulmapalikkaa(2,3,1,2);
        
        this.kaannaReunapalikkaa(0);
        this.kaannaReunapalikkaa(2);
        this.kaannaReunapalikkaa(3);
        this.kaannaReunapalikkaa(1);
       
       this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }
    /**
     * metodi kääntää 'vasen'-sivua myötäpäivään. Se muuttaa sekä palikoiden paikkoja että asentoja
     */
    public void kaannaVasen(){
        this.vaihdaKulmapalikkojenPaikat(0,2,5,4);
        this.vaihdaReunapalikoidenPaikat(1,5,8,4);
       
        this.kaannaKulmapalikkaa(0,3,1,2);
        this.kaannaKulmapalikkaa(2,2,3,1);
        this.kaannaKulmapalikkaa(5,3,1,2);
        this.kaannaKulmapalikkaa(4,2,3,1);
       
       //reunapalikoiden asennot pysyvät tässä siirrossa samoina
       
       this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }
    /**
     * metodi kääntää 'oikea'-sivua myötäpäivään. Se muuttaa sekä palikoiden paikkoja että asentoja
     */
    public void kaannaOikea(){
        this.vaihdaKulmapalikkojenPaikat(3,1,7,6);
        this.vaihdaReunapalikoidenPaikat(2,7,10,6);
       
        this.kaannaKulmapalikkaa(3,3,1,2);
        this.kaannaKulmapalikkaa(1,2,3,1);
        this.kaannaKulmapalikkaa(7,3,1,2);
        this.kaannaKulmapalikkaa(6,2,3,1);
       
       //reunapalikoiden asennot pysyvät tässä siirrossa samoina
       
       this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }
    /**
     * metodi kääntää 'ala'-sivua myötäpäivään. Se muuttaa sekä palikoiden paikkoja että asentoja
     */
    public void kaannaAla(){
        this.vaihdaKulmapalikkojenPaikat(5,6,7,4);
        this.vaihdaReunapalikoidenPaikat(9,10,11,8);
        
        this.kaannaKulmapalikkaa(5,2,3,1);
        this.kaannaKulmapalikkaa(6,3,1,2);
        this.kaannaKulmapalikkaa(7,2,3,1);
        this.kaannaKulmapalikkaa(4,3,1,2);
       
       this.kaannaReunapalikkaa(9);
       this.kaannaReunapalikkaa(10);
       this.kaannaReunapalikkaa(11);
       this.kaannaReunapalikkaa(8);
       
       this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }
    /**
     * Metodi kääntää haluttua sivua haluttuun suuntaan
     * @param myotaVaiVasta arvo 0 kääntää sivua myötäpäivään ja arvo 1 vastapäivään
     * @param mikaSivu mitä sivua halutaan kääntää
     * (Vastapäivään kääntäminen on sama, kuin kääntäisi sivua kolme kertaa myötäpäivään)
     */
    
    public void kaannaMyotaTaiVastaPaivaan(int myotaVaiVasta, int mikaSivu){
        if(myotaVaiVasta==0){
            this.kaannaSivu(mikaSivu);
        }else if(myotaVaiVasta==1){
            this.kaannaSivu(mikaSivu);
            this.kaannaSivu(mikaSivu);
            this.kaannaSivu(mikaSivu);
        }
    }
    private void kaannaSivu(int mikaSivu){
        if(mikaSivu==0){
            this.kaannaYla();
        }else if(mikaSivu==1){
            this.kaannaVasen();
        }else if(mikaSivu==2){
            this.kaannaEtu();
        }else if(mikaSivu==3){
            this.kaannaOikea();
        }else if(mikaSivu==4){
            this.kaannaAla();
        }else if(mikaSivu==5){
            this.kaannaTaka();
        }else{
            
        }
    }
    
    /**
     * metodille annetaan paikkaa vaihtavien Reunapalikoiden numerot myötäpäivään kiertävässä järjestyksessä
     * ja se vaihtaa niiden paikat siten että palikanNumero1 menee palikanNumero2 tilalle ja PalikanNumero2 taas PalikanNumero3 paikalle jne.
     */
    private void vaihdaKulmapalikkojenPaikat(int palikanNumero1, int palikanNumero2, int palikanNumero3, int palikanNumero4){
       PalikkaJaAsento vanhaKulma1 = this.kulmapalikoidenPaikat[palikanNumero1];
       PalikkaJaAsento vanhaKulma2 = this.kulmapalikoidenPaikat[palikanNumero2];
       PalikkaJaAsento vanhaKulma3 = this.kulmapalikoidenPaikat[palikanNumero3];
       PalikkaJaAsento vanhaKulma4 = this.kulmapalikoidenPaikat[palikanNumero4];
       
       this.kulmapalikoidenPaikat[palikanNumero1] = vanhaKulma4;
       this.kulmapalikoidenPaikat[palikanNumero2] = vanhaKulma1;
       this.kulmapalikoidenPaikat[palikanNumero3] = vanhaKulma2;
       this.kulmapalikoidenPaikat[palikanNumero4] = vanhaKulma3;
    }
    
    private void vaihdaReunapalikoidenPaikat(int palikanNumero1, int palikanNumero2, int palikanNumero3, int palikanNumero4){
       PalikkaJaAsento vanhaReuna1 = this.reunapalikoidenPaikat[palikanNumero1];
       PalikkaJaAsento vanhaReuna2 = this.reunapalikoidenPaikat[palikanNumero2];
       PalikkaJaAsento vanhaReuna3 = this.reunapalikoidenPaikat[palikanNumero3];
       PalikkaJaAsento vanhaReuna4 = this.reunapalikoidenPaikat[palikanNumero4];
       
       this.reunapalikoidenPaikat[palikanNumero1] = vanhaReuna4;
       this.reunapalikoidenPaikat[palikanNumero2] = vanhaReuna1;
       this.reunapalikoidenPaikat[palikanNumero3] = vanhaReuna2;
       this.reunapalikoidenPaikat[palikanNumero4] = vanhaReuna3;
       
    }
    
    private void kaannaKulmapalikkaa(int palikanIndeksi,int sivu1,int sivu2,int sivu3){
        this.kulmapalikoidenPaikat[palikanIndeksi].muutaAsento(new int[] {sivu1, sivu2, sivu3});
    }
    private void kaannaReunapalikkaa(int palikanIndeksi){
        this.reunapalikoidenPaikat[palikanIndeksi].muutaAsento(new int[] {2,1});
    }
    
    private void luoKulmapalikkaJaAsetaSePaikalleAsentoon(String PalikanNimi,int paikka,String sivu1vari,String sivu2vari,String sivu3vari){
        this.kulmapalikoidenPaikat[paikka]= new PalikkaJaAsento(new Kulmapalikka(PalikanNimi, sivu1vari, sivu2vari, sivu3vari));
    }
    private void luoReunapalikkaJaAsetaSePaikalleAsentoon(String PalikanNimi,int paikka,String sivu1vari,String sivu2vari){
        this.reunapalikoidenPaikat[paikka]= new PalikkaJaAsento(new Reunapalikka(PalikanNimi, sivu1vari, sivu2vari));
    }
    /**
     * Palauttaa RubikinKuution halutun sivun alkuperäisen värin
     */
    public String mikaVariSivullaOn(int mikaSivu){
        String[] sivujenVarit = new String[] {yla, vasen, etu, oikea, ala, taka};
        return sivujenVarit[mikaSivu];
        
    }
    
    private void paivitaYla(){
       
        this.taulukonTulkintaKuutionSivuiksi[0][0][0] = this.kulmapalikoidenPaikat[0].haeMikaVariPaikallaOn(2);
        this.taulukonTulkintaKuutionSivuiksi[0][0][1] = this.reunapalikoidenPaikat[0].haeMikaVariPaikallaOn(2);
        this.taulukonTulkintaKuutionSivuiksi[0][0][2] = this.kulmapalikoidenPaikat[1].haeMikaVariPaikallaOn(3);
        
        this.taulukonTulkintaKuutionSivuiksi[0][1][0] = this.reunapalikoidenPaikat[1].haeMikaVariPaikallaOn(1); 
        this.taulukonTulkintaKuutionSivuiksi[0][1][1] = this.yla;
        this.taulukonTulkintaKuutionSivuiksi[0][1][2] = this.reunapalikoidenPaikat[2].haeMikaVariPaikallaOn(1); 
        
        this.taulukonTulkintaKuutionSivuiksi[0][2][0] = this.kulmapalikoidenPaikat[2].haeMikaVariPaikallaOn(3);
        this.taulukonTulkintaKuutionSivuiksi[0][2][1] = this.reunapalikoidenPaikat[3].haeMikaVariPaikallaOn(2);
        this.taulukonTulkintaKuutionSivuiksi[0][2][2] = this.kulmapalikoidenPaikat[3].haeMikaVariPaikallaOn(2);
        
    }
    private void paivitaVasen(){
        this.taulukonTulkintaKuutionSivuiksi[1][0][0] = this.kulmapalikoidenPaikat[0].haeMikaVariPaikallaOn(3);
        this.taulukonTulkintaKuutionSivuiksi[1][0][1] = this.reunapalikoidenPaikat[1].haeMikaVariPaikallaOn(2);
        this.taulukonTulkintaKuutionSivuiksi[1][0][2] = this.kulmapalikoidenPaikat[2].haeMikaVariPaikallaOn(2);
        
        this.taulukonTulkintaKuutionSivuiksi[1][1][0]= this.reunapalikoidenPaikat[4].haeMikaVariPaikallaOn(2); 
        this.taulukonTulkintaKuutionSivuiksi[1][1][1] = this.vasen;
        this.taulukonTulkintaKuutionSivuiksi[1][1][2] = this.reunapalikoidenPaikat[5].haeMikaVariPaikallaOn(2); 
        
        this.taulukonTulkintaKuutionSivuiksi[1][2][0] = this.kulmapalikoidenPaikat[4].haeMikaVariPaikallaOn(2);
        this.taulukonTulkintaKuutionSivuiksi[1][2][1] = this.reunapalikoidenPaikat[8].haeMikaVariPaikallaOn(2);
        this.taulukonTulkintaKuutionSivuiksi[1][2][2] = this.kulmapalikoidenPaikat[5].haeMikaVariPaikallaOn(3);
    }
    
    private void paivitaEtu(){
        this.taulukonTulkintaKuutionSivuiksi[2][0][0] = this.kulmapalikoidenPaikat[2].haeMikaVariPaikallaOn(1);
        this.taulukonTulkintaKuutionSivuiksi[2][0][1] = this.reunapalikoidenPaikat[3].haeMikaVariPaikallaOn(1);
        this.taulukonTulkintaKuutionSivuiksi[2][0][2] = this.kulmapalikoidenPaikat[3].haeMikaVariPaikallaOn(1);
        
        this.taulukonTulkintaKuutionSivuiksi[2][1][0] = this.reunapalikoidenPaikat[5].haeMikaVariPaikallaOn(1); 
        this.taulukonTulkintaKuutionSivuiksi[2][1][1] = this.etu;
        this.taulukonTulkintaKuutionSivuiksi[2][1][2] = this.reunapalikoidenPaikat[6].haeMikaVariPaikallaOn(1); 
        
        this.taulukonTulkintaKuutionSivuiksi[2][2][0] = this.kulmapalikoidenPaikat[5].haeMikaVariPaikallaOn(1);
        this.taulukonTulkintaKuutionSivuiksi[2][2][1] = this.reunapalikoidenPaikat[9].haeMikaVariPaikallaOn(1);
        this.taulukonTulkintaKuutionSivuiksi[2][2][2] = this.kulmapalikoidenPaikat[6].haeMikaVariPaikallaOn(1);
    }
    
    private void paivitaOikea(){
        this.taulukonTulkintaKuutionSivuiksi[3][0][0] = this.kulmapalikoidenPaikat[3].haeMikaVariPaikallaOn(3);
        this.taulukonTulkintaKuutionSivuiksi[3][0][1] = this.reunapalikoidenPaikat[2].haeMikaVariPaikallaOn(2);
        this.taulukonTulkintaKuutionSivuiksi[3][0][2] = this.kulmapalikoidenPaikat[1].haeMikaVariPaikallaOn(2);
        
        this.taulukonTulkintaKuutionSivuiksi[3][1][0] = this.reunapalikoidenPaikat[6].haeMikaVariPaikallaOn(2); 
        this.taulukonTulkintaKuutionSivuiksi[3][1][1] = this.oikea;
        this.taulukonTulkintaKuutionSivuiksi[3][1][2] = this.reunapalikoidenPaikat[7].haeMikaVariPaikallaOn(2); 
        
        this.taulukonTulkintaKuutionSivuiksi[3][2][0] = this.kulmapalikoidenPaikat[6].haeMikaVariPaikallaOn(2);
        this.taulukonTulkintaKuutionSivuiksi[3][2][1] = this.reunapalikoidenPaikat[10].haeMikaVariPaikallaOn(2);
        this.taulukonTulkintaKuutionSivuiksi[3][2][2] = this.kulmapalikoidenPaikat[7].haeMikaVariPaikallaOn(3);
    }
    
    private void paivitaAla(){
        this.taulukonTulkintaKuutionSivuiksi[4][0][0] = this.kulmapalikoidenPaikat[5].haeMikaVariPaikallaOn(2);
        this.taulukonTulkintaKuutionSivuiksi[4][0][1] = this.reunapalikoidenPaikat[9].haeMikaVariPaikallaOn(2);
        this.taulukonTulkintaKuutionSivuiksi[4][0][2] = this.kulmapalikoidenPaikat[6].haeMikaVariPaikallaOn(3);
        
        this.taulukonTulkintaKuutionSivuiksi[4][1][0] = this.reunapalikoidenPaikat[8].haeMikaVariPaikallaOn(1); 
        this.taulukonTulkintaKuutionSivuiksi[4][1][1] = this.ala;
        this.taulukonTulkintaKuutionSivuiksi[4][1][2] = this.reunapalikoidenPaikat[10].haeMikaVariPaikallaOn(1); 
        
        this.taulukonTulkintaKuutionSivuiksi[4][2][0] = this.kulmapalikoidenPaikat[4].haeMikaVariPaikallaOn(3);
        this.taulukonTulkintaKuutionSivuiksi[4][2][1] = this.reunapalikoidenPaikat[11].haeMikaVariPaikallaOn(2);
        this.taulukonTulkintaKuutionSivuiksi[4][2][2] = this.kulmapalikoidenPaikat[7].haeMikaVariPaikallaOn(2);
    }
    
     private void paivitaTaka(){
        this.taulukonTulkintaKuutionSivuiksi[5][0][0] = this.kulmapalikoidenPaikat[4].haeMikaVariPaikallaOn(1);
        this.taulukonTulkintaKuutionSivuiksi[5][0][1] = this.reunapalikoidenPaikat[11].haeMikaVariPaikallaOn(1);
        this.taulukonTulkintaKuutionSivuiksi[5][0][2] = this.kulmapalikoidenPaikat[7].haeMikaVariPaikallaOn(1);
       
        this.taulukonTulkintaKuutionSivuiksi[5][1][0] = this.reunapalikoidenPaikat[4].haeMikaVariPaikallaOn(1); 
        this.taulukonTulkintaKuutionSivuiksi[5][1][1] = this.taka;
        this.taulukonTulkintaKuutionSivuiksi[5][1][2] = this.reunapalikoidenPaikat[7].haeMikaVariPaikallaOn(1); 
        
        this.taulukonTulkintaKuutionSivuiksi[5][2][0] = this.kulmapalikoidenPaikat[0].haeMikaVariPaikallaOn(1);
        this.taulukonTulkintaKuutionSivuiksi[5][2][1] = this.reunapalikoidenPaikat[0].haeMikaVariPaikallaOn(1);
        this.taulukonTulkintaKuutionSivuiksi[5][2][2] = this.kulmapalikoidenPaikat[1].haeMikaVariPaikallaOn(1);
        
    }
    

    private String tulostaSivu(int mikaSivu){
        StringBuilder sivuRakentaja = new StringBuilder();
         for(int i = 0; i<3; i++){
            sivuRakentaja.append("   ");
            for(int a = 0; a<3; a++){
                sivuRakentaja.append(this.taulukonTulkintaKuutionSivuiksi[mikaSivu][i][a]);
            }
           sivuRakentaja.append('\n');
        }
        return sivuRakentaja.toString();
    }
    
    public String tulostaKuutio(){
        StringBuilder kuutionRakentaja = new StringBuilder();
            kuutionRakentaja.append(tulostaSivu(0));
            for(int i = 0; i<3;i++){
            for(int mikaSivu=1; mikaSivu<=3; mikaSivu++){
                for(int a=0; a<3; a++){
                kuutionRakentaja.append(this.taulukonTulkintaKuutionSivuiksi[mikaSivu][i][a]);
                }
            }
                kuutionRakentaja.append('\n');
            }
            kuutionRakentaja.append(tulostaSivu(4));
            kuutionRakentaja.append(tulostaSivu(5));
            
        return kuutionRakentaja.toString();
    }
    
    public String[][] haeTaulukonTulkintaSivuiksi(int mikaSivu){
        return this.taulukonTulkintaKuutionSivuiksi[mikaSivu];
    }
    
}
