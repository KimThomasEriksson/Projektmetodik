package  view;




import javax.sound.sampled.*;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public  class Text {

    public void run(){
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String s = null;

    }


    public void intro() throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException {


        File f = new File( "8bit.wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
        boolean state =true;
        int time=0;

        Thread newThread =new Thread();

        while(time!=3) {


            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println(Text.introOverHeadCenter());
            Thread.sleep(200);

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println(Text.introOverHeadDown());
            Thread.sleep(200);

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println(Text.introOverHeadCenter());
            Thread.sleep(200);

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println(Text.introOverHeadUp());
            Thread.sleep(200);
            time++;



        }
        clip.stop();
        clearScreen();

    }


    public static void pressToContinue(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }


    public static void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }


    public static String introOverHeadDown() {
        String overhead;


        overhead =
                " _______   __    __  __    __   ______   ________   ______   __    __                  _______   __    __  __    __ \n" +
                        "|       \\ |  \\  |  \\|  \\  |  \\ /      \\ |        \\ /      \\ |  \\  |  \\                |       \\ |  \\  |  \\|  \\  |  \\\n" +
                        "| $$$$$$$\\| $$  | $$| $$\\ | $$|  $$$$$$\\| $$$$$$$$|  $$$$$$\\| $$\\ | $$                | $$$$$$$\\| $$  | $$| $$\\ | $$\n" +
                        "| $$  | $$| $$  | $$| $$$\\| $$| $$ __\\$$| $$__    | $$  | $$| $$$\\| $$                | $$__| $$| $$  | $$| $$$\\| $$\n" +
                        "| $$  | $$| $$  | $$| $$$$\\ $$| $$|    \\| $$  \\   | $$  | $$| $$$$\\ $$                | $$    $$| $$  | $$| $$$$\\ $$\n" +
                        "| $$  | $$| $$  | $$| $$\\$$ $$| $$ \\$$$$| $$$$$   | $$  | $$| $$\\$$ $$                | $$$$$$$\\| $$  | $$| $$\\$$ $$\n" +
                        "| $$__/ $$| $$__/ $$| $$ \\$$$$| $$__| $$| $$_____ | $$__/ $$| $$ \\$$$$                | $$  | $$| $$__/ $$| $$ \\$$$$\n" +
                        "| $$    $$ \\$$    $$| $$  \\$$$ \\$$    $$| $$     \\ \\$$    $$| $$  \\$$$                | $$  | $$ \\$$    $$| $$  \\$$$\n" +
                        " \\$$$$$$$   \\$$$$$$  \\$$   \\$$  \\$$$$$$  \\$$$$$$$$  \\$$$$$$  \\$$   \\$$                 \\$$   \\$$  \\$$$$$$  \\$$   \\$$\n" +
                        "                                                                                                                    \n" +
                        "______________________________________________________________________________________________________________________\n"+
                        "Av: Kim Burhan Peter Axel Kassim   ";


        return overhead;
    }

    public static String introOverHeadUp() {
        String overhead;


        overhead = "\n" +
                "$$$$$$$\\  $$\\   $$\\ $$\\   $$\\  $$$$$$\\  $$$$$$$$\\  $$$$$$\\  $$\\   $$\\                   $$$$$$$\\  $$\\   $$\\ $$\\   $$\\ \n" +
                "$$  __$$\\ $$ |  $$ |$$$\\  $$ |$$  __$$\\ $$  _____|$$  __$$\\ $$$\\  $$ |                  $$  __$$\\ $$ |  $$ |$$$\\  $$ |\n" +
                "$$ |  $$ |$$ |  $$ |$$$$\\ $$ |$$ /  \\__|$$ |      $$ /  $$ |$$$$\\ $$ |                  $$ |  $$ |$$ |  $$ |$$$$\\ $$ |\n" +
                "$$ |  $$ |$$ |  $$ |$$ $$\\$$ |$$ |$$$$\\ $$$$$\\    $$ |  $$ |$$ $$\\$$ |                  $$$$$$$  |$$ |  $$ |$$ $$\\$$ |\n" +
                "$$ |  $$ |$$ |  $$ |$$ \\$$$$ |$$ |\\_$$ |$$  __|   $$ |  $$ |$$ \\$$$$ |                  $$  __$$< $$ |  $$ |$$ \\$$$$ |\n" +
                "$$ |  $$ |$$ |  $$ |$$ |\\$$$ |$$ |  $$ |$$ |      $$ |  $$ |$$ |\\$$$ |                  $$ |  $$ |$$ |  $$ |$$ |\\$$$ |\n" +
                "$$$$$$$  |\\$$$$$$  |$$ | \\$$ |\\$$$$$$  |$$$$$$$$\\  $$$$$$  |$$ | \\$$ |                  $$ |  $$ |\\$$$$$$  |$$ | \\$$ |\n" +
                "\\_______/  \\______/ \\__|  \\__| \\______/ \\________| \\______/ \\__|  \\__|                  \\__|  \\__| \\______/ \\__|  \\__|\n" +
                "                                                                                                                      \n" +
                "______________________________________________________________________________________________________________________\n"+
                "Av: Kim Burhan Peter Axel Kassim   ";


        return overhead;
    }

    public static String introOverHeadCenter() {
        String overhead;

        overhead = "\n" +
                " /$$$$$$$  /$$   /$$ /$$   /$$  /$$$$$$  /$$$$$$$$  /$$$$$$  /$$   /$$                 /$$$$$$$  /$$   /$$ /$$   /$$\n" +
                "| $$__  $$| $$  | $$| $$$ | $$ /$$__  $$| $$_____/ /$$__  $$| $$$ | $$                | $$__  $$| $$  | $$| $$$ | $$\n" +
                "| $$  \\ $$| $$  | $$| $$$$| $$| $$  \\__/| $$      | $$  \\ $$| $$$$| $$                | $$  \\ $$| $$  | $$| $$$$| $$\n" +
                "| $$  | $$| $$  | $$| $$ $$ $$| $$ /$$$$| $$$$$   | $$  | $$| $$ $$ $$                | $$$$$$$/| $$  | $$| $$ $$ $$\n" +
                "| $$  | $$| $$  | $$| $$  $$$$| $$|_  $$| $$__/   | $$  | $$| $$  $$$$                | $$__  $$| $$  | $$| $$  $$$$\n" +
                "| $$  | $$| $$  | $$| $$\\  $$$| $$  \\ $$| $$      | $$  | $$| $$\\  $$$                | $$  \\ $$| $$  | $$| $$\\  $$$\n" +
                "| $$$$$$$/|  $$$$$$/| $$ \\  $$|  $$$$$$/| $$$$$$$$|  $$$$$$/| $$ \\  $$                | $$  | $$|  $$$$$$/| $$ \\  $$\n" +
                "|_______/  \\______/ |__/  \\__/ \\______/ |________/ \\______/ |__/  \\__/                |__/  |__/ \\______/ |__/  \\__/\n" +
                "                                                                                                                    \n" +
                "______________________________________________________________________________________________________________________\n"+
                "Av: Kim Burhan Peter Axel Kassim   ";


        return overhead;
    }


}
