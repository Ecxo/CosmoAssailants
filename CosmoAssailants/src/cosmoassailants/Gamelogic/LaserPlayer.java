/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

import cosmoassailants.GraphicsUI.Cosmos;
import java.util.ArrayList;

/**
 * Lasers shot by the player
 * @author ptpihlaj
 */
public class LaserPlayer implements Laser {
    private int locationX;
    private int locationY;
    private ArrayList<Enemy> enemies;
    private Cosmos cosmos;
    
    
    /**
     * Creates a laser at the designated coordinates. Knows cosmos
     * to retrieve enemies.
     * 
     * @param x
     * @param y
     * @param cosmos to retrieve enemies
     */
    
    public LaserPlayer(int x, int y, Cosmos cosmos) {
        this.locationX = x;
        this.locationY = y;
        this.enemies = cosmos.getEnemies();
        this.cosmos = cosmos;
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
    
    /**
     * moves laser upwards, checks if enemies at the same location.
     * 
     */
    public void travel() {
        this.locationY -= 20;
        laserEnemyCheck();
    }

    private void laserEnemyCheck() {
        for (Enemy enemy : this.enemies) {
            if (enemy.getLocationX() == laserX() && enemy.getLocationY() == this.locationY && enemy.isAlive()) {
                enemy.hasDied();
                this.cosmos.newExplosion(enemy);
                this.cosmos.getScoring().increaseScore();
                
            }
        }
        
    }

    @Override
    public boolean isHostile() {
        return false;
    }
    
    
}
