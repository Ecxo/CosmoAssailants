/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.GraphicsUI;

import cosmoassailants.Engine.GameEngine;
import cosmoassailants.Gamelogic.DifficultyLevel;
import cosmoassailants.Gamelogic.Enemy;
import cosmoassailants.Gamelogic.EnemyAssailant;
import cosmoassailants.Gamelogic.Explosion;
import cosmoassailants.Gamelogic.Laser;
import cosmoassailants.Gamelogic.LaserEnemy;
import cosmoassailants.Gamelogic.LaserPlayer;
import cosmoassailants.Gamelogic.Player;
import cosmoassailants.Gamelogic.Scoring;
import java.util.ArrayList;

/**
 * Graphics of the game world
 *
 * @author ptpihlaj
 */
public class Cosmos {

    private Player player;
    private ArrayList<Laser> lasers;
    private ArrayList<Enemy> enemies;
    private Scoring score;
    private DifficultyLevel level;
    private GameEngine engine;
    private ArrayList<Explosion> explosions;

    public Cosmos() {
        this.player = new Player();
        this.lasers = new ArrayList<>();
        this.score = new Scoring();

        this.level = new DifficultyLevel(this);
        this.enemies = new ArrayList<Enemy>();
        this.enemies.addAll(level.getListEnemies());
        this.explosions = new ArrayList<Explosion>();

    }

    /**
     * Resets everything to restart game
     */
    public void restartCosmos() {
        player.reset();
        lasers.clear();
        score.reset();

        level.reset();
        enemies.clear();
        enemies.addAll(level.getListEnemies());
        //engine.getUI().setKeyListener();
        //engine.getUI().getWindow().setCosmos(this);


    }

    public Player getPlayer() {
        return this.player;
    }

    public ArrayList<Laser> getLasers() {
        return this.lasers;

    }

    /**
     * Adds a new laser to the ArrayList when player shoots.
     */
    public void shootLaser() {
        this.lasers.add(new LaserPlayer(this.player.getLocationX(), this.player.getLocationY(), this));
        this.score.loseScoreShot();
    }

    /**
     * Updates all the objects in the game
     */
    public void updateGame() {
        if (this.player.playerAlive()) {




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





    }

    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }

    public Scoring getScoring() {
        return this.score;
    }

    /**
     * Checks if ArrayList contains any enemies that are still alive.
     *
     * @return boolean
     */
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

    /**
     * Kills every enemy on screen.
     */
    public void cheatButton() {
        for (Enemy enemy : this.enemies) {
            enemy.hasDied();
        }
    }

    public void setEngine(GameEngine eng) {
        this.engine = eng;
    }

    public GameEngine getEngine() {
        return this.engine;
    }

    public void newExplosion(Enemy enemy) {
        this.explosions.add(new Explosion(enemy.getLocationX(), enemy.getLocationY()));

    }

    public ArrayList<Explosion> getExplosions() {
        return this.explosions;
    }
}
