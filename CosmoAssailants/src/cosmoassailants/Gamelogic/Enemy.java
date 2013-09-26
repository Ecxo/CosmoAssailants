/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

/**
 * Interface class for enemies
 * 
 * @author ptpihlaj
 */
public interface Enemy {
    
    public int getLocationX();
    public int getLocationY();
    
    /**
     * Moves the enemy
     */
    public void move();
    
    /**
     * Returns enemy status.
     * @return boolean whether enemy is alive
     */

    public boolean isAlive();
    
    /**
     * Sets enemy status to dead
     */

    public void hasDied();
    
    /**
     * Changes how many frame refreshes the enemy must remain stationary
     * after every move
     * @param s how many frames the enemy should wait until moving
     */
    public void setMoveSpeed(int s);
    
    /**
     * creates a random number and compares it to enemyShotChance,
     * if random number is smaller returns true and enemy can shoot.
     * @return boolean 
     */
    public boolean enemyCanShoot();
    
    /**
     * Checks how often the enemy is allowed to move, 
     * returns true if enemy has been stationary for
     * sufficient number of frame updates.
     * @return boolean
     */
    public boolean allowedToMove();
    
    

    
    
    
     
}
