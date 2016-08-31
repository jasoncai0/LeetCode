package SuperPow;

/**
 * Created by zhensheng on 2016/8/26.
 */
public class Solution {
    public int superPow(int a, int[] b) {

        int ret = 1 ;
        int base = a ;
        for (int i = b.length -1 ; i >=0 ; i--) {

            for (int j = 0; j < b[i] ; j++) {
                ret = (ret*base)%1337 ;
            }
            base = ((int) Math.pow(base ,10) )%1337;

        }
         return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int b[] = {1,1};
        System.out.println(s.superPow(2,b));
    }
}
