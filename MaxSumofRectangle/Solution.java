package MaxSumofRectangle;

import java.util.Arrays;

/**
 * Created by zhensheng on 2016/8/25.
 */
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int a = 0; a < n  ; a++) {
            int col[] = new int[m];
            //System.arraycopy(matrix[a],0,col, 0 ,m );
            //System.out.println(Arrays.toString(col));
            for (int c = a; c < n ; c++) {
                for (int i = 0; i < m; i++) {
                    col[i] += matrix[c][i];
                }
                System.out.println(Arrays.toString(col));
                int ends =col[0] ;
                int sum = col[0] ;

                for (int i = 1; i < m ; i++) {

                    ends= Math.max(col[i] , col[i]+ ends);
                    if(ends>sum){
                        sum = ends;
                    }
                    
                }
                /*
                if(sum >k ) continue;
                else {
                    if(sum== k ) return k;
                    else if(sum >max){
                        max = sum;
                    }
                }
                */
                if(sum> max){
                    max=  sum ;
                }
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int a[][] = {{-1,2,-3},{3,4,5},{2,3,4} };
        Solution s=  new Solution();
        System.out.println(s.maxSumSubmatrix(a,2));
    }
}
