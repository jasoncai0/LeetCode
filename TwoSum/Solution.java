package TwoSum;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by zhensheng on 2016/3/28.
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int a[] = new int [2];
        Deque<Integer> d= new LinkedList<>();
        d.contains(1);
        Map< Integer , Integer> hm = new HashMap<>();
        for (int i = 0; i <  nums.length; i++) {
            hm.put(nums[i] , i ) ;
        }
        for (int i = 0; i <nums.length ; i++) {
            if(hm.containsKey(target- nums[i]) && hm.get(target- nums[i])  != i ){
                a[0] = i ;
                a[1] = hm.get(target- nums[i]) ;
                return a ;
            }
        }
        return a ;
    }
}
