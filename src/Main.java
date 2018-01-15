

import model.Character.Character;
import model.Character.Knight;
import model.Monster.Monster;
import model.Monster.Skeleton;
import view.Combat;
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

        Monster skeleton = new Skeleton();
        Character testChar = new Knight();

        Combat combat = new Combat();
        combat.combatStart(skeleton,testChar);

    }
}
