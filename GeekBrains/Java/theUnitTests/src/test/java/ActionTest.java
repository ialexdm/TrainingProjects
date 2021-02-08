import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.internal.matchers.Null;

import java.util.concurrent.TimeUnit;

public class ActionTest {

    Action action;
    private static Integer ONE;
    private static Integer TWO;
    private static final int SUM = 12;
    private static final int SUB = 8;
    private static final int MULTI = 20;
    private static final int DIV = 5;
    private static final Integer WRONG = -6545421;


    public ActionTest(){
        action = new Action();
    }

    @BeforeEach
    public void init(){
        ONE = 10;
        TWO = 2;
        Assertions.assertNotNull(action);
        Assertions.assertNotNull(ONE);
        Assertions.assertNotNull(TWO);
    }

    @Test
    public void subTest(){
        Assertions.assertEquals(SUB,action.sub(ONE,TWO));
        Assertions.assertNotEquals(WRONG,action.sub(ONE,TWO));

    }
    @Test

    public void divTest(){
        Assertions.assertEquals(DIV,action.div(ONE,TWO));
        Assertions.assertNotEquals(WRONG,action.div(ONE,TWO));
    }
    @Test
    @Timeout(value =  1, unit = TimeUnit.MICROSECONDS)
    public void multiTest(){
        Assertions.assertEquals(MULTI,action.multi(ONE,TWO));
        Assertions.assertNotEquals(WRONG,action.multi(ONE,TWO));

    }
    @Test
    public void sumTest(){
        Assertions.assertEquals(SUM,action.sum(ONE,TWO));
        Assertions.assertNotEquals(WRONG,action.sum(ONE,TWO));

    }
    @CsvSource({
            "1, 2, 3",
            "-1, -1, -2",
            "0, 3 , 3",
            "0, 0 , 0",
            "3, -1 , 2"
    })

    @ParameterizedTest
    public void sumManyTest(int a, int b, int sum){
        Assertions.assertEquals(sum,action.sum(a,b));
        Assertions.assertNotEquals(WRONG,action.sum(ONE,TWO));

    }

    @Test
    public void sumWithException(){

        ONE = null;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
            action.sumWithException(ONE, TWO);
        });

        ONE = 10;
        TWO = null;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    action.sumWithException(ONE, TWO);
                });

        ONE = null;
        TWO = null;
        try {
            action.sumWithException(ONE, TWO);
            Assertions.fail("Will be throw IllegalArgumentException");
        }catch (IllegalArgumentException e){
        }
        ONE = 10;
        TWO = 2;
        Assertions.assertEquals(SUM,action.sumWithException(ONE,TWO));
        Assertions.assertNotEquals(WRONG,action.sumWithException(ONE,TWO));
        try {
            action.sumWithException(ONE, TWO);
        }catch (Exception e){
            Assertions.fail("Will not be throw Exception");
        }


    }


}
