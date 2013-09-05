/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.GraphicsUI;

import cosmoassailants.gamelogic.Player;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author petri
 */
public class PlayerShip extends JPanel {

    Player playerShip;

    public PlayerShip() {
        this.playerShip = new Player();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GREEN);
        g.fillOval(this.playerShip.getLocationX(), this.playerShip.getLocationY(), 30, 30);
        
        
    }
}
