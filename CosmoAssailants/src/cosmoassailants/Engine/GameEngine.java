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
 * Game engine, updates the game at 30 frames per second.
 * @author ptpihlaj
 */
public class GameEngine extends Thread {

    private GraphicsUI gui;
    private Cosmos cosmos;
    private boolean running;
    public GameEngine engine;

    public GameEngine(GraphicsUI gui, Cosmos cosmos) {
        this.gui = gui;
        this.cosmos = cosmos;
        this.running = true;
        cosmos.setEngine(this);



    }
    
    /**
     * Updates the game, should stop running unless player quits.
     */

    @Override
    public void run() {
        while (running = true) {
            cosmos.updateGame();
            gui.reDraw();
            waiting();


        }
        
        System.out.println("Stopped");
        run();

        
        
       
        
    }
    
    /**
     * Controls how often the game updates.
     */
    

    private void waiting() {
        try {
            Thread.sleep(1000 / 30);
        } catch (InterruptedException ex) {
            System.exit(0);
        }
    }

    public Cosmos getCosmos() {
        return this.cosmos;
    }

    public GraphicsUI getUI() {
        return this.gui;

    }


}
