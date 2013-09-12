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
public class LaserPlayer implements Laser {
    private int locationX;
    private int locationY;
    private ArrayList<Enemy> enemies;
    
    public LaserPlayer(int x, Cosmos cosmos) {
        this.locationX = x;
        this.locationY = 700;
        this.enemies = cosmos.getEnemies();
    }
    
    @Override
    public int laserX() {
        return locationX;
    }
    
    @Override
    public int laserY() {
        return locationY;
    }

    @Override
    public void travel() {
        this.locationY -= 20;
        laserEnemyCheck();
    }

    private void laserEnemyCheck() {
        for (Enemy enemy : this.enemies) {
            if (enemy.getLocationX() == laserX() && enemy.getLocationY() == this.locationY && enemy.isAlive()) {
                enemy.hasDied();
                System.out.println("Enemy dies!");
            }
        }
        
    }

    @Override
    public boolean isHostile() {
        return false;
    }
    
    
}
