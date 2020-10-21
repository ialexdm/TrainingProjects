package Lesson6;

public abstract class Animal {
    protected String name;

    protected double runDistance;
    protected double swimDistance;
    protected double jumpHeight;

    protected boolean run(double distance){
        if (distance<=runDistance){
            System.out.println(getFormattedName() + " пробежал через препятствие!!!");
            return true;
        }
        else {
            System.out.println(getFormattedName() + " не смог пробежать препятствие.=(((");
        }
        return false;
    }
    protected boolean swim(double distance){
        if (distance<=swimDistance){
        System.out.println(getFormattedName() + " переплыл препятствие!!!");
        return true;
    }
    else {
        System.out.println(getFormattedName() + " не смог переплыть препятствие.=(((");
    }
        return false;}
    protected boolean jump(double height){
        if (height<=jumpHeight){
            System.out.println(getFormattedName() + " перепрыгнул препятствие!!!");
            return true;
        }
        else {
            System.out.println(getFormattedName() + " не смог перепрыгнуть препятствие.=(((");
        }
        return false;
    }
    protected abstract String getFormattedName();



}
