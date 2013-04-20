/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author eevanikkari
 */
public class KeskiPalikka extends Palikka{
    public KeskiPalikka(String nimi){
        super(nimi, 1);
        
    }
    
    public KeskiPalikka(String nimi, String vari1){
        super(nimi, 1);
        this.asetavari(1, vari1);
    }
}
