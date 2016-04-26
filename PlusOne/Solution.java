package PlusOne;

/**
 * Created by zhensheng on 2015/12/13.
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len-1] ++;
        for(int i = len-1 ; i>= 1 ; --i){

            if(digits[i] ==10 ) {
                digits[i] =  0 ;
                digits[i-1] ++;
            }
        }
        if(digits[0] == 10 ){
            int[]   ret = new int[len+1];
            ret[0] = 1 ;
            ret[1] = 0 ;
            for(int i= 1 ; i <len; ++i ){
                ret[i+1] =digits[i];
            }
            return ret;
        }
        return digits;
    }
    public static  void main(String[] args){
        Solution s = new Solution();
        int[] digits = { 9};
        System.out.println(s.plusOne(digits));
    }
}
