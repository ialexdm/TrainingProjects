package Lesson2;

import java.util.Arrays;

public class ArraysAndSort {
    public static void main(String[] args) {
        /*
        Задание 2.1
        На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
        Выполните обращение к массиву и базовые операции класса Arrays.
                Оценить выполненные методы с помощью базового класса System.nanoTime().
         */

        MyArray myArray = new MyArray();

        myArray.setArray();
        myArray.setArrayCopy();
        myArray.printArray();
        myArray.printArrayCopy();

        System.out.println(Arrays.equals(myArray.getArray(),myArray.getCopyArray()));

        long start = System.nanoTime();
        Arrays.sort(myArray.getArray());
        System.out.println("Sorting time: " +(System.nanoTime()-start) +" nanoseconds");
        myArray.printArray();

        myArray.setArray();
        myArray.setArrayCopy();


        /*Задание 2.2
        На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
        Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime() (реализовано в методах класса myArray),
        при необходимости расширьте уже существующий массив данных.
         */
        myArray.linearSearch(5);
        myArray.printArray();
        myArray.binarySearch(5);
        myArray.printArray();


        /*Задание 2.3

        Создайте массив размером 400 элементов.Выполните сортировку с помощью метода sort().
        Оцените сортировку с помощью базового класса System.nanoTime().
         */
        myArray = new MyArray(400);
        myArray.setArray();
        myArray.printArray();
        start = System.nanoTime();
        Arrays.sort(myArray.getArray());
        myArray.printArray();
        long arraysSort = System.nanoTime()-start;
        System.out.println("Sorting time with Arrays.sort(): " + arraysSort);

        /*Задание 2.4

        На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
        Оцените сортировку с помощью базового класса System.nanoTime().
        Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.

         */

        myArray = new MyArray(400);
        myArray.setArray();
        myArray.printArray();
        long bubbleSort = myArray.bubbleSort();
        System.out.println("Sorting time with BubbleSort(): " + bubbleSort);
        myArray.printArray();

        if (arraysSort<bubbleSort){
            System.out.println("Arrays.sort() faster than bubbleSort()");
        }else {
            System.out.println("bubbleSort() faster than Arrays.sort()");
        }

        /*Задание 2.5
           На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
           Оцените сортировку с помощью базового класса System.nanoTime().
           Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.

         */

        myArray = new MyArray(400);
        myArray.setArray();
        myArray.printArray();
        long selectionSort = myArray.selectionSort();
        System.out.println("Sorting time with selectionSort(): " + selectionSort);
        myArray.printArray();

        if (arraysSort<selectionSort){
            System.out.println("Arrays.sort() faster than selectionSort()");
        }else {
            System.out.println("selectionSort() faster than Arrays.sort()");
        }
        if (bubbleSort < selectionSort){
            System.out.println("bubbleSort() faster than selectionSort()");
        }else {
            System.out.println("selectionSort() faster than bubbleSort()");
        }

        /*Задание 2.6
          На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
          Оцените сортировку с помощью базового класса System.nanoTime().
          Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.

         */

        myArray = new MyArray(400);
        myArray.setArray();
        myArray.printArray();
        long insertionSort = myArray.insertionSort();
        System.out.println("Sorting time with selectionSort(): " + insertionSort);
        myArray.printArray();

        if (arraysSort<insertionSort){
            System.out.println("Arrays.sort() faster than insertionSort()");
        }else {
            System.out.println("insertionSort() faster than Arrays.sort()");
        }
        if (bubbleSort < insertionSort){
            System.out.println("bubbleSort() faster than insertionSort()");
        }else {
            System.out.println("insertionSort() faster than bubbleSort()");
        }
        if (selectionSort < insertionSort){
            System.out.println("selectionSort() faster than insertionSort()");
        }else {
            System.out.println("insertionSort() faster than selectionSort()");
        }
    }
}
