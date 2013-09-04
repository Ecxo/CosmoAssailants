/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants;

import cosmoassailants.TextUI.TextUI;
import cosmoassailants.gamelogic.Arena;

/**
 *
 * @author ptpihlaj
 */
public class CosmoAssailants {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Arena arena = new Arena(5);
        TextUI textUI = new TextUI(arena);
        System.out.println(textUI.printLocations());
        arena.moveObjects();
        System.out.println(textUI.printLocations());

        // TODO code application logic here
    }
}
