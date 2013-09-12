package CosmoAssailantTests;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import cosmoassailants.GraphicsUI.Cosmos;
import cosmoassailants.gamelogic.Enemy;
import cosmoassailants.gamelogic.EnemyAssailant;
import cosmoassailants.gamelogic.Laser;
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
public class LaserTest {

    public LaserTest() {
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
    public void laserMoves() {
        Cosmos cosmos = new Cosmos();
        Laser laser = new Laser(400, cosmos);
        assertEquals(400, laser.laserX());
        assertEquals(700, laser.laserY());
        laser.travel();
        assertEquals(680, laser.laserY());
        assertEquals(400, laser.laserX());

    }

    @Test
    public void laserKillsEnemy() {
        Cosmos cosmos = new Cosmos();
        int firstEnemyX = cosmos.getEnemies().get(0).getLocationX();
        Laser laser = new Laser(firstEnemyX, cosmos);
        assertEquals(true, cosmos.getEnemies().get(0).isAlive());
        for (int i = 1; i < 35; i++) {
            laser.travel();
        }
        assertEquals(false, cosmos.getEnemies().get(0).isAlive());


    }
}