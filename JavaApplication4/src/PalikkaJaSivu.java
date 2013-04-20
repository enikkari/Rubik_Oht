/*
 * Apuluokka
 * Pari, jossa on palikka ja numero, joka kertoo mikä palikan sivu on kysessä.
 */


import rubik_oht.palikat.*;

/**
 *
 * @author eevanikkari
 */
public class PalikkaJaSivu {
    private Palikka palikka;
    private int sivu;
    
    public PalikkaJaSivu(Palikka palikka, int sivu){
        this.palikka=palikka;
        this.sivu=sivu;
    }
    
    public void asetaVari(String vari){
        this.palikka.asetavari(this.sivu, vari);
    }
    public Palikka haePalikka(){
        return this.palikka;
    }
    public String haeVari(){
        return this.palikka.haeVari(this.sivu);
    }
            
    
}
