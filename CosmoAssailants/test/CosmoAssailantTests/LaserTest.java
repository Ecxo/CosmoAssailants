package CosmoAssailantTests;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import cosmoassailants.GraphicsUI.Cosmos;
import cosmoassailants.gamelogic.Enemy;
import cosmoassailants.gamelogic.EnemyAssailant;
import cosmoassailants.gamelogic.LaserEnemy;
import cosmoassailants.gamelogic.LaserPlayer;
import cosmoassailants.gamelogic.Player;
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
    public void laserCanMove() {
        Cosmos cosmos = new Cosmos();
        LaserPlayer laser = new LaserPlayer(400, cosmos);

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

        LaserPlayer laser = new LaserPlayer(firstEnemyX, cosmos);

        assertEquals(true, cosmos.getEnemies().get(0).isAlive());

        for (int i = 1; i < 35; i++) {
            laser.travel();
        }
        assertEquals(false, cosmos.getEnemies().get(0).isAlive());


    }

    @Test
    public void laserKillsPlayer() {

        Enemy enemy = new EnemyAssailant (400,100);
        Player player = new Player();


        LaserEnemy laserEnemy = new LaserEnemy(enemy, player);

        assertEquals(true, player.playerAlive());

        for (int i = 1; i < 500; i++) {
            laserEnemy.travel();
            System.out.println(laserEnemy.laserY());
        }

        assertEquals(false, player.playerAlive());

    }
    
    @Test
    public void laserIsAddedToArrayList() {
        Cosmos cosmos = new Cosmos();
        
        assertEquals(0, cosmos.getLasers().size());
        cosmos.shootLaser();
        cosmos.shootLaser();
        cosmos.shootLaser();
        assertEquals(3, cosmos.getLasers().size());

    }
}