
package rubik_oht;

public class Reunapalikka extends Palikka{
    //Reunapalikka on rubikin kuution reunalla, kahden kulmapalikan välissä,
    //oleva palikka, jolla on kaksi sivua ja siis kaksi eri väriä.
    //Reunapalikoita on Rubikin kuutiossa yhteensä 12
    private String nimi;
    private String vari1;  //"Värit" ovat merkkijonoja
    private String vari2;
    
    
    public Reunapalikka(String nimi){  //luodaan konstruktori
        this.nimi=nimi;
    }
    
    public Reunapalikka(String nimi, String vari1, String vari2){
        this.nimi=nimi;
        this.vari1=vari1;
        this.vari2=vari2;
    }
    
    public void asetavari(int monesVari, String Vari){
        if(monesVari==1){
          this.vari1=Vari;
        }
        if(monesVari==2){
        this.vari2=Vari;
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
        else{
            return "";
        }
    }
    
     public String haeNimi(){
        return this.nimi;
    }
}
    

