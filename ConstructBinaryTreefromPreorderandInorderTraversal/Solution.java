package ConstructBinaryTreefromPreorderandInorderTraversal;

import util.TreeNode;

/**
 * Created by zhensheng on 2016/9/18.
 */
public class Solution {

    public TreeNode build(int preorder[] , int prelo, int prehi, int inorder[] , int inlo, int inhi){
        if(prelo>prehi || inlo> inhi) return null;
        TreeNode root = new TreeNode(preorder[prelo]);
        int i= inlo;
        for( ; i <=  inhi ; i++){
            if(inorder[i] == preorder[prelo]) break;
        }
        int lenleft = i-inlo;
        int lenright = inhi - i ;
        root.left = build(preorder, prelo+1 , prelo+lenleft , inorder, inlo,i-1 );
        root.right = build(preorder,prelo+lenleft+1 , prehi, inorder,i+1 , inhi);


        return root;

    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, 0 , preorder.length-1 , inorder, 0, inorder.length-1);

    }

    public static void main(String[] args) {
        int preorder [] = {2,3,4,5,1,6};
        int inorder [] = {4,3,5,2,1,6};
        Solution s = new Solution();
        System.out.println(s.buildTree(preorder,inorder));
    }
}
