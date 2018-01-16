package model;

import java.util.ArrayList;

public class Room {
    private int playerPositionX;
    private int playerPositionY;
    private String playerPosition="[P]";
    private int level;
    String[][] rooms;




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


    public void checkAvalibleMovements(){
        String moveUp="";
        String moveDown="";
        String moveLeft="";
        String moveRight="";

        if(this.level==1){
            if(this.playerPositionX==0){
                moveDown="S";

            }

        }



    }


    public void moveDown(){
        int oldPlayerPositionX=this.playerPositionX;
        int oldPlayerPositionY=this.playerPositionY;
        try{

            this.rooms[this.playerPositionX][this.playerPositionY] ="[ ]";
            this.playerPositionX++;
            this.rooms[this.playerPositionX][this.playerPositionY]=playerPosition;

        }catch (ArrayIndexOutOfBoundsException e){
            this.playerPositionX=oldPlayerPositionX;
            this.playerPositionY=oldPlayerPositionY;
            System.out.println("You can't walk that way");
            this.rooms[oldPlayerPositionX][oldPlayerPositionY]=playerPosition;

        }
    }

    public void moveUp(){
        int oldPlayerPositionX=this.playerPositionX;
        int oldPlayerPositionY=this.playerPositionY;
        try{

            this.rooms[this.playerPositionX][this.playerPositionY] ="[ ]";
            this.playerPositionX--;
            this.rooms[this.playerPositionX][this.playerPositionY]=playerPosition;

        }catch (ArrayIndexOutOfBoundsException e){
            this.playerPositionX=oldPlayerPositionX;
            this.playerPositionY=oldPlayerPositionY;
            System.out.println("You can't walk that way");
            this.rooms[oldPlayerPositionX][oldPlayerPositionY]=playerPosition;

        }



    }

    public void moveLeft(){
        int oldPlayerPositionX=this.playerPositionX;
        int oldPlayerPositionY=this.playerPositionY;
        try{

            this.rooms[this.playerPositionX][this.playerPositionY] ="[ ]";
            this.playerPositionY--;
            this.rooms[this.playerPositionX][this.playerPositionY]=playerPosition;

        }catch (ArrayIndexOutOfBoundsException e){
            this.playerPositionX=oldPlayerPositionX;
            this.playerPositionY=oldPlayerPositionY;
            System.out.println("You can't walk that way");
            this.rooms[oldPlayerPositionX][oldPlayerPositionY]=playerPosition;

        }

    }

    public void moveRight(){
        int oldPlayerPositionX=this.playerPositionX;
        int oldPlayerPositionY=this.playerPositionY;
        try{

            this.rooms[this.playerPositionX][this.playerPositionY] ="[ ]";
            this.playerPositionY++;
            this.rooms[this.playerPositionX][this.playerPositionY]=playerPosition;

        }catch (ArrayIndexOutOfBoundsException e){
            this.playerPositionX=oldPlayerPositionX;
            this.playerPositionY=oldPlayerPositionY;
            System.out.println("You can't walk that way");
            this.rooms[oldPlayerPositionX][oldPlayerPositionY]=playerPosition;

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

}
