package ValiPerfectSquare;

/**
 * Created by zhensheng on 2016/6/26.
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int hi  = num ;
        int lo = 0 ;
        //if(num* num  == num ) return  true;
        long mid ;
        while(lo <= hi ){
            mid = lo + (hi- lo ) /2 ;
            if(mid * mid == num ) return true;
            else if(mid* mid < num ) lo = (int) mid +1 ;
            else hi = (int)mid -1 ;

        }
        return false ;
    }
    public static void main(String args[]){
        Solution s = new Solution();
        System.out.print(s.isPerfectSquare(2147483647));
    }
}
