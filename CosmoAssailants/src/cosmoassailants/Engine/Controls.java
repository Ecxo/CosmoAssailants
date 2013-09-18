/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Engine;

import cosmoassailants.GraphicsUI.Cosmos;
import cosmoassailants.Gamelogic.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

/**
 *
 * @author ptpihlaj
 */
public class Controls implements KeyListener {

    private Player player;
    private Cosmos cosmos;
    private FireRateTimer playerTimer;

    public Controls(Player player, Cosmos cosmos) {
        this.player = player;
        this.cosmos = cosmos;
        this.playerTimer = new FireRateTimer();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.player.movePlayer(1);
            System.out.println("Go right!");

        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.player.movePlayer(0);
            System.out.println("Go left!");

        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (playerTimer.playerShotAllowed() == true) {
                this.cosmos.shootLaser();
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
