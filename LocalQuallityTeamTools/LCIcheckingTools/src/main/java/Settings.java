
import java.io.*;

public class Settings {


    public static String readPath(String name){
        String path = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(name));){
            path = reader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
    public static void setPath(String name, String newPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name))) {
            writer.write(newPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
