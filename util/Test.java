package util;

import java.util.Comparator;

/**
 * Created by zhensheng on 2016/3/24.
 */
public class Test {

    public String str= "6";
    public void change(String str){
        str= "10";
    }
    public void change(Test t){
        t.str="11";
    }
    public static void main(String args[])  {
        Test t= new Test();
        t.change(t.str);
        String s = "1111";
        t.change(s);
        System.out.println(s);
        System.out.println(t.str);
        Test t2= new Test();
        t.change(t2);
        System.out.println(t2.str);

    }


}


