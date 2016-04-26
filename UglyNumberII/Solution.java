package UglyNumberII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhensheng on 2016/2/27.
 */
public class Solution {
    public int nthUglyNumber(int n) {
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3= new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();
        q2.add(1);
        q3.add(1);
        q5.add(1);
        int ret = 0 ;
        for (int i = 0; i <  n ; i++) {
            ret= Math.min(q2.peek(),Math.min(q3.peek(), q5.peek()));
            if(ret == q2.peek()) q2.poll();
            if(ret == q3.peek()) q3.poll();
            if(ret == q5.peek()) q5.poll();

            q2.add(ret *2 );
            q3.add(ret *3 );
            q5.add(ret * 5);
        }
        return ret ;
    }
    public static void main(String[]args){
        Solution s = new Solution();
        System.out.println(s.nthUglyNumber(10));
    }


}
