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

    private boolean navigationBool = false;
    private boolean navigationBoolGoToExit = false;
    private boolean movementBool = false;
    private boolean keepMoving = false;
    private boolean wantToExit = false;
    private boolean progressAfterExitDiscovery = false;

    private int maxIndex = 0;
    private int minIndex = 0;
    private int areaRows;
    private int areaColumns;


    public Adventure(Menu menu) {
        this.menu = menu;
        this.menu.setMyAdventure(this);
        this.listOfMoves = new int[4];
        listOfMoves[0] = 0;
        listOfMoves[1] = 1;
        listOfMoves[2] = 1;
        listOfMoves[3] = 3;
        myCharacter = menu.getMyCharacter();

    }

    public void startGame()throws IOException, InterruptedException{

        myCharacter = menu.getMyCharacter();

        if(myCharacter.getName().startsWith("AI")){
            startNewAiRoom();
        }else {
            startNewRoom();
        }

    }

    public void startNewAiRoom() throws IOException, InterruptedException {
        this.startPosition = this.menu.getStartingCorner();
        this.level = this.menu.getSubmitDifficulty();
        scanner = new Scanner(System.in);
        getStartingPositions();
        this.testRoom = new TestRoom(startPositionX, startPositionY, level);
        characterAi = new AI(myCharacter, menu.isQuickCombat());
        characterAi.setAiAdventure(this);
        testRoom.setCharacterAi(characterAi);
        findNewExit(true);
        menu.setMenuFirstPhase(true);
        menu.runMainMenu();

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

    //
    // Goal is to find EXIT and set coordinates for it for later progression function
    //
    public void findNewExit(boolean sentBool) throws IOException, InterruptedException {

        navigationBool = sentBool;

        while (navigationBool) {

            menu.clearWindow();
            testRoom.printRoom();
            System.out.println("I need to find out where the EXIT is located!");
            Thread.sleep(1000);

            for (int rows = 0; rows < testRoom.getRooms().length; rows++) {
                for (int columns = 0; columns < testRoom.getRooms()[rows].length; columns++) {
                    if (testRoom.getRooms()[rows][columns].equals("[A]")) {
                        areaRows = rows;
                        areaColumns = columns;
                        try {
                            if (testRoom.getRooms()[areaRows + 1][areaColumns].equals("[X]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows + 2][areaColumns].equals("[X]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows + 3][areaColumns].equals("[X]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows + 4][areaColumns].equals("[X]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows + 5][areaColumns].equals("[X]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows + 6][areaColumns].equals("[X]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows + 7][areaColumns].equals("[X]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows + 8][areaColumns].equals("[X]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);

                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows - 1][areaColumns].equals("[X]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows - 2][areaColumns].equals("[X]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows - 3][areaColumns].equals("[X]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows - 4][areaColumns].equals("[X]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows - 5][areaColumns].equals("[X]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows - 6][areaColumns].equals("[X]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows - 7][areaColumns].equals("[X]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows - 8][areaColumns].equals("[X]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns + 1].equals("[X]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns + 2].equals("[X]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns + 3].equals("[X]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns + 4].equals("[X]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns + 5].equals("[X]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns + 6].equals("[X]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns + 7].equals("[X]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns + 8].equals("[X]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns - 1].equals("[X]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns - 2].equals("[X]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns - 3].equals("[X]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns - 4].equals("[X]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns - 5].equals("[X]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);

                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns - 6].equals("[X]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns - 7].equals("[X]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (testRoom.getRooms()[areaRows][areaColumns - 8].equals("[X]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }

                        } catch (ArrayIndexOutOfBoundsException e) {
                            try {
                                if (testRoom.getRooms()[areaRows + 1][areaColumns].equals("[X]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                if (testRoom.getRooms()[areaRows + 2][areaColumns].equals("[X]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                if (testRoom.getRooms()[areaRows + 3][areaColumns].equals("[X]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                if (testRoom.getRooms()[areaRows + 4][areaColumns].equals("[X]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                if (testRoom.getRooms()[areaRows + 5][areaColumns].equals("[X]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                if (testRoom.getRooms()[areaRows + 6][areaColumns].equals("[X]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                if (testRoom.getRooms()[areaRows + 7][areaColumns].equals("[X]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                if (testRoom.getRooms()[areaRows + 8][areaColumns].equals("[X]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows - 1][areaColumns].equals("[X]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows - 2][areaColumns].equals("[X]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows - 3][areaColumns].equals("[X]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows - 4][areaColumns].equals("[X]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);

                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows - 5][areaColumns].equals("[X]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);

                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows - 6][areaColumns].equals("[X]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows - 7][areaColumns].equals("[X]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows - 8][areaColumns].equals("[X]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns + 1].equals("[X]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns + 2].equals("[X]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns + 3].equals("[X]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns + 4].equals("[X]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);

                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns + 5].equals("[X]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns + 6].equals("[X]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns + 7].equals("[X]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns + 8].equals("[X]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns - 1].equals("[X]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns - 2].equals("[X]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns - 3].equals("[X]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns - 4].equals("[X]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns - 5].equals("[X]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns - 6].equals("[X]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns - 7].equals("[X]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (testRoom.getRooms()[areaRows][areaColumns - 8].equals("[X]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }

                        }
                    }
                    if (testRoom.getRooms()[rows][columns].equals("[E]")) {
                        testRoom.setFirstTimeExit(true);
                        testRoom.setPermissionToExit(true);
                        wantToExit = true;
                        testRoom.setExitPositionX(rows);
                        testRoom.setExitPositionY(columns);
                        navigationBool = false;
                    }
                }
            }
        }
        if (testRoom.isFirstTimeExit()) {
            System.out.println("\nFound the EXIT, leaving...");
            Thread.sleep(3000);
            System.out.println("Let's check our progress...");
            Thread.sleep(3000);
            System.out.println("\nFar below is our inventory with all the loot we got away with");
            System.out.println(myCharacter.previewLogo());
            scanner.nextLine();
            menu.setMenuThirdPhase(true);
            menu.thirdMenuGameLoader();
        }
    }

    public void findLootAndFight(boolean sentBool) throws IOException, InterruptedException {

        progressAfterExitDiscovery = sentBool;

        while (progressAfterExitDiscovery) {
            menu.clearWindow();
            testRoom.printRoom();
            System.out.println("Let's keep exploring since i know where the EXIT is located");
            Thread.sleep(1000);
            for (int rows = 0; rows < testRoom.getRooms().length; rows++) {
                for (int columns = 0; columns < testRoom.getRooms()[rows].length; columns++) {
                    if (!testRoom.getRooms()[rows][columns].equals("[A]")) {
                        areaRows = rows;
                        areaColumns = columns;
                        try {
                            if (!testRoom.getRooms()[areaRows + 1][areaColumns].equals("[ ]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows + 2][areaColumns].equals("[ ]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows + 3][areaColumns].equals("[ ]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows + 4][areaColumns].equals("[ ]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows + 5][areaColumns].equals("[ ]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows + 6][areaColumns].equals("[ ]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows + 7][areaColumns].equals("[ ]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows + 8][areaColumns].equals("[ ]")) {
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveDown();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);

                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows - 1][areaColumns].equals("[ ]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows - 2][areaColumns].equals("[ ]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows - 3][areaColumns].equals("[ ]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows - 4][areaColumns].equals("[ ]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows - 5][areaColumns].equals("[ ]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows - 6][areaColumns].equals("[ ]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows - 7][areaColumns].equals("[ ]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows - 8][areaColumns].equals("[ ]")) {
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveUp();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns + 1].equals("[ ]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns + 2].equals("[ ]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns + 3].equals("[ ]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns + 4].equals("[ ]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns + 5].equals("[ ]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns + 6].equals("[ ]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns + 7].equals("[ ]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns + 8].equals("[ ]")) {
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveRight();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns - 1].equals("[ ]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns - 2].equals("[ ]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns - 3].equals("[ ]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns - 4].equals("[ ]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns - 5].equals("[ ]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);

                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns - 6].equals("[ ]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns - 7].equals("[ ]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }
                            areaRows = rows;
                            areaColumns = columns;
                            if (!testRoom.getRooms()[areaRows][areaColumns - 8].equals("[ ]")) {
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                testRoom.moveLeft();
                                menu.clearWindow();
                                testRoom.printRoom();
                                Thread.sleep(1000);
                                continue;
                            }

                        } catch (ArrayIndexOutOfBoundsException e) {
                            try {
                                if (!testRoom.getRooms()[areaRows + 1][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                if (!testRoom.getRooms()[areaRows + 2][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                if (!testRoom.getRooms()[areaRows + 3][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                if (!testRoom.getRooms()[areaRows + 4][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                if (!testRoom.getRooms()[areaRows + 5][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                if (!testRoom.getRooms()[areaRows + 6][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                if (!testRoom.getRooms()[areaRows + 7][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                if (!testRoom.getRooms()[areaRows + 8][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {
                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 1][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 2][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 3][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 4][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);

                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 5][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);

                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 6][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 7][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 8][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 1].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 2].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 3].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 4].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);

                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 5].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 6].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 7].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 8].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 1].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 2].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 3].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 4].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 5].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 6].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 7].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                            try {
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 8].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                            } catch (ArrayIndexOutOfBoundsException r) {

                            }
                        }
                    }
                    if (testRoom.getRooms()[rows][columns].equals("[E]")) {
                        testRoom.setFirstTimeExit(true);
                        testRoom.setExitPositionX(rows);
                        testRoom.setExitPositionY(columns);
                        if (testRoom.isPermissionToExit() && wantToExit) {
                            return;
                        }
                        if (!wantToExit) {
                            try {
                                if (!testRoom.getRooms()[areaRows + 1][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows + 2][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows + 3][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows + 4][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows + 5][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows + 6][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows + 7][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows + 8][areaColumns].equals("[ ]")) {
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveDown();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);

                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 1][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 2][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 3][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 4][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 5][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 6][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 7][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows - 8][areaColumns].equals("[ ]")) {
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveUp();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 1].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 2].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 3].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 4].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 5].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 6].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 7].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns + 8].equals("[ ]")) {
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveRight();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 1].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 2].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 3].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 4].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 5].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);

                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 6].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 7].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }
                                areaRows = rows;
                                areaColumns = columns;
                                if (!testRoom.getRooms()[areaRows][areaColumns - 8].equals("[ ]")) {
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    testRoom.moveLeft();
                                    menu.clearWindow();
                                    testRoom.printRoom();
                                    Thread.sleep(1000);
                                    continue;
                                }

                            } catch (ArrayIndexOutOfBoundsException e) {
                                try {
                                    if (!testRoom.getRooms()[areaRows + 1][areaColumns].equals("[ ]")) {
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {
                                }
                                try {
                                    if (!testRoom.getRooms()[areaRows + 2][areaColumns].equals("[ ]")) {
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {
                                }
                                try {
                                    if (!testRoom.getRooms()[areaRows + 3][areaColumns].equals("[ ]")) {
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {
                                }
                                try {
                                    if (!testRoom.getRooms()[areaRows + 4][areaColumns].equals("[ ]")) {
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {
                                }
                                try {
                                    if (!testRoom.getRooms()[areaRows + 5][areaColumns].equals("[ ]")) {
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {
                                }
                                try {
                                    if (!testRoom.getRooms()[areaRows + 6][areaColumns].equals("[ ]")) {
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {
                                }
                                try {
                                    if (!testRoom.getRooms()[areaRows + 7][areaColumns].equals("[ ]")) {
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {
                                }
                                try {
                                    if (!testRoom.getRooms()[areaRows + 8][areaColumns].equals("[ ]")) {
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveDown();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {
                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows - 1][areaColumns].equals("[ ]")) {
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows - 2][areaColumns].equals("[ ]")) {
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows - 3][areaColumns].equals("[ ]")) {
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows - 4][areaColumns].equals("[ ]")) {
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);

                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows - 5][areaColumns].equals("[ ]")) {
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);

                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows - 6][areaColumns].equals("[ ]")) {
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows - 7][areaColumns].equals("[ ]")) {
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows - 8][areaColumns].equals("[ ]")) {
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveUp();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns + 1].equals("[ ]")) {
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns + 2].equals("[ ]")) {
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns + 3].equals("[ ]")) {
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns + 4].equals("[ ]")) {
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);

                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns + 5].equals("[ ]")) {
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns + 6].equals("[ ]")) {
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns + 7].equals("[ ]")) {
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns + 8].equals("[ ]")) {
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveRight();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns - 1].equals("[ ]")) {
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns - 2].equals("[ ]")) {
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns - 3].equals("[ ]")) {
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns - 4].equals("[ ]")) {
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns - 5].equals("[ ]")) {
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns - 6].equals("[ ]")) {
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns - 7].equals("[ ]")) {
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }
                                try {
                                    areaRows = rows;
                                    areaColumns = columns;
                                    if (!testRoom.getRooms()[areaRows][areaColumns - 8].equals("[ ]")) {
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        testRoom.moveLeft();
                                        menu.clearWindow();
                                        testRoom.printRoom();
                                        Thread.sleep(1000);
                                        continue;
                                    }
                                } catch (ArrayIndexOutOfBoundsException r) {

                                }

                            }
                            System.out.println("Found the EXIT!");
                            Thread.sleep(3000);
                            System.out.println("I'll MARK this EXIT, time to kill and loot before i head out of here!");

                        }
                    }
                }
            }
        }
    }

    public void dropEverythingAndGoToEXit(boolean sentBool) throws IOException, InterruptedException {

        wantToExit = sentBool;
        System.out.println("Let's head back to the EXIT");

        while (wantToExit) {

            menu.clearWindow();
            testRoom.printRoom();

            for (int rows = 0; rows < testRoom.getRooms().length; rows++) {
                for (int columns = 0; columns < testRoom.getRooms()[rows].length; columns++) {
                    if (testRoom.getRooms()[rows][columns].equals("[A]")) {
                        do {
                            if (testRoom.getExitPositionX() < rows) {
                                testRoom.moveUp();
                            }
                            if (testRoom.getExitPositionX() > rows) {
                                testRoom.moveDown();
                            }
                            if (testRoom.getExitPositionY() < columns) {
                                testRoom.moveLeft();
                            }
                            if (testRoom.getExitPositionY() < columns) {
                                testRoom.moveRight();
                            }
                        } while (!testRoom.getRooms()[rows][columns].equals("[E]"));
                        {

                        }
                    }
                }
            }
        }
    }

    public void doProgressionForTest() throws IOException, InterruptedException {

        boolean canIExit = false;


        while (progressAfterExitDiscovery) {

            menu.clearWindow();
            testRoom.printRoom();
            Thread.sleep(1000);
            int randomAiChoice = testRoom.random.nextInt(4);

            switch (randomAiChoice) {


                case 0:
                    testRoom.moveDown();
                    canIExit = testRoom.isPermissionToExit();
                    if (canIExit && wantToExit) {
                        progressAfterExitDiscovery = false;
                    }
                    break;
                case 1:
                    testRoom.moveUp();
                    canIExit = testRoom.isPermissionToExit();
                    if (canIExit && wantToExit) {
                        progressAfterExitDiscovery = false;
                    }
                    break;
                case 2:
                    testRoom.moveLeft();
                    canIExit = testRoom.isPermissionToExit();
                    if (canIExit && wantToExit) {
                        progressAfterExitDiscovery = false;
                    }
                    break;
                case 3:
                    testRoom.moveRight();
                    canIExit = testRoom.isPermissionToExit();
                    if (canIExit && wantToExit) {
                        progressAfterExitDiscovery = false;
                    }
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
        boolean fleestatus = false;
        this.monsterToFight = this.rooms.getMonstersToFight();


        Combat combat = new Combat();
        combat.setFlee(false);
        if (this.monsterToFight.size() == 0) {

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
        if (this.monsterToFight.size() > 0) {

            fleestatus = combat.combatStart(this.rooms.getMonstersToFight(), this.menu.getMyCharacter(), this.rooms);
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

    public boolean isMovementBool() {
        return movementBool;
    }

    public void setMovementBool(boolean movementBool) {
        this.movementBool = movementBool;
    }

    public boolean isWantToExit() {
        return wantToExit;
    }

    public void setWantToExit(boolean wantToExit) {
        this.wantToExit = wantToExit;
    }

    public boolean isProgressAfterExitDiscovery() {
        return progressAfterExitDiscovery;
    }

    public void setProgressAfterExitDiscovery(boolean progressAfterExitDiscovery) {
        this.progressAfterExitDiscovery = progressAfterExitDiscovery;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    public int getMinIndex() {
        return minIndex;
    }

    public void setMinIndex(int minIndex) {
        this.minIndex = minIndex;
    }

    public int getAreaRows() {
        return areaRows;
    }

    public void setAreaRows(int areaRows) {
        this.areaRows = areaRows;
    }

    public int getAreaColumns() {
        return areaColumns;
    }

    public void setAreaColumns(int areaColumns) {
        this.areaColumns = areaColumns;
    }

    public boolean isNavigationBool() {
        return navigationBool;
    }

    public void setNavigationBool(boolean navigationBool) {
        this.navigationBool = navigationBool;
    }

    public boolean isNavigationBoolGoToExit() {
        return navigationBoolGoToExit;
    }

    public void setNavigationBoolGoToExit(boolean navigationBoolGoToExit) {
        this.navigationBoolGoToExit = navigationBoolGoToExit;
    }
}
