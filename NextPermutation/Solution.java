package NextPermutation;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by zhensheng on 2016/4/12.
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums ==null || nums.length  <=1  )return;
        int i = nums.length-2 ;
        while(i >= 0 && nums[i] >= nums[i+1]) i-- ;
        if(i >=0 ){
            int j = nums.length-1  ;
            while( j>=0 && nums[i] >=nums[j] ) j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1 , nums.length-1 );

    }
    public void swap(int[] a , int i , int j ){
        int temp = a[i];
        a[i] = a[j];;
        a[j] = temp ;
    }
    public void reverse(int a[] , int i , int j ){
        while(i<j ) swap(a,i++ , j -- );
    }
    public static void main(String args[]){
        Solution s = new Solution();
        int[] a= {1,1};
        s.nextPermutation(a);
        for(int b :a ){
            System.out.println(b);
        }
        HashMap m;
        Arrays.sort(a);
    }
}
