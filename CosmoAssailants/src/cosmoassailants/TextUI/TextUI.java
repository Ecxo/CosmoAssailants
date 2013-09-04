/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.TextUI;

import cosmoassailants.gamelogic.Arena;

/**
 *
 * @author ptpihlaj
 */
public class TextUI {

    private Arena arena;
    private PrintArena printArena;

    public TextUI(Arena arena) {
        this.arena = arena;
        this.printArena = new PrintArena(this.arena);

    }

    public String printLocations() {
        String locations = printArena.printEnemyLocations();
        return locations;
    }
}
