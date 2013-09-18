/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CosmoAssailantTests;

import cosmoassailants.GraphicsUI.Cosmos;
import cosmoassailants.Gamelogic.Enemy;
import cosmoassailants.Gamelogic.EnemyAssailant;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ptpihlaj
 */
public class EnemyAssailantTest {

    public EnemyAssailantTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void assailantCanMove() {
        Enemy enemyTest = new EnemyAssailant(400, 100) {
        };
        int enemyStartX = enemyTest.getLocationX();
        int enemyStartY = enemyTest.getLocationY();
        enemyTest.setMoveSpeed(1); // To make enemies move every update
        enemyTest.move();
        enemyTest.move();
        assertEquals(enemyStartX + 20 + 20, enemyTest.getLocationX());
    }

    @Test
    public void assailantCanNotMoveThroughWall() {
        Cosmos cosmos = new Cosmos();
        Enemy enemy = cosmos.getEnemies().get(0);
        enemy.setMoveSpeed(1);
        int enemyLocation = enemy.getLocationX();
        int distancetoEdge = Math.abs(enemyLocation - 700);
        System.out.println(distancetoEdge);
        distancetoEdge = distancetoEdge / 20;
        int distancetoEdge2 = distancetoEdge;
        int distancetoEdge3 = distancetoEdge;
        System.out.println(distancetoEdge);

        while (distancetoEdge != -0) {
            enemy.move();
            distancetoEdge--;
        }
        assertEquals(700, enemy.getLocationX());

        enemy.move();

        assertEquals(700, enemy.getLocationX());

        enemy.move();
        
        assertEquals(680, enemy.getLocationX());


    }
}