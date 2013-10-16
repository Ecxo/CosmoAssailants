/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Engine;

import java.util.Random;

/**
 * Controls the players maximum fire rate
 * @author ptpihlaj
 */
public class FireRateTimer {
    

    private long previousShot;
    private long previousEnemyShot;
    final int PLAYERFIRERATE = 350; // milliseconds between shots;
    
    /**
     * Saves the time when the previous shot was fired.
     */
  
    public FireRateTimer() {
        this.previousShot = System.currentTimeMillis();

    }
    
    /**
     * Compares the current time - PLAYERFIRERATE against previous shot
     * time, returns true if enough time has passed since last shot.
     * 
     * @return boolean
     */

    public boolean playerShotAllowed() {
        if (System.currentTimeMillis() - this.previousShot > PLAYERFIRERATE) {
            this.previousShot = System.currentTimeMillis();
            return true;
        }
        return false;
    }
}
