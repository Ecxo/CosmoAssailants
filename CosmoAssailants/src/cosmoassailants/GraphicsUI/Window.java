/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.GraphicsUI;

import cosmoassailants.gamelogic.Enemy;
import cosmoassailants.gamelogic.EnemyAssailant;
import cosmoassailants.gamelogic.Laser;
import cosmoassailants.gamelogic.LaserPlayer;
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



        for (Laser laser : cosmos.getLasers()) {
            g.setColor(Color.GREEN);
            if (laser.isHostile() == true) {
            g.setColor(Color.MAGENTA);
            g.fillRect(laser.laserX() + 10, laser.laserY(), 10, 20);
            
        }
            g.fillRect(laser.laserX() + 10, laser.laserY(), 10, 20);
            
        }


        g.setColor(Color.BLUE);

        for (Enemy enemy : cosmos.getEnemies()) {
            if (enemy.isAlive() == true) {
                g.fill3DRect(enemy.getLocationX()+5, enemy.getLocationY(), 20, 20, true);
            }
        }

        getToolkit().sync();




    }
}
