package ExtraTusks;

public class Tusk3 {
    static int[] deleteNumberFromArray(int[] array, int number){
        int frequency =0;
        for (int a: array) {
            if (a == number){
            frequency++;
            }
        }
        int[] arrayWithoutNumber = new int[array.length-frequency];
        for (int i = 0, j =0; i < arrayWithoutNumber.length; i++, j++) {
            while (array[j] == number){
                j++;
            }
            arrayWithoutNumber[i] = array[j];
        }
        return arrayWithoutNumber;
    }
}
