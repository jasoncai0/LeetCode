package Serial;

/**
 * Created by zhensheng on 2016/8/24.
 */
public class Manager extends Employee {
    Employee secretary;

    public Manager(String name, Employee secretary) {
        super(name);
        this.secretary = secretary;
    }
}
