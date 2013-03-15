
package rubik_oht;

public class Kulmapalikka extends Palikka {
    //Kulmapalikka on rubikin kuution kulmassa oleva palikka.
    //Siinä on kolme sivua ja siis kolme eri väriä.
    //Rubikin kuutiossa on yhteensä 8 kulmapalikkaa
    
    private String nimi;
    private String vari1;  //"Värit" ovat merkkijonoja
    private String vari2;
    private String vari3;
    
    public Kulmapalikka(String nimi){
        this.nimi=nimi;
    }
    
    public Kulmapalikka(String nimi, String vari1, String vari2, String vari3){
        this.nimi=nimi;
        this.vari1=vari1;
        this.vari2=vari2;
        this.vari3=vari3;
    }
    
    public void asetavari(int monesVari, String Vari){
        if(monesVari==1){
          this.vari1=Vari;
        }
        if(monesVari==2){
        this.vari2=Vari;
        }
        if(monesVari==3){
            this.vari3=Vari;
        }
        else{
         
        }
    }
    
    public String haeVari(int monesVari){
        if(monesVari==1){
        return vari1;
        }
        if(monesVari==2){
            return vari2;
        }
        if(monesVari==3){
            return vari3;
        }
        else{
            return "";
        }
    }
    
     public String haeNimi(){
        return this.nimi;
    }
    
}
