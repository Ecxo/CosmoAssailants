/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.GraphicsUI;

import cosmoassailants.Engine.ClickListener;
import cosmoassailants.Engine.Controls;
import cosmoassailants.Engine.InputScanner;
import cosmoassailants.Gamelogic.Enemy;
import cosmoassailants.Gamelogic.EnemyAssailant;
import cosmoassailants.Gamelogic.Laser;
import cosmoassailants.Gamelogic.LaserPlayer;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Contents of the game window
 *
 * @author ptpihlaj
 */
public class Window extends JPanel {

    private Cosmos cosmos;
    private InputScanner scanner;
    private JFrame scorePanel;
    private ActionListener listener;
    private JTextField playerName;

    public Window(Cosmos cosmos) {
        this.cosmos = cosmos;
        scanner = new InputScanner(this);


    }

    public void setCosmos(Cosmos cosmos) {
        this.cosmos = cosmos;
    }

    /**
     * Draws the game world if player alive, if player is dead draws gameOver
     * screen.
     *
     * @see #gameRunning(graphics)
     * @see #gameOver(graphics)
     * @param g
     */
    public void paint(Graphics g) {
        //super.paint(g);

        if (cosmos.getPlayer().playerAlive() == true) {
            super.paint(g);
            gameRunning(g);

        }

        if (cosmos.getPlayer().playerAlive() == false) {
            super.paint(g);
            gameOver(g);
        }

        getToolkit().sync();










    }

    /**
     * Paints the game world.
     *
     * @param g
     */
    public void gameRunning(Graphics g) {
        setBackground(Color.black);



        drawPlayer(g);

        drawLasers(g);

        drawEnemies(g);

        drawScore(g);

        drawLevel(g);








    }

    /**
     * Paints the lasers in the game world
     *
     * @param g
     */
    private void drawLasers(Graphics g) {
        for (Laser laser : cosmos.getLasers()) {
            g.setColor(Color.GREEN);
            if (laser.isHostile() == true) {
                g.setColor(Color.MAGENTA);
                g.fillRect(laser.laserX() + 10, laser.laserY(), 10, 20);

            }
            g.fillRect(laser.laserX() + 10, laser.laserY(), 10, 20);

        }

    }

    /**
     * Draws the enemies in the game world
     *
     * @param g
     */
    private void drawEnemies(Graphics g) {
        g.setColor(Color.BLUE);

        for (Enemy enemy : cosmos.getEnemies()) {
            if (enemy.isAlive() == true) {
                g.fill3DRect(enemy.getLocationX() + 5, enemy.getLocationY(), 20, 20, true);
            }

        }
    }

    /**
     * Draws the player in the game world.
     *
     * @param g
     */
    private void drawPlayer(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(cosmos.getPlayer().getLocationX(), cosmos.getPlayer().getLocationY(), 30, 30);
    }

    /**
     * Draws the score.
     *
     * @param g
     */
    private void drawScore(Graphics g) {
        g.setColor(Color.RED);
        Font scoreFont = new Font("Arial Black", Font.PLAIN, 20);
        g.setFont(scoreFont);
        g.drawString("Score: " + this.cosmos.getScoring().getScore(), 50, 50);
    }

    /**
     * Draws the gameOver screen.
     *
     * @param g
     */
    private void gameOver(Graphics g) {

        g.setColor(Color.RED);
        Font scoreFont = new Font("Arial Black", Font.PLAIN, 40);
        g.setFont(scoreFont);
        g.drawString("Game over! You lose!", 100, 100);
        g.drawString("Your score: " + this.cosmos.getScoring().getScore(), 100, 200);
        g.drawString("You reached level : " + this.cosmos.getLevel().getLevel(), 100, 300);
        if (this.scorePanel == null) {
            highScoreScreen();
        }


    }

    /**
     * Draws the level number
     *
     * @param g
     */
    private void drawLevel(Graphics g) {
        g.setColor(Color.RED);
        Font scoreFont = new Font("Arial Black", Font.PLAIN, 20);
        g.setFont(scoreFont);
        g.drawString("Level: " + this.cosmos.getLevel().getLevel(), 700, 50);

    }

    /**
     * Opens a new window.
     */
    public void highScoreScreen() {
        scorePanel = new JFrame("Scores");


        scorePanel.setPreferredSize(new Dimension(400, 400));
        scorePanel.setResizable(false);
        scorePanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        scoreScreenComponents(scorePanel);



        scorePanel.pack();
        scorePanel.setVisible(true);

    }

    /**
     * Creates components of the highScoreScreen window.
     *
     * @param container
     */
    private void scoreScreenComponents(Container container) {
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(10, 2);
        panel.setLayout(grid);
        panel.setBackground(Color.lightGray);

        listener = new ClickListener(this.cosmos, this.scorePanel);


        panel.add(new JLabel("Hall of Fame", JLabel.CENTER));


        panel.add(new JLabel(""));
        panel.add(new JLabel("Player:", JLabel.CENTER));
        panel.add(new JLabel("Score:" , JLabel.CENTER));
        panel.add(new JLabel(this.cosmos.getScoring().getHighScore().getPlayerNameScore(1)[0], JLabel.CENTER));
        panel.add(new JLabel(this.cosmos.getScoring().getHighScore().getPlayerNameScore(1)[1], JLabel.CENTER));
        panel.add(new JLabel(this.cosmos.getScoring().getHighScore().getPlayerNameScore(2)[0], JLabel.CENTER));
        panel.add(new JLabel(this.cosmos.getScoring().getHighScore().getPlayerNameScore(2)[1], JLabel.CENTER));
        panel.add(new JLabel(this.cosmos.getScoring().getHighScore().getPlayerNameScore(3)[0], JLabel.CENTER));
        panel.add(new JLabel(this.cosmos.getScoring().getHighScore().getPlayerNameScore(3)[1], JLabel.CENTER));
        panel.add(new JLabel(this.cosmos.getScoring().getHighScore().getPlayerNameScore(4)[0], JLabel.CENTER));
        panel.add(new JLabel(this.cosmos.getScoring().getHighScore().getPlayerNameScore(4)[1], JLabel.CENTER));
        panel.add(new JLabel(this.cosmos.getScoring().getHighScore().getPlayerNameScore(5)[0], JLabel.CENTER));
        panel.add(new JLabel(this.cosmos.getScoring().getHighScore().getPlayerNameScore(5)[1], JLabel.CENTER));
        panel.add(new JLabel(cosmos.getScoring().getHighScore().newRecordCheck()));
        panel.add(new JLabel(""));
        
        playerName = new JTextField("Write here");
        playerName.setActionCommand(ClickListener.Actions.SAVESCORE.name());
        playerName.addActionListener(listener);
        
        panel.add(playerName);

        JButton saveScore = new JButton("Save & Restart");
        saveScore.setActionCommand(ClickListener.Actions.SAVESCORE.name());
        saveScore.addActionListener(listener);
        panel.add(saveScore);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        

//        JButton newGame = new JButton("New Game");
////        newGame.setActionCommand(ClickListener.Actions.NEWGAME.name());
////        newGame.addActionListener(listener);
//        panel.add(newGame);



        container.add(panel);

    }

    public void resetScorePanel() {
        this.scorePanel = null;
    }
    
    public JTextField getPlayerTextField() {
        return this.playerName;
    }
}
