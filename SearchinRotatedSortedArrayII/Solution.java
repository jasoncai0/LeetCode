package SearchinRotatedSortedArrayII;

/**
 * Created by zhensheng on 2016/3/2.
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        int size = nums.length;
        int lo = 0 ;
        int hi = size -1 ;
        int mid ;
        while(lo<= hi ){
            mid = (lo+ hi)/2;
            if(nums[mid] == target ) return true;
            if(nums[mid] < nums[lo]|| nums[mid] < nums[hi]){
                if(target <= nums[hi] && target > nums[mid] ){
                    lo = mid+1;
                }
                else {
                    hi= mid-1;
                }
            }
            else if(nums[mid] > nums[lo ] || nums[mid] > nums[hi]) {
                if(target < nums[mid ] && target >= nums[lo]){
                    hi = mid - 1;
                }else {
                    lo =mid +1;
                }
            }
            else {
                hi -- ;
            }
        }
        return false ;

        /*
        boolean flag = target >= nums[0] ;
        while(lo <= hi){
            mid = (lo+ hi) /2 ;
            int temp = nums[mid];
            int num;
            if(temp == target ) return true;
            if(temp == nums[lo] && temp == nums[hi ]){
                hi -- ;
                continue;
            }
            if(flag ){
                if(temp >= nums[lo] )
                    num = temp ;
                else num = Integer.MAX_VALUE;
            }
            else {
                if(temp >=nums[lo]){
                    num = Integer.MIN_VALUE;
                }
                else num = temp;
            }
            if(num > target ){
                hi = mid-1 ;
            }
            else if(num< target){
                lo = mid+1 ;
            }
            else return true ;
        }
        return false ;
        */
    }
    public static void main(String []args){
        Solution s= new Solution() ;
        int []a = {1,1,3,1};
        System.out.println(s.search(a,3));

    }
}
