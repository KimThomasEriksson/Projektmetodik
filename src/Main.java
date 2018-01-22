

import controller.RandGenerator;
import model.Adventure;
import model.Character.*;
import model.Character.Character;
import model.Character.Knight;
import model.Character.Thief;
import model.Monster.*;
import view.Combat;
//import view.Menu;
import view.Menu;
import view.Text;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Testing execution flow from this point

        //Text credits = new Text();
        //credits.intro();

        //Menu mainMenu = new Menu();
        //mainMenu.runMainMenu();

        //Adventure gameEngine = new Adventure(mainMenu);
        //gameEngine.startNewRoom();
        Knight testKnight = new Knight();
        Monster test1 = new GiantSpider();
        Monster test2 = new Skeleton();
        Monster test3 = new Orc();
        Monster test4 = new Troll();
        Monster test5 = new Troll();
        Monster test6 = new Troll();

        AICombat ai = new AICombat();
        ai.startCombat(testKnight, test1, false);
        ai.startCombat(testKnight, test2, false);
        ai.startCombat(testKnight, test3, false);
        ai.startCombat(testKnight, test4, false);
        ai.startCombat(testKnight, test5, false);
        ai.startCombat(testKnight, test6, false);

        System.out.println(testKnight.getHp());



    }
}
