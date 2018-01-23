package model;

import controller.RandGenerator;
import model.Character.AI;
import model.Character.Character;
import model.Character.Wizard;
import model.Monster.Monster;
import view.Combat;
import view.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Adventure {

    private int level;
    private Character myCharacter;
    private Boolean flee;
    private int startPosition;
    private int startPositionX;
    private int startPositionY;
    private ArrayList<Monster> monsterToFight;
    private Room rooms;
    private Menu menu;
    private Scanner scanner;
    private int totalCoins;
    private TestRoom testRoom;
    private AI characterAi;
    private int[] listOfMoves;
    private boolean keepMoving = true;
    private int maxIndex = 0;
    private int minIndex = 0;


    public Adventure(Menu menu) {
        this.menu = menu;
        this.menu.setMyAdventure(this);
        this.listOfMoves = new int[4];
        listOfMoves[0] = 0;
        listOfMoves[1] = 1;
//        listOfMoves[2] = 1;
//        listOfMoves[3] = 3;

    }

    public void startNewAiRoom() throws IOException, InterruptedException {
        this.startPosition = this.menu.getStartingCorner();
        this.level = this.menu.getSubmitDifficulty();
        scanner = new Scanner(System.in);
        getStartingPositions();
        this.testRoom = new TestRoom(startPositionX, startPositionY, 3);
        myCharacter = new Wizard();
        characterAi = new AI(myCharacter, menu.isQuickCombat());
        characterAi.setAiAdventure(this);
        testRoom.setCharacterAi(characterAi);
        findNewExit();

    }

    public void startNewRoom() throws IOException, InterruptedException {

        this.startPosition = this.menu.getStartingCorner();
        this.level = this.menu.getSubmitDifficulty();
        scanner = new Scanner(System.in);
        getStartingPositions();
        this.rooms = new Room(startPositionX, startPositionY, level);
        myCharacter = menu.getMyCharacter();
        gameRound();


    }

    public void findNewExit() throws IOException, InterruptedException {
        boolean movementBool = false;

        while (!movementBool) {

            testRoom.printRoom();
            int randomAiChoice = testRoom.random.nextInt(4);
            System.out.println(randomAiChoice);

            switch (randomAiChoice) {


                case 0:
                    testRoom.moveDown();
                    movementBool = testRoom.isFirstTimeExit();
                    menu.clearWindow();
                    break;
                case 1:
                    testRoom.moveUp();
                    movementBool = testRoom.isFirstTimeExit();
                    menu.clearWindow();
                    break;
                case 2:
                    testRoom.moveLeft();
                    movementBool = testRoom.isFirstTimeExit();

                    break;
                case 3:
                    testRoom.moveRight();
                    movementBool = testRoom.isFirstTimeExit();
                    menu.clearWindow();
                    break;

            }
        }
        testRoom.printRoom();
    }

    public void findExit() throws InterruptedException, IOException {

        boolean tryFindingExit = testRoom.isFirstTimeExit();

        while (!tryFindingExit) {

            int down = 1 + testRoom.getPlayerPositionX();

            int up = 1 - testRoom.getPlayerPositionX();

            int right = 1 + testRoom.getPlayerPositionY();

            int left = 1 - testRoom.getPlayerPositionY();
            try {

                if (testRoom.getRooms()[down][testRoom.getPlayerPositionY()].equals("[X]")) {
                    System.out.println("Found X down");
                    testRoom.moveDown();
                    down = 1 + testRoom.getPlayerPositionX();

                    up = 1 - testRoom.getPlayerPositionX();

                    right = 1 + testRoom.getPlayerPositionY();

                    left = 1 - testRoom.getPlayerPositionY();

                    tryFindingExit = testRoom.isFirstTimeExit();
                    menu.clearWindow();
                    testRoom.printRoom();
                    if (down > maxIndex) {
                        down = maxIndex;
                    }

                }
            } catch (Exception g) {

            }
            try {
                if (testRoom.getRooms()[up][testRoom.getPlayerPositionY()].equals("[X]")) {
                    System.out.println("Found X up");
                    testRoom.moveUp();
                    down = 1 + testRoom.getPlayerPositionX();

                    up = 1 - testRoom.getPlayerPositionX();

                    right = 1 + testRoom.getPlayerPositionY();

                    left = 1 - testRoom.getPlayerPositionY();
                    menu.clearWindow();
                    testRoom.printRoom();
                    if (up < minIndex) {
                        up = minIndex;
                    }
                }
            } catch (Exception h) {

            }
            try {
                if (testRoom.getRooms()[testRoom.getPlayerPositionX()][right].equals("[X]")) {
                    System.out.println("Found X right");
                    testRoom.moveRight();
                    down = 1 + testRoom.getPlayerPositionX();

                    up = 1 - testRoom.getPlayerPositionX();

                    right = 1 + testRoom.getPlayerPositionY();

                    left = 1 - testRoom.getPlayerPositionY();
                    menu.clearWindow();
                    testRoom.printRoom();
                    if (right > maxIndex) {
                        right = maxIndex;
                    }
                }
            } catch (Exception j) {

            }
            try {


                if (testRoom.getRooms()[testRoom.getPlayerPositionX()][left].equals("[X]")) {
                    System.out.println("Found X left");
                    testRoom.moveLeft();
                    down = 1 + testRoom.getPlayerPositionX();

                    up = 1 - testRoom.getPlayerPositionX();

                    right = 1 + testRoom.getPlayerPositionY();

                    left = 1 - testRoom.getPlayerPositionY();
                    menu.clearWindow();
                    testRoom.printRoom();
                    if (left < minIndex) {
                        left = minIndex;
                    }
                } else {
                    testRoom.moveRight();
                    testRoom.moveRight();
                    testRoom.moveRight();

                }
            } catch (Exception k) {

            }


        }
    }


    public void gameRoundAi(boolean navigate) {
        try {

            boolean movementNavigationBool = navigate;
            while (movementNavigationBool) {
//                System.out.println("Movement round");
//                System.out.println(listOfMoves.length);
//                menu.clearWindow();
//                testRoom.printRoom();
                for (int e : listOfMoves) {
                    if (e == 3) {
                        boolean moveDown = testRoom.moveDown();
                        while (moveDown) {
                            testRoom.moveDown();

                            System.out.println("Down");

                            Thread.sleep(2000);
                            moveDown = testRoom.isMovementOutcome();
                            menu.clearWindow();
                            testRoom.printRoom();
                        }
                    }
                    if (e == 2) {
                        boolean moveUp = testRoom.moveUp();
                        while (moveUp) {
                            testRoom.moveUp();

                            System.out.println("Up");
                            Thread.sleep(2000);
                            moveUp = testRoom.isMovementOutcome();
                            menu.clearWindow();
                            testRoom.printRoom();
                        }
                    }
                    if (e == 1) {
                        boolean moveLeft = testRoom.moveLeft();
                        while (moveLeft) {
                            testRoom.moveLeft();

                            System.out.println("Left");

                            Thread.sleep(2000);
                            moveLeft = testRoom.isMovementOutcome();
                            menu.clearWindow();
                            testRoom.printRoom();
                        }
                        testRoom.moveDown();
                    }
                    if (e == 0) {
                        boolean moveRight = testRoom.moveRight();
                        while (moveRight) {
                            testRoom.moveRight();

                            System.out.println("Right");

                            Thread.sleep(4000);
                            moveRight = testRoom.isMovementOutcome();
                            menu.clearWindow();
                            testRoom.printRoom();
                        }
                        testRoom.moveDown();
                    }
                }


                movementNavigationBool = keepMoving;
            }
        } catch (Exception e) {
            System.out.println(e + "");
        }
    }

    public void gameRound() throws IOException, InterruptedException {

        String w = "W";
        String a = "A";
        String d = "D";
        String s = "S";
        String e = "";

        while (true) {

            menu.clearWindow();
            rooms.printRoom();
            if (rooms.isPermissionToExit()) {
                e = "You found the EXIT!\t[0]EXIT";
            }
            if (!rooms.isPermissionToExit()) {
                e = "";
            }
            System.out.println("Which direction do u want to go?\n\n" +
                    "[W]Go Up\n" +
                    "[A]Go Left\n" +
                    "[D]Go Right\n" +
                    "[S]Go Down\n\n\n" +
                    "" + e);

            String gameRoundInput = scanner.nextLine().toUpperCase();
            boolean permissionToExit = false;

            switch (gameRoundInput) {

                case "W":
                    makeAMove("W");
                    break;
                case "A":
                    makeAMove("A");
                    break;
                case "D":
                    makeAMove("D");
                    break;
                case "S":
                    makeAMove("S");
                    break;

                case "0":
                    if (rooms.isPermissionToExit()) {
                        myCharacter.resetStats();
                        menu.getMyCharacterData().saveFunc();
                        menu.setMenuThirdPhase(true);
                        menu.thirdMenuGameLoader();
                    }
                    break;

            }
        }
    }

    public void flee() {
        this.flee = true;
        String[][] room;
        room = rooms.getRooms();
        room[rooms.getOldPlayerPositionX()][rooms.getOldPlayerPositionY()] = rooms.getPlayerPosition();
        rooms.flee();

        rooms.setRooms(room);
    }

    public void startFight() throws IOException, InterruptedException {

        this.monsterToFight = this.rooms.getMonstersToFight();

        Combat combat = new Combat();
        combat.setFlee(false);
        for (int i = 0; i < this.monsterToFight.size(); i++) {

            combat.combatStart(this.monsterToFight.get(i), this.menu.getMyCharacter(), this.rooms);


        }

        boolean fleestatus = combat.getFlee();

        if (fleestatus == false) {
            int roomItems;
            roomItems = RandGenerator.ItemGenerator(this.menu.getMyCharacter());


            totalCoins += roomItems;
            if (roomItems > 0) {
                System.out.println("\n\nPress any key to continue...");
                scanner.nextLine();
            }

        }


    }

    public void makeAMove(String direction) throws IOException, InterruptedException {
        Boolean fight = false;


        if (direction.equals("W")) {
            fight = this.rooms.moveUp();

            if (fight) {
                startFight();
            }


        }

        if (direction.equals("S")) {

            fight = this.rooms.moveDown();

            if (fight) {
                startFight();
            }


        }

        if (direction.equals("A")) {

            fight = this.rooms.moveLeft();

            if (fight) {
                startFight();
            }


        }

        if (direction.equals("D")) {

            fight = this.rooms.moveRight();

            if (fight) {
                startFight();
            }


        }
    }

    public Character getMyCharacter() {
        return myCharacter;
    }


    public void setMyCharacter(Character myCharacter) {
        this.myCharacter = new Character();
        this.myCharacter = myCharacter;
    }

    public Room getRooms() {
        return rooms;
    }

    /*This function sets the starting position of the character based on what level(1,2,3) you choose and which startPosition(1,2,3,4) you selected
        Example: if constructor gets 1,2 you will get this layout of rooms and you will spawn where the 2 is located
            1XX2
            XXXX
            3XX4

         */
    public void getStartingPositions() {

        //level 1= 4x4 rooms
        if (this.level == 1) {
            if (this.startPosition == 1) {
                this.startPositionX = 0;
                this.startPositionY = 0;


            }
            if (this.startPosition == 2) {
                this.startPositionX = 0;
                this.startPositionY = 3;

            }
            if (this.startPosition == 3) {
                this.startPositionX = 3;
                this.startPositionY = 0;

            }
            if (this.startPosition == 4) {
                this.startPositionX = 3;
                this.startPositionY = 3;

            }

            maxIndex = 3;
            minIndex = 0;
        }
        //level 2= 5x5 rooms
        if (this.level == 2) {
            if (this.startPosition == 1) {
                this.startPositionX = 0;
                this.startPositionY = 0;


            }
            if (this.startPosition == 2) {
                this.startPositionX = 0;
                this.startPositionY = 4;

            }
            if (this.startPosition == 3) {
                this.startPositionX = 4;
                this.startPositionY = 0;

            }
            if (this.startPosition == 4) {
                this.startPositionX = 4;
                this.startPositionY = 4;

            }

            maxIndex = 4;
            minIndex = 0;
        }

        //level 3= 8x8 rooms
        if (this.level == 3) {
            if (this.startPosition == 1) {
                this.startPositionX = 0;
                this.startPositionY = 0;


            }
            if (this.startPosition == 2) {
                this.startPositionX = 0;
                this.startPositionY = 7;

            }
            if (this.startPosition == 3) {
                this.startPositionX = 7;
                this.startPositionY = 0;

            }
            if (this.startPosition == 4) {
                this.startPositionX = 7;
                this.startPositionY = 7;

            }
            maxIndex = 7;
            minIndex = 0;
        }


    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Boolean getFlee() {
        return flee;
    }

    public void setFlee(Boolean flee) {
        this.flee = flee;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getStartPositionX() {
        return startPositionX;
    }

    public void setStartPositionX(int startPositionX) {
        this.startPositionX = startPositionX;
    }

    public int getStartPositionY() {
        return startPositionY;
    }

    public void setStartPositionY(int startPositionY) {
        this.startPositionY = startPositionY;
    }

    public ArrayList<Monster> getMonsterToFight() {
        return monsterToFight;
    }

    public void setMonsterToFight(ArrayList<Monster> monsterToFight) {
        this.monsterToFight = monsterToFight;
    }

    public void setRooms(Room rooms) {
        this.rooms = rooms;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getTotalCoins() {
        return totalCoins;
    }

    public void setTotalCoins(int totalCoins) {
        this.totalCoins = totalCoins;
    }

    public TestRoom getTestRoom() {
        return testRoom;
    }

    public void setTestRoom(TestRoom testRoom) {
        this.testRoom = testRoom;
    }

    public AI getCharacterAi() {
        return characterAi;
    }

    public void setCharacterAi(AI characterAi) {
        this.characterAi = characterAi;
    }

    public int[] getListOfMoves() {
        return listOfMoves;
    }

    public void setListOfMoves(int[] listOfMoves) {
        this.listOfMoves = listOfMoves;
    }

    public boolean isKeepMoving() {
        return keepMoving;
    }

    public void setKeepMoving(boolean keepMoving) {
        this.keepMoving = keepMoving;
    }
}
