/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.gamelogic;

import java.util.ArrayList;

/**
 *
 * @author ptpihlaj
 */
public class Arena {

    final int ARENAHEIGHT = 40;
    final int ARENAWIDTH = 40;
    private ArrayList<Object> objects;
    private Player player;

    public Arena(int enemies) {
        this.objects = createEnemies(enemies);
        this.player = new Player();

    }

    public ArrayList<Object> createEnemies(int enemies) {
        ArrayList<Object> listEnemies = new ArrayList<Object>();
        for (int i = 0; i < enemies; i++) {
            listEnemies.add(new Assailant(i));
        }
        return listEnemies;
    }
    
    public ArrayList<Object> objectsAt() {
        return this.objects;
    }
    
    public void moveObjects() {
        for (Object o : this.objects) {
            o.moveObject();
        }
    }
    
    public Player arenaGetPlayer() {
        return this.player;
    }
}
