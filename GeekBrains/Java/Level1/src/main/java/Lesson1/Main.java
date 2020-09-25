package Lesson1;

public class Main {
    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {
        System.out.println(arithmeticMethod1(7, 2, 7, 3));


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
        static double arithmeticMethod1 ( int a, int b, int c, int d){
            return a * (b + ((double)c / d));
        }

}
