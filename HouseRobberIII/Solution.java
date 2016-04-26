package HouseRobberIII;

import util.TreeNode;

/**
 * Created by zhensheng on 2016/3/21.
 */
public class Solution {
    public int rob(TreeNode root) {
        int ret1;
        int ret2= 0 ;
        if(root == null ) return 0 ;
        ret1 = rob(root.left)+rob(root.right);
        ret2 += root.val;
        if(root.left !=null ) {
            ret2+= rob(root.left.left);
            ret2+= rob(root.left.right);

        }
        if(root.right !=null ) {
            ret2+= rob(root.right.left);
            ret2+= rob(root.right.right);
        }
        return Math.max(ret1,ret2);
    }
}
