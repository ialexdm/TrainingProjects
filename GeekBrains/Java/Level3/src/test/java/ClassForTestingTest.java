import Lesson6.ClassForTesting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ClassForTestingTest {

    public  ClassForTesting classForTesting;
    public Integer[] fourIsNotFound = {1,2,3};
    public Integer[] fourIsNotOnlyOne ={1,2,4,2,5,4,6,7,8,9};
    public Integer[] actual = {6,7,8,9};
    public Integer[] fourIsLast = {1,2,3,5,6,7,8,9,4};
    public Integer[] empty = new Integer[0];
    @BeforeEach
    void init(){
        classForTesting = new ClassForTesting();
    }

    @Test
    void getNumbersAfterLastFour(){
        Assertions.assertNotNull(classForTesting);
        Assertions.assertNotNull(actual);
        Assertions.assertNotNull(fourIsNotOnlyOne);
        Assertions.assertNotNull(fourIsLast);
        Assertions.assertNotNull(empty);
        //1
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            classForTesting.getNumbersAfterLastFour(fourIsNotFound);
        });
        //2
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            classForTesting.getNumbersAfterLastFour(empty);
        });
        //3
        Assertions.assertArrayEquals(classForTesting.getNumbersAfterLastFour(fourIsNotOnlyOne), actual);
        //4
        Assertions.assertArrayEquals(classForTesting.getNumbersAfterLastFour(fourIsLast), empty);

    }

}
