/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

/**
 *
 * @author ptpihlaj
 */
public class Player {

    private int locationX;
    private int locationY;
    private boolean playerAlive;

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

    public void movePlayer(int direction) {
        //1 = right, 0 = left
        if (direction == 1 && !hitEdgeRight()) {
            this.locationX += gameValues.ARENA_STEPSIZE;
        }
        if (direction == 0 && !hitEdgeLeft()) {
            this.locationX -= gameValues.ARENA_STEPSIZE;
        }

    }

    public boolean hitEdgeRight() {
        if (this.locationX == 700) {
            return true;
        }
        return false;
    }

    public boolean hitEdgeLeft() {
        if (this.locationX == 100) {
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

    public void reset() {
        this.locationX = gameValues.ARENA_PLAYERSTARTPOS;
        this.locationY = gameValues.ARENA_BOTTOM_Y;
        playerAlive = true;
    }
}
