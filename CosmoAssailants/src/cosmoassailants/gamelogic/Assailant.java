/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.gamelogic;

/**
 *
 * @author ptpihlaj
 */
public class Assailant implements Object {

    private int locationX;
    private int locationY;
    private boolean directionRight;

    public Assailant(int x) {
        this.locationX = x;
        this.locationY = 0;
        this.directionRight = true;
    }

    @Override
    public int getLocationX() {
        return this.locationX;
    }

    @Override
    public int getLocationY() {
        return this.locationY;

    }
    
    @Override
    public void moveObject() {
        if (this.directionRight = true) {
            this.locationX++;
            } else {
            this.locationY--;
        }
       
    }
    
    
    
}
