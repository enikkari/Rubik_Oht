
package rubik_oht;

import java.util.*;

public class Kuutio {
    //Kuutio on olio, joka sisältää Palikka-olentoja ja tiedot niiden sijainneista ja 
    //asennoista eli palikoiden sivujen sijainneista.
    //Sen ilmentymiä ovat erikokoiset Rubikin kuutiot.
    //Tavallinen Rubikin kuutio on 3x3x3 kuutio
    //Jätämme osan muiden kuin 3x3x3-kuutioiden toiminnallisuudesta myöhemmin toteutettavaksi
    
    //Kuutiolla on kuusi sivua, joiden nimet ovat etu, taka, ylä, ala, oikea ja vasen
    
    //Taulukkojen avulla kuvataan kuution 'koordinaatteja', jotka pysyvät paikallaan.
    //Kuutiota väänneltäessä palikat vaihtavat paikkoja
    private int kuutionKoko;
    private PalikkaJaAsento[] kulmapalikoidenPaikat;
    //Taulukossa on (numeroiduilla) paikoilla tieto mikä palikka paikalla on ja
    //(numeroitu) lista sen sivuista. Apuna käytetään apuluokkaa 'PalikkaJaAsento'
    
    private PalikkaJaAsento[] reunapalikoidenPaikat;
    
    //private PalikkaJaAsento[] keskipalikoidenPaikat; //Tätä ei tarvita vielä 3x3 kuutiossa
    
    private String[][][] taulukonTulkintaKuutionSivuiksi;
    //Tässä taulukossa on 6 paikkaa; yksi jokaiselle kuution sivulle. Jokaisella
    //paikalla on kuutionKoko x kuutionKoko kokoinen taulukko.
    
    
    public Kuutio(int kuutionKoko){
        this.kuutionKoko=kuutionKoko;
        if(kuutionKoko>=1){
        this.kulmapalikoidenPaikat = new PalikkaJaAsento[8];//Kulmapalikoille on aina 8 paikka kuutiossa
        this.reunapalikoidenPaikat = new PalikkaJaAsento[(kuutionKoko-2)*12];
        //Palikan reunalla on koon verran palikoita, joista kaksi ovat kulmapalikoita.
        //reunoja kuutiossa on taas 12 kpl. Siis reunapalikoita on (koko-2)*12 kpl
        
        //this.PalikkaJaAsento = new PalikkaJaAsento[Math.sqrt(koko-2)*6];
        }else{
            //Jos kuutio on 1x1x1-kuutio niin siinä on vain yksi 6-sivuinen palikka
        }
    }         
                
    
    public Kuutio(int kuutionKoko, String etu, String taka, String yla, String ala, String oikea, String vasen){
        this.kuutionKoko=kuutionKoko;
        if(kuutionKoko>=1){
        this.kulmapalikoidenPaikat = new PalikkaJaAsento[8];
        this.reunapalikoidenPaikat = new PalikkaJaAsento[(kuutionKoko-2)*12];
        
        }else{
            //Jos kuutio on 1x1x1-kuutio niin siinä on vain yksi 6-sivuinen palikka
        }
    }

    
    public void taytaKuutio(String etu, String taka, String yla, String ala, String oikea, String vasen){
        //metodi täyttää kuution ja asettaa sivujen väreiksi annetut
    }
    
    
    public String tulostaSivu(String mikaSivu){
        if(mikaSivu == "etu"){
            
            return "";
        }
        else if(mikaSivu == "taka"){
            return "";
        }
        else if(mikaSivu == "yla"){
            return "";
        }
        else if(mikaSivu == "ala"){
           return ""; 
        }
        else if(mikaSivu == "oikea"){
            return "";
        }
        else if(mikaSivu == "vasen"){
            return "";
        }
        else{
            return null;
        }
        
    }
    
    
    public String tulostaKuutio(){
        //tähän tehdään mahdollisuus tulostaa miltä kuutio näyttää
        return "";
    }
    
    
    
    
    
    
}
