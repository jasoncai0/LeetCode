package LongestIncreasingSubsequence;

/**
 * Created by zhensheng on 2016/6/26.
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[] = new int[nums.length];
        int max = 0;
        for(int i = 0 ;i< nums.length ; i++ ){
            dp[i] =1 ;
            for(int j = 0 ; j < i ; j ++ ){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i] ,dp[j] +1 );
                }
            }
            max= Math.max(dp[i],max);
        }
        return max;
    }
    public static void main(String args[]){
        int a[] = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS(a));
    }
}
