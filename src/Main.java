

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

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {
        // Testing execution flow from this point

//        Text credits = new Text();
//        credits.intro();

        Menu mainMenu = new Menu();
//        mainMenu.runMainMenu();


        Adventure gameEngine = new Adventure(mainMenu);
        gameEngine.startNewAiRoom();








    }
}
