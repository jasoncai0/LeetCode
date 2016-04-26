package ContainsDuplicate;

import java.util.Arrays;

/**
 * Created by zhensheng on 2016/3/3.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length ; i++) {
            if(nums[i] == nums[i-1]) return  true;

        }
        return false;
    }
    public static void main(String []args){
        Solution s= new Solution();
        int a[]= {1,2,3,4,53};
        System.out.println(s.containsDuplicate(a));
    }
}
