package util;

import java.util.Objects;

/**
 * Created by zhensheng on 2016/3/31.
 */
public class Variargs {
    public static void main(String[] args) {
        test("aaa");
        test("aaa", "bbb");
        test("aaa", "bbb", "ccc");
        String a = "" +1 ;
        System.out.println(a);
    }

    public static void test(Object ... args) {
        for(Object arg : args) System.out.println(arg);
    }

    public static void test(String arg, String... args) {
        System.out.println(arg);
        System.out.println("--------------------------");
        for(Object ar : args) System.out.println(ar);
    }
}
