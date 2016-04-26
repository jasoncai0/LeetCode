package reflection;

import java.lang.reflect.Constructor;

import static java.lang.Class.*;

/**
 * Created by zhensheng on 2016/3/24.
 */
class Person2 {
    private String name;
    private int age;

    public Person2() {

    }

    public Person2(String name) {
        this.name = name;
    }

    public Person2(int age) {
        this.age = age;
    }

    public Person2(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "["+ this.name +  this.age + "]";
    }
}

public class Reflection {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> demo = null;

        try {
            demo = forName("reflection.Person2");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(forName("java.lang.String").newInstance().getClass().getName());
        System.out.println(forName("java.lang.String").newInstance().getClass());
        System.out.println(forName("java.lang.String").getName());
        System.out.println(forName("java.lang.String").newInstance().hashCode());
        System.out.println(forName("java.lang.String").getConstructors());
        Person2 per1 = null;
        Person2 per2 = null;
        Person2 per3 = null;
        Person2 per4 = null;

        Constructor<?> con[] = demo.getConstructors();
        for(Constructor<?> c : con ){
            System.out.println(c);
        }
        try {
            per4 = (Person2) con[3].newInstance();
            per3 = (Person2) con[2].newInstance("rrrrr");
            per2 = (Person2) con[1].newInstance(20);
            per1 = (Person2) con[0].newInstance("Roller", 20);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(per1.toString());
        System.out.println(per2.toString());
        System.out.println(per3.toString());
        System.out.println(per4.toString());
    }
}
