package model;
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
    private int startPosition;
    private int startPositionX;
    private int startPositionY;
    private ArrayList<Monster> monsterToFight;
    private Room rooms;
    private Menu menu;
    private Scanner scanner;


    public Adventure(Menu menu) {
        this.menu=menu;
        this.menu.setMyAdventure(this);
        this.startPosition = this.menu.getStartingCorner();
        this.level = this.menu.getSubmitDifficulty();
        scanner = new Scanner(System.in);
    }

    public void startNewRoom() throws IOException, InterruptedException {
        getStartingPositions();
        this.rooms = new Room(startPositionX,startPositionY,level);
        gameRound();

    }

    public void gameRound() throws IOException, InterruptedException {

        String w = "W";
        String a = "A";
        String d = "D";
        String s = "S";

        while(true){

            menu.clearWindow();
            rooms.printRoom();
            System.out.println("Which direction do u want to go?\n\n" +
                            "[W]Go Up\n" +
                            "[A]Go Left\n" +
                            "[D]Go Right\n" +
                            "[S]Go Down\n\n\n" +
                            "\t\t\t\t[0]EXIT");

            String gameRoundInput = scanner.nextLine().toUpperCase();


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
                    menu.setMenuThirdPhase(true);
                    menu.thirdMenuGameLoader();

                    break;

            }




        }

    }

    public void flee(){
        String[][] room;
        room=rooms.getRooms();
        room[rooms.getOldPlayerPositionX()][rooms.getOldPlayerPositionY()]=rooms.getPlayerPosition();
        rooms.flee();

        rooms.setRooms(room);
    }

    public void startFight(){

        this.monsterToFight=this.rooms.getMonstersToFight();
        Combat combat = new Combat();
        for (int i = 0; i < this.monsterToFight.size(); i++){

            combat.combatStart(this.monsterToFight.get(i),this.menu.getMyCharacter(),this.rooms);


        }


    }

    public void makeAMove(String direction){
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
