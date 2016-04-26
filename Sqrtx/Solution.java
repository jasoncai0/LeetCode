package Sqrtx;

/**
 * Created by zhensheng on 2016/4/1.
 */
public class Solution {
    public int mySqrt(int x) {
        if(x< 0 ) return  -1 ;
        if(x <=1 ) return x;
        int  lo = 0 ;
        int hi =  x ;
        int mid  ;
        while(lo< hi){
            mid = (lo+  hi ) /2;
            if(mid >x/mid ) hi = mid -1 ;
            else if(mid   < x/mid) lo =mid +1 ;
            else  return mid ;
        }
        return (lo* lo > x ) ? lo -1 : lo;
    }
    public static void main(String args[]){
        Solution s= new Solution();
        System.out.println(s.mySqrt(30));
    }
}
