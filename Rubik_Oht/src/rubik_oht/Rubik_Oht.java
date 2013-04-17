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
//        RubikinKuutio rubik;
//        rubik = new RubikinKuutio("a","b","c","d","E","f");
//        System.out.println(rubik.palautaStringKuutio());
//        
//        int taulukonIndeksi = 0;
        String[][] taulukko = new String[][]{{"k"},{"r"},{"k"},{"r"},{"r"},{"k"},{"r"},{"k"}};
        String[][] taulukko2 = new String[3][3];
        int taulukonIndeksi = 0;
        for (int rivi = 0; rivi < 3; rivi++) {
            for (int sarake = 0; sarake < 3; sarake++) {
                int summa = rivi + sarake;
                if (summa == 1 || summa == 3) {
                    taulukko2[rivi][sarake] = "r";
                    taulukonIndeksi = taulukonIndeksi + 1;
                } else if (!(rivi == 1 && sarake == 1)) {
                    taulukko2[rivi][sarake] = "k";
                    taulukonIndeksi = taulukonIndeksi + 1;
                }
                    
            }
            
        }

        for (int rivi = 0; rivi < 3; rivi++) {
            for (int sarake = 0; sarake < 3; sarake++) {
                System.out.println(taulukko2[rivi][sarake]);
            }
            System.out.println("");
        }
    }
}
