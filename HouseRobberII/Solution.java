package HouseRobberII;

/**
 * Created by zhensheng on 2016/2/24.
 */
public class Solution {
    public int rob(int[] nums) {
        int size =nums.length ;
        if(size ==0 ) return 0 ;
        if (size ==1 ) return  nums[0] ;
        return Math.max(rob(nums, 0, nums.length-2 ) ,rob(nums, 1, nums.length-1 )) ;

    }
    public int rob(int [] nums , int begin, int end ){
        int size = end- begin +1 ;
        if(size == 0 ) return 0 ;
        int []tou = new int[size];
        int []butou = new int[size] ;
        tou[0] = nums[begin] ;
        butou[0] = 0 ;
        for (int i = 1; i < size  ; i++) {
            tou[i] = butou[i-1] + nums[i+begin] ;
            butou[i] = Math.max(tou[i-1] ,butou[i-1]);
        }
        return Math.max(tou[size-1] , butou[size -1 ] ) ;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int a[] = {2,1,2,2};
        System.out.println(s.rob(a));
    }
}
