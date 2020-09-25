package Lesson1;

public class Main {
    //1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {
        System.out.println(arithmeticMethod1(7, 2, 7, 3));
        System.out.println(isSumValueFrom10to20(3,14));
        numberCategory(12);
        System.out.println(isNegative(-7));
        hiNameMethod("Max");
        isIntercalaryYear(2400);


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
    //6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
    static boolean isNegative(int a){
        return a<0;
    }
    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    static void hiNameMethod(String name){
        System.out.println("Привет, "+ name + "!");
    }
    //8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    static boolean isIntercalaryYear(int year){
        if (year%4 == 0 && year%400 == 0 || year%4 ==0 && year%100!=0){
            System.out.println("The year "+ year + " is intercalary year.");
            return true;
        }
        System.out.println("The year "+ year + " is not intercalary year.");
        return false;
    }

}
