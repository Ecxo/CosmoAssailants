/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CosmoAssailantTests;

import cosmoassailants.Gamelogic.DifficultyLevel;
import cosmoassailants.GraphicsUI.Cosmos;
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
public class DifficultyLevelTest {

    public DifficultyLevelTest() {
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
    public void shootingChanceIncreases() {
        Cosmos cosmos = new Cosmos();
        DifficultyLevel diff = new DifficultyLevel(cosmos);
        double difficulty = diff.getShootingChance();
        diff.increaseDifficulty();
        assertEquals(difficulty+0.005, diff.getShootingChance(), 0.0005);


    }
}