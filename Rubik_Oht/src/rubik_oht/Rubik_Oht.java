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
        
         SwingUtilities.invokeLater(new RubikKayttoliittyma());
         
    }
}
