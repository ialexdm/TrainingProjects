package Lesson6;

public class Main {
    public static long start;
    public static long finish;
    /*
Задание 6.1
    Приведите пример использования древовидной структуры.
        1.Классификации видов животных 2.организационная структура предприятия. 3. Генеалогическое древо
    */
    public static void main(String[] args) {


        /*
 Задание 6.2
    Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.
        * */
        Tree tree = new Tree();
    /*

Задание 6.3
    Реализуйте методы поиска и вставки узла в дерево.
    */
        start();
        tree.insert(new Weapon(1,5, "Axe"));
        finish();
        System.out.println("Insert time: " + finish);
        tree.insert(new Weapon(2,4, "Spear"));
        tree.insert(new Weapon(3,3, "Sword"));
        tree.insert(new Weapon(4,2, "Knife"));
        tree.insert(new Weapon(5,1, "Stick"));
        Tree.Node testFindTime;
        start();
        testFindTime =  tree.find(3);
        finish();
        testFindTime.display();
        System.out.println("Find time: " + finish);

        /*
Задание 6.4
    Реализуйте базовые методы обхода дерева и метода дисплей.
    Реализуйте поиск максимума и минимума.
    */
         start();
         Tree.Node minTest = tree.min();
         finish();
         minTest.display();
         System.out.println("min time: " + finish);
         start();
         Tree.Node maxTest = tree.max();
         finish();
         maxTest.display();
         System.out.println("max time: " + finish);
         System.out.println("________________________________");
         tree.displayTree();

        /*
Задание 6.5
    Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью System.nanoTime().
    */
         start();
         tree.delete(3);
         finish();
         System.out.println("delete time: " + finish);
         tree.displayTree();
        /*

Задание 6.6
    Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.
    Выполните оценку алгоритма пирамидальной сортировки с помощью System.nanoTime() и сравните с предыдущими алгоритмами сортировки.
Задание 6.7
    Приведите пример сбалансированного дерева и его применения.
     */
    }
    public static void start(){
        start = System.nanoTime();
    }
    public static void finish(){
        finish = System.nanoTime() - start;
    }
}
