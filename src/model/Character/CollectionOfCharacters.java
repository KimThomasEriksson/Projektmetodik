package model.Character;

import java.io.*;
import java.util.ArrayList;

public class CollectionOfCharacters implements Serializable {
    private ArrayList<Character> characterArrayList;

    public CollectionOfCharacters(ArrayList<Character> characterArrayList) {
        this.characterArrayList = characterArrayList;
    }

    public void addChar(Character character){
        this.characterArrayList.add(character);
    }

    public void deleteChar(Character character){
        this.characterArrayList.remove(character);
    }

    public void openFunc(String filename){
        try {
            FileInputStream fis = new FileInputStream(filename+".txt");
            ObjectInputStream in = new ObjectInputStream(fis);
            characterArrayList = (ArrayList) in.readObject();
            in.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveFunc(String filename) throws IOException {
        File f = new File(filename+".txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(characterArrayList);
        oos.flush();
        oos.close();
    }
}
