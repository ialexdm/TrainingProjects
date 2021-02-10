package Lesson6;

import java.util.*;

public class ClassForTesting {
    //  1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
    //  Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
    //  идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
    //  иначе в методе необходимо выбросить RuntimeException. Написать набор тестов для этого метода
    //  (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].//
    public Integer[] getNumbersAfterLastFour(Integer[] numbers){
        final Integer NUM = 4;
        if (numbers.length == 0){
            throw new IllegalArgumentException("Incoming array is empty.");
        }
        List<Integer> numberList = new ArrayList<>();

        for (Integer i : numbers
             ) {
            numberList.add(i);
        }
        if (!numberList.contains(NUM)){
            throw new IllegalArgumentException("Incoming array hasn't number 4.");
        }
        for (int i = numberList.size()-1 ; i> -1 ; i--){
            if (numberList.get(i) == 4){
                for (int j = 0 ; j<=i ; i--){
                    numberList.remove(j);
                }
                Integer[] numbersAfterLastFour = new Integer[numberList.size()];
                for (int j = 0; j < numberList.size(); j++) {
                    numbersAfterLastFour[j] = numberList.get(j);
                }
                return numbersAfterLastFour;
            }
        }
        return null;
    }

    //  2. Написать метод, который проверяет состав массива из чисел 1 и 4.
    //  Если в нем нет хоть одной четверки или единицы, то метод вернет false;
    //  Написать набор тестов для этого метода (по 3-4 варианта входных данных).
}
