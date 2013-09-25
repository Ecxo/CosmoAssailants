/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

import cosmoassailants.GraphicsUI.Cosmos;
import java.util.ArrayList;

/**
 *
 * @author ptpihlaj
 */
public class DifficultyLevel {

    private int numberofEnemies;
    private double shootingChance = 0.005;
    ;
    private int levelNumber;
    private Cosmos cosmos;
    private ArrayList<Enemy> randomEnemies;

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

    public void increaseDifficulty() {
        this.levelNumber++;
        this.numberofEnemies += 1;
        this.shootingChance += 0.003;

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

    public void reset() {
        this.cosmos = cosmos;
        levelNumber = 1;
        shootingChance = 0.005;
        numberofEnemies = 4;
        this.randomEnemies = new ArrayList<Enemy>();
        this.randomEnemies.addAll(createListEnemies(numberofEnemies));


    }
}
