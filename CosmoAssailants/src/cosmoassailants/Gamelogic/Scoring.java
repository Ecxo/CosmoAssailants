/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

/**
 * Counts and increases player score
 * @author ptpihlaj
 */
public class Scoring {
    private int score;
    private HighScore highScore;
    
    public Scoring() {
        this.score = 100;
        highScore = new HighScore(this);
        
        
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
    
    public HighScore getHighScore() {
        return this.highScore;
    }

    public void reset() {
        this.score = 100;
    }
    
    }
