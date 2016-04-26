package NQueens2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhensheng on 2016/1/12.
 */
public class Solution {
    class node {
        public int x;
    }
    public int totalNQueens(int n) {
        //List<List<String>> ret= new ArrayList<>();
        //int []ret = new int [1 ];
        //ret[0] = 0;
        node ret =new node(); ;
        ret.x= 0 ;
        int[] cols = new int[n];
        dfs(ret,cols,0 , n );
        return ret.x;
    }
    public void dfs (node ret,int [] cols,int rows ,int n  ){
        if(rows == n ) {
            ret.x ++  ;
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
        System.out.println(s.totalNQueens(4));

    }
}
