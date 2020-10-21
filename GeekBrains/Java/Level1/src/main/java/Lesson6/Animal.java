package Lesson6;
//      1. Создать классы Собака и Кот с наследованием от класса Животное.
//      2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
//      В качестве параметра каждому методу передается величина, означающая или длину препятствия
//      (для бега и плавания), или высоту (для прыжков).
//      3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
//      прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
//      4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
//      (Например, dog1.run(150); -> результат: run: true)
//      5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение
//      на бег может быть 400 м., у другой 600 м.

public abstract class Animal {
    protected String name;
    protected String color;
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
