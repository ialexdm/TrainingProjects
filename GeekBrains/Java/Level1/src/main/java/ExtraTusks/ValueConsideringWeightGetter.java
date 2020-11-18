package ExtraTusks;

public class ValueConsideringWeightGetter {
    int[] values, weight;

    public ValueConsideringWeightGetter(int[] values, int[] weight) {
        this.values = values;
        this.weight = weight;
    }
    public int get(){
        int weightSum = 0;
        for (int i = 0; i < this.weight.length; i++) {
            weightSum += this.weight[i];
        }
        int[] valuesConsideringWeight = new int[weightSum];

        for (int i = 0, j=0, count =0 ; i < valuesConsideringWeight.length;) {
                this.weight[j]--;
                count++;
                valuesConsideringWeight[i] = this.values[j];
                i++;
                if (this.weight[j]==0){
                    this.weight[j] = count;
                    count = 0;
                    j++;
                }

        }

        return valuesConsideringWeight[(int) (Math.random()*(valuesConsideringWeight.length))];
    }

}
