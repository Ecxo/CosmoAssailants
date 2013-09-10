/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.GraphicsUI;

import cosmoassailants.gamelogic.EnemyAssailant;
import cosmoassailants.gamelogic.Laser;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author ptpihlaj
 */
public class Window extends JPanel {
    
    private Cosmos cosmos;
    
    public Window(Cosmos cosmos) {
        this.cosmos = cosmos;
        
        
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.black);
        
        g.setColor(Color.RED);
        g.fillOval(cosmos.getPlayer().getLocationX(), cosmos.getPlayer().getLocationY(), 30, 30);
        
        
        g.setColor(Color.GREEN);
        if (cosmos.getLasers().isEmpty() == false) {
            for (Laser laser : cosmos.getLasers()) {
                g.fillRect(laser.laserX()+10, laser.laserY(), 10, 20);
            }
        }
        
        g.setColor(Color.BLUE);
        
        if (cosmos.getEnemies().isEmpty() == false) {
            for (EnemyAssailant enemy : cosmos.getEnemies()) {
                g.fillRect(enemy.getLocationX(), enemy.getLocationY(), 20, 20);
            }
        }
        getToolkit().sync();
        
        
        
        
    }
}
