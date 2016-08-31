package xiachufang;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by zhensheng on 2016/8/2.
 */
public class Main {
    public static void main(String args[]){
        Scanner in=  new Scanner(System.in);
        Set<String> s = new HashSet<>();
        while(in.hasNext()){
            String m = in.next();
            if(!s.contains(m)) s.add(m);
            System.out.println(s.size());
        }
        System.out.println(s.size());
    }

}