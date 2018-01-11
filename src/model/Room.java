package model;

public class Room {
    private int playerPositionX;
    private int playerPositionY;
    private int playerPosition;
    private int level;

    int[][] rooms;

    public Room(int playerPositionX, int playerPositionY, int level) {
        this.playerPositionX = playerPositionX;
        this.playerPositionY = playerPositionY;
        this.level = level;
        createGame();
    }

    /*
     *This function creates rooms based of level and sets player position to one of the rooms
     */
    public void createGame(){

        if(level==1){
            this.rooms = new int[3][3];
            playerPosition=rooms[this.playerPositionX][this.playerPositionY];

            // rooms[this.playerPositionX][this.playerPositionY]=playerPosition;

        }

        if(level==2){
            this.rooms = new int[4][4];
            playerPosition=rooms[this.playerPositionX][this.playerPositionY];

           // rooms[this.playerPositionX][this.playerPositionY]=playerPosition;

        }

        if(level==3){
            this.rooms = new int[7][7];
            playerPosition=rooms[this.playerPositionX][this.playerPositionY];

           // rooms[this.playerPositionX][this.playerPositionY]=playerPosition;

        }



    }

}
