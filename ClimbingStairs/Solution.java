package ClimbingStairs;

/**
 * Created by zhensheng on 2016/2/23.
 */
public class Solution {
    public int climbStairs(int n) {

        return climbStairs(1,1, n );

    }
    public static int climbStairs( int a , int b , int n ){
        if( n==0  ) return a;
        return climbStairs(b, a+b , n-1 ) ;
    }

    public static void main(String []args){
        Solution s = new Solution();
        System.out.println(s.climbStairs(4));
    }
}
