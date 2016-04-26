package JumpGame2;

/**
 * Created by zhensheng on 2015/11/21.
 */
public class Solution {
    public int jump(int[] nums) {
        int count  = 0 ;
        int i= 0;
        int len = nums.length ;
        if(len==0 ) return 0 ;
        if(len ==1 ) return 0;
        while(i<=nums.length-1){
            int max =0 ;
            int index=  i;
            if(i +nums[i] >=nums.length-1 ) {
                count ++;
                break;
            }

            for(int j = i ; j<nums.length &&j <= i + nums[i]; j++ ) {
                if (j + nums[j] > max) {
                    max = j + nums[j];
                    index = j;
                }
            }
            if (index!=i) {
                //System.out.println(i);
                i = index ;
                count ++;
            }
            else return 0;
        }
        return count ;
    }
    public static void main(String [] args){
        Solution s = new Solution();
        int []nums= {0};
        System.out.println(s.jump(nums));
    }
}
