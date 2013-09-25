/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.GraphicsUI;

import cosmoassailants.Engine.Controls;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import cosmoassailants.Gamelogic.gameValues;

/**
 *
 * @author ptpihlaj
 */
public class GraphicsUI implements Runnable {

    private JFrame frame;
    private Window window;
    private Cosmos cosmos;

    public GraphicsUI(Cosmos cosmos) {
        this.cosmos = cosmos;
    }

    public void run() {

        frame = new JFrame("Cosmo Assailants");
        frame.setPreferredSize(new Dimension(cosmoassailants.Gamelogic.gameValues.ARENA_SIZE_X, cosmoassailants.Gamelogic.gameValues.ARENA_SIZE_Y));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        if (this.cosmos.getPlayer().playerAlive()) {
        createComponents(frame.getContentPane());
        }
        





        setKeyListener();
        frame.pack();
        frame.setVisible(true);


    }

private void createComponents(Container container) {

        this.window = new Window(this.cosmos);
        container.add(window);

    }


    public void setKeyListener() {
        Controls control = new Controls(this.cosmos.getPlayer(), this.cosmos);
        frame.addKeyListener(control);
    }

    public JFrame getFrame() {
        return frame;
    }
    
    public Window getWindow() {
    return this.window;
}

    public void reDraw() {
        if (window == null) {
            return;
        }
        window.repaint();
    }
}
