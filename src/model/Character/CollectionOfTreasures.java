package model.Character;


import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.io.Serializable;


/// Test of Total Score items Data
public class CollectionOfTreasures implements Serializable {

    public ArrayList<Character> treasuresArrayList;

    public CollectionOfTreasures(ArrayList<Character> treasuresArrayList) {
        this.treasuresArrayList = treasuresArrayList;
    }

    public CollectionOfTreasures() {
        this.treasuresArrayList = new ArrayList<>();
    }

    // function that calls upon getcoin, shuld it be a function to call the sum of colled coins etc.
    public boolean addChar(Character character){

        if (character.getName().equals("") || character.getName().toUpperCase().equals("EMPTY") || character.getName().length() > 15 || character.getName().length() < 1){
            return false;

        }

        for (Character e : this.treasuresArrayList) {
            if (e.getName().equals(character.getName())){
                return false;
            }
        }

        this.treasuresArrayList.add(character);
        return true;
    }
    //Function to Reset High Score
    public boolean resetStats (String character ){
        for (Character e: this.treasuresArrayList) {
            if (e.getName().equals(character)){
                this.treasuresArrayList.remove(e);
                return true;
            }
        }
        return false;
    }

    /// Search for highest Score + Name of player
    public Character getTotalScore(String charName){
        for (Character e: this.treasuresArrayList) {
            if (e.getName().equals(charName)){
                return e;
            }
        }
        return null;
    }
/*
    public Character getTotalScore(String charName){
        for (Character e: this.treasuresArrayList) {
            if (e.getName().equals(charName)){
                return e;
            }
        }
        return null;
    }
*/

    public void openFunc() throws Exception{
        try {
            FileInputStream fis = new FileInputStream("TreasureData.ser");
            ObjectInputStream in = new ObjectInputStream(fis);
            treasuresArrayList = (ArrayList<Character>) in.readObject();
            in.close();
            fis.close();
        } catch (Exception e){

        }
    }
    public void saveFunc(){
        try{
            FileOutputStream fos = new FileOutputStream("TreasureData.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(treasuresArrayList);
            oos.flush();
            oos.close();
            fos.close();
        }catch (Exception e){
        }
    }

    public ArrayList<Character> getTreasuresArrayList() {
        return treasuresArrayList;
    }

    public void setTreasuresArrayList(ArrayList<Character> treasuresArrayList) {
        this.treasuresArrayList = treasuresArrayList;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof CollectionOfTreasures))return false;
        CollectionOfTreasures that = (CollectionOfTreasures) o;
        return Objects.equals(getTreasuresArrayList(),that.getTreasuresArrayList());
    }
    //@Override
    public int hashcode(){

        return Objects.hash(getTreasuresArrayList());
    }
}
