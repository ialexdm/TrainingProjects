package Lesson3;


import java.util.*;

public class Main {
    public static void main(String... args){
        Integer[] array = new Integer[400];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(array.length);
        }
        System.out.println("array: " + Arrays.toString(array));
        /*
                Задание 3.1
        На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
        Оцените время выполнения преобразования.
         */
        long start = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<>();
     //  for (Integer i: array
     //       ) {
     //      arrayList.add(i);
     //  }
        Collections.addAll(arrayList, array);

        long finish = System.nanoTime() - start;
        System.out.println("ArrayList: " + arrayList);
        System.out.println("Change time: " + finish + " nanoseconds");

        /*
                Задание 3.2
        На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта или элемента из списка.
        Оценить выполненные методы с помощью базового класса System.nanoTime().
         */
        start = System.nanoTime();
        arrayList.get(random.nextInt(300));
        finish = System.nanoTime() - start;
        System.out.println("getting time: " + finish + " nanoseconds");
        start = System.nanoTime();
        arrayList.remove(random.nextInt(300));
        finish = System.nanoTime() - start;
        System.out.println("removing time: " + finish + " nanoseconds");
        start = System.nanoTime();
        arrayList.add(random.nextInt(300));
        finish = System.nanoTime() - start;
        System.out.println("adding time: " + finish + " nanoseconds");

        /*
                Задание 3.3
        Реализуйте простой односвязный список и его базовые методы.
         */
        SinglelinkedList<Integer> singlelinkedList = new SinglelinkedList<>();
        for (int i = 0; i< 10; i++){
            singlelinkedList.insert(random.nextInt(10));
        }
        System.out.println(singlelinkedList.isEmpty());
        singlelinkedList.display();
        System.out.println(singlelinkedList.find(7));
        singlelinkedList.delete();
        singlelinkedList.display();
        /*
                Задание 3.4
        На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
        Реализуйте список заполненный объектами из вашего класса из задания 1.3
         */
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        System.out.println("LinkedList: " + linkedList);
        start = System.nanoTime();
        linkedList.get(random.nextInt(300));
        finish = System.nanoTime() - start;
        System.out.println("getting time: " + finish + " nanoseconds");
        start = System.nanoTime();
        linkedList.remove(random.nextInt(300));
        finish = System.nanoTime() - start;
        System.out.println("removing time: " + finish + " nanoseconds");
        start = System.nanoTime();
        linkedList.add(random.nextInt(300));
        finish = System.nanoTime() - start;
        System.out.println("adding time: " + finish + " nanoseconds");
        start = System.nanoTime();
        linkedList.getFirst();
        finish = System.nanoTime() - start;
        System.out.println("getting start: " + finish + " nanoseconds");
        start = System.nanoTime();
        linkedList.getLast();
        finish = System.nanoTime() - start;
        System.out.println("getting start: " + finish + " nanoseconds");

        LinkedList<StringBuilder> myClassLinkedList = new LinkedList<>();
        for (int i =0; i < 5; i++){
            myClassLinkedList.add(new StringBuilder());
        }
        /*
        Задание 3.5
        Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
                Оцените время выполнения операций с помощью базового метода System.nanoTime()
         */
        Iterator<Integer> iterator = linkedList.iterator();
        start = System.nanoTime();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+ ", ");
        }
        System.out.println();
        finish = System.nanoTime() - start;
        System.out.println("iterator time: " + finish + " nanoseconds");




    }
}
