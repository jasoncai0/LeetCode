package SingleNumberIII;

import java.util.*;

/**
 * Created by zhensheng on 2016/2/25.
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> ret = new HashSet<>();
        for (int num : nums ){
            if(ret.contains(num)){
                ret.remove(new Integer(num));
            }
            else ret.add(new Integer(num));
        }
        int res[] =new int[2];
        Iterator<Integer> it = ret.iterator();
        if(ret.size() < 2 ) return res;
        for (int i = 0; i < 2 ; i++) {
            res[i] = it.next();
        }
        return res;
    }
    public static void main(String[]args){
        Solution s = new Solution();
        int a[] = {};
        int b[] = s.singleNumber(a);
        for (int i = 0; i < b.length ; i++) {
            System.out.println(b[i]);
        }

    }

}
