package UglyNumber;

/**
 * Created by zhensheng on 2016/2/27.
 */
public class Solution {
    public boolean isUgly(int num) {
        if(num ==2||num==3 ||num==5 || num==1  ) return true;
        for (int i = 2; i <= Math.sqrt(num) ; i++) {
            if(num% i == 0 ){
                return isUgly(i)&& isUgly(num/i);
            }
        }
        return false ;
    }
    public static void main(String[]args){
        Solution s = new Solution();
        System.out.println(s.isUgly(4));
    }
}
