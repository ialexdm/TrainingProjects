package Lesson4;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Lambdas {
       /* 1. Напишите метод, который возвращает индекс первого вхождения данного целого числа в списке.
                Предположим, что индекс первого элемента в списке равен нулю.
                Если числа не существует в списке, верните -1.
        public int search(Integer n, Integer[] list)
        */
       public static int search(Integer n, Integer[] list){
           BiFunction<Integer[],Integer, Integer> index = (array, x) -> {
               for (int i =0; i<array.length; i++){
                   if (x == array[i]){
                       return i;
                   }
               }
               return -1;
           };
           return index.apply(list, n);
       }
    /*

        2. Напишите метод, переворачивающий строку.
                Например, «java interview» превращается в «weivretni avaj».
        public String reverse(String s)
     */
/*
        3. Напишите метод, который возвращает наибольшее целое число в списке.
        public Integer maximum(Integer[] list)

        4. Напишите метод, который возвращает среднее значение из списка целых чисел.
        public Double average(List<Integer> list)

        5. Имея список строк, напишите метод, который возвращает список всех строк, которые начинаются с буквы «а» (нижний регистр) и имеют ровно 3 буквы.
        public List<String> search(List<String> list)

        Все должно быть реализовано с помощью лямбда выражений
                */

}
