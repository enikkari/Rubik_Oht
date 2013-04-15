
package rubik_oht;

import rubik_oht.kuutiot.RubikinKuutio;
import java.util.*;
import javax.swing.SwingUtilities;
import rubik_oht.apuluokat.PalikkaJaAsento;
import rubik_oht.apuluokat.PalikkaJaSivu;
import rubik_oht.kayttoliittyma.RubikKayttoliittyma;
import rubik_oht.kuutiot.RubikinKuutioMuokkaus;
import rubik_oht.palikat.KeskiPalikka;
import rubik_oht.palikat.KulmaPalikka;

public class Rubik_Oht {

    public static void main(String[] args) {
        
        // kuution sivuja voi pyörittää myötäpäivään numeronäppäimillä 0...5
        //tai kirjaimilla 'y' (ylä),'v' (vasen), 'e' (etu), 'o' (oikea), 
        //'a' (ala), 't' (taka)
//         SwingUtilities.invokeLater(new RubikKayttoliittyma());
        RubikinKuutioMuokkaus rubik;
        rubik = new RubikinKuutioMuokkaus("a","b","c","d","e","f");
//        KulmaPalikka omg =new KulmaPalikka("omg");
        PalikkaJaSivu nn = rubik.luoPalikkaJaSivu('k', 0, 2);
        rubik.kulmaPalikoidenPaikat[0].asetavari(2, "värijee");
        
        rubik.taulukonTulkintaKuutionSivuiksi[0][0][0].haePalikka().asetavari(2, "väri");
        
        String vari =  nn.haeVari();
          System.out.println(rubik.palautaStringKuutio());    
         
        
    }   
}