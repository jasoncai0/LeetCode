package Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhensheng on 2016/2/23.
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if(triangle.size() == 1 ) return triangle.get(0).get(0);
        int [] ret = new int [size ];
        ret[0] = triangle.get(0).get(0);
        for (int i = 1 ; i < triangle.size() ; i++) {
            List<Integer> cur = triangle.get(i);
            ret[cur.size()-1] = ret[cur.size()-2 ] + cur.get(cur.size()-1) ;
            for(int j = cur.size()-2 ; j > 0 ;j--){
                ret[j] = Math.min(ret[j] , ret[j-1 ]) + cur.get(j);
            }
            ret[0] = cur.get(0) + ret[0];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size ; i++) {
            if (ret[i]<min){
                min= ret[i];
            }
        }
        return  min ;
    }
    public static void main(String []args){
        Solution s = new Solution();
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(Arrays.asList(2));
        ret.add(Arrays.asList(3,4));
        ret.add(Arrays.asList(6,5,7));
        ret.add(Arrays.asList(4,1,8,3));
        System.out.println(s.minimumTotal(ret));
    }

}
