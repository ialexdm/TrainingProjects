import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

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
    public void setPath(String name) {
        //TODO
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name))) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
