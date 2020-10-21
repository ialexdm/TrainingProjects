package Lesson6;

public abstract class Animal {
    protected String name;

    protected double runDistance;
    protected double swimDistance;
    protected double jumpHeight;

    protected boolean run(double distance){
        if (distance<=runDistance){
            System.out.println(getFormatedName() + " пробежал через препятствие!!!");
            return true;
        }
        else {
            System.out.println(getFormatedName() + " не смог пробежать препятствие.=(((");
        }
        return false;
    }
    protected boolean swim(double distance){
        if (distance<=swimDistance){
        System.out.println(getFormatedName() + " переплыл препятствие!!!");
        return true;
    }
    else {
        System.out.println(getFormatedName() + " не смог переплыть препятствие.=(((");
    }
        return false;}
    protected boolean jump(double height){
        if (height<=jumpHeight){
            System.out.println(getFormatedName() + " перепрыгнул препятствие!!!");
            return true;
        }
        else {
            System.out.println(getFormatedName() + " не смог перепрыгнуть препятствие.=(((");
        }
        return false;
    }
    protected abstract String getFormatedName();



}
