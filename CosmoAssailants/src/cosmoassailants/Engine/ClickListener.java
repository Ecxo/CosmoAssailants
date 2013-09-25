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
 *
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == Actions.NEWGAME.name()) {
            System.out.println("new game");
            cosmos.restartCosmos();
            frame.dispose();
            


            

            
        }
    }
}
