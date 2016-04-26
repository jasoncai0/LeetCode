package MaximumSubarray;

/**
 * Created by zhensheng on 2016/1/12.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 0; i < len; i++) {
            dp[i + 1] = Math.max(nums[i], nums[i] + dp[i]);
        }
        int max = dp[1];
        for (int i = 0; i < len; i++) {
            if (dp[i + 1] > max) max = dp[i + 1];
        }
        return max;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int a[] = { -2, 1,-3, 4,-1, 2, 1,-5, 4};
        System.out.println(s.maxSubArray(a));


    }
}
