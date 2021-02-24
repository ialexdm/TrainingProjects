package Lesson4;

import java.util.Random;

public class Burn {
    static final String[] TYPES = {"Fire", "Frost", "Electricity", "Acid"};
    static final int MAX_POWER = 10;


    private int power;
    private String type;

    public Burn(){
        Random random = new Random();
        power = random.nextInt(MAX_POWER);
        type = TYPES[random.nextInt(TYPES.length)];
    }
    public void print(){
        System.out.println("The burn power is: " +  this.power + ". Burn type is: " + this.type + ". " );
    }

    @Override
    public String toString() {
        return "Burns{" +
                "power=" + power +
                ", type='" + type + '\'' +
                '}';
    }
}
