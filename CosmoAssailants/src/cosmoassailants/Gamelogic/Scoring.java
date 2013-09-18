/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

/**
 *
 * @author ptpihlaj
 */
public class Scoring {
    private int score;
    
    public Scoring() {
        this.score = 100;
        
    }
    
    public void increaseScore() {
        this.score += 50;
        
    }

    public int getScore() {
        return this.score;
    }

    public void loseScoreShot() {
        this.score -= 10;
    }
    
    }
