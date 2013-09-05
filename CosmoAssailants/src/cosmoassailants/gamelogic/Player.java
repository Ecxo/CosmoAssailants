/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.gamelogic;

/**
 *
 * @author ptpihlaj
 */
public class Player implements Object {

    private int locationX;
    private int locationY;

    public Player() {
        this.locationX = 40;
        this.locationY = 40;

    }

    public int getLocationX() {
        return this.locationX;

    }

    public int getLocationY() {
        return this.locationY;
    }

    public void moveObject() { // Get rid of this
    }

    public void movePlayerRight() {
        this.locationX++;
    }

    public void movePlayerLeft() {
        this.locationY--;
    }
}
