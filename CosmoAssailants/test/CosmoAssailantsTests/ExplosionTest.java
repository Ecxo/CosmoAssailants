/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CosmoAssailantsTests;

import cosmoassailants.Gamelogic.Explosion;
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
public class ExplosionTest {

    Explosion explosion;

    public ExplosionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        explosion = new Explosion(50, 50);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void explosionEndsAfterThreeUpdates() {
        boolean exploding = explosion.getExploding();
        assertEquals(true, exploding);
        explosion.explode();
        exploding = explosion.getExploding();
        assertEquals(true, exploding);
        explosion.explode();
        explosion.explode();
        exploding = explosion.getExploding();
        assertEquals(false, exploding);
        
        
        
        
    }
}