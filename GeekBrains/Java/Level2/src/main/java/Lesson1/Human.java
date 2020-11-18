package Lesson1;

public class Human implements Jumpability, Runnability {
    String name;

    public Human(String name){
        this.name = name;
    }
    public Human(){
        this.name = "";
    }

    public void jump() {
        System.out.println("Человек " + name + " прыгает");
    }

    public void run() {
        System.out.println("Человек " + name + " бежит");
    }
}
