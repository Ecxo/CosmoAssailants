/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

/**
 * Player in the game
 *
 * @author ptpihlaj
 */
public class Player {

    private int locationX;
    private int locationY;
    private boolean playerAlive;
    
    /**
     * Creates the player in the default starting position and sets
     * playerAlive = true.
     */

    public Player() {
        this.locationX = gameValues.ARENA_PLAYERSTARTPOS;
        this.locationY = gameValues.ARENA_BOTTOM_Y;
        playerAlive = true;

    }

    public int getLocationX() {
        return this.locationX;

    }

    public int getLocationY() {
        return this.locationY;
    }

    /**
     * tried to move the player to the specified direction if the player is not
     * already at wall
     *
     * @param direction
     */
    public void movePlayer(int direction) {
        //1 = right, 0 = left
        if (direction == 1 && !hitEdgeRight()) {
            this.locationX += gameValues.ARENA_STEPSIZE;
        }
        if (direction == 0 && !hitEdgeLeft()) {
            this.locationX -= gameValues.ARENA_STEPSIZE;
        }

    }

    /**
     * Checks if the player is touching arena's right wall
     *
     * @return boolean
     */
    public boolean hitEdgeRight() {
        if (this.locationX == gameValues.ARENA_REDGE_X) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the player is touching arena's left wall
     *
     * @return boolean
     */
    public boolean hitEdgeLeft() {
        if (this.locationX == gameValues.ARENA_LEDGE_X) {
            return true;
        }
        return false;
    }

    public void setAsDead() {
        this.playerAlive = false;
    }

    public boolean playerAlive() {
        return this.playerAlive;
    }

    public void setPlayerAlive() {
        this.playerAlive = true;
    }

    /**
     * Sets player to initial values.
     *
     */
    public void reset() {
        this.locationX = gameValues.ARENA_PLAYERSTARTPOS;
        this.locationY = gameValues.ARENA_BOTTOM_Y;
        playerAlive = true;
    }
}
