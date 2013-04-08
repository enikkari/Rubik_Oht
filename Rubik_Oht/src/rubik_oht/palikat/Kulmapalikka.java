
package rubik_oht.palikat;
/**
 *
 * @author eevanikkari
 */

    /**Kulmapalikka on rubikin kuution kulmassa oleva palikka.
    *Siinä on kolme sivua ja siis kolme eri väriä.
    *Rubikin kuutiossa on yhteensä 8 kulmapalikkaa
    */
    
public class Kulmapalikka extends Palikka {
    
    
    public Kulmapalikka(String nimi){
        super(nimi, 3);
        
    }
    
    public Kulmapalikka(String nimi, String vari1, String vari2, String vari3){
        super(nimi, 3);
        this.asetavari(1, vari1);
        this.asetavari(2, vari2);
        this.asetavari(3, vari3);
    }
 
}
