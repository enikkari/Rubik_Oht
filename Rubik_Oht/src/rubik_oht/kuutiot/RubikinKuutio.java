
package rubik_oht.kuutiot;

import rubik_oht.apuluokat.PalikkaJaAsento;
import rubik_oht.palikat.Reunapalikka;
import rubik_oht.palikat.Kulmapalikka;

public class RubikinKuutio{
    //Kuutiolla on kuusi sivua, joiden nimet ovat yla, vasen, etu, oikea, ala ja taka
    
    //Taulukkojen avulla kuvataan kuution 'koordinaatteja', jotka pysyvät paikallaan.
    //Kuutiota väänneltäessä palikat vaihtavat paikkoja
    
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

    
    public void taytaKuutio(){
            //Luodaan palikat oikean värisinä niin että kuutio on alussa ratkaistuna
            this.kulmapalikoidenPaikat[0]= new PalikkaJaAsento(new Kulmapalikka("K1", taka, yla, vasen));
            this.kulmapalikoidenPaikat[1]= new PalikkaJaAsento(new Kulmapalikka("K2", taka, oikea, yla));
            this.kulmapalikoidenPaikat[2]= new PalikkaJaAsento(new Kulmapalikka("K3", etu, vasen, yla));
            this.kulmapalikoidenPaikat[3]= new PalikkaJaAsento(new Kulmapalikka("K4", etu, yla, oikea));
            this.kulmapalikoidenPaikat[4]= new PalikkaJaAsento(new Kulmapalikka("K5", taka, vasen, ala));
            this.kulmapalikoidenPaikat[5]= new PalikkaJaAsento(new Kulmapalikka("K6", etu, ala, vasen));
            this.kulmapalikoidenPaikat[6]= new PalikkaJaAsento(new Kulmapalikka("K7", etu, oikea, ala));
            this.kulmapalikoidenPaikat[7]= new PalikkaJaAsento(new Kulmapalikka("K8", taka, ala, oikea));
            
            this.reunapalikoidenPaikat[0]= new PalikkaJaAsento(new Reunapalikka("R1", taka, yla));
            this.reunapalikoidenPaikat[1]= new PalikkaJaAsento(new Reunapalikka("R2", yla, vasen));
            this.reunapalikoidenPaikat[2]= new PalikkaJaAsento(new Reunapalikka("R3", yla, oikea));
            this.reunapalikoidenPaikat[3]= new PalikkaJaAsento(new Reunapalikka("R4", etu, yla));
            this.reunapalikoidenPaikat[4]= new PalikkaJaAsento(new Reunapalikka("R5", taka, vasen));
            this.reunapalikoidenPaikat[5]= new PalikkaJaAsento(new Reunapalikka("R6", etu, vasen));
            this.reunapalikoidenPaikat[6]= new PalikkaJaAsento(new Reunapalikka("R7", etu, oikea));
            this.reunapalikoidenPaikat[7]= new PalikkaJaAsento(new Reunapalikka("R8", taka, oikea));
            this.reunapalikoidenPaikat[8]= new PalikkaJaAsento(new Reunapalikka("R9", ala, vasen));
            this.reunapalikoidenPaikat[9]= new PalikkaJaAsento(new Reunapalikka("R10", etu, ala));
            this.reunapalikoidenPaikat[10]= new PalikkaJaAsento(new Reunapalikka("R11", ala, oikea));
            this.reunapalikoidenPaikat[11]= new PalikkaJaAsento(new Reunapalikka("R12", taka, ala));
       
            this.paivitaTaulukonTulkintaKuutionSivuiksi();
    }
    
    public void paivitaTaulukonTulkintaKuutionSivuiksi(){
        this.paivitaYla();
        this.paivitaVasen();
        this.paivitaEtu();
        this.paivitaOikea();
        this.paivitaAla();
        this.paivitaTaka();
    }
    
    
    public void paivitaYla(){
       //palikoiden päivittäminen paikoilleen perustuu kuution koordinaatteihin
       //Lisään työhön havainnolistavan kaavion kuution koordinaateista
       //Yla-sivu on taulukonTulkintaKuutionSivuiksi paikalla 0 siksi ensimmäinen koordinaatti on [0]
       //seuraavat koordinaatit ovat sivun tulkinta tavallisessa koordinaatistossa, johon etsitään tiedot taulukoista

        //Taulukoista haetaan tiedot toiminnolla
        //this.mikaTaulukko[PalikanNumero-1](varinNumero);
        
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
    public void paivitaVasen(){
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
    
    public void paivitaEtu(){
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
    
    public void paivitaOikea(){
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
    
    public void paivitaAla(){
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
    
     public void paivitaTaka(){
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
    

    public String tulostaSivu(int mikaSivu){
        StringBuilder sivuRakentaja = new StringBuilder();
         for(int i = 0; i<3; i++){
            for(int a = 0; a<3; a++){
                sivuRakentaja.append(this.taulukonTulkintaKuutionSivuiksi[mikaSivu][i][a]);
            }
           sivuRakentaja.append('\n');
        }
        return sivuRakentaja.toString();
    }
    
    public String tulostaKuutio(){
        StringBuilder kuutionRakentaja = new StringBuilder();
        for(int i = 0; i<6; i++){
            kuutionRakentaja.append(tulostaSivu(i));
            kuutionRakentaja.append('\n');
        }
        return kuutionRakentaja.toString();
    }
    
    public String[][] haeTaulukonTulkintaSivuiksi(int mikaSivu){
        return this.taulukonTulkintaKuutionSivuiksi[mikaSivu];
    }
    
}
