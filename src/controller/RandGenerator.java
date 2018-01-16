// Fig. 6.7: RandomInt.java
// Shifted, scaled random integers

package controller;
import model.Room;
import java.util.Random;


public class RandGenerator extends Room {

    private boolean additionalMonster = false;
    //private boolean additionalItems = false;
    private boolean firstMonster = true;
    //private boolean firstItems =true;
    private int level3MonsterLimit = 2;
    //private int levelItemsLimit = 2;
    private int counter = 1;
    int level = getLevel();

    public static void main(String args[]) {

    }

    public void generateMonsters() {



        boolean spawnSpider = spawnMonster(20);

        System.out.println("Spider: " + spawnSpider);

        boolean spawnSkeleton = spawnMonster(15);

        System.out.println("Skeleton: " + spawnSkeleton);

        boolean spawnOrc = spawnMonster(10);

        System.out.println("Orc: " + spawnOrc);

        boolean spawnTroll = spawnMonster(5);

        System.out.println("Troll: " + spawnTroll);

        int points = itemsTest();

        System.out.println(points);

    }

    private boolean spawnMonster(int chance) {
        if (this.firstMonster || this.additionalMonster) {
            Random rand = new Random();
            int randomInt = rand.nextInt(100);

            System.out.println(randomInt);

            if (randomInt <= chance) {

                if (level == 1) {
                    if (this.firstMonster) {
                        this.firstMonster = false;
                        return true;
                    }
                    else{return false; }
                }
                if (this.level == 2) {
                    if (this.firstMonster) {
                        this.firstMonster = false;
                        this.additionalMonster = true;

                        return true;
                    }

                    randomInt = rand.nextInt(100);
                    System.out.println(randomInt);

                    if (randomInt <= 50 && additionalMonster == true) {
                        //spawna ett monster
                        this.additionalMonster = false;
                        return true;
                    } else if (randomInt <= 50 && additionalMonster == false) {
                        //spawna inte ett monster
                        return false;
                    }
                }

                if (this.level == 3) {
                    if(this.counter <= this.level3MonsterLimit){
                        this.counter += 1;
                        //spawna monster
                        return true;
                    }
                    else{
                        randomInt = rand.nextInt(100);
                        System.out.println(randomInt);

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

    private int itemsTest(){
        Random rand = new Random();
        int randomInt = rand.nextInt(100);
        int treasureTotalWorth = 0;

        if (randomInt <= 40){
            System.out.println("Du hittade lösa slantar ");
            treasureTotalWorth += 2;
        }

        randomInt = rand.nextInt(100);

        if (randomInt <= 20){
            System.out.println("Du hittade en pengapung ");
            treasureTotalWorth += 6;
        }

        randomInt = rand.nextInt(100);

        if (randomInt <= 15){
            System.out.println("Du hittade guldsmycken");
            treasureTotalWorth += 10;
        }

        randomInt = rand.nextInt(100);

        if (randomInt <= 10){
            System.out.println("Du hittade en ädelsten");
            treasureTotalWorth += 14;
        }

        randomInt = rand.nextInt(100);


        if (randomInt <= 5){
            System.out.println("Du hittade en liten skattkista !");
            treasureTotalWorth += 20;
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