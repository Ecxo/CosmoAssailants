/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

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
    private Cosmos cosmos;
    
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
    public void travel() {
        this.locationY -= 20;
        laserEnemyCheck();
    }

    private void laserEnemyCheck() {
        for (Enemy enemy : this.enemies) {
            if (enemy.getLocationX() == laserX() && enemy.getLocationY() == this.locationY && enemy.isAlive()) {
                enemy.hasDied();
                this.cosmos.getScoring().increaseScore();
                System.out.println("Score: "+cosmos.getScoring().getScore());
                
            }
        }
        
    }

    @Override
    public boolean isHostile() {
        return false;
    }
    
    
}