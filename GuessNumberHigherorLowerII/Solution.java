package GuessNumberHigherorLowerII;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhensheng on 2016/8/25.
 */
public class Solution {
    public int guess( int [][] dp , int begin, int end   ){
        if(begin >= end) return 0 ;
        if(dp[begin][end] != 0 ) return dp[begin][end];
        int min = Integer.MAX_VALUE ;
        int cost = 0 ;
        for (int i = begin; i <= end ; i++) {

            cost = i + Math.max(guess(dp, begin, i-1 ), guess(dp, i+1, end) );
            if(cost< min ) {
                min = cost;
            }
        }
        dp[begin][end] = min;
        return min;
    }
    public int getMoneyAmount(int n) {
        int [][] dp = new int[n+1][n+1];
        return guess(dp, 1 , n );

    }

    public static void main(String[] args) {
        Solution s=  new Solution();
        System.out.println(s.getMoneyAmount(3));
    }
}
