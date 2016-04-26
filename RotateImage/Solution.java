package RotateImage;

/**
 * Created by zhensheng on 2016/3/30.
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int half = (n+1) /2 ;
        int halfj = n%2 ==1 ? half-1 : half;
        int temp = 0 ;
        for(int i = 0 ; i< half ;i++ ){
            for (int j = 0; j <halfj ; j++) {
                temp = matrix[i][j];
                matrix[i][j]= matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]= matrix[j][n-1-i];
                matrix[j][n-1-i] =temp;
            }
        }

    }
    public static void main(String args[]){
        int [][]a = {{1,2,3 ,4,5},{3,4,5,6,7},{5,6,7,8,9},{2,3,4,5,6},{1,2,3,4,5}};
        Solution s = new Solution();
        s.rotate(a);
        for(int []b :a ){
            for (int c :b)
                System.out.print(c);
            System.out.println();
        }
    }

}
