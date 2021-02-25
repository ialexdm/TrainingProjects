package Lesson5;

import java.util.Arrays;
import java.util.Random;

public class Main {
    /*
    Задание 5.1
    Приведите пример использования рекурсии.

    Факториал, Числа фибоначи.

    Поиск в древовидных структурах может быть реализован с помощью рекурсивного поиска,
    например поиск файлов в каталоге.

     */

    /*Задание 5.2
Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.
     */
    //бесконечная рекурсия
    public static byte countdown( byte n){
        System.out.println(n);
        return countdown((byte) (n-1));
    }
    //"правильная" рекурсия
    public static byte countdown( int n){
        System.out.println(n);
        if (n==0){
            return -1;
        }
        return countdown((n-1));
    }

    /*Задание 5.3
    Приведите пример изображающий стек вызова и стек вызова с рекурсией.

    смысл задания непонятен: нарисовать как в видео или что?


    */



    public static void main(String[] args) {
        countdown(100);
        long start;
        long finish;
            /*   Задание 5.4
Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
Оцените два алгоритма с помощью базового метода System.nanoTime().*/

        start = System.nanoTime();
        loop(5);
        finish = System.nanoTime();
        System.out.println("Время цикла: " + (finish-start));
        start = System.nanoTime();
        recursion(5);
        finish = System.nanoTime();
        System.out.println("Время рекурсии: " + (finish-start));

/*
        Задание 5.5
    Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
    Оцените алгоритм двоичного рекурсивного поиска с помощью базового метода System.nanoTime() и сравните с обычным двоичным поиском.

 */
    int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = i*2;
        }

        start = System.nanoTime();
        System.out.println(binarySearch(6, array));
        finish = System.nanoTime();
        System.out.println("Время бинарного поиска: " + (finish-start));

        start = System.nanoTime();
        System.out.println(binarySearchWithRecursion(6, array, 0, array.length - 1));
        finish = System.nanoTime();
        System.out.println("Время бинарного поиска c рекурсией: " + (finish-start));

/*
        Задание 5.6
    На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием.
    Оцените алгоритм сортировки слиянием с помощью базового метода System.nanoTime() и сравните с сортировкой методом sort().
    */
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
        }
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        System.out.println(Arrays.toString(arrayCopy));
        start = System.nanoTime();
        Arrays.sort(arrayCopy);
        finish = System.nanoTime();
        System.out.println(Arrays.toString(arrayCopy));
        System.out.println("Время  Arrays.sort(): " + (finish-start));
        System.out.println(Arrays.toString(array));
        start = System.nanoTime();
        array = mergeSort(array);
        finish = System.nanoTime();
        System.out.println(Arrays.toString(arrayCopy));
        System.out.println("Время  mergeSort(): " + (finish-start));

    }

    public static void loop(int n){//цикл
        while (n<5){
            System.out.print(n++);
        }
    }
    public static int recursion(int n){//рекурсия
        if (n == 5){
            return -1;
        }
        System.out.print(n);

        return recursion(++n);
    }

    public static int binarySearch(int soughtNumber, int[] array){
        int firstIndex = 0 ;
        int lastIndex = array.length - 1;
        while (firstIndex<=lastIndex){
            int middleIndex = (lastIndex+firstIndex)/2;
            if (array[middleIndex] == soughtNumber){
                return middleIndex;
            }else if (soughtNumber > array[middleIndex]){
                firstIndex = middleIndex + 1;
            }else if (soughtNumber < array[middleIndex]){
                lastIndex = middleIndex - 1;
            }
        }
        return -1;
    }

    public static int binarySearchWithRecursion(int soughtNumber, int[] array, int firstIndex, int lastIndex){
        if (firstIndex<=lastIndex){
            int middleIndex = (lastIndex+firstIndex)/2;
            if (array[middleIndex] == soughtNumber){
                return middleIndex;
            }else if (soughtNumber > array[middleIndex]){
                return binarySearchWithRecursion(soughtNumber, array, middleIndex+1, lastIndex);
            }else if (soughtNumber < array[middleIndex]){
                return binarySearchWithRecursion(soughtNumber, array, firstIndex, middleIndex - 1);
            }
        }
        return -1;
    }

    public static int[] mergeSort(int[] array){
        int length = array.length;
        if (length<2){
            return array;
        }
        int middle = length/2;
        return merge(mergeSort(Arrays.copyOfRange(array, 0, middle)), mergeSort(Arrays.copyOfRange(array, middle, length)));
    }
    public static int[] merge(int[] a, int[] b){
        int[] result = new int[(a.length+ b.length)];
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length){
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex );
                break;
            }
            if (bIndex == b.length){
                System.arraycopy(a, aIndex, result, ++i, a.length - aIndex );
                break;
            }
        }
        return result;
    }
}
