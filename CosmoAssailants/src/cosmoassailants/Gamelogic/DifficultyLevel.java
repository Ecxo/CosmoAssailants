/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

import cosmoassailants.GraphicsUI.Cosmos;
import java.util.ArrayList;

/**
 * Creates lists of enemies and sets their shooting speed and amount
 * 
 * @author ptpihlaj
 */
public class DifficultyLevel {

    private int numberofEnemies;
    private double shootingChance = 0.005;
    private double shootingChanceIncrease = 0.005;
    private int levelNumber;
    private Cosmos cosmos;
    private ArrayList<Enemy> randomEnemies;
    
    /**
     * Constructor that sets initial difficulty related values
     * 
     * 
     * @param cosmos 
     */
    

    public DifficultyLevel(Cosmos cosmos) {
        this.cosmos = cosmos;
        levelNumber = 1;
        shootingChance = 0.005;
        numberofEnemies = 4;
        this.randomEnemies = new ArrayList<Enemy>();
        this.randomEnemies.addAll(createListEnemies(numberofEnemies));





    }

    public ArrayList<Enemy> getListEnemies() {
        return this.randomEnemies;

    }

    /**
     * Creates an ArrayList<Enemy> with the specified number of enemies.
     *
     * @param enemies number of enemies to generate for the list.
     *
     * @return ArrayList<Enemy> containing specified number of enemies
     */
    public ArrayList<Enemy> createListEnemies(int enemies) {
        ArrayList<Enemy> list = new ArrayList<>();

        int yCounter = gameValues.ARENA_TOP_Y;
        int xCounter = 0;
        for (int i = 0; i < enemies; i++) {
            int x = gameValues.ARENA_LEDGE_X + (xCounter * 60);
            xCounter++;
            int y = yCounter;


            if (x >= gameValues.ARENA_REDGE_X) {

                yCounter += gameValues.ARENA_STEPSIZE * 4;
                xCounter = 0;

            }


            EnemyAssailant createdEnemy = new EnemyAssailant(x, y);
            createdEnemy.setEnemyShootingChance(this.shootingChance);

            list.add(createdEnemy);

            System.out.println(list.size());



        }



        return list;



    }

    /**
     * Increases enemy shooting change by preset amount Increases level count by
     * 1 Increases number of enemies by 1
     *
     *
     */
    public void increaseDifficulty() {
        this.levelNumber++;
        this.numberofEnemies += 1;
        this.shootingChance += shootingChanceIncrease;

    }

    public double getShootingChance() {
        return this.shootingChance;
    }

    public int getLevel() {
        return this.levelNumber;
    }

    public int getEnemyNumber() {
        return this.numberofEnemies;
    }

    /**
     * Resets all difficulty values to initial values
     * 
     */
    public void reset() {
        this.cosmos = cosmos;
        levelNumber = 1;
        shootingChance = 0.005;
        numberofEnemies = 4;
        this.randomEnemies = new ArrayList<Enemy>();
        this.randomEnemies.addAll(createListEnemies(numberofEnemies));


    }
}
