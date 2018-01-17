package model;

import model.Monster.Monster;

import java.util.ArrayList;

public class Room {
    private int playerPositionX;
    private int playerPositionY;
    private String playerPosition="[P]";
    private int level;
    private String[][] rooms;
    private ArrayList<Monster> monstersToFight;




    public Room(int playerPositionX, int playerPositionY, int level) {
        this.playerPositionX = playerPositionX;
        this.playerPositionY = playerPositionY;
        this.level = level;

        createGame();
        fillRoom();
    }

    public int getLevel() {
        return level;
    }

    public void printRoom(){
        String stringToReturn="";

        for(int rows=0;rows<this.rooms.length;rows++){
            stringToReturn+=rows;
            for(int columns=0;columns <this.rooms[rows].length;columns++){
                stringToReturn+=columns;

                System.out.print(rooms[rows][columns]  );}
            System.out.println();}



    }
//





    public boolean moveDown(){
        ArrayList<Monster> listToReturn = new ArrayList<>();
        int oldPlayerPositionX=this.playerPositionX;
        int oldPlayerPositionY=this.playerPositionY;
        String Roomcondition;
        try{

            this.rooms[this.playerPositionX][this.playerPositionY] ="[ ]";
            this.playerPositionX++;
            Roomcondition=this.rooms[this.playerPositionX][this.playerPositionY];
            this.rooms[this.playerPositionX][this.playerPositionY]=playerPosition;

            if (Roomcondition.equals("[X]")){
                this.monstersToFight=controller.RandGenerator.rollTheDice(this.level);

                return true;

            }else{
                System.out.println("You have been here before");
                return false;
            }


        }catch (ArrayIndexOutOfBoundsException e){
            this.playerPositionX=oldPlayerPositionX;
            this.playerPositionY=oldPlayerPositionY;
            System.out.println("You can't walk that way");
            this.rooms[oldPlayerPositionX][oldPlayerPositionY]=playerPosition;
            return false;


        }
    }

    public boolean moveUp(){
        ArrayList<Monster> listToReturn = new ArrayList<>();
        int oldPlayerPositionX=this.playerPositionX;
        int oldPlayerPositionY=this.playerPositionY;
        String Roomcondition;
        try{

            this.rooms[this.playerPositionX][this.playerPositionY] ="[ ]";
            this.playerPositionX--;
            Roomcondition=this.rooms[this.playerPositionX][this.playerPositionY];
            this.rooms[this.playerPositionX][this.playerPositionY]=playerPosition;


            if (Roomcondition.equals("[X]")){
                this.monstersToFight=controller.RandGenerator.rollTheDice(this.level);
                return true;

            }else{
                System.out.println("You have been here before");
                return false;
            }

        }catch (ArrayIndexOutOfBoundsException e){
            this.playerPositionX=oldPlayerPositionX;
            this.playerPositionY=oldPlayerPositionY;
            System.out.println("You can't walk that way");
            this.rooms[oldPlayerPositionX][oldPlayerPositionY]=playerPosition;
            return false;

        }



    }

    public boolean moveLeft(){
        ArrayList<Monster> listToReturn = new ArrayList<>();
        int oldPlayerPositionX=this.playerPositionX;
        int oldPlayerPositionY=this.playerPositionY;
        String Roomcondition;
        try{

            this.rooms[this.playerPositionX][this.playerPositionY] ="[ ]";
            this.playerPositionY--;
            Roomcondition=this.rooms[this.playerPositionX][this.playerPositionY];
            this.rooms[this.playerPositionX][this.playerPositionY]=playerPosition;

            if (Roomcondition.equals("[X]")){
                this.monstersToFight=controller.RandGenerator.rollTheDice(this.level);
                return true;

            }else{
                System.out.println("You have been here before");
                return false;
            }

        }catch (ArrayIndexOutOfBoundsException e){
            this.playerPositionX=oldPlayerPositionX;
            this.playerPositionY=oldPlayerPositionY;
            System.out.println("You can't walk that way");
            this.rooms[oldPlayerPositionX][oldPlayerPositionY]=playerPosition;
            return false;

        }

    }

    public boolean moveRight(){
        int oldPlayerPositionX=this.playerPositionX;
        int oldPlayerPositionY=this.playerPositionY;
        String Roomcondition;
        try{

            this.rooms[this.playerPositionX][this.playerPositionY] ="[ ]";
            this.playerPositionY++;
            Roomcondition=this.rooms[this.playerPositionX][this.playerPositionY];
            this.rooms[this.playerPositionX][this.playerPositionY]=playerPosition;

            if (Roomcondition.equals("[X]")){
                this.monstersToFight=controller.RandGenerator.rollTheDice(this.level);
                return true;

            }else{
                System.out.println("You have been here before");
                return false;
            }

        }catch (ArrayIndexOutOfBoundsException e){
            this.playerPositionX=oldPlayerPositionX;
            this.playerPositionY=oldPlayerPositionY;
            System.out.println("You can't walk that way");
            this.rooms[oldPlayerPositionX][oldPlayerPositionY]=playerPosition;
            return false;

        }

    }


    public void fillRoom(){

        for(int rows=0;rows<this.rooms.length;rows++) {
            for (int columns = 0; columns < this.rooms[rows].length; columns++) {
                this.rooms[rows][columns] = "[X]";
                //System.out.print(rooms[rows][columns] + "\t");
            }

        }

        this.rooms[this.playerPositionX][this.playerPositionY]=playerPosition;



    }

    /*
     *This function creates rooms based of level and sets player position to one of the rooms
     */
    public void createGame(){

        if(level==1){
            this.rooms = new String[4][4];


        }

        if(level==2){
            this.rooms = new String[5][5];


        }

        if(level==3){
            this.rooms = new String[8][8];




        }



    }

    public ArrayList<Monster> getMonstersToFight() {
        return monstersToFight;
    }
}
