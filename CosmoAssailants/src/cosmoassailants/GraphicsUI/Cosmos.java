/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.GraphicsUI;

import cosmoassailants.Gamelogic.Enemy;
import cosmoassailants.Gamelogic.EnemyAssailant;
import cosmoassailants.Gamelogic.Laser;
import cosmoassailants.Gamelogic.LaserEnemy;
import cosmoassailants.Gamelogic.LaserPlayer;
import cosmoassailants.Gamelogic.Player;
import java.util.ArrayList;

/**
 *
 * @author ptpihlaj
 */
public class Cosmos {

    private Player player;
    private ArrayList<Laser> lasers;
    private ArrayList<Enemy> enemies;

    public Cosmos() {
        this.player = new Player();
        this.lasers = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.enemies.add(new EnemyAssailant(100, 100));
        this.enemies.add(new EnemyAssailant(200, 100));
        this.enemies.add(new EnemyAssailant(300, 100));
        this.enemies.add(new EnemyAssailant(400, 100));
        this.enemies.add(new EnemyAssailant(500, 100));
        this.enemies.add(new EnemyAssailant(600, 100));
        this.enemies.add(new EnemyAssailant(700, 100));
        this.enemies.add(new EnemyAssailant(100, 200));
        this.enemies.add(new EnemyAssailant(700, 200));
        this.enemies.add(new EnemyAssailant(600, 200));
        this.enemies.add(new EnemyAssailant(200, 200));
    }

    public Player getPlayer() {
        return this.player;
    }

    public ArrayList<Laser> getLasers() {
        return this.lasers;

    }

    public void shootLaser() {
        this.lasers.add(new LaserPlayer(this.player.getLocationX(), this.player.getLocationY(), this));
        System.out.println(this.lasers.size());
    }

    public void updateGame() {
//        for (Laser laser : this.lasers) {
//            laser.travel();
//        }


        for (Enemy enemy : this.enemies) {
            enemy.move();
            if (enemy.enemyCanShoot() && enemy.isAlive()) {
                this.lasers.add(new LaserEnemy(enemy, player));
            }

        }
        for (Laser laser : this.lasers) {
            laser.travel();
        }
    }

    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }
}
