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
public class LaserEnemy implements Laser {

    private int locationX;
    private int locationY;
    private ArrayList<Enemy> enemies;
    private Player player;

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
    public void travel() {
        this.locationY += 5;
        laserPlayerCheck();
    }

    private void laserPlayerCheck() {
        if (this.locationX == player.getLocationX() && this.locationY == player.getLocationY()) {
            System.out.println("YOU DIED!");
            player.setAsDead();
        }
    }
    
    public boolean isHostile() {
        return true;
    }
 
}
