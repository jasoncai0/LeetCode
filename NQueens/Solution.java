package NQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhensheng on 2015/12/30.
 */

public class Solution {


    public class node {
        public int x ;
        public int y ;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret= new ArrayList<>();
        int[] cols = new int[n];
        dfs(ret,cols,0 , n );
        return ret;

    }
    public void dfs (List<List<String>> ret,int [] cols,int rows ,int n  ){
        if(rows == n ) {
            List<String> ans = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < n ; i ++ ) {
                for ( int j= 0 ; j< n  ; j++ ){
                    if(cols[i] == j ){
                        sb.append('Q');
                    }
                    else sb.append('.');
                }
                ans.add(sb.toString());
                sb= new StringBuilder();
            }
            ret.add(ans);
        }
        else {
            for(int i= 0 ; i< n ; i ++ ){
                cols[rows] = i ;
                if(isSafe(cols,rows)){
                    dfs(ret, cols , rows+1 , n );
                }
            }
        }
    }
    public boolean isSafe(int []cols , int rows ){
        for(int i= 0 ; i< rows ;i++ )
        {
            if(cols[rows] == cols[i] || Math.abs(i -rows) == Math.abs(cols[i] - cols[rows])){
                return false;
            }

        }
        return true;
    }



    public static void main(String [] args){

        Solution s =new Solution();
        int a[] = {1,2,3};
        System.out.println(s.solveNQueens(4));

    }
}
