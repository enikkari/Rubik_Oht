
package rubik_oht;

public abstract class Palikka {
    //Palikka kuvaa palikkaa, joista Rubikin kuutio muodostuu.
    //Tavallisessa Rubikin kuutiossa on reuna- ja kulmapalikoita
    //Halutaan että mahdollisilla palikoilla on seuraavat metodit:
    
    public abstract void asetavari(int monesVari, String Vari);
    public abstract String haeVari(int monesVari);
    public abstract String haeNimi();
    
}
