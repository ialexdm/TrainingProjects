package Lesson4;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Burn> burns  = new LinkedList<>();
        for (int i = 0; i < 30; i++) {
            burns.add(new Burn());
        }

    }
}
