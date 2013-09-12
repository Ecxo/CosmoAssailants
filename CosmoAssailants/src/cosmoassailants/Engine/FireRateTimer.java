/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Engine;

import java.util.Random;

/**
 *
 * @author ptpihlaj
 */
public class FireRateTimer {

    private long previousShot;
    private long previousEnemyShot;
    final int PLAYERFIRERATE = 350; // milliseconds between shots;
  
    public FireRateTimer() {
        this.previousShot = System.currentTimeMillis();

    }

    public boolean playerShotAllowed() {
        if (System.currentTimeMillis() - this.previousShot > PLAYERFIRERATE) {
            this.previousShot = System.currentTimeMillis();
            return true;
        }
        return false;
    }
}
