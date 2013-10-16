/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

import cosmoassailants.GraphicsUI.Cosmos;
import java.util.ArrayList;

/**
 * Lasers shot by enemies
 * @author ptpihlaj
 */
public class LaserEnemy implements Laser {

    private int locationX;
    private int locationY;
    private ArrayList<Enemy> enemies;
    private Player player;
    
    /**
     * Creates an enemy laser. Creates the laser at the enemy location
     * and knows the player object.
     * 
     * @param enemy
     * @param player 
     */

    public LaserEnemy(Enemy enemy, Player player) {
        this.locationX = enemy.getLocationX();
        this.locationY = enemy.getLocationY();
        this.player = player;
        
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
     * Moves player upwards, then checks if player is in the same spot.
     * 
     */
    public void travel() {
        this.locationY += 5;
        laserPlayerCheck();
    }
    
    /**
     * Checks if the laser is in the same spot as the player, sets player dead
     * if both in the same place.
     * 
     */

    private void laserPlayerCheck() {
        if (this.locationX == player.getLocationX() && this.locationY == player.getLocationY()) {
            player.setAsDead();
        }
    }
    
    public boolean isHostile() {
        return true;
    }
 
}
