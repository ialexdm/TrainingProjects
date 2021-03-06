package Lesson8;

import java.util.Arrays;
import java.util.Random;

public class Main {



    public static void main(String[] args){
            /*
    Задание 8.1
Приведите пример использование хеш-таблиц.

Хэш таблицы используются для шифрования блокчейн

Задание 8.2
Приведите примеры ключей и коллизий.

Парадокс дней рожде́ния. В группе, состоящей из 23 или более человек,
вероятность совпадения дней рождения (число и месяц) хотя бы у двух людей превышает 50 %
Ключ - день рождения, их совпадение - коллизия

Задание 8.3
Приведите примеры популярных и эффективных хеш-функций.

хэш-функции из группы алгоритмов MD и SHA.


     */
        int size = 801;
        /*Задание 2.3
Создайте массив размером 400 элементов.Выполните сортировку с помощью метода sort().
Оцените сортировку с помощью базового класса System.nanoTime().*/
        Integer[] array = new Integer[400];
        Random random = new Random();
        /*Задание 8.4
На основе данных массива из задания 2.3 реализуйте хеш-таблицу с помощью открытой адресации, а конкретнее метода линейного пробирования*/
        HashTable hashTable = new HashTable(size, false);
        /*Задание 8.5
Перестройте программный код задания 8.4 из алгоритма линейного пробирования в алгоритм двойного хеширования.
Сравните отличительные черты двух алгоритмов.

Двойное хеширование: интервал между ячейками фиксирован, как при линейном пробировании,
но, в отличие от него, размер интервала вычисляется второй, вспомогательной хеш-функцией,
а значит, может быть различным для разных ключей. Значения этой хеш-функции должны быть
ненулевыми и взаимно-простыми с размером хеш-таблицы, что проще всего достичь,
взяв простое число в качестве размера, и потребовав,
чтобы вспомогательная хеш-функция принимала значения от 1 до N — 1.

*/
        HashTable doubleHashTable = new HashTable(size, true);
        for (int i = 0; i< array.length; i++){
            array[i] = random.nextInt(999);
        }
        Arrays.sort(array);
        for (int i = 0; i< array.length; i++){
            hashTable.insert(array[i], false);
            doubleHashTable.insert(array[i], true);
        }
        System.out.println();
        System.out.println(Arrays.toString(array));
        hashTable.display();
        System.out.println("__________________________________");
        doubleHashTable.display();
    }

    static class HashTable{
        private Integer[] hashArray;
        private int arrSize;
        private final int MINUS_ONE = -1;
        private boolean isDoubleHash;//это просто флаг использует ли таблица двойне хэширование или нет.
        //в реализации не используется

        public HashTable(int size, boolean isDoubleHash){
            this.arrSize = size;
            this.hashArray = new Integer[arrSize];
            this.isDoubleHash = isDoubleHash;

        }
        public void display(){//вывод на экран нагляднее в виде массива
            System.out.print("[");
            for (int i = 0; i < arrSize; i++) {
                if (hashArray[i]!=null){
                    System.out.print(hashArray[i]);
                }else {
                    System.out.print("***");
                }
                if (i != arrSize-1){
                    System.out.print(", ");
                }
                else {
                    System.out.println("]");
                }
            }
        }
        public int hashFunc(Integer in){
            int key = in;
            return key % arrSize;
        }
        public int hashFuncDouble(Integer in){
            int key = in;
            return 5 - key % 5;
        }

        private void insert(Integer in){//вставка открытой адресации
            int key = in;
            int hashValue = hashFunc(key);
            while (hashArray[hashValue] != null && hashArray[hashValue] != MINUS_ONE){
                if (hashArray[hashValue].equals(key)){
                    System.out.printf("Число %s уже есть в хэш таблице. ", key);
                    return;
                }
                ++hashValue;
                hashValue%=arrSize;
            }
            hashArray[hashValue] = in;
        }
        public  void insert(Integer in, boolean isDoubleHash){//если тру то будет двойное хэширование, если фолс то обычное
            if (isDoubleHash == true){                         //другие методы реализованы аналогично.
                int key = in;                                  //вообще конечо нужно было через наследование и переопределение метода hashValue+=stepSize делать.
            int hashValue = hashFunc(key);
            int stepSize = hashFuncDouble(key);
            while (hashArray[hashValue] != null && hashArray[hashValue] != MINUS_ONE){
                if (hashArray[hashValue].equals(key)){
                    System.out.printf("Число %s уже есть в хэш таблице. ", key);
                    return;
                }
                hashValue+=stepSize;
                hashValue%=arrSize;
            }
            hashArray[hashValue] = in;
            return;
            }else {
                insert(in);
            }
        }
        private Integer delete(Integer in){
            int key = in;
            int hashValue = hashFunc(key);
            while (hashArray[hashValue]!= null){
                if (hashArray[hashValue] == key){
                    Integer temp = new Integer(hashArray[hashValue]);
                    hashArray[hashValue] = MINUS_ONE;
                    return temp;
                }
                ++hashValue;
                hashValue %= arrSize;
            }return null;
        }
        public Integer delete(Integer in, boolean isDoubleHash){
            if (isDoubleHash == true){
                int key = in;
            int hashValue = hashFunc(key);
            int stepSize = hashFuncDouble(key);
            while (hashArray[hashValue]!= null){
                if (hashArray[hashValue] == key){
                    Integer temp = new Integer(hashArray[hashValue]);
                    hashArray[hashValue] = MINUS_ONE;
                    return temp;
                }
                hashValue+=stepSize;
                hashValue %= arrSize;
            }return null;
            }
            return delete(in);
        }
        private Integer find(Integer in){
            int key = in;
            int hashVal = hashFunc(key);
            while (hashArray[hashVal]!= null){
                if (hashArray[hashVal] == key){
                    return hashArray[hashVal];
                }
                ++hashVal;
                hashVal %= arrSize;
            }
            return null;
        }
        public Integer find(Integer in, boolean isDoubleHash){
            if (isDoubleHash == true){
                int key = in;
            int hashVal = hashFunc(key);
            while (hashArray[hashVal]!= null){
                if (hashArray[hashVal] == key){
                    return hashArray[hashVal];
                }
                ++hashVal;
                hashVal %= arrSize;
            }
            return null;
            }
            return find(in);
        }
    }

}
