import com.google.gson.Gson;
import model.Character.Thief;

import java.io.*;

public class JsonUtil {
    public static void main(String[] args) {
        serlize();
    }
    private static void serlize() {
        Thief char1 = new Thief();
        Thief char2 = new Thief();

        Gson gson = new Gson();
        String json = gson.toJson(char1);
        String json2 = gson.toJson(char2);
        /*try(FileWriter file = new FileWriter("file1.txt")){
            file.write(json);
            file.write(json2);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        String fileContent="";
        try {
            File f = new File("file1.txt");
            FileInputStream inp = new FileInputStream(f);
            byte[] bf = new byte[(int)f.length()];
            inp.read(bf);
            fileContent = new String(bf, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fileContent);

        Character char3 = new Gson().fromJson(fileContent,Character.class);

        System.out.println(char3);
    }
}
