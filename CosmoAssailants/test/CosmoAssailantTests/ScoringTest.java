/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CosmoAssailantTests;

import cosmoassailants.Gamelogic.Enemy;
import cosmoassailants.Gamelogic.EnemyAssailant;
import cosmoassailants.Gamelogic.Scoring;
import cosmoassailants.Gamelogic.gameValues;
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
public class ScoringTest {

    Cosmos cosmos;

    public ScoringTest() {
        Cosmos cosmos = new Cosmos();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Cosmos cosmos = new Cosmos();


    }

    @After
    public void tearDown() {
    }

    @Test
    public void loseScoreWhenPlayerShoots() {
        Cosmos cosmos = new Cosmos();
        int score = cosmos.getScoring().getScore();
        cosmos.shootLaser();
        cosmos.shootLaser();
        cosmos.shootLaser();

        assertEquals(score - 30, cosmos.getScoring().getScore());


    }
    
    @Test
    public void gainScoreWhenEnemyKilled() {
        Cosmos cosmos = new Cosmos();
        
        int x = cosmos.getPlayer().getLocationX();
        cosmos.getEnemies().add(new EnemyAssailant(x, gameValues.ARENA_TOP_Y));
        
        cosmos.shootLaser();
        assertEquals(90, cosmos.getScoring().getScore());
        for (int i = 0; i <50 ; i++) {
        cosmos.getLasers().get(0).travel(); 
        }
        assertEquals(140, cosmos.getScoring().getScore());
        
        
        
    }

}