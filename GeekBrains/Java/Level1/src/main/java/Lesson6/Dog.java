package Lesson6;

public class Dog extends Animal {

    public Dog(String name){
        super.name = name;
        super.runDistance = ((int)(40000 + Math.random()*(50000-40000)))/100.00;
        super.swimDistance = ((int)(800 + Math.random()*(1500-800)))/100.00;
        super.jumpHeight = ((int)(40 + Math.random()*(70-40)))/100.00;
    }

    @Override
    public String getFormattedName() {
        return "Dog " + name;
    }

    @Override
    public String toString() {
        return getFormattedName() + " " + runDistance + " " + swimDistance + " " + jumpHeight;
    }
}
