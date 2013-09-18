/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.GraphicsUI;

import cosmoassailants.Gamelogic.DifficultyLevel;
import cosmoassailants.Gamelogic.Enemy;
import cosmoassailants.Gamelogic.EnemyAssailant;
import cosmoassailants.Gamelogic.Laser;
import cosmoassailants.Gamelogic.LaserEnemy;
import cosmoassailants.Gamelogic.LaserPlayer;
import cosmoassailants.Gamelogic.Player;
import cosmoassailants.Gamelogic.Scoring;
import java.util.ArrayList;

/**
 *
 * @author ptpihlaj
 */
public class Cosmos {

    private Player player;
    private ArrayList<Laser> lasers;
    private ArrayList<Enemy> enemies;
    private Scoring score;
    private DifficultyLevel level;

    public Cosmos() {
        this.player = new Player();
        this.lasers = new ArrayList<>();
        this.score = new Scoring();

        this.level = new DifficultyLevel(this);
        this.enemies = new ArrayList<Enemy>();
        this.enemies.addAll(level.getListEnemies());

    }

    public Player getPlayer() {
        return this.player;
    }

    public ArrayList<Laser> getLasers() {
        return this.lasers;

    }

    public void shootLaser() {
        this.lasers.add(new LaserPlayer(this.player.getLocationX(), this.player.getLocationY(), this));
        this.score.loseScore();
        System.out.println(this.enemies.size());
    }

    public void updateGame() {



            for (Enemy enemy : this.enemies) {
                enemy.move();
                if (enemy.enemyCanShoot() && enemy.isAlive()) {
                    this.lasers.add(new LaserEnemy(enemy, player));
                }

            }
            for (Laser laser : this.lasers) {
                laser.travel();
            }
            
            while (enemiesLeft() == false) {
                level.increaseDifficulty();
                this.enemies = level.createListEnemies(level.getEnemyNumber());
                
            }


    }

    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }

    public Scoring getScoring() {
        return this.score;
    }

    public boolean enemiesLeft() {
        for (Enemy enemy : this.enemies) {
            if (enemy.isAlive()) {
                return true;
            }
        }
        return false;
    }
    
    public DifficultyLevel getLevel() {
        return this.level;
    }
}
