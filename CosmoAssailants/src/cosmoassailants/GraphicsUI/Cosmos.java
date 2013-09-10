/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.GraphicsUI;

import cosmoassailants.gamelogic.Laser;
import cosmoassailants.gamelogic.Player;
import java.util.ArrayList;

/**
 *
 * @author ptpihlaj
 */
public class Cosmos {

    private Player player;
    private ArrayList<Laser> lasers;

    public Cosmos() {
        this.player = new Player();
        this.lasers = new ArrayList<Laser>();
    }

    public Player getPlayer() {
        return this.player;
    }

    public ArrayList<Laser> getLasers() {
        return this.lasers;
        
    }
    
    public void shootLaser() {
        this.lasers.add(new Laser(this.player.getLocationX()));
        System.out.println(this.lasers);
    }
    

    public void movePlayerRight() {
    }

    public void updateGame() {
        if (this.lasers.isEmpty() == false) {
            for (Laser laser : this.lasers) {
                laser.travel();
            }
        }
    }
}

