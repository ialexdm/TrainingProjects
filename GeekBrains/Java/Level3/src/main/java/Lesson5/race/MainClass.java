package Lesson5.race;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
/*Организуем гонки:
        Все участники должны стартовать одновременно, несмотря на то, что на подготовку у каждого из них уходит разное время.
        В туннель не может заехать одновременно больше половины участников (условность).
        Попробуйте всё это синхронизировать.
        Только после того как все завершат гонку, нужно выдать объявление об окончании.
        Можете корректировать классы (в т.ч. конструктор машин) и добавлять объекты классов из пакета util.concurrent.*/

public class MainClass {
    public static String winner;
    public static final int CARS_COUNT = 4;
    public static CountDownLatch ready;
    public static CyclicBarrier starter;
    public static CountDownLatch finish;
    public static void main(String[] args) {
        starter = new CyclicBarrier(MainClass.CARS_COUNT);
        ready = new CountDownLatch(CARS_COUNT);
        finish = new CountDownLatch(CARS_COUNT);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            ready.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        try {
            finish.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Победитель: " + winner);
    }
}

