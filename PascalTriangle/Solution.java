package PascalTriangle;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhensheng on 2016/2/23.
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRows == 0) return ret ;
        ret.add(Arrays.asList(1));
        for (int i = 1; i <numRows ; i++) {
            List<Integer> rows = new ArrayList<>();
            List<Integer> pre = ret.get(i-1);
            rows.add(1);
            for(int j = 1 ; j< i ; j++  ){
                rows.add(pre.get(j)+ pre.get(j-1));
            }
            if(i>0 ){
                rows.add(1);
            }
            ret.add(rows);

        }
        return ret;

    }
    public static void main(String[]args){
        Solution s = new Solution();
        System.out.println(s.generate(2));


    }
}
