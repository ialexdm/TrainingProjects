package Lesson1;

public class Main {
    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {
        System.out.println(arithmeticMethod1(7, 2, 7, 3));
        System.out.println(isSumValueFrom10to20(3,14));
        numberCategory(12);


    }
    //2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte b = 100;
        short s = 10000;
        int i = 1000000000;
        long l = 1000000000000000000L;
        float f = 0.001f;
        double d = 0.000000000000009;
        char c = 'C';
        boolean bool = true;
        String str = "String";

    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
    static double arithmeticMethod1(int a, int b, int c, int d) {
        return a * (b + ((double) c / d));
    }
    //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно)
    // , если да – вернуть true, в противном случае – false;
    static boolean isSumValueFrom10to20(int a, int b){
        int minSumValue = 10;
        int maxSumValue = 20;
        return ((a+b)<=maxSumValue && (a+b)<=minSumValue);
    }
    //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
    // положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
    static void numberCategory(int a){
        if (a<0)
            {
                System.out.println("Number " + a + " is negative");}
        else {
            System.out.println("Number " + a + " is positive");
        }
    }

}
