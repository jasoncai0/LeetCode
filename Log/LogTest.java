package Log;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by zhensheng on 2016/5/4.
 */
public class LogTest {

    public static void main(String []args){
        Logger.getGlobal().info("Log test");
        Arrays.asList();
        int i = Integer.MAX_VALUE;
        System.out.println(i);
        Date d = new Date((long)(i)*1000);
        System.out.println(d);
        Date d2= new Date();
        System.out.println(d2);
    }
}
