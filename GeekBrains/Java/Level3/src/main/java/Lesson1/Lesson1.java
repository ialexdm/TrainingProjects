package Lesson1;

import java.util.ArrayList;

public class Lesson1 {
    public static void main(String[] args){
        /*
        Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        Написать метод, который преобразует массив в ArrayList;
        Задача:

        Даны классы Lesson1.Fruit, Lesson1.Apple extends Lesson1.Fruit, Lesson1.Orange extends Lesson1.Fruit;
        Класс Lesson1.Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
        поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        Для хранения фруктов внутри коробки можно использовать ArrayList;
        Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
         вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
        Внутри класса Lesson1.Box сделать метод compare(),
         который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра.
         true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
        Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов:
         нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается,
         а в другую перекидываются объекты, которые были в первой;
        Не забываем про метод добавления фрукта в коробку.
         */
        String[] strings = {"bye", "whats up", "hi"};
        Integer[] numbers = {1,2,3,4,5};
        ArrayTransformer<String> transformer = new ArrayTransformer();
        //tusk1
        transformer.swapArrayElements(strings,0,2);
        swapArrayElements(strings, 0,2);
        swapArrayElements(numbers,0,numbers.length-1);
        //tusk2
        transformer.transformArrayToList(strings);
        transformArrayToList(strings);
        transformArrayToList(numbers);
        //tusk3
        Box<Orange> orangeBox = new Box<Orange>(new Orange(),new Orange(),new Orange(),new Orange());
        Box<Apple> bigAppleBox = new Box<Apple>(new Apple(),new Apple(),new Apple(),new Apple());
        Box<Apple> smallAppleBox = new Box<Apple>(new Apple(),new Apple());
        System.out.println(bigAppleBox.compare(orangeBox));
        smallAppleBox.reFill(bigAppleBox);
        System.out.println(bigAppleBox.compare(orangeBox));





    }
    public static <T> void swapArrayElements(T[] t, int first, int second)

    {
        if (second < t.length && first < t.length) {
            T tmp = t[first];
            t[first] = t[second];
            t[second] = tmp;
        }
    }
    public static<T> ArrayList<T> transformArrayToList(T[] t){
        ArrayList<T> transformedList = new ArrayList<T>();
        for (T e: t) {
            transformedList.add(e);
        }
        return transformedList;
    }

}


