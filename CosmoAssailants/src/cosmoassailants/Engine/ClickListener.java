/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Engine;

import cosmoassailants.GraphicsUI.Cosmos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Listens mouse clicks in the end game screen
 * @author ptpihlaj
 */
public class ClickListener implements ActionListener {

    private Cosmos cosmos;
    private JFrame frame;

    public enum Actions {

        NEWGAME,
        SAVERECORD
    }

    public ClickListener(Cosmos cosmos, JFrame frame) {
        this.cosmos = cosmos;
        this.frame = frame;


    }
    
    /**
     * Actions based on which button clicked in end game screen.
     * @param e 
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == Actions.NEWGAME.name()) {
            System.out.println("new game");
            frame.dispose();
            cosmos.getEngine().getUI().getWindow().resetScorePanel();

            cosmos.restartCosmos();
            







        }
    }
}
