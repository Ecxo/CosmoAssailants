/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.gamelogic;

/**
 *
 * @author ptpihlaj
 */
public class Laser {
    private int locationX;
    private int locationY;
    
    public Laser(int x) {
        this.locationX = x;
        this.locationY = 700;
    }
    
    public int laserX() {
        return locationX;
    }
    
    public int laserY() {
        return locationY;
    }

    public void travel() {
        this.locationY -= 20;
    }
    
    
}
