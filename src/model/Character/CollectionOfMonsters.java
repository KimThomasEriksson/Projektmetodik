package model.Character;

import model.Monster.Monster;

import java.util.ArrayList;

public class CollectionOfMonsters {

    private ArrayList<Monster> listOfMonsters;
    private int timesFled;



    /*public CollectionOfMonsters(ArrayList<Monster> monster) {
        listOfMonsters=monster;
    }*/

    public CollectionOfMonsters(ArrayList<Monster> listOfMonsters) {
        this.listOfMonsters = listOfMonsters;
        this.timesFled=0;

    }

    public void setListOfMonsters(ArrayList<Monster> listOfMonsters) {
        this.listOfMonsters = listOfMonsters;
    }

    public ArrayList<Monster> getListOfMonsters() {
        return listOfMonsters;
    }

    public int getTimesFled() {
        return timesFled;
    }

    public void setTimesFled(int timesFled) {
        this.timesFled = timesFled;
    }
    public void incTimesFled(){
        this.timesFled++;
    }
}
