/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

/**
 *
 * @author ptpihlaj
 */
public interface Laser {
    
    public int laserX();
    public int laserY();
    public void travel();
    public boolean isHostile();
    
}
