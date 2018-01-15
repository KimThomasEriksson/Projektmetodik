// Fig. 6.7: RandomInt.java
// Shifted, scaled random integers

//package model;
import javax.swing.JOptionPane;
import java.lang.NullPointerException;

import model.Room;

import java.util.Arrays;
import java.util.Random;

public class Randnumber extends Room {

    Random randomThingGenerator;
    Random randomRoomGenerator;
    int randObj;
    int randMonst;


    public Randnumber(int playerPositionX, int playerPositionY, int level, Random randomThingGenerator, Random randomRoomGenerator, int randObj, int randMonst) {
        super(playerPositionX, playerPositionY, level);
        this.randomThingGenerator = randomThingGenerator;
        this.randomRoomGenerator = randomRoomGenerator;
        this.randObj = randObj;
        this.randMonst = randMonst;
        this.createGame();
    }
    {
    }
    public static void main( String args[] ) {

        Random randomThingGenerator = null;
        int randObj;
        int randMonst;
        //Room.createGame();

        int value;
        String[] aryString = new String[4];
        aryString[0] = "GiantSpider";
        aryString[1] = "Skeleton";
        aryString[2] = "Orc";
        aryString[3] = "Troll";

        String[] aryString2 = new String[5];
        aryString2[0] = "Lösa Slantar";
        aryString2[1] = "PeningPung";
        aryString2[2] = "Guldsmycken";
        aryString2[3] = "Ädelsten";
        aryString2[4] = "Liten Skattkista";

//        Arrays.sort(aryString);
        String output = "";
        System.out.println("test");

        for ( int i = 0; i <= aryString.length; i++ ) {
            value = 0 + (int) ( Math.random() * 100 );
            output += value + "\n";
            //value += randomThingGenerator.nextInt(100);
            // 1 + rand.nextInt(100);

            //System.out.println(value+ aryString[i]);

            if ( i % 100 == 0 )
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
