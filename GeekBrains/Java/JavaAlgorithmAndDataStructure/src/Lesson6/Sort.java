package Lesson6;


import static java.util.Arrays.*;

public class Sort {
    private static int heapSize;

    public static int[] heapSort(int[] array){
        buildHeap(array);
        while (heapSize >1){
            swap(0,heapSize-1,array);
            heapSize--;
            heapify(array, 0);
        }


        return array;
    }

    private static void buildHeap(int[] array) {
        heapSize = array.length;
        for (int i = array.length / 2; i>= 0; i--) {
            heapify(array, i);
        }
    }

    private static void heapify(int[] array, int i) {
        int l =left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && array[i] < array[l]){
            largest = l;
        }
        if (r < heapSize && array[largest] < array[r]){
            largest = r;
        }
        if (i != largest){
            swap(i, largest, array);
            heapify(array, largest);
        }
    }

    private static int left(int i) {
        return 2 * i +1;
    }

    private static int right(int i) {
        return 2 * i +2;
    }


    public static int[] bubbleSort(int[] array){
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for (int i =0 ; i < array.length-1 ; i++) {
                if (array[i] > array[i+1]){
                    isSorted = false;
                    swap(i,i+1,array);
                }
            }
        }
        return array;
    }
    private static void swap(int first, int last, int[] array){
        int tmp = array[first];
        array[first] = array[last];
        array[last] = tmp;
    }

    public static int[] selectionSort(int[] array){
        for (int i = 0; i<array.length-1; i++){
            swap(i,min(array, i),array);

        }
        return array;
    }

    public static int[] insertionSort(int[] array){
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
        return array;
    }
    public static int[] mergeSort(int[] array){
        int length = array.length;
        if (length<2){
            return array;
        }
        int middle = length/2;
        return merge(mergeSort(copyOfRange(array, 0, middle)), mergeSort(copyOfRange(array, middle, length)));
    }
    private static int[] merge(int[] a, int[] b){
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
    private static int min(int[] array, int start){
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
