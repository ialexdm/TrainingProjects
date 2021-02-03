package Lesson5;

public class Abc {
    static Object monitor;
    static char current = 'A';
    public static void main(String[] args) {
        //Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз
        // (порядок – ABСABСABС). Используйте wait/notify/notifyAll.

        monitor = new Object();
        Thread a = new Thread(() -> {
            printChar('A','B');
        });
        Thread b = new Thread(() -> {
            printChar('B','C');
        });
        Thread c = new Thread(() -> {
            printChar('C', 'A');
        });
        a.start();
        b.start();
        c.start();
    }

    public static void printChar(char character, char newCurrentChar) {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (current != character) {
                        monitor.wait();
                    }
                    System.out.print(character);
                    current = newCurrentChar;
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
