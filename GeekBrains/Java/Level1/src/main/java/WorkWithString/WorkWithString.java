package WorkWithString;


import java.nio.charset.StandardCharsets;

public class WorkWithString {
    public static void main(String[] args){
        String s = new String("A");
        String s1 = new String("A");
        String s2 = "B";
        String s3 = "B";
        String s4 = new String(new char[]{'A','B'});
        String s5 = new String(new byte[]{'5','5'});
        String s6 = new String(new byte[]{'5','5'}, StandardCharsets.UTF_8);



        System.out.println(s == s1);//выведет false, т.к. объекты хранятся в heap
        System.out.println(s2 == s3);//выведет true т.к. строки хранятся в String pool

        s = s.intern();
        s1 = s1.intern();//перевели объекты в стрингпул

        System.out.println(s == s1);//выведет true т.к. строки хранятся в String pool
        System.out.println(s2);
        System.out.println(s3);
        s2 = "A";//значение строки в памяти не меняется, меняется только ссылка на объект s2
        System.out.println(s2);//A
        System.out.println(s3);//B

        String str = " OK";
        str.concat(" GOOGLE ");//значение не изменится, т.к. String неизменяемый объект
        str += " Google";// значение изменится.
        System.out.println(str);
        System.out.println(str.contains("oo"));
        str.length();//длина строки
        str.isEmpty();//если пустой то true
        str = str.trim();//убирает пробелы спереди и сзади
        System.out.println(str.charAt(0));//возвращает символ по индексу начиная с 0
        str.equalsIgnoreCase(s); //сравнение строк без учета регистра
        str.indexOf("G");// вернет индекс первого найденного символа
        str.lastIndexOf("G");// вернет индекс последнего найденного символа
        for (String s7 : str.split(" ")) {//разделить строку по пробелам
            System.out.println(s7);
        }
        str.substring(0,4);//вернет строку с 0 символа до 3 включительно
        str.toLowerCase();//в нижний регистр
        str.toUpperCase();//в верхний регистр
        System.out.println(str.replace("oo", "replace"));//меняет символы на другие
        System.out.println(str.replace('o', 't'));


        StringBuilder strb = new StringBuilder("String Builder");
        System.out.println(strb.append(" dadasd"));//StringBuilder изменяемый класс, в отличае от java
        StringBuffer strbf = new StringBuffer("String Buffer");//StringBuffer - изменяемый потокобезопасный класс.
        System.out.println(strbf.replace(0, 3, "ff"));

    }
}
