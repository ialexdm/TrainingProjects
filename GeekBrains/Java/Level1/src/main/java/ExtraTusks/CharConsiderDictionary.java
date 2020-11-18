package ExtraTusks;

import java.math.RoundingMode;

public class CharConsiderDictionary {
    String dictionary;
    String[] letters = {"а","б","в","г","д","е","ё","ж","з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х","ц","ч","ш","щ","ъ","ы","ь","э","ю","я"};
    int[] repeatability = new int[letters.length];
    float allRepeatability = 0.0f;
    float[] frequency = new float[letters.length];
    int[] rank = new int[letters.length];

    public void info() {
        for (int i = 0; i < letters.length; i++) {
            System.out.println("Rank "+rank[i]+" #"+letters[i]+"#"+"{" + frequency[i] + "%} [" + repeatability[i] + "]");
        }
    }

    public CharConsiderDictionary(){
        dictionary = "Частотность — термин лексикостатистики, предназначенный для определения наиболее употребительных слов. Расчёт осуществляется по формуле:\n" +
                "\n" +
                "{\\displaystyle Freq_{x}={\\frac {Q_{x}}{Q_{all}}},}Freq_{x}={\\frac  {Q_{x}}{Q_{{all}}}},\n" +
                "где Freqx — частотность слова «x», Qx — количество словоупотреблений слова «x», Qall — общее количество словоупотреблений. " +
                "В большинстве случаев частотность выражается в процентах. В словарях частотность слов может отражаться пометками — употребительное, малоупотребительное и т. д.\n" +
                "\n" +
                "Аналогичным образом определяется частотность для букв. Бо́льшая частотность согласных на данном отрезке текста (например, в стихотворениях) получила название аллитерации. Высокие показатели частотности гласных называются ассонансом. Частотный анализ используется в криптографии для выявления наиболее частотных букв того или иного языка.\n" +
                "\n" +
                "Частотность слов и букв являлась важнейшим инструментов криптоанализа в эпоху до повсеместного распространения блочных шифров.\n" +
                "\n" +
                "Не следует путать термины частотность и частота.";
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < dictionary.length(); j++) {
                String s = String.valueOf(dictionary.charAt(j));
                if(letters[i].equalsIgnoreCase(s)){
                    repeatability[i]++;
                }
            }
            allRepeatability += repeatability[i];
        }
        for (int i = 0; i < letters.length; i++) {
            frequency[i] = Math.round(repeatability[i]/allRepeatability*10000)/100.0f;
        }
        ranking();
    }
    void ranking(){
        int[] tmps = repeatability.clone();
        for (int i = tmps.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (tmps[j]>tmps[j+1]){
                    int tmp = tmps[j];
                    tmps[j] = tmps[j+1];
                    tmps[j+1] = tmp;
                }
            }
        }
        for (int i = 0; i < repeatability.length; i++) {
            for (int j = 0; j < tmps.length; j++) {
                if (repeatability[i] == tmps[j]) {
                    rank[i] = j+1;
                    tmps[j] = -1;
                    break;
                }
            }
        }
    }
            
}




