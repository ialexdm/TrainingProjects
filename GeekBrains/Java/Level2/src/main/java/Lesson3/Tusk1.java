package Lesson3;

import java.util.*;

public class Tusk1 {
         /*1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных
    слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.*/
    List<String> stringList;
    Set<String> stringSet;

    public Tusk1(){
        stringList = new ArrayList();

        stringList.add("first");
        stringList.add("second");
        stringList.add("third");
        stringList.add("fourth");
        stringList.add("fifth");
        stringList.add("sixth");
        stringList.add("seventh");
        stringList.add("eighth");
        stringList.add("ninth");
        stringList.add("tenth");
        stringList.add("first");
        stringList.add("third");
        stringList.add("sixth");
        stringList.add("seventh");
        stringList.add("eleventh");
        stringList.add("first");
        stringList.add("second");
        stringList.add("third");
    }
    public void printQtyRepeat(){
        HashMap<String, Integer> qtyRepeat = new HashMap();
        stringSet = new HashSet<String>(stringList);
        Iterator<String> hashSetIterator = stringSet.iterator();
        int count =0;
        while (hashSetIterator.hasNext()){

            String key = hashSetIterator.next();
            Iterator<String> listIterator = stringList.iterator();
            while(listIterator.hasNext()){
                if (key.equals(listIterator.next())){
                    count++;
                }
            }
            qtyRepeat.put(key, count);
            count =0;
        }
        System.out.println(qtyRepeat);


    }
    public void printUnique(){
        stringSet = new HashSet<String>(stringList);
        System.out.println(stringSet);


    }


}
