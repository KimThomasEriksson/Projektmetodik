package view;

import java.util.Scanner;

public class Menu {

    /* Concept for terminal view were we use variables like booleans to control phases
     *  and object references to try method involved in each phase route or functionality.
     *  Inputs and outputs, while loops with switch cases for robust interaction for user
     *  were we also consider the way movement gets impacted.
     *  Graphical design concludes and will be developed as we go.*/


    private boolean menuFirstPhase;
    private boolean menuSecondPhase;
    private boolean menuThirdPhase;
    private Scanner scanner;

    public Menu() {

        this.scanner = new Scanner(System.in);
        this.menuFirstPhase = true;
        this.menuSecondPhase = false;

    }

    // UI initiation starts here

    public void runMainMenu() {


        while (menuFirstPhase) {

            System.out.println("_____________________________________" +
                    "\n|\t\t\t\t\t\t\t\t\t|" +
                    "\n|\t\t\tDungeon Run\t\t\t\t|" +
                    "\n|\t\t\t\t\t\t\t\t\t|" +
                    "\n|\t\t\t[1]Create Character\t\t|" +
                    "\n|\t\t\t[2]Load Character\t\t|" +
                    "\n|\t\t\t[0]Exit\t\t\t\t\t|" +
                    "\n_____________________________________");


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


        /* Second phase menu dynamic according to follow up choice
         *  were checking of object concludes to avoid duplicate
         *  creation, if loading initiated try object methods for
         *  file reading and potentially writing... */

    }

    public void secondMenuCreation() {

        String nameToCheck = "Empty";
        String first = "1";
        String second = "2";
        String third = "3";

        while (menuSecondPhase) {

            Scanner scanner = new Scanner(System.in);


            System.out.println("_____________________________________" +
                    "\n|\t\t\t\t\t\t\t\t\t|" +
                    "\n|\t\t\tCreate Character\t\t|" +
                    "\n|\t\t\t\t\t\t\t\t\t|" +
                    "\n_____________________________________" +

                    "\n\t\t\t\t\t\t\t\t\t" +
                    "\n\t\t\tName: " + nameToCheck + "\t\t\t\t" +
                    "\n\t\t\t\t\t\t\t\t\t" +
                    "\n\t\t\t[" + first + "]Knight\t\t\t\t" +
                    "\n\t\t\t[" + second + "]Wizard\t\t\t\t" +
                    "\n\t\t\t[" + third + "]Thief\t\t\t\t" +
                    "\n\t\t\t[0]Return\t\t\t\t" +
                    "\n\t\t\t\t\t\t\t\t\t" +
                    "\n\t\t\t\t\t\t[X]SUBMIT\t" +
                    "\n_____________________________________");


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

                // Submit cases to try the given name to check object and break loop

                // Object validation
                case "X":
                    menuFirstPhase = true;
                    menuSecondPhase = false;
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

    public void secondMenuLoading() {

        String nameToCheck = "Empty";
        while (menuSecondPhase) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("_____________________________________" +
                    "\n|\t\t\t\t\t\t\t\t\t|" +
                    "\n|\t\t\tLoad Character\t\t\t|" +
                    "\n|\t\t\t\t\t\t\t\t\t|" +
                    "\n_____________________________________" +

                    "\n\t\t\t\t\t\t\t\t\t" +
                    "\n\t\t\tName: " + nameToCheck + "\t\t\t\t" +
                    "\n\t\t\t\t\t\t\t\t\t" +
                    "\n\t\t\t[0]Return\t\t\t\t" +
                    "\n\t\t\t\t\t\t\t\t\t" +
                    "\n\t\t\t\t\t\t[X]SUBMIT\t" +
                    "\n_____________________________________");


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

    public void thirdMenuGameLoader() {

        String first = "1";
        String second = "2";
        String third = "3";
        String tR = "A";
        String tL = "B";
        String bR = "C";
        String bL = "D";

        int submitDifficulty = 0;
        int startingCorner = 0;

        while (menuThirdPhase) {

            Scanner scanner = new Scanner(System.in);


            System.out.println("_____________________________________" +
                    "\n|\t\t\t\t\t\t\t\t\t|" +
                    "\n|\t\t\tStart Game!\t\t\t\t|" +
                    "\n|\t\t\t\t\t\t\t\t\t|" +
                    "\n_____________________________________" +

                    "\n\t\t\t\t\t\t\t\t\t" +
                    "\n\t\t\t\t\t\t\t\t\t" +
                    "\n\t\t\t[" + first + "]Easy\t\t\t\t" +
                    "\n\t\t\t[" + second + "]Medium\t\t\t\t" +
                    "\n\t\t\t[" + third + "]Hard\t\t\t\t" +
                    "\n\t\t\t\t\t\t\t\t\t" +

                    "\n\t\t\tSPAWN\t\t\t\t" +
                    "\n\t\t\t\t\t\t\t\t\t" +
                    "\n\t\t\t[" + tL + "]Top L\t\t\t\t" +
                    "\n\t\t\t[" + tR + "]Top R\t\t\t\t" +
                    "\n\t\t\t[" + bR + "]Bottom R\t\t\t\t" +
                    "\n\t\t\t[" + bL + "]Bottom L\t\t\t\t" +

                    "\n\t\t\t[0]Return\t\t\t\t" +
                    "\n\t\t\t\t\t\t\t\t\t" +
                    "\n\t\t\t\t\t\t\t\t\t" +


                    "\n\t\t\t\t\t\t[X]SUBMIT\t" +
                    "\n_____________________________________");


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
                    tR = "B";
                    tL = "X";
                    bR = "D";
                    bL = "C";
                    clearWindow();
                    break;
                case "B":
                    tR = "X";
                    tL = "A";
                    bR = "D";
                    bL = "C";
                    clearWindow();
                    break;
                case "C":
                    tR = "B";
                    tL = "A";
                    bR = "D";
                    bL = "X";
                    clearWindow();
                    break;
                case "D":
                    tR = "B";
                    tL = "A";
                    bR = "X";
                    bL = "C";
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
    private void clearWindow() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            for (int i = 0; i < 50; ++i) System.out.println();
        }
    }
}
