
package rubik_oht;

public class Palikka {
    //Palikka kuvaa palikkaa, joista Rubikin kuutio muodostuu.
    //Tavallisessa Rubikin kuutiossa on reuna- ja kulmapalikoita
    private String Nimi;
    private String[] vari;//Taulukon koko määrä kuinka monta sivua eli väriä palikalla on
                          //"Värit" ovat merkkijonoja 
    
    public Palikka(String Nimi, int KuinkaMontaSivuaPalikassaOn){
        this.Nimi=Nimi;
        this.vari= new String[KuinkaMontaSivuaPalikassaOn];
    }
    
    public void asetavari(int monesVari, String Vari){
        if(1<=monesVari && monesVari<=vari.length){
        this.vari[monesVari-1] = Vari;              //indeksöinti alkaa 0:sta, joten
    }                                               //n:ännes palikka on taulukossa
    }                                               //paikalla n-1
    
    public String haeVari(int monesVari){
        if(1<=monesVari && monesVari<=vari.length){
        return this.vari[monesVari-1];
        }
        else{
            return null;
        }
    }
    
    
    public String haeNimi(){
        return this.Nimi;
    }
    
    public int kuinkaMontaSivua(){
        return vari.length;
    }
    
}
