package MajorityElement;

import java.util.Objects;

/**
 * Created by zhensheng on 2016/3/15.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        if(nums.length == 0 ) return 0;
        int candidate  = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(candidate == nums[i]){
                count ++;
            }
            else count --;
            if(count == 0 ) {
                count =1;
                candidate= nums[i];

            }
        }
        return candidate;

    }



    public static void main (String []args){
        Solution s = new Solution();
        Object cb= new Object();
        char b = '的';

        System.out.println(b);
        int a []= {1,1,2,2,3,3,3,3,3};
        System.out.println(s.majorityElement(a));

    }
}
