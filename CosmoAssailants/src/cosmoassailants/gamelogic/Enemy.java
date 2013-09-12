/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.gamelogic;

/**
 *
 * @author ptpihlaj
 */
public interface Enemy {
    
    public int getLocationX();
    public int getLocationY();
    public void move();

    public boolean isAlive();

    public void hasDied();
    
    public void setMoveSpeed(int s);
    public boolean enemyCanShoot();
    public boolean allowedToMove();
    
    

    
    
    
     
}
