/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CosmoAssailantTests;

import cosmoassailants.GraphicsUI.Cosmos;
import cosmoassailants.gamelogic.Enemy;
import cosmoassailants.gamelogic.EnemyAssailant;
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
    public void assailantMoves() {
        Enemy enemyTest = new EnemyAssailant(400, 100) {
        };
        int enemyStartX = enemyTest.getLocationX();
        int enemyStartY = enemyTest.getLocationY();
        enemyTest.setMoveSpeed(1); // To make enemies move every update
        enemyTest.move();
        enemyTest.move();
        assertEquals(enemyStartX + 20 + 20, enemyTest.getLocationX());
    }
}