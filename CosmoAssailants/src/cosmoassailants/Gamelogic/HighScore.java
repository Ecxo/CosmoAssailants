/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ptpihlaj
 */
public class HighScore {

    private final File scores = new File("scores.txt");
    private Scoring scoring;

    public HighScore(Scoring s) {
        this.scoring = s;


    }

    public void writeScore(String playername) {
        
        try {
            FileWriter fwriter = new FileWriter(scores, true);
            PrintWriter write = new PrintWriter(fwriter);
            write.append("" + playername + " | " + scoring.getScore() + "\n");
            fwriter.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
