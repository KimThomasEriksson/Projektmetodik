package controller;

import java.lang.*;
import model.Character.Knight;
import model.Character.Thief;
import model.Monster.Skeleton;
import view.Menu;

public class Main {

    public static void main(String[] args) {
        // Testing execution flow from this point
        //Menu testGame = new Menu();
        //testGame.runMainMenu();
        Thief testChar = new Thief("Thief","Kalle", 5, 9,6, 4, 0, 0, 0, 0, 0);
        Skeleton testSkel = new Skeleton();
        try {
            while (true) {
                if(testChar.getHp() == 0){
                    System.out.println("You died!");
                    break;
                }
                testChar.attackMonster(testSkel);
                Thread.sleep(1000);
                if(testSkel.getHp() == 0){
                    System.out.println(testSkel.getClassType() + " Died!");
                    break;
                }
                testChar.defendAttack(testSkel);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        //System.out.println("SPELET STARTAS!");

    }
}
