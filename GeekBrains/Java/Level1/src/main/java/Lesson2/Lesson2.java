package Lesson2;

import javax.swing.*;

public class Lesson2 {
    public static void main(String[] args) {

//    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
//    [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        tusk1();

        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        tusk2();

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        tusk3();
        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        tusk4();
        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        tusk5();
        //6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть
// true, если в массиве есть место, в котором сумма левой и правой части массива равны.
// Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница
// показана символами ||, эти символы в массив не входят.
        tusk6();


    }




    static void tusk1(){
        System.out.println("tusk1:");
        int[] array = {1, 1, 1, 0, 1, 0, 1, 1, 0, 0};
        binaryArrayInverter(array);
        System.out.println("***********:");
        System.out.println("***********:");
    }
    static void tusk2(){
        System.out.println("tusk2:");
        int[] array = new int[8];
        fillArrayGeometricProgression(array,3);
        System.out.println();
        System.out.println("***********");
        System.out.println("***********");
    }
    static void tusk3(){
        System.out.println("tusk3:");
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int a: array
             ) {
            System.out.print(a+" ");
        }
        System.out.println();
        doubleArrayElementsLessNumber(array,6);
        for (int a: array
        ) {
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println("***********");
        System.out.println("***********");
    }

    static void tusk4(){
        System.out.println("tusk4:");
        int[][] array = new int[9][9];
        for (int[] ar: array
             ) {
            for (int a: ar
                 ) {
                a = 0;
                System.out.print(a+" ");
            }
            System.out.println();

        }
        System.out.println("***********");
        putOnesInDiagonalElementsOfSquareArray(array);
        for (int[] ar: array
        ) {
            for (int a: ar
            ) {
                System.out.print(a+" ");
            }
            System.out.println();

        }
        System.out.println();
        System.out.println("***********");
        System.out.println("***********");
    }
    static void tusk5(){
        int[] array = {1, 2, 3, 4, 18, 20, 100, 1000, -8, 20};
        arrayMin(array);
        arrayMax(array);
        System.out.println("***********:");
        System.out.println("***********:");
    }
    static void tusk6(){
        System.out.println("tusk6:");
        int[] array = {1,1,2,3,1};
        checkBalance(array);
        System.out.println("***********:");
        System.out.println("***********:");
    }


    static void doubleArrayElementsLessNumber(int[] array, int number){
        for (int i = 0; i < array.length; i++) {
            if (array[i] < number){
                array[i]*=2;
            }
        }
    }

    static void putOnesInDiagonalElementsOfSquareArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[array.length-1-i][i] = 1;
        }
    }
    static void fillArrayGeometricProgression(int[] array, int step){
        for (int i = 0; i < array.length; i++) {
            array[i] = i*step;
            System.out.print(array[i]+" ");
        }
    }

    static void binaryArrayInverter(int[] array){
        for (int i = 0; i < array.length; i++){
           if (array[i] != 0 && array[i]!=1){
               throw new IllegalArgumentException("Array is not binary. array["+i+"] is not 0 or 1.");
           }
           else {
               System.out.print(array[i]);
           }
        }
        System.out.println("\n**********");

        for (int i = 0; i < array.length; i++) {

            if (array[i] == 1){
                array[i] = 0;
            }
            else if (array[i]==0){
                array[i] = 1;
            }
            System.out.print(array[i]);
        }
    }
    static int arrayMin(int[] array){
        int min = array[0];
        for (int a: array
             ) {if (min>a){
                 min = a;
        }

        }System.out.println("Minimum is: "+ min);
        return min;
    }
    static int arrayMax(int[] array){
        int max = array[0];
        for (int a: array
        ) {if (max<a){
            max = a;
        }

        }System.out.println("Maximum is: "+ max);
        return max;
    }
    static boolean checkBalance(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < array.length - 1 - i; j++) {
                sum1 += array[j];
            }
            for (int q = array.length - 1; q >= array.length - 1 - i; q--) {
                sum2 += array[q];
            }
            if (sum1 == sum2) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    System.out.print(array[j]);
                }
                System.out.print("||");
                for (int q = array.length -i-1; q <= array.length - 1; q++) {
                    System.out.print(array[q]);
                }
                System.out.println("→true");
                return true;
            }
        }
        System.out.println("false");
        return false;
    }



//  7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
//  при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя
//  пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2
//  (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
//
}
