package IntersectionofTwoArrays;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhensheng on 2016/5/19.
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums2){
            if(set.contains(num)){
                set2.add(num);
            }
        }

        Lock l= new ReentrantLock();
        int [] ret = new int[set2.size()];
        int index = 0 ;
        for (int num : set2){
            ret[index] = num;
            index++;
        }
        return ret;

    }
}
