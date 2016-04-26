package RemoveColsRows;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by zhensheng on 2016/3/30.
 */
public class Clearer {
    public int[][] clearZero(int[][] mat, int n) {
        // write code here
        StringBuffer sb ;
        String str;
        HashMap hm;

        if(n<=1 ) return mat;
        boolean flag = false ;
        for (int i = 0; i <n ; i++) {
            if(mat[0][i] == 0 ) {
                flag =true;
                break;
            }
        }
        for(int i = 1 ; i< n ;i++ ){
            for (int j =0; j < n; j++) {
                if(mat[i][j] == 0 ) {
                    mat[i][0] =  0 ;
                    mat[0][j] = 0 ;
                }
            }
        }
        for(int i = 1 ; i< n ; i++){
            for (int j =n-1; j >= 0 ; j--) {
                if(mat[i][0] == 0 || mat[0][j] == 0 ) mat[i][j] = 0 ;
            }
        }
        if(flag ) Arrays.fill(mat[0],0);
       //if(mat[0][0] == 0 ) Arrays.fill(mat[0],0);
        return mat;
    }
    public static void main(String args[]){
        Clearer c= new Clearer();
        int a [][] = { {1,2,3},{0,1,2},{0,0,1}};
        int b[][] = c.clearZero(a,a.length);
        for(int e[] : b){
            for(int d : e)
                System.out.print(d);
            System.out.println();
        }


    }
}
