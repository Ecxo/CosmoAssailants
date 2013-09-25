package cosmoassailants;

import cosmoassailants.Engine.GameEngine;
import cosmoassailants.GraphicsUI.Cosmos;
import cosmoassailants.GraphicsUI.GraphicsUI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class CosmoAssailants {

    public static void main(String[] args) {
        Cosmos cosmos = new Cosmos();

        GraphicsUI ui = new GraphicsUI(cosmos);
        SwingUtilities.invokeLater(ui);

        GameEngine engine = new GameEngine(ui, cosmos);
        engine.start();


    }
}
