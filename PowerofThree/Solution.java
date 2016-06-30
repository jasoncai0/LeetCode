package PowerofThree;

/**
 * Created by zhensheng on 2016/6/29.
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0 )return false;
        if( n ==1 ) return true;
        while(n >=3 ){
            if(n %3 == 0 && n !=3 ){
                n /=3 ;
            }else {
                n %=3  ;
            }
        }
        if(n == 0 )return true;
        else return false ;
    }
    public static void main(String []args){
        Solution s = new Solution ();
        System.out.println(s.isPowerOfThree(9));
        System.out.println(s.isPowerOfThree(27));
        System.out.println(s.isPowerOfThree(6));
    }
}
