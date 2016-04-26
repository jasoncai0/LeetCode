package PathSum;

import util.TreeNode;

/**
 * Created by zhensheng on 2016/2/24.
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return sum(root,0 , sum );
    }
    public boolean sum(TreeNode cur , int curSum, int sum  ){
        if (cur == null ) return false ;
        if(cur.left == null && cur.right== null ){
            if (curSum + cur.val == sum ){
                return true;
            }
            else return false;
        }

        return sum(cur.left , curSum + cur.val , sum  )||sum(cur.right , curSum + cur.val , sum  ) ;

    }
    public static void main(String []args){
        Solution s = new Solution();

        System.out.println();
    }

}
