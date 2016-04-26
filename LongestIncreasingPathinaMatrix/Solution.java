package LongestIncreasingPathinaMatrix;

/**
 * Created by zhensheng on 2016/3/28.
 */
public class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        if(matrix.length == 0 || matrix[0].length == 0 ) return 0 ;
        int max [][] =new int [matrix.length][matrix[0].length];
        int longest =0 ;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                longest = Math.max(longest , dfs(matrix,max,i , j ));
            }
        }
        return longest ;

    }
    public int dfs(int [][]matrix , int [][] max , int i , int j ){
        if(max[i][j]> 0 ) return max[i][j];
        int longest = 0 ;
        if( i> 0 &&matrix[i][j] < matrix[i-1][j]) longest = Math.max(longest,dfs(matrix, max, i-1, j ));
        if(i<max.length-1 &&matrix[i][j] < matrix[i+1][j]) longest =Math.max(longest,dfs(matrix,max,i+1 , j ));
        if(j > 0 && matrix[i][j] < matrix[i][j-1] )longest =Math.max(longest, dfs(matrix,max, i , j-1 ));
        if(j< max[0].length-1 && matrix[i][j] < matrix[i][j+1] ) longest = Math.max(longest, dfs(matrix, max, i , j+1 )) ;
        max[i][j] = longest+1;
        return longest+1 ;
    }
    public static void main(String args[]){
        Solution s = new Solution();
        int a [][] = {{3,4,5},{3,2,6},{2,2,1}};
        System.out.print(s.longestIncreasingPath(a));
    }
}
