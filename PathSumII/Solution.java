package PathSumII;


import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhensheng on 2016/2/24.
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer> > ret = new ArrayList<>();
        sum(ret, new ArrayList<>() , root ,  sum ) ;
        return ret;
    }
    public void sum (List<List<Integer >> ret, List<Integer> curList, TreeNode cur, int sum  ){
        if (cur == null ) return;
        curList.add(cur.val);
        sum -= cur.val;
        if(cur.left == null && cur.right== null ){
            if (sum == 0 ){
                ret.add(new ArrayList<>(curList));
            }
            else return;
        }
        sum(ret, curList,cur.left ,sum  );
        sum(ret, curList,cur.right ,  sum  );
    }
    public static void main(String []args){
        Solution s = new Solution();

        System.out.println();
    }


}
