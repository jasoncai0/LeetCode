package FirstMissingPositive;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhensheng on 2016/1/5.
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {
        Map<Integer ,Integer > hm = new HashMap<>();
        for(int i= 0 ; i < nums.length ; i ++ ) {
            hm.put(nums[i] , i ) ;

        }
        int i= 1 ;

        while(true){
            if(hm.containsKey(i)){
                i++;
            }
            else break;
        }
        return i;
    }
    public static  void main(String[] args){
        Solution s = new Solution();
        int [] a=  {1,2,3,-1 ,5,4,8 };
        System.out.println(s.firstMissingPositive(a));
    }

}
