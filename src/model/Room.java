package model;

import model.Monster.Monster;

import java.util.ArrayList;
import java.util.Random;

public class Room {


    private int playerPositionX;
    private int playerPositionY;
    private int startPositionX;
    private int startPositionY;
    private String playerPosition="[P]";
    private String exitPosition = "[E]";
    private boolean exitVisited = false;
    private boolean permissionToExit = false;
    private int exitPositionX;
    private int exitPositionY;
    private int level;
    private String[][] rooms;
    private ArrayList<Monster> monstersToFight;
    private int oldPlayerPositionX;
    private int oldPlayerPositionY;
    Random random = new Random();

    // This is a "cell" we can use this concept for AI architect where we store -1,0,1
    private int miniMaxValue;

    public Room(int playerPositionX, int playerPositionY, int level) {
        this.playerPositionX = playerPositionX;
        this.playerPositionY = playerPositionY;
        this.startPositionX = playerPositionX;
        this.startPositionY = playerPositionY;
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

    public void flee(){
        this.rooms[this.playerPositionX][this.playerPositionY]="[X]";
        this.rooms[oldPlayerPositionX][oldPlayerPositionY]=playerPosition;
        this.playerPositionX=oldPlayerPositionX;
        this.playerPositionY=oldPlayerPositionY;
    }

    public void randomExitPositions(int x, int y){
        exitPositionX = random.nextInt(x);
        exitPositionY = random.nextInt(y);
    }

    public boolean moveDown(){
        this.oldPlayerPositionX=this.playerPositionX;
        this.oldPlayerPositionY=this.playerPositionY;
        String Roomcondition;
        permissionToExit = false;
        try{

            this.rooms[this.playerPositionX][this.playerPositionY] ="[ ]";
            this.playerPositionX++;
            Roomcondition=this.rooms[this.playerPositionX][this.playerPositionY];
            this.rooms[this.playerPositionX][this.playerPositionY]=playerPosition;

            if (this.playerPositionX == this.exitPositionX && this.playerPositionY == this.exitPositionY){
                permissionToExit = true;
                exitVisited = true;
                this.rooms[this.playerPositionX][playerPositionY] = exitPosition;
                return false;
            }

            if (Roomcondition.equals("[X]")){
                this.monstersToFight=controller.RandGenerator.rollTheDice(this.level);

                return true;

            }else{
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
        this.oldPlayerPositionX=this.playerPositionX;
        this.oldPlayerPositionY=this.playerPositionY;
        String Roomcondition;
        permissionToExit = false;
        try{

            this.rooms[this.playerPositionX][this.playerPositionY] ="[ ]";
            this.playerPositionX--;
            Roomcondition=this.rooms[this.playerPositionX][this.playerPositionY];
            this.rooms[this.playerPositionX][this.playerPositionY]=playerPosition;

            if (this.playerPositionX == this.exitPositionX && this.playerPositionY == this.exitPositionY){
                permissionToExit = true;
                exitVisited = true;
                this.rooms[this.playerPositionX][playerPositionY] = exitPosition;
                return false;
            }

            if (Roomcondition.equals("[X]")){
                this.monstersToFight=controller.RandGenerator.rollTheDice(this.level);
                return true;

            }else{
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
        this.oldPlayerPositionX=this.playerPositionX;
        this.oldPlayerPositionY=this.playerPositionY;
        String Roomcondition;
        permissionToExit = false;
        try{

            this.rooms[this.playerPositionX][this.playerPositionY] ="[ ]";
            this.playerPositionY--;
            Roomcondition=this.rooms[this.playerPositionX][this.playerPositionY];
            this.rooms[this.playerPositionX][this.playerPositionY]=playerPosition;

            if (this.playerPositionX == this.exitPositionX && this.playerPositionY == this.exitPositionY){
                permissionToExit = true;
                exitVisited = true;
                this.rooms[this.playerPositionX][playerPositionY] = exitPosition;
                return false;
            }

            if (Roomcondition.equals("[X]")){
                this.monstersToFight=controller.RandGenerator.rollTheDice(this.level);
                return true;

            }else{
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
        this.oldPlayerPositionX=this.playerPositionX;
        this.oldPlayerPositionY=this.playerPositionY;
        String Roomcondition;
        permissionToExit = false;
        try{

            this.rooms[this.playerPositionX][this.playerPositionY] ="[ ]";
            this.playerPositionY++;
            Roomcondition=this.rooms[this.playerPositionX][this.playerPositionY];
            this.rooms[this.playerPositionX][this.playerPositionY]=playerPosition;

            if (this.playerPositionX == this.exitPositionX && this.playerPositionY == this.exitPositionY){
                permissionToExit = true;
                exitVisited = true;
                this.rooms[this.playerPositionX][playerPositionY] = exitPosition;
                return false;
            }

            if (Roomcondition.equals("[X]")){
                this.monstersToFight=controller.RandGenerator.rollTheDice(this.level);
                return true;

            }else{
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
            while(startPositionX == exitPositionX && startPositionY == exitPositionY){
                randomExitPositions(4,4);
            }
            this.rooms[this.exitPositionX][this.exitPositionY]=exitPosition;
            return;
        }

        if(level==2){
            this.rooms = new String[5][5];
            while(startPositionX == exitPositionX && startPositionY == exitPositionY){
                randomExitPositions(5,5);
            }
            this.rooms[this.exitPositionX][this.exitPositionY]=exitPosition;
            return;
        }

        if(level==3){
            this.rooms = new String[8][8];
            while(startPositionX == exitPositionX && startPositionY == exitPositionY){
                randomExitPositions(8,8);
            }
            this.rooms[this.exitPositionX][this.exitPositionY]=exitPosition;
            return;
        }
    }

    public ArrayList<Monster> getMonstersToFight() {
        return monstersToFight;
    }

    public String[][] getRooms() {
        return rooms;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public int getOldPlayerPositionX() {
        return oldPlayerPositionX;
    }

    public int getOldPlayerPositionY() {
        return oldPlayerPositionY;
    }

    public void setRooms(String[][] rooms) {
        this.rooms = rooms;
    }

    public int getPlayerPositionX() {
        return playerPositionX;
    }

    public void setPlayerPositionX(int playerPositionX) {
        this.playerPositionX = playerPositionX;
    }

    public int getPlayerPositionY() {
        return playerPositionY;
    }

    public void setPlayerPositionY(int playerPositionY) {
        this.playerPositionY = playerPositionY;
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

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getExitPosition() {
        return exitPosition;
    }

    public void setExitPosition(String exitPosition) {
        this.exitPosition = exitPosition;
    }

    public boolean isExitVisited() {
        return exitVisited;
    }

    public void setExitVisited(boolean exitVisited) {
        this.exitVisited = exitVisited;
    }

    public boolean isPermissionToExit() {
        return permissionToExit;
    }

    public void setPermissionToExit(boolean permissionToExit) {
        this.permissionToExit = permissionToExit;
    }

    public int getExitPositionX() {
        return exitPositionX;
    }

    public void setExitPositionX(int exitPositionX) {
        this.exitPositionX = exitPositionX;
    }

    public int getExitPositionY() {
        return exitPositionY;
    }

    public void setExitPositionY(int exitPositionY) {
        this.exitPositionY = exitPositionY;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMonstersToFight(ArrayList<Monster> monstersToFight) {
        this.monstersToFight = monstersToFight;
    }

    public void setOldPlayerPositionX(int oldPlayerPositionX) {
        this.oldPlayerPositionX = oldPlayerPositionX;
    }

    public void setOldPlayerPositionY(int oldPlayerPositionY) {
        this.oldPlayerPositionY = oldPlayerPositionY;
    }

    public int getMiniMaxValue() {
        return miniMaxValue;
    }

    public void setMiniMaxValue(int miniMaxValue) {
        this.miniMaxValue = miniMaxValue;
    }
}
