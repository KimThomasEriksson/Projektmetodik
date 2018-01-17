// Fig. 6.7: RandomInt.java
// Shifted, scaled random integers

package controller;
import model.Monster.*;
import model.Room;

import java.util.ArrayList;
import java.util.Random;


public class RandGenerator {

    //int level = (Level);

    private static boolean additionalMonster = false;
    private static boolean firstMonster = true;
    private static int level3MonsterLimit = 3;

    private static int counter = 1;


    public RandGenerator(){}

    public void generateMonsters() {

        int points = itemsTest();

        System.out.println(points);

    }


    public void resetVariables(){
        this.additionalMonster = false;
        this.firstMonster = true;
    }


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


    private static boolean spawnMonster(int level, int chance) {
        if (firstMonster || additionalMonster) {
            Random rand = new Random();
            int randomInt = rand.nextInt(5);

            if (randomInt <= chance) {

                if (level == 1) {
                    if (firstMonster) {
                        firstMonster = false;
                        return true;
                    }
                    else{return false; }
                }

                if (level == 2) {

                    if (firstMonster) {
                        firstMonster = false;
                        additionalMonster = true;

                        return true;
                    }

                    randomInt = rand.nextInt(100);

                    if (randomInt <= 50 && additionalMonster == true) {
                        //spawna ett monster
                        additionalMonster = false;
                        return true;
                    }

                    else if (randomInt <= 50 && additionalMonster == false) {
                        //spawna inte ett monster
                        return false;
                    }
                }

                if (level == 3) {

                    if(counter <= level3MonsterLimit){
                        counter += 1;
                        //spawna monster
                        return true;
                    }
                    else{
                            return false;
                        }
                    }
                }
            }
            return false;
    }

    private int itemsTest(){
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
}

/*
        }

            //value = 0 + (int) ( Math.random() * 10 );
            //output += value + "\n";



            //value += randomThingGenerator.nextInt(100);
            // 1 + rand.nextInt(100);

            //System.out.println(value+ aryString[i]);

            if ( i % 5 == 0 )
                output += "\n"; //+aryString[i]+"\n";

            //System.out.println(output+"\n"+("printed from the Arraylist;" +aryString[i]));
        }

            System.out.println(output+"\n");
               // ("printed from the Arraylist;" +aryString[i]));
        JOptionPane.showMessageDialog( null, output +"\n",
                "lenght of arrylist Random Numbers from 1 to 9",
                JOptionPane.INFORMATION_MESSAGE );
        System.exit( 0 );
    }

    public Randnumber() {
        this.randomRoomGenerator.nextInt(3);

    }

    public int getRandomThingGenerator() {
        return randomThingGenerator.nextInt(10);
    }

    public void setRandomThingGenerator(Random randomThingGenerator) {
        this.randomThingGenerator = randomThingGenerator;
    }
}
*/