package SpiralMatrix;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhensheng on 2016/1/12.
 * @author zhenshengcai
 * @<code>ddddd</code>
 * @param
 */
public class Solution implements Serializable{


    private static final long serialVersionUID = 6340186374868176818L;

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret= new ArrayList<>();
        int rows = matrix.length;
        if (rows == 0 ) return ret ;
        int cols = matrix[0].length;
        if(cols== 0) return  ret;
        spiral(ret, matrix,  0 , cols-1 , 0 , rows-1 );
        return  ret;

    }
    public void spiral(List<Integer> ret ,int [][] matrix , int col1 , int col2 , int row1 , int row2  ){
        if(col1 >  col2 ) return;
        if(row1 > row2 ) return ;
        for(int i = col1 ; i <= col2 ; i++  ){
            ret.add(matrix[row1][i]);
        }
        for(int i = row1+1 ; i<= row2 ; i++){
            ret.add(matrix[i][col2]);
        }
        if(row1< row2 ){
            for(int i = col2-1 ; i>=col1 ; i--){
                ret.add(matrix[row2][i]);
            }
        }
        if(col1< col2 ){
            for(int i= row2-1 ; i>=row1+1 ;i--){
                ret.add(matrix[i][col1]);
            }
        }
        spiral(ret, matrix, col1+1 , col2-1 , row1+1 , row2 -1 );


    }
    public static void main(String []args){
        Solution s = new Solution();
        int [][]a = {{1,2,3}  ,{4,5,6 },{7,8,9 }};
        System.out.println(s.spiralOrder(a));
    }
}
