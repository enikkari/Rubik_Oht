
package rubik_oht.palikat;

import rubik_oht.palikat.Palikka;
    /**Reunapalikka on rubikin kuution reunalla, kahden kulmapalikan välissä,
    *oleva palikka, jolla on kaksi sivua ja siis kaksi eri väriä.
    *Reunapalikoita on Rubikin kuutiossa yhteensä 12
    */
public class ReunaPalikka extends Palikka{
    
    public ReunaPalikka(String nimi){
        super(nimi, 2);
    }
    
    public ReunaPalikka(String nimi, String vari1, String vari2){
        super(nimi, 2);
        this.asetavari(1, vari1);
        this.asetavari(2, vari2);
    }
}
    

