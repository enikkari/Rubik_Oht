
package rubik_oht;

public class Palikka {
    //Palikka kuvaa palikkaa, joista Rubikin kuutio muodostuu.
    //Tavallisessa Rubikin kuutiossa on reuna- ja kulmapalikoita
    
    //"Keskipalikoita" ei ole tavallisessa rubikin kuutiossa (3x3-kuutiossa), 
    //sillä keskellä olevat palikat pysyvät koko ajan toisiinsa nähden paikoillaan.
    
    private String Nimi;
    private String[] vari;//Tähän taulukko sisältää palikan sivujen värit.
                          //"värit" ovat merkkijonoja 
    
    public Palikka(String Nimi, int KuinkaMontaSivuaPalikassaOn){
        this.Nimi=Nimi;
        this.vari= new String[KuinkaMontaSivuaPalikassaOn];
    }
    
    public void asetavari(int monesVari, String Vari){
        if(1<=monesVari && monesVari<=vari.length){
        this.vari[monesVari-1] = Vari;              //Taulukon indeksöinti alkaa 0:sta, joten
    }                                               //n:ännes sivu on taulukossa
    }                                               //paikalla n-1
    
    public String haeVari(int monesVari){ //Palauttaa halutun sivun värin
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
    
    public int kuinkaMontaSivua(){ //Metodilla voidaan selvittää millainen palikka on kyseessä
        return vari.length;         //eli kuinka monta sivua sillä on
    }
    
    @Override
    public String toString(){
//        String tulostus;
//        for(int i=0; i<=vari.length; i++){
//            tulostus=+vari[]; 
//        }
        
        return vari.toString();
        
    }
    
}
