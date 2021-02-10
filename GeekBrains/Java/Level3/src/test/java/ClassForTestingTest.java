import Lesson6.ClassForTesting;
import org.junit.jupiter.api.*;

public class ClassForTestingTest {

    public  ClassForTesting classForTesting;
    public Integer[] fourIsNotFound = {1,2,3};
    public Integer[] oneIsNotFound = {4,2,3};
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
    @Test
    void hasOneAndFour(){
        Assertions.assertNotNull(classForTesting);
        Assertions.assertNotNull(fourIsNotFound);
        Assertions.assertNotNull(oneIsNotFound);
        Assertions.assertNotNull(actual);
        Assertions.assertNotNull(fourIsLast);
        Assertions.assertNotNull(empty);

        Assertions.assertFalse(classForTesting.hasOneAndFour(fourIsNotFound));
        Assertions.assertFalse(classForTesting.hasOneAndFour(oneIsNotFound));
        Assertions.assertFalse(classForTesting.hasOneAndFour(actual));
        Assertions.assertTrue(classForTesting.hasOneAndFour(fourIsLast));
        Assertions.assertFalse(classForTesting.hasOneAndFour(empty));


    }

}
