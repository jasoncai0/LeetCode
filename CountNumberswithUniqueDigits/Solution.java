package CountNumberswithUniqueDigits;

/**
 * Created by zhensheng on 2016/6/22.
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n<=0 )return 1 ;
        else if(n ==1 ) return 10 ;
        else if(n>10 ){
            return countNumbersWithUniqueDigits(10);
        }else {
            int count = 9 ;
            for(int i = 0 ; i < n-1 ; i++ ){
                count *= (9 - i);
            }
            return count + countNumbersWithUniqueDigits(n-1);
        }
    }
    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.countNumbersWithUniqueDigits(2));
    }
}
