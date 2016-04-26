package MajorityElementII;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhensheng on 2016/3/15.
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {

        int count1 =0 ;
        int count2 =0 ;

        List<Integer> ret= new ArrayList<>();
        if(nums.length == 0 ) return ret;
        if(nums.length==1 ){
            ret.add(nums[0]);
            return  ret;
        }
        int candidate1 = nums[0];
        int candidate2 = nums[0] ;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] == candidate1) count1 ++ ;
            else if(nums[i] == candidate2 ) count2++ ;
            else if(count1 ==0 ) {
                count1 =1 ;
                candidate1 = nums[i];
            }
            else if(count2 == 0){
                count2= 1;
                candidate2 =nums[i];

            }
            else {
                count1-- ;
                count2--;
            }
        }
        count1 = 0 ;
        count2= 0 ;

        for(int num : nums){
            if(num == candidate1) count1++ ;
            else if(num == candidate2) count2++ ;
        }
        if(count1 > nums.length/3) ret.add(candidate1);
        if(count2 > nums.length/3 ) ret.add(candidate2);
        return ret;

    }
}
