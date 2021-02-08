import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {
    public static final Logger LOGGER = LogManager.getLogger(TestLogger.class);

    public static void main(String[] args) {

        try{
            int[] arr = new int[5];
            arr[7]=0;
        }catch (IndexOutOfBoundsException e){
            LOGGER.log(Level.WARN,e);
        }finally {
            LOGGER.log(Level.INFO, "Stop");
        }



    }
        //trace
        //Debug
        //Info
        //Warn warning
        //Error
        //Fatal
}
