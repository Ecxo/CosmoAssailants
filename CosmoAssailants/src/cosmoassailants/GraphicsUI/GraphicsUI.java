/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.GraphicsUI;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author ptpihlaj
 */
public class GraphicsUI implements Runnable {

    private JFrame frame;
    private Cosmos cosmos;

    public GraphicsUI() {
    }

    @Override
    public void run() {
        frame = new JFrame("Cosmo Assailants");

        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
        
    }

    private void createComponents(Container container) {
        this.cosmos = new Cosmos();
        container.add(cosmos);
        
        
    }
}
