package Searcha2DMatrix;

/**
 * Created by zhensheng on 2016/1/18.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0 ) return false ;
        int n = matrix[0].length;
        int i = m-1 ;
        int j = 0 ;
        while (i>= 0 && j <n ){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] > target ) i--;
            else j++ ;

        }
        return  false ;
    }
    public static void main(String []args){
        Solution s = new Solution();
        int [][]a = {{1,   3,  5,  7},{10, 11, 16, 20}};
        System.out.println(s.searchMatrix(a,3));
    }
}
