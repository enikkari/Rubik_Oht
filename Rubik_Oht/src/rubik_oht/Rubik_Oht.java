
package rubik_oht;

import rubik_oht.kuutiot.RubikinKuutio;
import java.util.HashMap;

public class Rubik_Oht {

    public static void main(String[] args) {
        // TODO code application logic here
       
         RubikinKuutio jeejee = new RubikinKuutio("y","v","e","o","a","t");
        System.out.println(jeejee.tulostaSivu(0));
        System.out.println(jeejee.tulostaSivu(1));
        System.out.println(jeejee.tulostaSivu(2));
        System.out.println(jeejee.tulostaSivu(3));
        System.out.println(jeejee.tulostaSivu(4));
        System.out.println(jeejee.tulostaSivu(5));
        
    }
        
}
