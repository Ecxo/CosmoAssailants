package cosmoassailants.gamelogic;

public class EnemyAssailant implements Object {

    private int locationX;
    private int locationY;
    private boolean movingRight;
    private int allowedToMove; // to slow down enemy movement
    private boolean isAlive;

    public EnemyAssailant(int x, int y) {
        this.locationX = x;
        this.locationY = y;
        movingRight = true;
        allowedToMove = 1;
        this.isAlive = true;

    }

    @Override
    public int getLocationX() {
        return this.locationX;
    }

    @Override
    public int getLocationY() {
        return this.locationY;
    }

    public void move() {
        if (allowedToMove() == true) {
            if (movingRight == true) {
                moveRight();
            } else {
                moveLeft();
            }
        }
    }

    private void moveRight() {
        if (hitEdgeRight() == true) {
            movingRight = false;
        } else {
            this.locationX += 20;
        }
    }

    private void moveLeft() {
        if (hitEdgeLeft() == true) {
            movingRight = true;
        } else {
            this.locationX -= 20;
        }
    }

    public boolean hitEdgeRight() {
        if (this.locationX == 700) {
            moveDown();
            return true;
        }
        return false;
    }

    public boolean hitEdgeLeft() {
        if (this.locationX == 100) {
            moveDown();
            return true;
        }
        return false;
    }

    public boolean allowedToMove() { //to slow down enemy movement
        if (allowedToMove == 1) {
            allowedToMove = 1;
            return true;
        } else {
            allowedToMove++;
            return false;



        }
    }

    public void hasDied() {
        this.isAlive = false;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void moveDown() {
        this.locationY +=20;
    }
}
