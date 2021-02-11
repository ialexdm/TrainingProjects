import java.io.IOException;

public class Main {

    public static void main(String[] lciCheckingTools) {
        long startTime = System.currentTimeMillis();
        try {
            Table table = new Table();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
