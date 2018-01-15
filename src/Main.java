

import view.Menu;
import view.Text;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Testing execution flow from this point
        Text intro = new Text();
        intro.intro();
        Menu mainMenu = new Menu();
        mainMenu.runMainMenu();

        System.out.println("SPELET STARTAS!");

    }
}
