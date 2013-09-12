/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Engine;

/**
 *
 * @author ptpihlaj
 */
public class FireRateTimer {
    
    private long previousShot;
    final long PLAYERFIRERATE = 400; // milliseconds between shots;
    
    public FireRateTimer() {
        this.previousShot = System.currentTimeMillis();
        
    }
    
    public boolean playerShotAllowed() {
        if (System.currentTimeMillis()-this.previousShot > 300)  {
            this.previousShot = System.currentTimeMillis();
            return true;
        }
        return false;
    }
    
    
}
