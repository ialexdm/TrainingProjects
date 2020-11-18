package Lesson2;

public class Lesson2 {

    /*1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
     при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
     Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
      должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
    3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException,
    и вывести результат расчета.
*/
    public static void main(String[] args) {
        String[][] numbers = {{"1","1","1","s"},{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"}};

        try {
            System.out.println(sum(numbers));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e){
            e.printStackTrace();
        }

    }
    static int sum(String[][] numbers)  throws MyArraySizeException, MyArrayDataException{
        if (numbers.length !=4){
            throw new MyArraySizeException("Не правильный размер массива");
        } else
            {
                for (int i = 0; i <numbers.length ; i++) {
                    if(numbers[i].length !=4){
                        throw new MyArraySizeException("Не правильный размер массива");
                    }
                }
            }
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                try {
                    sum += Integer.parseInt(numbers[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("элемент [" + i + "]["+ j +"] не может быть приведен к типу int");

                }



            }
        }
        return sum;
    }
}
