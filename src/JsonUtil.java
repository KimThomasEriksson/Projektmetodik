import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Character.Character;
import model.Character.Theif;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonUtil {
    public static void main(String[] args) {
        serlize();
    }
    private static void serlize() {
        Theif char1 = new Theif();
        Theif char2 = new Theif();

        Gson gson = new Gson();
        String json = gson.toJson(char1);
        String json2 = gson.toJson(char2);
        try(FileWriter file = new FileWriter("file1.txt")){
            file.write(json);
            file.write(json2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            JsonParser parser = new JsonParser();
           Object obj = parser.parse(new FileReader("file1.txt"));
            JsonObject jsonObject = (JsonObject) obj;

            String name = (String) jsonObject.get("classType");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
