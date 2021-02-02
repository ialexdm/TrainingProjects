package Lesson1;

import java.util.ArrayList;

public class ArrayTransformer<T> {
    public void swapArrayElements(T[] t, int first, int second){
        if (second < t.length && first < t.length){
            T tmp = t[first];
            t[first] = t[second];
            t[second] = tmp;
        }
        else if (first>=t.length){
            System.out.println("the First is index Out Of Bound");
        }
        else if (second>=t.length){
            System.out.println("the Second is index Out Of Bound");
        }
    }

    public ArrayList<T> transformArrayToList(T[] t){
        ArrayList<T> transformedList = new ArrayList<T>();
        for (T e: t) {
            transformedList.add(e);
        }
        return transformedList;
    }
}
