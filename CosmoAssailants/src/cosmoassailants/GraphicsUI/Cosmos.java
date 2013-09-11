/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.GraphicsUI;

import cosmoassailants.gamelogic.EnemyAssailant;
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
    private ArrayList<EnemyAssailant> enemies;

    public Cosmos() {
        this.player = new Player();
        this.lasers = new ArrayList<Laser>();
        this.enemies = new ArrayList<EnemyAssailant>();
        this.enemies.add(new EnemyAssailant(600, 100));
        this.enemies.add(new EnemyAssailant(400, 100));
        this.enemies.add(new EnemyAssailant(300, 100));
        this.enemies.add(new EnemyAssailant(200, 100));
        this.enemies.add(new EnemyAssailant(300, 200));
    }

    public Player getPlayer() {
        return this.player;
    }

    public ArrayList<Laser> getLasers() {
        return this.lasers;

    }

    public void shootLaser() {
        this.lasers.add(new Laser(this.player.getLocationX(), this));
        System.out.println(this.lasers.size());
    }

    public void updateGame() {
            for (Laser laser : this.lasers) {
                laser.travel();
            }

        
            for (EnemyAssailant enemy : this.enemies) {
                enemy.move();

            }
        }
    

    public ArrayList<EnemyAssailant> getEnemies() {
        return this.enemies;
    }
}
