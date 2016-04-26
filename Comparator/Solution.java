package Comparator;

import java.util.*;

/**
 * Created by zhensheng on 2016/3/23.
 */
public class Solution {

    public static class StringComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            int temp1 =Integer.parseInt(o1+o2);
            int temp2= Integer.parseInt(o2+o1);
            return temp2-temp1;
        }
    }

    public static void main(String args[]){
        Stack<String> st= new Stack<>();
        List<String > ls = new ArrayList<>();
        ls.add("123");
        ls.add("345");
        ls.add("3465");
        Collections.sort(ls,new StringComparator());
        for(String s : ls){
            System.out.println(s);
        }

    }
}
