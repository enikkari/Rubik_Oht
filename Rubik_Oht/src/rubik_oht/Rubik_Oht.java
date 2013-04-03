
package rubik_oht;

import rubik_oht.kuutiot.RubikinKuutio;
import java.util.*;

public class Rubik_Oht {

    public static void main(String[] args) {
        Scanner pelaaja = new Scanner(System.in);
       
         RubikinKuutio rubik = new RubikinKuutio("Y","V","E","O","A","T");
         System.out.println("paina y pyörittääksesi 'ylä'reunaa myötäpäivään;"+'\n'+"paina v pyörittääksesti 'vasen'reunaa myötäpäivään"+ '\n'+"jne"+'\n'+"kirjoita 'lopeta', kun haluat lopettaa");
         boolean jatkuukoPeli = true;
         System.out.println(rubik.tulostaKuutio());
         while(jatkuukoPeli){
             String komento = pelaaja.nextLine();
             if(komento.equals("lopeta")){
                 jatkuukoPeli = false;
                 System.out.println("lopetit ratkaisemisen");
             }else if(komento.equals("e")){
                 rubik.kaannaEtu();
             }else if(komento.equals("t")){
                 rubik.kaannaTaka();
             }else if(komento.contentEquals("y")){
                 rubik.kaannaYla();
             }else if(komento.contentEquals("v")){
                 rubik.kaannaVasen();
             }else if(komento.contentEquals("o")){
                 rubik.kaannaOikea();
             }else if(komento.contentEquals("a")){
                 rubik.kaannaAla();
             }
         System.out.println(rubik.tulostaKuutio());
         
        
    }
        
}
}
