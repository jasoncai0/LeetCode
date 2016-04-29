package baidu;

import sun.reflect.generics.tree.Tree;
import util.TreeNode;

/**
 * Created by zhensheng on 2016/4/21.
 */
public class subTree {
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public  static int isSubTree(TreeNode root1, TreeNode root2)
    {
        // INSERT YOUR CODE HERE
        boolean ret =judge(root1, root2);
        if (ret ) return  1 ;
        else return -1 ;

    }
    public static boolean judge(TreeNode root1 , TreeNode root2 ){
        if(root2 == null ) return true;
        if(root1 == null )return  false ;
        boolean ret = false;
        boolean ret2 = false ;
        if(root1.val != root2.val) ret = judge(root1.left , root2)|| judge(root1.right , root2) ;
        else ret2 = contain(root1, root2);
        return ret||ret2;
        //StringBuilder sb = new StringBuilder();
        //sb.delete()
        //Integer.parse
    }

    public static boolean contain(TreeNode root1  , TreeNode root2 ){
        if(root2 ==null ) return  true;
        if(root1 == null ) return  false;
        if(root1.val == root2.val) return contain(root1.left,root2.left)&& contain(root1.right,root2.right);
        return  false ;
    }
}
