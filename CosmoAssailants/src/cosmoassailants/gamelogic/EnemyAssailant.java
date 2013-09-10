
package cosmoassailants.gamelogic;

public class EnemyAssailant implements Object {
    
    private int locationX;
    private int locationY;
    
    public EnemyAssailant(int x, int y) {
        this.locationX = x;
        this.locationY = y;
    }
    
    
    


    @Override
    public int getLocationX() {
        return this.locationX;
    }


    @Override
    public int getLocationY() {
        return this.locationY;
    }
    
}



    
    
    


