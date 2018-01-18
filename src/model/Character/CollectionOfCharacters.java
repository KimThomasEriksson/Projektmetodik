package model.Character;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class CollectionOfCharacters implements Serializable {

    public ArrayList<Character> characterArrayList;

    public CollectionOfCharacters(ArrayList<Character> characterArrayList) {
        this.characterArrayList = characterArrayList;
    }

    public CollectionOfCharacters() {
        this.characterArrayList = new ArrayList<>();
    }

    public boolean addChar(Character character){

        if (character.getName().equals("") || character.getName().toUpperCase().equals("EMPTY") || character.getName().length() > 15 || character.getName().length() < 1){
            return false;
        }

        for (Character e : this.characterArrayList) {
            if (e.getName().equals(character.getName())){
                return false;
            }

        }
        this.characterArrayList.add(character);
        return true;
    }

    public boolean deleteChar(Character character){

        for (Character e: this.characterArrayList){
            if (e.getName().equals(character.getName())){
                this.characterArrayList.remove(character);
                return true;
            }
        }
        return false;
    }

    public Character searchCharacter(String charName){
        for (Character e: this.characterArrayList) {
            if (e.getName().equals(charName)){
                return e;
            }
        }
        return null;
    }

    public void openFunc(String filename){
        try {
            FileInputStream fis = new FileInputStream(filename+".ser");
            ObjectInputStream in = new ObjectInputStream(fis);
            characterArrayList = (ArrayList<Character>) in.readObject();
            in.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
        }
    }

    public void saveFunc(String filename) throws IOException {
        FileOutputStream f = new FileOutputStream(filename+".ser");
        ObjectOutputStream oos = new ObjectOutputStream(f);
        oos.writeObject(characterArrayList);
        oos.flush();
        oos.close();
        f.close();
    }

    public ArrayList<Character> getCharacterArrayList() {
        return characterArrayList;
    }

    public void setCharacterArrayList(ArrayList<Character> characterArrayList) {
        this.characterArrayList = characterArrayList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CollectionOfCharacters)) return false;
        CollectionOfCharacters that = (CollectionOfCharacters) o;
        return Objects.equals(getCharacterArrayList(), that.getCharacterArrayList());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCharacterArrayList());
    }
}
