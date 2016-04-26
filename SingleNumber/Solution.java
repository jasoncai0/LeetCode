package SingleNumber;

/**
 * Created by zhensheng on 2016/2/25.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0 ;
        for(int num :nums){
            ret = ret ^num ;
        }
        return ret ;
    }
    public static void main(String[]args){
        Solution s = new Solution();
        int a[] = { 1,1,2,3,3};
        System.out.println(s.singleNumber(a));
    }
}
