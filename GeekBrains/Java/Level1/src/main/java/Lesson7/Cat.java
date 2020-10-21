package Lesson7;

public class Cat {
    public Cat(String name, double appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    private String name;
    private double appetite;
    private boolean satiety;

    public void eat(Plate plate){
        System.out.println("Кошка " + name + " ест");
        if (plate.decreaseFood(appetite) && !satiety){
            appetite = 0;
            System.out.println("Кошка " + name + " сыта");
            this.satiety = true;
        }
        else {
            System.out.println("Кошка " + name + " голодна");
        }


    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAppetite() {
        return appetite;
    }

    public void setAppetite(double appetite) {
        this.appetite = appetite;
    }

}
