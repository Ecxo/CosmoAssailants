/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

/**
 * Explosion in the game world.
 * @author ptpihlaj
 */
public class Explosion {
    int locationX;
    int locationY;
    boolean exploding;
    private int explosionCounter;
    
    public Explosion(int x, int y) {
        this.locationX = x;
        this.locationY = y;
        exploding = true;
        explosionCounter = 0;
        
    }
    
    /**
     * Increases explosionCounter by one and sets exploding to false if explosion ends.
     * 
     */
    
    
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
