
package rubik_oht;

import rubik_oht.kuutiot.RubikinKuutio;
import java.util.*;
import javax.swing.SwingUtilities;
import kayttoliittyma.RubikKayttoliittyma;

public class Rubik_Oht {

    public static void main(String[] args) {
        
        // kuution sivuja voi pyörittää myötäpäivään numeronäppäimillä 0...5
        //tai kirjaimilla 'y' (ylä),'v' (vasen), 'e' (etu), 'o' (oikea), 
        //'a' (ala), 't' (taka)
         SwingUtilities.invokeLater(new RubikKayttoliittyma());
        
    }   
}