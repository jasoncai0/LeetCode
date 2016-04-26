package PascalTriangleII;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhensheng on 2016/2/23.
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] ret = new Integer[rowIndex+1 ] ;
        int half = (rowIndex+2)/2 ;
        ret[0] = ret[rowIndex] = 1 ;
        long j = rowIndex ;
        for (int i = 1; i < half ; i++,--j ) {
            ret[i] = ret[rowIndex-i ] = (int)((j) * ret [i-1] /i  );

        }
        return Arrays.asList(ret);

    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.getRow(3));
    }
}
