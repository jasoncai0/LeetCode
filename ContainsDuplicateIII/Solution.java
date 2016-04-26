package ContainsDuplicateIII;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by zhensheng on 2016/3/3.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0) return false ;
        Map<Long , Integer> m = new HashMap<>();
        //double buk = t +1 ;
        for (int i = 0; i < nums.length; i++) {
            if(i> k ) m.remove(getKey(nums[i-k-1],t));
            long key= getKey(nums[i],t) ;

            if(m.containsKey(key) ) return true;
            if(m.containsKey(key-1 )&& Math.abs(m.get(key-1 ) - nums[i] ) <=t  ) return true;
            if(m.containsKey(key+1 ) && Math.abs(m.get(key+1) - nums[i] ) <=t) return true;
            m.put(key,nums[i]);

        }
        return false ;

    }

    public Long getKey(long nums,long t ){
        if(nums >= 0 ){
            return nums/ (long)(t+1) ;
        }
        else {
            return (nums+1)/(long)(t+1) -1 ;
        }
    }
    public static void main(String []args){
        Solution s= new Solution();
        int a[]= {1,2};
        System.out.println(s.containsNearbyAlmostDuplicate(a,0,1));
    }
}
