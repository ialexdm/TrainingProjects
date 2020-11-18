package ExtraTusks;

public class ExtraTusks {
    public static void main(String[] args) {
        //     Заполните массив случайным числами и выведете максимальное, минимальное и среднее значение.
        System.out.println("Tusk 1:");
        Tusk1Array tusk1Array = new Tusk1Array();
        for (double d : tusk1Array.getRandomArray()
             ) {
            System.out.print("["+ d + "] ");
        }
        System.out.println();
        System.out.println("Maximum value is: " + tusk1Array.getMax());
        System.out.println("Minimum value is: " + tusk1Array.getMin());
        System.out.println("Mean value is: " + tusk1Array.getMean());

        //     Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
        System.out.println("Tusk2:");
        for (int i = 0; i < 200; i++) {
            System.out.print((int)(2 + Math.random()*99) + " ");
        }
        System.out.println();

        //     Дан массив целых чисел и ещё одно целое число. Удалите все вхождения этого числа из массива (пропусков быть не должно).
        System.out.println("Tusk3:");
        int[] array1 = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};
        int[] array2 = Tusk3.deleteNumberFromArray(array1,5);
        for (int a: array2) {
            System.out.print(a+",");
        }
        System.out.println();
        //     Напишите класс, конструктор которого принимает два массива: массив значений и массив весов значений.
        //     Класс должен содержать метод, который будет возвращать элемент из первого массива случайным образом,
        //     с учётом его веса. Пример: Дан массив [1, 2, 3], и массив весов [1, 2, 10]. В среднем,
        //     значение «1» должно возвращаться в 2 раза реже, чем значение «2» и в десять раз реже, чем значение «3».
        System.out.println("Tusk4:");
        int[] value = {1,2,3};
        int[] weight = {1,2,10};
        ValueConsideringWeightGetter valueConsideringWeightGetter = new ValueConsideringWeightGetter(value, weight);
        for (int i = 0; i < 10; i++) {
            System.out.print(" "+ valueConsideringWeightGetter.get());
        }
        System.out.println();
        //     Постройте частотный словарь букв русского (или английского) алфавита. Опустим проблему выбора и анализа корпуса языка, достаточно будет взять текст небольшой длины).
        System.out.println("Tusk5: ");
        CharConsiderDictionary russianDictionary = new CharConsiderDictionary();
        russianDictionary.info();



        System.out.println();
        //     Напишите класс BaseConverter для конвертации из градусов по Цельсию в Кельвины​, ​Фаренгейты​,
        //     и так далее. У метода должен быть метод convert, который и делает конвертацию.
        System.out.println("Tusk6: ");
        System.out.println("32 градуса цельсия это:");
        System.out.println(BaseConverter.convert(32, true) + " градуса по фаренгейту");
        System.out.println(BaseConverter.convert(32, false)+ " градуса по кельвину");
    }

}
