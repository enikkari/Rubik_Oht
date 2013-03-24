
package rubik_oht;

public class PalikkaJaAsento {
    
    Palikka palikka;
    int[] asento;  //missä järjestyksessä palikan sivut ovat
    
    
    public PalikkaJaAsento(Palikka palikka){
        
        this.palikka = palikka;
        this.asento = new int[this.palikka.kuinkaMontaSivua()];
        for(int i=0; i<palikka.kuinkaMontaSivua(); i++){
            this.asento[i]=i;
        }
    }
    public PalikkaJaAsento(Palikka palikka, int[] sivujenJarjestys){
        this.palikka=palikka;
        this.asento=sivujenJarjestys;
    }
    
    public void muutaAsento(int[] uusiJarjestys){
        this.asento=uusiJarjestys;
    }
    public String haeMikaVariPaikallaOn(int kuinkaMonesSivu){
        return this.palikka.haeVari(kuinkaMonesSivu-1);
    }
}
