
package rubik_oht.kuutiot;

import rubik_oht.apuluokat.PalikkaJaAsento;
import java.util.*;
import rubik_oht.apuluokat.PalikkaJaSivu;
import rubik_oht.palikat.*;
/**Huom!!! Tämä luokka toteutetaan (loppuun) myöhemmin koodia laajennettaessa
    *RubikinKuution tekeminen Kuution aliluokkana ei pitäisi olla liian vaikeaa,
    *mutta ajankäytöllisistä syistä jätetään se myöhemmäksi.
    */
    
    /**Kuutio on olio, joka sisältää Palikka-olentoja ja tiedot niiden sijainneista ja 
    *asennoista eli palikoiden sivujen sijainneista.
    *Sen ilmentymiä ovat erikokoiset Rubikin kuutiot.
    *Jätämme osan muiden kuin 3x3x3-kuutioiden toiminnallisuudesta myöhemmin toteutettavaksi
    
    *Kuutiolla on kuusi sivua, joiden nimet ovat yla, vasen, etu, oikea, ala ja taka
    */
    
    /**Taulukkojen avulla kuvataan kuution 'koordinaatteja', jotka pysyvät paikallaan.
    *Kuutiota väänneltäessä palikat vaihtavat paikkoja
    */

/**
 *
 * @author eevanikkari
 */
public class Kuutio {
    
    private int kuutionKoko;
    private KulmaPalikka[] kulmapalikoidenPaikat;//Taulukossa on (numeroiduilla) paikoilla tieto mikä palikka paikalla on ja
                                                   //(numeroitu) lista sen sivuista. Apuna käytetään apuluokkaa 'PalikkaJaAsento'
    private ReunaPalikka[] reunapalikoidenPaikat;
    
    private KeskiPalikka[] keskipalikoidenPaikat;
    
    private String[][][] taulukonTulkintaKuutionSivuiksi;//Tässä taulukossa on 6 paikkaa; yksi jokaiselle kuution sivulle. Jokaisella
                                                        //paikalla on kuutionKoko x kuutionKoko kokoinen taulukko.
    private String yla; //sivujen värit
    private String vasen;
    private String etu;
    private String oikea;
    private String ala;
    private String taka;
    
    
    private PalikkaJaSivu[][] ylaSivulla;
    
    public Kuutio(int kuutionKoko){
        this.kuutionKoko=kuutionKoko;
        if(kuutionKoko>=1){
          
        this.kulmapalikoidenPaikat = new KulmaPalikka[8];//Kulmapalikoille on aina 8 paikka kuutiossa
        this.reunapalikoidenPaikat = new ReunaPalikka[(kuutionKoko-2)*12];
        //Palikan reunalla on koon verran palikoita, joista kaksi ovat kulmapalikoita.
        //reunoja kuutiossa on taas 12 kpl. Siis reunapalikoita on (koko-2)*12 kpl
        
        this.keskipalikoidenPaikat = new KeskiPalikka[((kuutionKoko-2)^2)*6];
        }else{
            //Jos kuutio on 1x1x1-kuutio niin siinä on vain yksi 6-sivuinen palikka
            //negatiivissivuisia kuutioita ei ole
        }
        this.yla ="#FF0000"; //punainen
        this.vasen ="#008000"; //vihreä
        this.etu ="#FFFF00"; //keltainen
        this.oikea="#0000FF"; //sininen
        this.ala ="#FFA500"; //oranssi
        this.taka ="#FFFFFF"; //valkoinen
        this.taulukonTulkintaKuutionSivuiksi = new String[6][kuutionKoko][kuutionKoko];
        this.taytaKuutio();
        
        this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }     
                
    
//    public Kuutio(int kuutionKoko, String yla, String vasen,String etu,String oikea,String ala,String taka){
//        this.kuutionKoko=kuutionKoko;
//        if(kuutionKoko>=1){
//        this.kulmapalikoidenPaikat = new PalikkaJaAsento[8];
//        this.reunapalikoidenPaikat = new PalikkaJaAsento[(kuutionKoko-2)*12];
//        
//        this.taytaKuutio(yla, vasen, etu, oikea, ala, taka);
//        this.paivitaTaulukonTulkintaKuutionSivuiksi();
//        
//        }else{
//            //Jos kuutio on 1x1x1-kuutio niin siinä on vain yksi 6-sivuinen palikka
//        }
//    }


    /**metodi täyttää kuution tyhjillä palikoilla
        */
    public void taytaKuutio(){
        for(int r = 0; r<reunapalikoidenPaikat.length;r++){
            this.reunapalikoidenPaikat[r]=new ReunaPalikka("Re"+r);
        }
        for(int k=0; k<kulmapalikoidenPaikat.length;k++){
            this.kulmapalikoidenPaikat[k]=new KulmaPalikka("Ku"+k);
        }
        for(int e=0; e<keskipalikoidenPaikat.length;e++){
            this.keskipalikoidenPaikat[e]=new KeskiPalikka("Ke"+e);
        }
    }
    
    /*Tämä metodi tulkitsee palikoiden paikat ja asennot taulukoista selvemmiksi
        *koordinaateiksi taulukonTulkintaKuutionSivuiksi -taulukkoon
        
        *tämä metodi täytyy suorittaa aina siirron jälkeen, muuten 'taulukonTulkintaKuutionSivuiksi'
        *ei ole ajan tasalla
        
        * jätetään suurempien kuutioiden logiikka myöhemmin toteutettavaksi
        */
    public void paivitaTaulukonTulkintaKuutionSivuiksi(){
        
    }
    
//    public String tulostaTaulukko(){
//        
//    }
    
    public String tulostaSivu(int mikaSivu){
        StringBuilder sivuRakentaja = new StringBuilder();
         for(int i = 0; i<this.kuutionKoko; i++){
            for(int a = 0; a<this.kuutionKoko; a++){
                sivuRakentaja.append(this.taulukonTulkintaKuutionSivuiksi[mikaSivu][i][a]);
            }
           sivuRakentaja.append('\n');
        }
        return sivuRakentaja.toString();
    }
    
    
}
