

import model.Adventure;
import model.Character.Character;
import model.Character.Knight;
import model.Character.Thief;
import model.Monster.Monster;
import model.Monster.Skeleton;
import view.Combat;
//import view.Menu;
import view.Text;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Testing execution flow from this point
//        Text intro = new Text();
//        intro.intro();
//
//      Menu mainMenu = new Menu();
        //mainMenu.runMainMenu();

        Thief thief= new Thief();


        Adventure newadventure =new Adventure(1,1);
        newadventure.setMyCharacter(thief);

        newadventure.getRooms().printRoom();
        newadventure.makeAMove("S");
        newadventure.getRooms().printRoom();
        newadventure.makeAMove("D");

        System.out.println("SPELET STARTAS!");

        Monster skeleton = new Skeleton();
        Character testChar = new Knight();

        Combat combat = new Combat();
        combat.combatStart(skeleton,testChar);

    }
}
