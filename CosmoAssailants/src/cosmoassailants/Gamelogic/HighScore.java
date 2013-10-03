/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Gamelogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creates a new file name /scores.txt in which the game saves scores.
 *
 * @author ptpihlaj
 */
public class HighScore {

    private final File scores = new File("CosmoAssailants/scores.txt");
    private Scoring scoring;
    private Scanner fileReader;

    public HighScore(Scoring s) {
        scores.getParentFile().mkdirs();
        this.scoring = s;
        try {
            scores.createNewFile();
            FileWriter fwriter = new FileWriter(scores, true);
            if (scores.length() < 5) {
                populateScoreList();
            }

            fwriter.close();
        } catch (IOException ex) {
            Logger.getLogger(HighScore.class.getName()).log(Level.SEVERE, null, ex);
        }




    }

    /**
     * Writes the players name and his score to the score file.
     *
     * @param playername
     */
    public void writeScore(String playername) {
        System.out.println(scores.getAbsoluteFile());
        if (playername.trim().length() < 1 || playername.equals("Write here") || playername.trim().length() > 20) {
            System.out.println("Not saved, bad name!");
            return;
        }


        try {
            FileWriter fwriter = new FileWriter(scores, true);
            PrintWriter write = new PrintWriter(fwriter);
            write.append("" + playername + "#" + scoring.getScore() + "\n");
            fwriter.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String getBestScore() {
        return null;

    }

    /**
     * Compares all the lines in the score file and finds the 5 best players,
     * returns a String[].
     *
     *
     *
     * @param rank which highest score and name you want to receive.
     * @return String[0] player name, String[1] player score
     */
    public String[] getPlayerNameScore(int rank) {
        try {
            fileReader = new Scanner(this.scores);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HighScore.class.getName()).log(Level.SEVERE, null, ex);
        }

        String returnedName[] = {"a", "b"};
        String name1 = "";
        String name2 = "";
        String name3 = "";
        String name4 = "";
        String name5 = "";
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        int score4 = 0;
        int score5 = 0;

        while (fileReader.hasNextLine()) {
            String[] bestPlayer = fileReader.nextLine().split("#");
            String playerName = bestPlayer[0];
            int playerScore = Integer.parseInt(bestPlayer[1]);
            if (score1 < playerScore) {
                score1 = playerScore;
                name1 = playerName;
            } else if (score2 < playerScore) {
                score2 = playerScore;
                name2 = playerName;
            } else if (score3 < playerScore) {
                score3 = playerScore;
                name3 = playerName;
            } else if (score4 < playerScore) {
                score4 = playerScore;
                name4 = playerName;
            } else if (score5 < playerScore) {
                score5 = playerScore;
                name5 = playerName;

            }
        }
        switch (rank) {
            case 1:
                returnedName[0] = name1;
                returnedName[1] = "" + score1;
                break;
            case 2:
                returnedName[0] = name2;
                returnedName[1] = "" + score2;
                break;
            case 3:
                returnedName[0] = name3;
                returnedName[1] = "" + score3;
                break;
            case 4:
                returnedName[0] = name4;
                returnedName[1] = "" + score4;
                break;
            case 5:
                returnedName[0] = name5;
                returnedName[1] = "" + score5;
                break;

        }


        return returnedName;
    }

    /**
     * If score list is empty, creates fake records.
     */
    private void populateScoreList() {


        try {
            FileWriter fwriter = new FileWriter(scores, true);
            PrintWriter write = new PrintWriter(fwriter);
            write.append("Paul" + "#" + 500 + "\n");
            write.append("John" + "#" + 400 + "\n");
            write.append("George" + "#" + 300 + "\n");
            write.append("Ringo" + "#" + 200 + "\n");
            write.append("Eino" + "#" + 100 + "\n");
            fwriter.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Compares score to the old scores and gives a cheerful text
     *
     * @return
     */
    public String newRecordCheck() {
        String record = "No record, try again!";

        if (Integer.parseInt(getPlayerNameScore(1)[1]) < this.scoring.getScore()) {
            record = "New best score!";

        } else if (Integer.parseInt(getPlayerNameScore(2)[1]) < this.scoring.getScore()) {
            record = "Second best score!";

        } else if (Integer.parseInt(getPlayerNameScore(3)[1]) < this.scoring.getScore()) {
            record = "Third best score!";

        } else if (Integer.parseInt(getPlayerNameScore(4)[1]) < this.scoring.getScore()) {
            record = "Fourth best score!";

        } else if (Integer.parseInt(getPlayerNameScore(5)[1]) < this.scoring.getScore()) {
            record = "Fifth best score!";

        }

        return record;




    }
}
