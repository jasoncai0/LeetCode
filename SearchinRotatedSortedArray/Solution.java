package SearchinRotatedSortedArray;

/**
 * Created by zhensheng on 2015/12/13.
 */
public class Solution {

    /**
     * 可以不要直接比较，先做一个处理，对于在同一梯度的 ，我们直接取， 不同一题则要修改
     * 这里需要注意 flag = 的情况和 》 的情况是一样的， 所以要考虑边界， 即 》= 放一起考虑
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int size = nums.length;
        int lo = 0 ;
        int hi = size -1 ;
        int mid ;
        boolean flag = target >= nums[0] ;
        while(lo <= hi){
            mid = (lo+ hi) /2 ;
            int temp = nums[mid];
            int num;
            if(flag ){
                if(temp >= nums[0])
                    num = temp ;
                else num = Integer.MAX_VALUE;
            }
            else {
                if(temp >=nums[0]){
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
            else return mid ;
        }
        return -1 ;

    }
    public static void main(String []args){
        Solution s= new Solution() ;
        int []a = { 3,1};
        System.out.println(s.search(a,3));

    }
}
