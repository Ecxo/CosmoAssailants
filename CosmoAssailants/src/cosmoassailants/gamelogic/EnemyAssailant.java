package cosmoassailants.gamelogic;

public class EnemyAssailant implements Object {

    private int locationX;
    private int locationY;
    private boolean movingRight;
    private int allowedToMove; // to slow down enemy movement

    public EnemyAssailant(int x, int y) {
        this.locationX = x;
        this.locationY = y;
        movingRight = true;
        allowedToMove = 1;

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

    public boolean allowedToMove() { //to slow down enemy movement
        if (allowedToMove == 10) {
            allowedToMove = 1;
            return true;
        } else {
            allowedToMove++;
            return false;



        }
    }
}
