package LargestRectangleinHistogram;

import java.util.Arrays;

/**
 * Created by zhensheng on 2016/2/26.
 */

//TODO: TML
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int ret =0 ;
        boolean isProcessed[] =new boolean[size] ;
        int temp=0 ;
        //Arrays.fill(isProcessed,false);
        for (int i = 0; i < size ; i++) {

            if(isProcessed[i] ) continue;
            int left = 1 ;
            int right =1 ;
            while (i+right<size && heights[i+right]>= heights[i] ){
                if(heights[i+right] == heights[i]) isProcessed[i+right]=true;
                right++;
            }

            while (i-left >= 0 &&  heights[i-left] >= heights[i]){
                left++;
            }

            temp=(left+right-1) * heights[i];
            if(ret < temp) ret = temp;
        }
        return ret;
    }
    public static void main(String args[]){
        Solution s= new Solution();
        int a[] = {1,2,3,3,5};
        System.out.println(s.largestRectangleArea(a));
    }
}
