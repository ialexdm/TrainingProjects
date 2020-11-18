package ExtraTusks;

public class BaseConverter {
    static int celsius;
    static int fahrenheit;
    static int kelvin;


    public static double convert(int celsius, boolean toFahrenheit){
        if (toFahrenheit){
            return (celsius*9.0/5)+32;
        }
        return celsius + 273.15;
    }

}
