/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.gamelogic;

/**
 *
 * @author ptpihlaj
 */
public class Player {

    private int locationX;
    private int locationY;

    public Player() {
        this.locationX = 400;
        this.locationY = 700;

    }

    public int getLocationX() {
        return this.locationX;

    }

    public int getLocationY() {
        return this.locationY;
    }

    public void movePlayerRight() {
        if (hitEdgeRight() == false) {
            this.locationX += 20;
        }

    }

    public void movePlayerLeft() {
        if (hitEdgeLeft() == false) {
            this.locationX -= 20;
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
}
