package Lesson1;

public class Cat implements Jumpability, Runnability {
    String name;

    public Cat(String name){
        this.name = name;
    }
    public Cat(){
        this.name = "";
    }


    public void jump() {
        System.out.println("Кот " + name + " прыгает");
    }

    public void run() {
        System.out.println("Кот " + name + " бежит");
    }
}
