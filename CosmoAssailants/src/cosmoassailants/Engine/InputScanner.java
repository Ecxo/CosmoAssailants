/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoassailants.Engine;

import cosmoassailants.GraphicsUI.Window;
import java.util.Scanner;

/**
 *
 * @author ptpihlaj
 */
public class InputScanner {

    private Scanner scan;
    private Window window;

    public InputScanner(Window win) {
        scan = new Scanner(System.in);
        this.window = win;

    }

    public String InputPlayerName() {
        String playerName = scan.nextLine();
        while (playerName.length() > 10) {
            playerName = scan.nextLine();

        }
        return playerName;
        

    }
}
