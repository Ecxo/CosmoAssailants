/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.gamelogic;

import cosmoassailants.GraphicsUI.Cosmos;
import java.util.ArrayList;

/**
 *
 * @author ptpihlaj
 */
public class Laser {
    private int locationX;
    private int locationY;
    private ArrayList<EnemyAssailant> enemies;
    
    public Laser(int x, Cosmos cosmos) {
        this.locationX = x;
        this.locationY = 700;
        this.enemies = cosmos.getEnemies();
    }
    
    public int laserX() {
        return locationX;
    }
    
    public int laserY() {
        return locationY;
    }

    public void travel() {
        this.locationY -= 20;
        laserEnemyCheck();
    }

    private void laserEnemyCheck() {
        for (EnemyAssailant enemy : this.enemies) {
            if (enemy.getLocationX() == laserX() && enemy.getLocationY() == this.locationY && enemy.isAlive()) {
                enemy.hasDied();
                System.out.println("Enemy dies!");
            }
        }
        
    }
    
    
}
