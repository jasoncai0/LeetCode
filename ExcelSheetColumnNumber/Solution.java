package ExcelSheetColumnNumber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhensheng on 2016/6/29.
 */
public class Solution {
    public int titleToNumber(String s) {
        char [] chs = s.toCharArray();
        int sum  = 0 ;
        for(char ch : chs){
            sum*= 26;
            sum += (ch- 'A') +1 ;
        }
        return  sum ;

    }
    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.titleToNumber("AA"));
        System.out.println(s.titleToNumber("Z"));
        List<String>[] arr =(List<String>[]) new ArrayList<?>[10];
        FutureTask ft;
        //ft.run();
        ExecutorService es = Executors.newFixedThreadPool(10);
        //Lock;


    }
}
