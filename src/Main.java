

import model.Adventure;
import model.Character.*;
import model.Character.Character;
import model.Character.Knight;
import model.Character.Thief;
import model.Monster.Monster;
import model.Monster.Skeleton;
import view.Combat;
//import view.Menu;
import view.Menu;
import view.Text;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Testing execution flow from this point

//
//        Knight myKnight = new Knight();
//        Wizard myWizard = new Wizard();
//        Thief myThief = new Thief();
//
//        myKnight.setName("A");
//        myWizard.setName("B");
//        myThief.setName("C");
//
//        CollectionOfCharacters myListToJson = new CollectionOfCharacters();
//        myListToJson.characterArrayList.add(myKnight);
//        myListToJson.characterArrayList.add(myWizard);
//        myListToJson.characterArrayList.add(myThief);


//        myListToJson.openFunc("test");
//
//        System.out.println(myListToJson.characterArrayList.get(0).getName());
//        System.out.println(myListToJson.characterArrayList.get(1).getName());
//        System.out.println(myListToJson.characterArrayList.get(2).getName());

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

        Menu mainMenu = new Menu();
        mainMenu.runMainMenu();

//        Adventure newadventure =new Adventure(1,1);
//        newadventure.getRooms().printRoom();
//        newadventure.getRooms().checkAvalibleMovements();
//        newadventure.getRooms().moveRight();
//        newadventure.getRooms().moveRight();
//        newadventure.getRooms().moveRight();
//        newadventure.getRooms().moveRight();
//        newadventure.getRooms().moveRight();
//        newadventure.getRooms().moveDown();
//        newadventure.getRooms().moveDown();
//        newadventure.getRooms().moveLeft();
//        newadventure.getRooms().moveLeft();//        System.out.println();
//        System.out.println();
//        System.out.println();
//        newadventure.getRooms().printRoom();
//
//
//        System.out.println("SPELET STARTAS!");
//
//        Monster skeleton = new Skeleton();
//        Character testChar = new Knight();
//
//        Combat combat = new Combat();
//        combat.combatStart(skeleton,testChar);

    }
}
