/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CosmoAssailantsTests;

import cosmoassailants.Gamelogic.Player;
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
public class PlayerTest {

    Player player;

    public PlayerTest() {
        player = new Player();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        player = new Player();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void playerCanMoveBothDirections() {

        assertEquals(400, player.getLocationX());
        assertEquals(500, player.getLocationY());

        player.movePlayer(1);

        assertEquals(420, player.getLocationX());
        assertEquals(500, player.getLocationY());

        player.movePlayer(0);
        player.movePlayer(0);

        assertEquals(380, player.getLocationX());
        assertEquals(500, player.getLocationY());

    }

    @Test
    public void playerCanNotMoveThroughEdgeRight() {

        assertEquals(400, player.getLocationX());
        assertEquals(500, player.getLocationY());

        for (int i = 1; i < 30; i++) {
            player.movePlayer(1);
        }

        assertEquals(700, player.getLocationX());
        assertEquals(500, player.getLocationY());



    }

    @Test
    public void playerCanNotMoveThroughEdgeLeft() {

        assertEquals(400, player.getLocationX());
        assertEquals(500, player.getLocationY());

        for (int i = 1; i < 30; i++) {
            player.movePlayer(0);
        }

        assertEquals(100, player.getLocationX());
        assertEquals(500, player.getLocationY());



    }
}