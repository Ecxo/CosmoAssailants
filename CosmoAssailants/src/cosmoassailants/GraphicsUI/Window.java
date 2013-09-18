/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.GraphicsUI;

import cosmoassailants.Gamelogic.Enemy;
import cosmoassailants.Gamelogic.EnemyAssailant;
import cosmoassailants.Gamelogic.Laser;
import cosmoassailants.Gamelogic.LaserPlayer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author ptpihlaj
 */
public class Window extends JPanel {

    private Cosmos cosmos;

    public Window(Cosmos cosmos) {
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
    }

    private void drawLevel(Graphics g) {
        g.setColor(Color.RED);
        Font scoreFont = new Font("Arial Black", Font.PLAIN, 20);
        g.setFont(scoreFont);
        g.drawString("Level: " + this.cosmos.getLevel().getLevel(), 700, 50);

    }
}
