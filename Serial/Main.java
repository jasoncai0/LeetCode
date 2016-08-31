package Serial;

import java.io.*;

/**
 * Created by zhensheng on 2016/8/24.
 */
public class Main {
    public static void main(String[] args) {
        Employee sec = new Employee("sec");
        Employee manager = new Manager("manager" ,sec);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.dat"));
            oos.writeObject(manager);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.dat"));
            Manager m = (Manager) ois.readObject();
            System.out.println(m.secretary.name);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
