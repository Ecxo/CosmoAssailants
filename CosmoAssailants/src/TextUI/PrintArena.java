/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TextUI;

import cosmoassailants.gamelogic.Arena;
import cosmoassailants.gamelogic.Object;
import java.util.ArrayList;

/**
 *
 * @author ptpihlaj
 */
public class PrintArena {

    Arena arena;

    public PrintArena(Arena arena) {
        this.arena = arena;

    }

    public String printEnemyLocations() {


        String locations = "Enemies spotted at:\n";
        for (Object e : this.arena.objectsAt()) {
            locations += "[" + e.getLocationX() + "," + e.getLocationY() + "]";
            locations += "\n";



        }

        return locations;

    }
}
