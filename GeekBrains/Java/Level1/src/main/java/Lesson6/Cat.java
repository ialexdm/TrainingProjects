package Lesson6;

public class Cat extends Animal{

    public Cat(String name){
        super.name = name;
        super.runDistance = ((int)(15000 + Math.random()*(20000-15000)))/100.00;
        super.swimDistance = 0;
        super.jumpHeight = ((int)(150 + Math.random()*(200-150)))/100.00;
    }

    @Override
    public String getFormattedName() {
        return "Cat " + name;
    }

    @Override
    public String toString() {
        return getFormattedName() + " " + runDistance + " " + swimDistance + " " + jumpHeight;
    }

    @Override
    public boolean swim(double distance){
        System.out.println(getFormattedName() + " can not swim");
        return false;
    }
}
