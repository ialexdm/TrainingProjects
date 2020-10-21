package Lesson7;

public class Plate {
    private double capacity;
    private double food;

    public Plate(double capacity, double food) {
        this.capacity = capacity;
        this.food = food;
    }

    public boolean decreaseFood(double appetite){
        if (appetite<=this.food){
            this.food -= appetite;
            return true;
        }
        return false;
    }

    public void fill(){
        this.food = this.capacity;
    }
    public void fill(double food){
        if (food> capacity - this.food){
            this.food = this.capacity;
        }else{
            this.food +=food;
        }

    }

    public void info(){
        System.out.println("In plate " + food + "food.");
    }

    public double getCapacity() {
        return capacity;
    }

    public double getFood() {
        return food;
    }

    public void setFood(double food) {
        this.food = food;
    }
}
