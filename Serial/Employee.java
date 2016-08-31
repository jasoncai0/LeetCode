package Serial;

import java.io.Serializable;

/**
 * Created by zhensheng on 2016/8/24.
 */
public class Employee implements Serializable {


    private static final long serialVersionUID = 6164387753903611148L;
    public String name ;

    public Employee(String name) {
        this.name = name;
    }
}
