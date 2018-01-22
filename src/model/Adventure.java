package model;
import controller.RandGenerator;
import model.Character.Character;
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


    public Adventure(Menu menu) {
        this.menu=menu;
        this.menu.setMyAdventure(this);

    }

    public void startNewRoom() throws IOException, InterruptedException {

        this.startPosition = this.menu.getStartingCorner();
        this.level = this.menu.getSubmitDifficulty();
        scanner = new Scanner(System.in);
        getStartingPositions();
        this.rooms = new Room(startPositionX,startPositionY,level);
        gameRound();

    }

    public void gameRound() throws IOException, InterruptedException {

        String w = "W";
        String a = "A";
        String d = "D";
        String s = "S";
        String e = "";

        while(true){

            menu.clearWindow();
            rooms.printRoom();
            if(rooms.isPermissionToExit()){
                e = "You found the EXIT!\t[0]EXIT";
            }
            if(!rooms.isPermissionToExit()){
                e = "";
            }
            System.out.println("Which direction do u want to go?\n\n" +
                            "[W]Go Up\n" +
                            "[A]Go Left\n" +
                            "[D]Go Right\n" +
                            "[S]Go Down\n\n\n" +
                            "" +e);

            String gameRoundInput = scanner.nextLine().toUpperCase();
            boolean permissionToExit = false;

            switch (gameRoundInput){

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
                    if (rooms.isPermissionToExit()){
                        menu.setMenuThirdPhase(true);
                        menu.thirdMenuGameLoader();
                    }
                    break;

            }
        }
    }

    public void flee(){
        this.flee=true;
        String[][] room;
        room=rooms.getRooms();
        room[rooms.getOldPlayerPositionX()][rooms.getOldPlayerPositionY()]=rooms.getPlayerPosition();
        rooms.flee();

        rooms.setRooms(room);
    }

    public void startFight() throws IOException, InterruptedException {

        this.monsterToFight=this.rooms.getMonstersToFight();

        Combat combat = new Combat();
        combat.setFlee(false);
        for (int i = 0; i < this.monsterToFight.size(); i++){

            combat.combatStart(this.monsterToFight.get(i),this.menu.getMyCharacter(),this.rooms);


        }

        boolean fleestatus=combat.getFlee();

        if(fleestatus==false){
            int roomItems;
            roomItems=RandGenerator.ItemGenerator(this.menu.getMyCharacter());


            totalCoins+=roomItems;
            if(roomItems>0){
                System.out.println("\n\nPress any key to continue...");
                scanner.nextLine();
            }

        }


    }

    public void makeAMove(String direction) throws IOException, InterruptedException {
        Boolean fight=false;


        if(direction.equals("W")){
            fight=this.rooms.moveUp();

            if(fight){
                startFight();
            }


        }

        if(direction.equals("S")){

            fight=this.rooms.moveDown();

            if(fight){
                startFight();
            }


        }

        if(direction.equals("A")){

            fight=this.rooms.moveLeft();

            if(fight){
                startFight();
            }


        }

        if(direction.equals("D")){

            fight=this.rooms.moveRight();

            if(fight){
                startFight();
            }


        }
    }

    public Character getMyCharacter() {
        return myCharacter;
    }


    public void setMyCharacter(Character myCharacter) {
        this.myCharacter =new Character();
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
    public void getStartingPositions(){

        //level 1= 4x4 rooms
        if(this.level==1) {
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
        }
            //level 2= 5x5 rooms
        if(this.level==2){
            if(this.startPosition==1){
                this.startPositionX=0;
                this.startPositionY=0;


            }
            if(this.startPosition==2){
                this.startPositionX=0;
                this.startPositionY=4;

            }
            if(this.startPosition==3){
                this.startPositionX=4;
                this.startPositionY=0;

            }
            if(this.startPosition==4){
                this.startPositionX=4;
                this.startPositionY=4;

            }
        }

        //level 3= 8x8 rooms
        if(this.level==3){
            if(this.startPosition==1){
                this.startPositionX=0;
                this.startPositionY=0;


            }
            if(this.startPosition==2){
                this.startPositionX=0;
                this.startPositionY=7;

            }
            if(this.startPosition==3){
                this.startPositionX=7;
                this.startPositionY=0;

            }
            if(this.startPosition==4){
                this.startPositionX=7;
                this.startPositionY=7;

            }
        }


    }


}
