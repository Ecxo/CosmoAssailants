package cosmoassailants;

import cosmoassailants.GraphicsUI.GraphicsUI;
import cosmoassailants.TextUI.TextUI;
import cosmoassailants.gamelogic.Arena;
import javax.swing.SwingUtilities;

public class CosmoAssailants {

    public static void main(String[] args) {
        GraphicsUI gui = new GraphicsUI();
        SwingUtilities.invokeLater(gui);
    }
}
