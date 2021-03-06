
package rubik_oht.apuluokat;

import rubik_oht.palikat.Palikka;
/** PalikkaJaAsento on apuluokka, jonka avulla saadaan sopivanlaisia taulukko-
     * olentoja Kuutioihin. Se säilöö Palikan ja tiedon sen asennosta eli sivujen järjestyksestä.
     */

public class PalikkaJaAsento {
    
    private Palikka palikka;
    private int[] asento;  //missä järjestyksessä palikan sivut ovat
    
    
    public PalikkaJaAsento(Palikka palikka){
        this.palikka = palikka;
        this.asento = new int[this.palikka.kuinkaMontaSivua()];
        for(int i=1; i<=palikka.kuinkaMontaSivua(); i++){
            this.asento[i-1]=i;
        }
    }
    public PalikkaJaAsento(Palikka palikka, int[] sivujenJarjestys){
        this.palikka=palikka;
        this.asento=sivujenJarjestys;
    }
    /**
     * Muuttaa asennon uuden järjestyksen mukaiseksi
     * esim. {3,2,1} -taulukko muuttaa järjestyksen siten että vanhan asennon 0. ja 2. indeksi vaihtavat paikkaa
     */
    public void muutaAsento(int[] uusiJarjestys){
        int[] vanhaAsento = new int[asento.length];
        for(int a =0; a<asento.length; a++){
            vanhaAsento[a]=asento[a];
        }
        
        for(int i=0; i<vanhaAsento.length; i++){
            this.asento[i]=vanhaAsento[uusiJarjestys[i]-1];
        }
    }
    public String haeMikaVariPaikallaOn(int kuinkaMonesSivu){
        return this.palikka.haeVari(this.asento[kuinkaMonesSivu-1]);
    }
    
    public int[] haeAsento(){
        return asento;
    }
    
    public Palikka haePalikka(){
        return this.palikka;
    }
}
