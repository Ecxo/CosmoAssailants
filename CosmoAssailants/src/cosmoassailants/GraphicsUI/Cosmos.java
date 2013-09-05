/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.GraphicsUI;

import cosmoassailants.gamelogic.Player;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author petri
 */
public class Cosmos extends JPanel {
    
    private PlayerShip playerShip;
    
    public Cosmos() {
        this.playerShip = new PlayerShip();
        
    }
    
    public void paint(Graphics g) {
        super.setBackground(Color.BLACK);
        super.paint(g);
        
        
        
    }
    
    
}
