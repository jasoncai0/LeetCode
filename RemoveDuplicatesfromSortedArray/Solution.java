package RemoveDuplicatesfromSortedArray;

/**
 * Created by zhensheng on 2015/11/21.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0 ;

        for(int i = 0 , j = 0  ; i< nums.length; ++i ,++j){
            nums[j] = nums [i];
            count ++;
            while (i<nums.length-1 && nums[i] == nums[i+1 ]) i++ ;
        }


        return count ;
    }
    public static void main(String []args){
        Solution s = new Solution();
        int []nums= {1,1,2,2,4,5};
        System.out.println(s.removeDuplicates(nums));
    }
}
