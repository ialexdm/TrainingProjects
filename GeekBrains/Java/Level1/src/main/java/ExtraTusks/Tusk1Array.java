package ExtraTusks;

public class Tusk1Array {
    private double max;
    private double min;
    private double mean;
    private double sum;
    private double[] randomArray;

    public double[] getRandomArray() {
        return randomArray;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public double getMean() {
        return mean;
    }

    public Tusk1Array(){
        randomArray = new double[3+(int)(Math.random()*(30-3))];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = Math.ceil(Math.random() * 100000) / 100 ;
            if (i == 0) {
                min = randomArray[i];
                max = randomArray[i];
            } else {
                if (min >= randomArray[i]) {
                    min = randomArray[i];
                } else if (max <= randomArray[i]) {
                    max = randomArray[i];
                }
                sum += randomArray[i];
            }
            mean = sum / randomArray.length;

        }
    }
}
