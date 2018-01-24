package model.Character;

import model.Monster.Monster;

import java.util.ArrayList;

public class CollectionOfMonsters {

    private ArrayList<Monster> listOfMonsters;



    /*public CollectionOfMonsters(ArrayList<Monster> monster) {
        listOfMonsters=monster;
    }*/

    public CollectionOfMonsters(ArrayList<Monster> listOfMonsters) {
        this.listOfMonsters = listOfMonsters;
    }

    public void setListOfMonsters(ArrayList<Monster> listOfMonsters) {
        this.listOfMonsters = listOfMonsters;
    }

    public ArrayList<Monster> getListOfMonsters() {
        return listOfMonsters;
    }

}
