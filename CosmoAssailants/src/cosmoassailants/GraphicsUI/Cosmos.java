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
        this.enemies.add(new EnemyAssailant(300, 100));
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

    public void updateGame() {
        if (this.lasers.isEmpty() == false) {
            for (Laser laser : this.lasers) {
                laser.travel();
            }

        }
        if (this.enemies.isEmpty() == false) {
            for (EnemyAssailant enemy : this.enemies) {
                enemy.move();

            }
        }
    }

    public ArrayList<EnemyAssailant> getEnemies() {
        return this.enemies;
    }
}
