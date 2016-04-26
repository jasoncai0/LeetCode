package SearchInsertPosition;

/**
 * Created by zhensheng on 2016/4/14.
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        int lo  =0 ;
        int hi = nums.length-1 ;
        int mid ;
        while(lo<= hi ){
            mid =(lo+hi)/2;
            if(nums[mid]> target)  hi = mid -1 ;
            else if(nums[mid]< target) lo = mid+1;
            else {
                while(mid >=0 && nums[mid] == target) mid -- ;
                return mid+1 ;
            }
        }
        return lo;

    }
    public static void main(String args[]){
        Solution s= new Solution();

        int a[]= {1 };
        System.out.println(s.searchInsert(a,1));
    }
}
