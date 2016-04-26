package ContainsDuplicateII;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhensheng on 2016/3/3.
 */

/**
 * hashset 方法， 移动窗口的思想， 每次只存K 个 如果存在就删掉，
 * ！！！
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer ,Integer > m = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(m.containsKey(nums[i])){
                int index  = m.get(nums[i]);
                if(Math.abs(index - i )  <= k ) return true;
                else m.put(nums[i] , i );

            }
            else {
                m.put(nums[i] , i );
            }
        }
        return false;
    }
    public static void main(String []args){
        Solution s= new Solution();
        int a[]= {1,0,1,1};
        System.out.println(s.containsNearbyDuplicate(a,1));
    }
}
