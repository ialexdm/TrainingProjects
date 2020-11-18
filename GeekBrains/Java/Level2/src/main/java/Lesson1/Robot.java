package Lesson1;

public class Robot implements Jumpability, Runnability {
    String name;

    public Robot(String name){
        this.name = name;
    }
    public Robot(){
        this.name = "";
    }


    public void jump() {
        System.out.println("Робот " + name + " прыгает");
    }

    public void run() {
        System.out.println("Робот " + name + " бежит");
    }
}
