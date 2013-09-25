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
 *
 * @author ptpihlaj
 */
public class Window extends JPanel {

    private Cosmos cosmos;
    private InputScanner scanner;
    private JFrame scorePanel;
    private ActionListener listener;

    public Window(Cosmos cosmos) {
        this.cosmos = cosmos;
        scanner = new InputScanner(this);


    }
    
    public void setCosmos (Cosmos cosmos) {
        this.cosmos = cosmos;
    }

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

    public void gameRunning(Graphics g) {
        setBackground(Color.black);



        drawPlayer(g);

        drawLasers(g);

        drawEnemies(g);

        drawScore(g);

        drawLevel(g);
        







    }

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

    private void drawEnemies(Graphics g) {
        g.setColor(Color.BLUE);

        for (Enemy enemy : cosmos.getEnemies()) {
            if (enemy.isAlive() == true) {
                g.fill3DRect(enemy.getLocationX() + 5, enemy.getLocationY(), 20, 20, true);
            }

        }
    }

    private void drawPlayer(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(cosmos.getPlayer().getLocationX(), cosmos.getPlayer().getLocationY(), 30, 30);
    }

    private void drawScore(Graphics g) {
        g.setColor(Color.RED);
        Font scoreFont = new Font("Arial Black", Font.PLAIN, 20);
        g.setFont(scoreFont);
        g.drawString("Score: " + this.cosmos.getScoring().getScore(), 50, 50);
    }

    private void gameOver(Graphics g) {
        
        g.setColor(Color.RED);
        Font scoreFont = new Font("Arial Black", Font.PLAIN, 40);
        g.setFont(scoreFont);
        g.drawString("Game over! You lose!", 100, 100);
        g.drawString("Your score: " + this.cosmos.getScoring().getScore(), 100, 200);
        g.drawString("You reached level : " + this.cosmos.getLevel().getLevel(), 100, 300);
        highScoreScreen();

    }

    private void drawLevel(Graphics g) {
        g.setColor(Color.RED);
        Font scoreFont = new Font("Arial Black", Font.PLAIN, 20);
        g.setFont(scoreFont);
        g.drawString("Level: " + this.cosmos.getLevel().getLevel(), 700, 50);

    }

    public void highScoreScreen() {
        scorePanel = new JFrame("Scores");


        scorePanel.setPreferredSize(new Dimension(400, 400));
        scorePanel.setResizable(false);
        scorePanel.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        scoreScreenComponents(scorePanel);



        scorePanel.pack();
        scorePanel.setVisible(true);

    }

    private void scoreScreenComponents(Container container) {
        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(10, 2);
        panel.setLayout(grid);

        listener = new ClickListener(this.cosmos, this.scorePanel);


        panel.add(new JLabel("Hall of Fame"));


        panel.add(new JLabel("2"));
        panel.add(new JLabel("3"));
        panel.add(new JLabel("4"));
        panel.add(new JLabel("5"));
        panel.add(new JLabel("6"));
        panel.add(new JLabel("7"));
        panel.add(new JLabel("8"));
        panel.add(new JLabel("9"));
        panel.add(new JLabel("10"));
        panel.add(new JLabel("11"));
        panel.add(new JLabel("12"));
        panel.add(new JLabel("13"));
        panel.add(new JLabel("14"));
        panel.add(new JLabel("New Record!"));
        panel.add(new JLabel("16"));
        panel.add(new JTextField("Enter name here"));
        panel.add(new JButton("Save"));

        JButton newGame = new JButton("New Game");
        newGame.setActionCommand(ClickListener.Actions.NEWGAME.name());
        newGame.addActionListener(listener);


        panel.add(newGame);

        panel.add(new JLabel("20"));


        container.add(panel);

    }
}
