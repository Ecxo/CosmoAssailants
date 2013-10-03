/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

/**
 *
 * @author ptpihlaj
 */
public class Explosion {
    int locationX;
    int locationY;
    boolean exploding;
    int explosionCounter;
    
    public Explosion(int x, int y) {
        this.locationX = x;
        this.locationY = y;
        exploding = true;
        int explosionCounter = 0;
        
    }
    
    public void explode() {
        explosionCounter++;
        if (this.explosionCounter == 3) {
            this.exploding = false;
        }
        
    }
    
    public boolean getExploding() {
        return this.exploding;
    }
            
    
    public int getExplosionCounter() {
        return this.explosionCounter;
    }
    
    public int getX() {
        return this.locationX;
    }
    
    public int getY() {
        return this.locationY;
    }
    
    
}
