/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Engine;

import cosmoassailants.GraphicsUI.Cosmos;
import cosmoassailants.gamelogic.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author ptpihlaj
 */
public class Controls implements KeyListener {

    private Player player;
    private Cosmos cosmos;

    public Controls(Player player, Cosmos cosmos) {
        this.player = player;
        this.cosmos = cosmos;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.player.movePlayerRight();
            System.out.println("Go right!");

        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.player.movePlayerLeft();
            System.out.println("Go left!");

        }
        
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.cosmos.shootLaser();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
