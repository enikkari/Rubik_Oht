package kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import rubik_oht.kuutiot.NappaimistonKuuntelija;
import rubik_oht.kuutiot.RubikinKuutio;

public class RubikKayttoliittyma implements Runnable {

    private JFrame frame;
    private RubikinKuutio kuutio;

    public RubikKayttoliittyma() {
        this.kuutio = new RubikinKuutio();
    }

    @Override
    public void run() {
        frame = new JFrame("Rubikin kuutio");
        frame.setPreferredSize(new Dimension(194, 281));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        Piirtoalusta piirtoalusta = new Piirtoalusta(kuutio);
        container.add(piirtoalusta);

        frame.addKeyListener(new NappaimistonKuuntelija(kuutio, piirtoalusta));
    }

    public JFrame getFrame() {
        return frame;
    }
}

