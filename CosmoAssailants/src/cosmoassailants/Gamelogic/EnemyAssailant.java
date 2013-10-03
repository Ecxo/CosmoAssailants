package cosmoassailants.Gamelogic;

import cosmoassailants.Engine.FireRateTimer;
import java.util.Random;

/**
 * Basic enemy type
 *
 * @author ptpihlaj
 */
public class EnemyAssailant implements Enemy {

    private int locationX;
    private int locationY;
    private boolean movingRight;
    private int allowedToMove; // to slow down enemy movement
    private boolean isAlive;
    private int allowedToMoveMax = 10; //how many updates between enemy moves
    private FireRateTimer enemyTimer;
    private Random enemyShotRandomizer;
    private double enemyShotChance; // How often the enemy shoots;

    /**
     * Creates an enemy and gives it the specified coordinates
     *
     * @param x
     * @param y
     */
    public EnemyAssailant(int x, int y) {
        this.locationX = x;
        this.locationY = y;
        movingRight = true;
        allowedToMove = 1;
        this.isAlive = true;
        enemyTimer = new FireRateTimer();
        this.enemyShotRandomizer = new Random();
        this.enemyShotChance = 0.001;

    }

    @Override
    public int getLocationX() {
        return this.locationX;
    }

    @Override
    public int getLocationY() {
        return this.locationY;
    }

    /**
     * Tries to move enemy right or left based on boolean movingRight.
     *
     *
     * @see #moveLeft()
     * @see #moveDown()
     */
    public void move() {
        if (allowedToMove() == true) {
            if (movingRight == true) {
                moveRight();
            } else {
                moveLeft();
            }
        }
    }

    /**
     * Moves the enemy right if movingRight = true.
     *
     */
    private void moveRight() {
        if (hitEdgeRight() == true) {
            movingRight = false;
        } else {
            this.locationX += gameValues.ARENA_STEPSIZE;
        }
    }

    /**
     * Moves the enemy left if movingRight = false.
     *
     */
    private void moveLeft() {
        if (hitEdgeLeft() == true) {
            movingRight = true;
        } else {
            this.locationX -= gameValues.ARENA_STEPSIZE;
        }
    }

    /**
     * Checks if the enemy is trying to cross the edge of the arena. If at right
     * edge and going right, changes movement direction and moves enemy
     * downwards.
     *
     * @see #moveDown()
     * @return boolean true if enemy is at right edge
     */
    public boolean hitEdgeRight() {
        if (this.locationX == gameValues.ARENA_REDGE_X) {
            moveDown();
            return true;
        }
        return false;
    }

    /**
     * Checks if the enemy is trying to cross the edge of the arena. If at left
     * edge and going left, changes movement direction and moves enemy
     * downwards.
     *
     * @see #moveDown()
     * @return boolean true if enemy is at left edge
     */
    public boolean hitEdgeLeft() {
        if (this.locationX == gameValues.ARENA_LEDGE_X) {
            moveDown();
            return true;
        }
        return false;
    }
    
    /**
     * Checks if enemy is allowed to move by comparing allowedToMove
     * to allowedToMoveMax, if false increases allowedToMove by one.
     * @return boolean
     */

    public boolean allowedToMove() { //to slow down enemy movement
        if (allowedToMove == allowedToMoveMax) {
            allowedToMove = 1;
            return true;
        } else {
            allowedToMove++;
            return false;



        }
    }

    public void setMoveSpeed(int s) {
        this.allowedToMoveMax = s;

    }

    public void hasDied() {
        this.isAlive = false;

    }

    public boolean isAlive() {
        return this.isAlive;
    }
    
    /**
     * moves enemy downward 2 * ARENA_STEPSIZE
     */

    public void moveDown() {
        if (this.locationY < 400) {
        this.locationY += gameValues.ARENA_STEPSIZE * 2;
        }
        
    }
    
    /**
     * Creates a random number and compares it to shooting chance,
     * if random is smaller returns true
     * @return boolean
     */

    public boolean enemyCanShoot() {
        double random = enemyShotRandomizer.nextDouble();
        if (random < this.enemyShotChance) {
            return true;
        }
        return false;



    }

    public void setEnemyShootingChance(double chance) {
        this.enemyShotChance = chance;
    }
}
