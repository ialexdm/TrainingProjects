package Lesson7;

public class Main {
    public static void main (String[] args)
    {
        /**
         * Задание 7.1
         * Приведите пример графа.
         * Частными случаями графа являются деревья
         */


        /**
         * Задание 7.2
         * Реализуйте базовые методы графа.
         */
        Graph graph = new Graph();
        graph.addVertex('A');//добавление вершин
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('H');
        graph.addVertex('I');

        graph.addEdge(0,1); //Добавление граней
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(4,5);

        graph.displayVertex(6);// вывод вершины на экран


        /**
         * Задание 7.3
         * В программный код из задания 7.2 добавьте реализацию метода обхода в глубину.
         * Выполните оценку времени с помощью System.nanoTime().
         */
        long finish, start = System.nanoTime();
        graph.dfs(1);
        graph.resetVisited();
        finish = System.nanoTime();
        System.out.println("Время обхода в глубину " + (finish-start) + " наносекунд");
        /**
         * Задание 7.4
         * В базовом графе из задания 7.2 реализуйте метод обхода в ширину.
         * Выполните оценку времени с помощью System.nanoTime().
         */
        start = System.nanoTime();
        graph.bfs(3);
        finish = System.nanoTime();
        System.out.println("Время обхода в ширину " + (finish-start) + " наносекунд");
    }
}
