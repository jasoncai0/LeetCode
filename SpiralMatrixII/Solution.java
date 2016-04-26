package SpiralMatrixII;

import java.util.List;

/**
 * Created by zhensheng on 2016/1/13.
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int [][] matrix = new int[n][n];
        spiral(matrix,0,n-1 , 0 , n-1 , 1  );
        return matrix;
    }
    public void spiral( int [][] matrix , int col1 , int col2 , int row1 , int row2 , int count  ){
        if(col1 >  col2 ) return;
        if(row1 > row2 ) return ;
        for(int i = col1 ; i <= col2 ; i++  ){
            matrix[row1][i] =count++ ;

        }
        for(int i = row1+1 ; i<= row2 ; i++){
            matrix[i][col2]=count ++;
        }
        if(row1< row2 ){
            for(int i = col2-1 ; i>=col1 ; i--){
                matrix[row2][i] =count ++;
            }
        }
        if(col1< col2 ){
            for(int i= row2-1 ; i>=row1+1 ;i--){
                matrix[i][col1] =count ++;
            }
        }
        spiral(matrix, col1+1 , col2-1 , row1+1 , row2 -1 ,count );


    }
    public static void main(String []args){
        Solution s = new Solution();
        int [][] a = s.generateMatrix(3);
        for(int i = 0 ; i <a.length ;i++)
            for(int j = 0 ; j< a[0].length; j++)
                System.out.println(a[i][j]);
    }
}
