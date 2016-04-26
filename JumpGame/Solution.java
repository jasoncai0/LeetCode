package JumpGame;

/**
 * Created by zhensheng on 2015/11/20.
 */
public class Solution {

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int target = len-1;
        if(len ==0 )return  false ;
        if(len ==1 ) return true;
        for(int i = len -2  ; i >=0 ;i --){
            if(i+nums[i] >= target) target = i ;
        }
        if(target == 0 )return true;
        else return false ;
    }
    public static void main(String [] args){
        Solution s = new Solution();
        int []nums= {3,2,1,0,4};
        System.out.println(s.canJump(nums));
    }

}
