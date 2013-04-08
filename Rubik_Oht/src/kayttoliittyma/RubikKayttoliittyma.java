package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author eevanikkari
 */
public class RubikKayttoliittyma  implements Runnable {

    private JFrame frame;

    public RubikKayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Rubikin kuutio");
        frame.setPreferredSize(new Dimension(300, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
    }

    public JFrame getFrame() {
        return frame;
    }
}

    

