/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

/**
 * Laser movement and creation
 * @author ptpihlaj
 */
public interface Laser {
    

    
    public int laserX();
    public int laserY();
    
    /**
     * Moves laser up or down
     */
    public void travel();
    
    /**
     * Was laser shot by player or enemy
     * @return boolean
     */
    public boolean isHostile();
    
}
