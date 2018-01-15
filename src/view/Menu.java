package view;

import model.Adventure;
import model.Character.Knight;
import model.Character.Thief;
import model.Character.Wizard;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    /*  Concept for terminal view were we use variables like booleans to control phases
     *  and object references to try method involved in each phase route or functionality.
     *  Inputs and outputs, while loops with switch cases for robust interaction for user
     *  were we also consider the way movement gets impacted.
     *  Graphical design concludes and will be developed as we go.*/


    private boolean menuFirstPhase;
    private boolean menuSecondPhase;
    private boolean menuThirdPhase;
    private Scanner scanner;

    // Model attributes reserved for interaction by method/function calling
    private Character myCharacter;
    private Knight myKnight;
    private Wizard myWizard;
    private Thief myThief;

    private Adventure myAdventure;

    public Menu() {

        this.scanner = new Scanner(System.in);
        this.menuFirstPhase = true;
        this.menuSecondPhase = false;
        this.myKnight = new Knight();
        this.myWizard = new Wizard();
        this.myThief = new Thief();

    }

    // Graphical representation of classes with their attributes and values
    public void classShowCase(){

        System.out.println("\t\t\t[" + myKnight.getClassType() + "]\t[" + myWizard.getClassType() + "]\t[" + myThief.getClassType()
                + "]\n\nHealth:\t\t\t" + myKnight.getHp() + "\t\t\t" + myWizard.getHp() + "\t\t\t" + myThief.getHp()
                + "\nAttack:\t\t\t" + myKnight.getAttack() + "\t\t\t" + myWizard.getAttack() + "\t\t\t" + myThief.getAttack()
                + "\nAgility\t\t\t" + myKnight.getAgility() + "\t\t\t" + myWizard.getAgility() + "\t\t\t" + myThief.getAgility()
                + "\nInitiative:\t\t" + myKnight.getInitiative() + "\t\t\t" + myWizard.getInitiative() + "\t\t\t" + myThief.getInitiative()
                + "\n\n\n\t\t\t\t\t\t\t" +
                "Enter to continue...");

        scanner.nextLine();
    }

    // UI initiation starts here

    public void runMainMenu() throws IOException, InterruptedException {


        while (menuFirstPhase) {

            System.out.println("_________________________________________________" +
                    "\n|\t\t\t\t\t\t|" +
                    "\n|\t\t\tMenu\t\t\t|" +
                    "\n|\t\t\t\t\t\t|" +
                    "\n_________________________________________________" +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\t[1]Create Character" +
                    "\n\t\t[2]Load Character" +
                    "\n\t\t[0]Exit" +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\t\t\t\t\t");


            String inputForFirstPhase = scanner.nextLine().toUpperCase();

            switch (inputForFirstPhase) {

                // Menu option 1 as follows

                case "1":
                    // Create new character
                    menuFirstPhase = false;
                    menuSecondPhase = true;
                    clearWindow();
                    secondMenuCreation();
                    break;
                case "CREATE":
                    menuFirstPhase = false;
                    menuSecondPhase = true;
                    clearWindow();
                    secondMenuCreation();
                    break;

                // Option 2 as follows

                case "2":
                    // Load character from file?
                    menuFirstPhase = false;
                    menuSecondPhase = true;
                    clearWindow();
                    secondMenuLoading();
                    break;
                case "LOAD":
                    menuFirstPhase = false;
                    menuSecondPhase = true;
                    clearWindow();
                    secondMenuLoading();
                    break;

                // Last exit option for total system shutdown

                case "0":
                    System.exit(0);
                    break;
                case "EXIT":
                    System.exit(0);
                    break;

                default:
                    clearWindow();
                    System.out.println("Try again!");

            }
        }


        /*  Second phase menu dynamic according to follow up choice
         *  were checking of object concludes to avoid duplicate
         *  creation, if loading initiated try object methods for
         *  file reading and potentially writing... */

    }

    public void secondMenuCreation() throws IOException, InterruptedException {

        String nameToCheck = "Empty";
        String first = "1";
        String second = "2";
        String third = "3";
        String classPreviewString = "";

        while (menuSecondPhase) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("_________________________________________________" +
                    "\n|\t\t\t\t\t\t|" +
                    "\n|\t\tCreate Character\t\t|" +
                    "\n|\t\t\t\t\t\t|" +
                    "\n_________________________________________________" +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\tName: " + nameToCheck +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\t[" + first + "]Knight" +
                    "\n\t\t[" + second + "]Wizard" +
                    "\n\t\t[" + third + "]Thief" +
                    "\n" +
                    "\n" + classPreviewString +
                    "\n\t\t\t\t\t\t" +
                    "\n[0]Return\t\t\t\t[X]SUBMIT\t" +
                    "\n\t\t\t\t\t\t");


            String secondPhaseInput = scanner.nextLine().toUpperCase();
            if (!secondPhaseInput.equals("") && !secondPhaseInput.equals("1") &&
                    !secondPhaseInput.contains("2") && !secondPhaseInput.equals("3")
                    && !secondPhaseInput.equals("X") && !secondPhaseInput.equals("0")) {
                nameToCheck = secondPhaseInput;
            }

            switch (secondPhaseInput) {

                // Test creation on submit for uniqueness
                case "1":
                    first = "X";
                    second = "2";
                    third = "3";
                    classPreviewString = myKnight.previewLogoKnight();
                    clearWindow();
                    break;
                case "2":
                    first = "1";
                    second = "X";
                    third = "3";
                    classPreviewString = myWizard.previewLogoWizard();
                    clearWindow();
                    break;
                case "3":
                    first = "1";
                    second = "2";
                    third = "X";
                    classPreviewString = myThief.previewLogoThief();
                    clearWindow();
                    break;

                // Submit cases to try the given name to check object and break loop

                // Object validation
                case "X":
                    menuFirstPhase = true;
                    menuSecondPhase = false;
                    if (first.equals("X")) {
//                        myCharacter =  myKnight;
                    }
                    if (second.equals("X")) {
//                        submitDifficulty = 2;
                    }
                    if (third.equals("X")) {
//                        submitDifficulty = 3;
                    }



                    clearWindow();
                    runMainMenu();
                    break;
                case "SUBMIT":
                    menuFirstPhase = true;
                    menuSecondPhase = false;




                    clearWindow();
                    runMainMenu();
                    break;
                // Object validation


                // Last exit option for total system shutdown

                case "0":
                    menuFirstPhase = true;
                    menuSecondPhase = false;
                    clearWindow();
                    runMainMenu();
                    break;
                case "RETURN":
                    menuFirstPhase = true;
                    menuSecondPhase = false;
                    clearWindow();
                    runMainMenu();
                    break;

                default:

                    clearWindow();
                    System.out.println("Submit to confirm!");

            }
        }
    }

    public void secondMenuLoading() throws IOException, InterruptedException {

        String nameToCheck = "Empty";
        while (menuSecondPhase) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("_________________________________________________" +
                    "\n|\t\t\t\t\t\t|" +
                    "\n|\t\tLoad Character\t\t\t|" +
                    "\n|\t\t\t\t\t\t|" +
                    "\n_________________________________________________" +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\tName: " + nameToCheck +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\t\t\t\t\t" +
                    "\n[0]Return\t\t\t\t[X]SUBMIT\t" +
                    "\n\t\t\t\t\t\t");


            String choice = scanner.nextLine().toUpperCase();
            if (!choice.equals("")) {
                nameToCheck = choice;
            }
            switch (choice) {

                // Submit cases to try the given name to check object and break loop
                case "X":
                    menuFirstPhase = false;
                    menuSecondPhase = false;
                    menuThirdPhase = true;
                    clearWindow();
                    thirdMenuGameLoader();
                    break;
                case "SUBMIT":
                    menuFirstPhase = false;
                    menuSecondPhase = false;
                    menuThirdPhase = true;
                    clearWindow();
                    thirdMenuGameLoader();
                    break;

                case "0":
                    menuFirstPhase = true;
                    menuSecondPhase = false;
                    clearWindow();
                    runMainMenu();
                    break;
                case "RETURN":
                    menuFirstPhase = true;
                    menuSecondPhase = false;
                    clearWindow();
                    runMainMenu();
                    break;

                default:

                    clearWindow();
                    System.out.println("Submit to confirm!");
            }
        }
    }

    public void thirdMenuGameLoader() throws IOException, InterruptedException {

        String first = "1";
        String second = "2";
        String third = "3";
        String tL = "A";
        String tR = "B";
        String bL = "C";
        String bR = "D";

        int submitDifficulty = 0;
        int startingCorner = 0;

        while (menuThirdPhase) {

            Scanner scanner = new Scanner(System.in);


            System.out.println("_________________________________________________" +
                    "\n|\t\t\t\t\t\t|" +
                    "\n|\t\tStart Game!\t\t\t|" +
                    "\n|\t\t\t\t\t\t|" +
                    "\n_________________________________________________" +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\tDIFFICULTY" +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\t[" + first + "]Easy" +
                    "\n\t\t[" + second + "]Medium" +
                    "\n\t\t[" + third + "]Hard" +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\tSPAWN\t\t\t\t" +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\t[" + tL + "]Top L" +
                    "\n\t\t[" + tR + "]Top R" +
                    "\n\t\t[" + bL + "]Bottom L" +
                    "\n\t\t[" + bR + "]Bottom R" +
                    "\n\t\t\t\t\t\t\t" +
                    "\n\t\t\t\t\t\t" +
                    "\n\t\t\t\t\t\t\t" +
                    "\n\t\t\t\t\t\t\t" +
                    "\n[0]Return\t\t\t\t[X]SUBMIT\t" +
                    "\n\t\t\t\t\t\t\t");


            String thirdPhaseInput = scanner.nextLine().toUpperCase();
            if (!thirdPhaseInput.equals("")) {
            }

            switch (thirdPhaseInput) {

                // Test creation on submit for uniqueness
                case "1":
                    first = "X";
                    second = "2";
                    third = "3";
                    clearWindow();
                    break;
                case "2":
                    first = "1";
                    second = "X";
                    third = "3";
                    clearWindow();
                    break;
                case "3":
                    first = "1";
                    second = "2";
                    third = "X";
                    clearWindow();
                    break;
                case "A":
                    tL = "X";
                    tR = "B";
                    bL = "C";
                    bR = "D";
                    clearWindow();
                    break;
                case "B":
                    tL = "A";
                    tR = "X";
                    bL = "C";
                    bR = "D";
                    clearWindow();
                    break;
                case "C":
                    tL = "A";
                    tR = "B";
                    bL = "X";
                    bR = "D";
                    clearWindow();
                    break;
                case "D":
                    tL = "A";
                    tR = "B";
                    bL = "C";
                    bR = "X";
                    clearWindow();
                    break;


                // Submit cases to try the given name to check object and break loop

                // Object validation
                case "X":

                    if (first.equals("X")) {
                        submitDifficulty = 1;
                    }
                    if (second.equals("X")) {
                        submitDifficulty = 2;
                    }
                    if (third.equals("X")) {
                        submitDifficulty = 3;
                    }

                    if (tL.equals("X")) {
                        startingCorner = 1;
                    }
                    if (tR.equals("X")) {
                        startingCorner = 2;
                    }
                    if (bL.equals("X")) {
                        startingCorner = 3;
                    }
                    if (bR.equals("X")) {
                        startingCorner = 4;
                    }


                    if (submitDifficulty > 0 && startingCorner > 0) {

                        // Interact with object
                        menuFirstPhase = false;
                        menuSecondPhase = false;
                        menuThirdPhase = false;
                        clearWindow();
                        break;
                    }
                    break;
                case "SUBMIT":

                    if (first.equals("X")) {
                        submitDifficulty = 1;
                    }
                    if (second.equals("X")) {
                        submitDifficulty = 2;
                    }
                    if (third.equals("X")) {
                        submitDifficulty = 3;
                    }

                    if (tL.equals("X")) {
                        startingCorner = 1;
                    }
                    if (tR.equals("X")) {
                        startingCorner = 2;
                    }
                    if (bL.equals("X")) {
                        startingCorner = 3;
                    }
                    if (bR.equals("X")) {
                        startingCorner = 4;
                    }


                    if (submitDifficulty > 0 && startingCorner > 0) {

                        // Interact with object
                        menuFirstPhase = false;
                        menuSecondPhase = false;
                        menuThirdPhase = false;
                        clearWindow();
                        break;


                        // Implement next phase, game engine?
                    }
                    break;
                // Object validation

                case "0":
                    menuFirstPhase = true;
                    menuSecondPhase = false;
                    menuThirdPhase = false;
                    clearWindow();
                    runMainMenu();
                    break;
                case "RETURN":
                    menuFirstPhase = true;
                    menuSecondPhase = false;
                    menuThirdPhase = false;
                    clearWindow();
                    runMainMenu();
                    break;

                default:

                    clearWindow();
                    System.out.println("Submit to confirm!");

            }
        }
    }

    // Erases all text in terminal based on system and environment
    private void clearWindow() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
