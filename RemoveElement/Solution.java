package RemoveElement;

/**
 * Created by zhensheng on 2015/11/21.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0 ;i< nums.length ; ++i ){
            if(nums[i] == val ){
                continue;
            }
            nums[j] =nums[i] ;
            j++;
        }
        return j;
    }
    public static void main(String []args){
        Solution s = new Solution();
        int []nums= {1,1,2,2,4,5};
        System.out.println(s.removeElement(nums,1));
    }

}
