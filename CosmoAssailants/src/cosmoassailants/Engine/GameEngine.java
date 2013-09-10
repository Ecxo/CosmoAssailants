/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Engine;

import cosmoassailants.GraphicsUI.Cosmos;
import cosmoassailants.GraphicsUI.GraphicsUI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ptpihlaj
 */
public class GameEngine extends Thread {

    private GraphicsUI gui;
    private Cosmos cosmos;
    private boolean running;

    public GameEngine(GraphicsUI gui, Cosmos cosmos) {
        this.gui = gui;
        this.cosmos = cosmos;
        this.running = true;



    }

    @Override
    public void run() {
        while (running = true) {
            cosmos.updateGame();
            gui.reDraw();
            waiting();

        }
    }

    private void waiting() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println("Something wrong with Waiting()...");
            System.exit(0);
        }
    }
    
    private Cosmos getCosmos() {
        return this.cosmos;
    }
}
