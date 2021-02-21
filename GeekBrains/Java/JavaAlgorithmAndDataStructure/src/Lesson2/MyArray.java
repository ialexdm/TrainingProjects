package Lesson2;

import java.util.Arrays;
import java.util.Random;

public class MyArray {
    private int[] array;
    private int[] arrayCopy;
    private boolean isSorted;

    public int[] getArray() {
        return array;
    }

    public int[] getCopyArray() {
        return arrayCopy;
    }
    public void setArrayCopy(){
        arrayCopy = Arrays.copyOf(array, array.length);
    }

    public MyArray(){
        array = new int[10];
    }
    public MyArray(int i){
        array = new int[i];
    }

    public void setArray(){
        Random random = new Random();
        for (int i = 0; i< array.length; i++){
            array[i] = random.nextInt(array.length);
        }
    }
    public void printArray(){
        System.out.println(Arrays.toString(array));
    }
    public void printArrayCopy(){
        long start =System.nanoTime();
        System.out.println(Arrays.toString(arrayCopy));
        System.out.println("Copy time is: " + (System.nanoTime()-start) + " nanoseconds");
    }

    public int linearSearch(int soughtNumber){
        long start = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == soughtNumber){
                System.out.println("Index " + i);
                System.out.println("Linear searching time is: " + (System.nanoTime()-start) + " nanoseconds");
                return i;
            }

        }
        System.out.println("Index not found");
        System.out.println("Linear searching time is: " + (System.nanoTime()-start) + " nanoseconds");
        return -1;
    }

    public int binarySearch(int soughtNumber){
        long start = System.nanoTime();
        int firstIndex = 0 ;
        int lastIndex = array.length - 1;
        Arrays.sort(array);
        while (firstIndex<=lastIndex){
            int middleIndex = (lastIndex+firstIndex)/2;
            if (array[middleIndex] == soughtNumber){
                System.out.println("Index " + middleIndex);
                System.out.println("Binary searching time is: " + (System.nanoTime()-start) + " nanoseconds");
                return middleIndex;
            }else if (soughtNumber > array[middleIndex]){
                firstIndex = middleIndex + 1;
            }else if (soughtNumber < array[middleIndex]){
                lastIndex = middleIndex - 1;
            }


        }System.out.println("Index not found");
        System.out.println("Binary searching time is: " + (System.nanoTime()-start) + " nanoseconds");
        return -1;
    }
    public long bubbleSort(){
        long start = System.nanoTime();
        isSorted = false;
        while(!isSorted){
            isSorted = true;
            for (int i =0 ; i < array.length-1 ; i++) {
                if (array[i] > array[i+1]){
                    isSorted = false;
                    swap(i,i+1);
                }
            }
        }
        long finish = System.nanoTime()-start;
        System.out.println("Bubble sort time is: " + finish + " nanoseconds");
        return finish;
    }
    public void swap(int first, int last){
        int tmp = array[first];
        array[first] = array[last];
        array[last] = tmp;
    }

    public long selectionSort(){
        long start = System.nanoTime();
        long finish;
        for (int i = 0; i<array.length-1; i++){
            swap(i,min(i));
        }
        finish = System.nanoTime()-start;
        return finish;
    }

    public long insertionSort(){
        long start = System.nanoTime();
        int in;
        int tmp;
        for (int i = 1; i< array.length; i++){
            tmp = array[i];
            in = i;
            while (in > 0 && array[in-1]>=tmp){
                array[in] = array[in-1];
                --in;
            }
            array[in] = tmp;
        }



        long finish = System.nanoTime() - start;
        return finish;
    }




    public int min(int start){
        int min = array[start];
        int minIndex = start;
        for (int i = start; i < array.length; i++) {
            if (min>array[i]){
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }


}
