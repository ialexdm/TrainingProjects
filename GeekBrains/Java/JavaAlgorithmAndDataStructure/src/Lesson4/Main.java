package Lesson4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        long start;
        long finish;

        /*Задание 4.1
        На основе данных объектного списка из задания 3.4 реализуйте простой стек и его базовые методы.
                Оцените время выполнения операций с помощью базового метода System.nanoTime().

         */
        //начало создания списка из Задания 3.4
        List<Burn> burns  = new LinkedList<>();//как мы видим, в задании 3.4 использовался связанный список
        for (int i = 0; i < 15; i++) {
            burns.add(new Burn());
        }//конец создания списка и вывод на экран всех элементов.
        for (Burn b : burns) {
            b.print();
        }
        System.out.println("начало реализации стека и его базовых методов.");
        Stack<Burn> burnsStack = new Stack<>();
        System.out.println("Добавление элемента в стек.");
        start = System.nanoTime();
        burnsStack.push(burns.get(0));
        finish = System.nanoTime();
        System.out.println("Время добавления элемента в стек: " + (finish - start) + " наносекунд.");
        for (int i = 1; i< burns.size(); i++){
            burnsStack.push(burns.get(i));
        }
        System.out.println("Удаление элемента");
        start = System.nanoTime();
        burnsStack.pop();
        finish = System.nanoTime();
        System.out.println("Время удаления элемента из стека: " + (finish - start) + " наносекунд.");

        System.out.println("Взятие элемента без удаления");
        start = System.nanoTime();
        burnsStack.peek();
        finish = System.nanoTime();
        System.out.println("Время взятия элемента из стека: " + (finish - start) + " наносекунд.");

        System.out.println("конец реализации стека и его базовых методов.");

        /*Задание 4.2
        На основе данных объектного списка из задания 3.4 реализуйте простую очередь и его базовые методы.
        Реализуйте вспомогательные методы.Оцените время выполнения операций с помощью базового метода System.nanoTime().
        */

        System.out.println("начало реализации очереди и ее базовых методов.");
        Queue<Burn> burnQueue = new LinkedList<>(burns);
        System.out.println("Добавление элемента в очередь.add()");
        start = System.nanoTime();
        burnQueue.add(burns.get(0));
        finish = System.nanoTime();
        System.out.println("Время добавления элемента в очередь add(): " + (finish - start) + " наносекунд.");
        for (int i = 1; i< burns.size(); i++){
            burnsStack.push(burns.get(i));
        }
        System.out.println("удаление элемента из очереди.remove()");
        start = System.nanoTime();
        burnQueue.remove();
        finish = System.nanoTime();
        System.out.println("Время удаления элемента из очереди remove(): " + (finish - start) + " наносекунд.");
        System.out.println("просмотр элемента из очереди.element()");
        start = System.nanoTime();
        burnQueue.element();
        finish = System.nanoTime();
        System.out.println("Время просмотра элемента из очереди remove(): " + (finish - start) + " наносекунд.");


        System.out.println("Добавление элемента в очередь.offer()");
        start = System.nanoTime();
        burnQueue.offer(burns.get(0));
        finish = System.nanoTime();
        System.out.println("Время добавления элемента в очередь offer(): " + (finish - start) + " наносекунд.");
        System.out.println("удаление элемента из очереди.poll()");
        start = System.nanoTime();
        burnQueue.poll();
        finish = System.nanoTime();
        System.out.println("Время удаления элемента из очереди poll(): " + (finish - start) + " наносекунд.");
        System.out.println("просмотр элемента из очереди.peek()");
        start = System.nanoTime();
        burnQueue.peek();
        finish = System.nanoTime();
        System.out.println("Время просмотра элемента из очереди peek(): " + (finish - start) + " наносекунд.");

        System.out.println("Вспомогательные методы очереди");
        System.out.println("проверка на пустоту");
        start = System.nanoTime();
        burnQueue.isEmpty();
        finish = System.nanoTime();
        System.out.println("Время проверки очереди на пустоту: " + (finish - start) + " наносекунд.");
        //проверка на переполнение отсутствует, по причине того,
        // что мы реализовывали очередь не на основе массива, а на основе списка из задания 3.4
        System.out.println("Время просмотра элемента из очереди peek(): " + (finish - start) + " наносекунд.");
        System.out.println("просмотр размера очереди.");
        start = System.nanoTime();
        burnQueue.size();
        finish = System.nanoTime();
        System.out.println("Время просмотра размера очереди: " + (finish - start) + " наносекунд.");

                /*Задание 4.3
        На основе данных объектного списка из задания 3.4 реализуйте простой дек и его базовые методы.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().
         */
        System.out.println("начало реализации простого дека и его базовых методов.");
        Deque<Burn> burnDeque = new LinkedList<>(burns);
        System.out.println("Добавление элементов.");
        System.out.print("add(): ");
        start = System.nanoTime();
        burnDeque.add(burns.get(0));
        finish = System.nanoTime();
        System.out.println((finish - start) + " наносекунд");
        System.out.print("addFirst(): ");
        start = System.nanoTime();
        burnDeque.addFirst(burns.get(1));
        finish = System.nanoTime();
        System.out.println((finish - start) + " наносекунд");
        System.out.print("addLast(): ");
        start = System.nanoTime();
        burnDeque.addLast(burns.get(2));
        finish = System.nanoTime();
        System.out.println((finish - start) + " наносекунд");
        System.out.print("offer(): ");
        start = System.nanoTime();
        burnDeque.offer(burns.get(3));
        finish = System.nanoTime();
        System.out.println((finish - start) + " наносекунд");
        System.out.print("offerFirst(): ");
        start = System.nanoTime();
        burnDeque.offerFirst(burns.get(4));
        finish = System.nanoTime();
        System.out.println((finish - start) + " наносекунд");
        System.out.print("offerLast(): ");
        start = System.nanoTime();
        burnDeque.offerLast(burns.get(5));
        finish = System.nanoTime();
        System.out.println((finish - start) + " наносекунд");
        for (int i = 3; i< burns.size(); i++){
            burnDeque.add(burns.get(i));
        }
        System.out.println("удаление элементов.");
        System.out.print("remove(): ");
        start = System.nanoTime();
        burnDeque.remove();
        finish = System.nanoTime();
        System.out.println((finish - start) + " наносекунд");
        System.out.print("removeFirst(): ");
        start = System.nanoTime();
        burnDeque.removeFirst();
        finish = System.nanoTime();
        System.out.println((finish - start) + " наносекунд");
        System.out.print("removeLast(): ");
        start = System.nanoTime();
        burnDeque.removeLast();
        finish = System.nanoTime();
        System.out.println((finish - start) + " наносекунд");
        System.out.print("poll(): ");
        start = System.nanoTime();
        burnDeque.poll();
        finish = System.nanoTime();
        System.out.println((finish - start) + " наносекунд");
        System.out.print("pollFirst(): ");
        start = System.nanoTime();
        burnDeque.pollFirst();
        finish = System.nanoTime();
        System.out.println((finish - start) + " наносекунд");
        System.out.print("pollLast(): ");
        start = System.nanoTime();
        burnDeque.pollLast();
        finish = System.nanoTime();
        System.out.println((finish - start) + " наносекунд");


        /*Задание 4.4
        Реализуйте приоритетную очередь на основе ссылочных типов данных, например, integer.
        Оцените время выполнения операций с помощью базового метода System.nanoTime().
         */
        System.out.println("начало реализации приоритетной очереди.");
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();
        start = System.nanoTime();
        integerPriorityQueue.add(1);
        finish = System.nanoTime();
        System.out.println("Время добавления элемента в очередь: " + (finish - start) + " наносекунд.");
        integerPriorityQueue.add(2);
        integerPriorityQueue.add(7);
        integerPriorityQueue.add(6);
        integerPriorityQueue.add(3);
        integerPriorityQueue.add(4);
        integerPriorityQueue.add(5);
        start = System.nanoTime();
        integerPriorityQueue.poll();
        finish = System.nanoTime();
        System.out.println("Время удаления элемента из очереди: " + (finish - start) + " наносекунд.");
        while (!integerPriorityQueue.isEmpty()){
            System.out.print(integerPriorityQueue.poll());
        }
        System.out.println();

        //Задание 4.5
        //На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на базе связанного списка.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime().

        //Чем дальше я прохожу этот курс, тем больше я недоумеваю от составления ДЗ к урокам.
        //Задание 4.5 дублирует Задание 4.1 и 4.2
        //Если в первых 2х заданиях имелось ввиду реализовать стек и очередь на основе массива, почему так не написали?










    }
}
