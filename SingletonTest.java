/**
 * Created by zhensheng on 2016/4/2.
 */
public class SingletonTest {
    private static SingletonTest ourInstance = new SingletonTest();

    public static SingletonTest getInstance() {
        return ourInstance;
    }

    private SingletonTest() {
    }
}
