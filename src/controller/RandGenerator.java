// Fig. 6.7: RandomInt.java
// Shifted, scaled random integers

package controller;
import model.Monster.*;
import model.Room;

import java.util.ArrayList;
import java.util.Random;


public class RandGenerator {


    //Deklaration av attributer.
    private static boolean additionalMonster = false;
    private static boolean firstMonster = true;
    private static int level3MonsterLimit = 3;
    private static int counter = 1;


    public RandGenerator(){}

    //method som skapar / genererar Monsters
    public void generateMonsters() {

        int points = ItemGenerator();

        System.out.println(points);

    }

    //Metod som återställer antall generation Monsterfor samtliga rum.
    public void resetVariables(){
        this.additionalMonster = false;
        this.firstMonster = true;
    }

    //En lista skapas på samtliga monster som kan generaras samt sanolikhet att den spawnas för varje nivå.
    public static ArrayList<Monster> rollTheDice(int level){
        ArrayList<Monster> listOfMonsters = new ArrayList<Monster>();

        boolean spawnSpider = spawnMonster(level,20);

        boolean spawnSkeleton = spawnMonster(level, 15);

        boolean spawnOrc = spawnMonster(level, 10);

        boolean spawnTroll = spawnMonster(level, 5);


        if(spawnSpider){
            Monster giantSpider = new GiantSpider();
            System.out.println("Spider ska spawna");
            listOfMonsters.add(giantSpider);
        }
        if(spawnSkeleton){
            Monster skeleton = new Skeleton();
            System.out.println("Skelett ska spawna");
            listOfMonsters.add(skeleton);
        }
        if(spawnOrc){
            Monster orc = new Orc();
            System.out.println("Orc ska spawna");
            listOfMonsters.add(orc);
        }
        if(spawnTroll){
            Monster troll = new Troll();
            System.out.println("Troll ska spawna");
            listOfMonsters.add(troll);
        }

        return listOfMonsters;

    }

    //genererar/spawn slumpmässiga monster mellan 0- 100 i boundery.
    private static boolean spawnMonster(int level, int chance) {
        if (firstMonster || additionalMonster) {
            Random rand = new Random();
            int randomInt = rand.nextInt(100);

            //Verifierar ifall om det redan finns ett på Level 1 om inte genererar det en monster enligt chance nivå
            if (randomInt <= chance) {

                if (level == 1) {
                    if (firstMonster) {
                        firstMonster = false;
                        return true;
                    }
                    else{return false; }
                }

                //Verifierar ifall om det redan finns ett monster på Level 2 oavsätt so lägger den till ett till monster.
                if (level == 2) {
                    if (firstMonster) {
                        firstMonster = false;
                        additionalMonster = true;

                        return true;
                    }

                    //Verifierar ifall om det redan finns ett monster.
                    //om det fins så lägger den till ett till monster om randomInt är större än 50.

                    randomInt = rand.nextInt(50);

                    if (randomInt <= 50 && additionalMonster == true) {
                        //spawna ett monster
                        additionalMonster = false;
                        return true;
                    } else if (randomInt <= 50 && additionalMonster == false) {
                        //spawna inte ett monster
                        return false;
                    }
                }

                //Genererar Monster oavsätt om det redan finns eller ej.
                if (level == 3) {
                    if(counter <= level3MonsterLimit){
                        counter += 1;
                        //spawna monster
                        return true;
                    }
                    else{
                        randomInt = rand.nextInt(100);

                        if (randomInt <= 50) {
                            //spawna ett monster

                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                }
            }


        }
        return false;
    }

    // Metod som genererar Items / Treasure.
    private int ItemGenerator(){
        Random rand = new Random();
        int randomInt = rand.nextInt(100);
        int treasureTotalWorth = 0;

        try {
            if (randomInt <= 40) {
                System.out.println("Du hittade lösa slantar ");
                Thread.sleep(500);
                treasureTotalWorth += 2;
            }

            randomInt = rand.nextInt(100);

            if (randomInt <= 20) {
                System.out.println("Du hittade en pengapung ");
                Thread.sleep(500);
                treasureTotalWorth += 6;
            }

            randomInt = rand.nextInt(100);

            if (randomInt <= 15) {
                System.out.println("Du hittade guldsmycken");
                Thread.sleep(500);
                treasureTotalWorth += 10;
            }

            randomInt = rand.nextInt(100);

            if (randomInt <= 10) {
                System.out.println("Du hittade en ädelsten");
                Thread.sleep(500);
                treasureTotalWorth += 14;
            }

            randomInt = rand.nextInt(100);


            if (randomInt <= 5) {
                System.out.println("Du hittade en liten skattkista !");
                Thread.sleep(500);
                treasureTotalWorth += 20;
            }
        }
        catch(InterruptedException e){
            System.out.println("tråd interruptad");
        }

        return treasureTotalWorth;
    }

    public static boolean isAdditionalMonster() {
        return additionalMonster;
    }

    public static void setAdditionalMonster(boolean additionalMonster) {
        RandGenerator.additionalMonster = additionalMonster;
    }

    public static boolean isFirstMonster() {
        return firstMonster;
    }

    public static void setFirstMonster(boolean firstMonster) {
        RandGenerator.firstMonster = firstMonster;
    }

    public static int getLevel3MonsterLimit() {
        return level3MonsterLimit;
    }

    public static void setLevel3MonsterLimit(int level3MonsterLimit) {
        RandGenerator.level3MonsterLimit = level3MonsterLimit;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        RandGenerator.counter = counter;
    }

}