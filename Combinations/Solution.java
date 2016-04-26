package Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhensheng on 2016/1/24.
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ret= new ArrayList<>();
        dfs(ret, new ArrayList<>(), 1, n ,k, 0 );
        return ret;

    }
    public void dfs(List<List<Integer>> ret  , List<Integer> cur,int start , int n ,int k , int curindex){
        if(curindex == k ){
            ret.add(new ArrayList<Integer>(cur));
            //ret.add(cur);
            return ;
        }
        //if(n-start < k-curindex || start> n) return ;
        for(int i  = start ; i<= n ; i++ ){
            cur.add(i);
            dfs(ret,cur,i+1 , n, k , curindex+1 );
            cur.remove(cur.size()-1);
        }

    }
    public static void main(String[]args){
        Solution s= new Solution();
        System.out.println(s.combine(4,2));
    }
}
