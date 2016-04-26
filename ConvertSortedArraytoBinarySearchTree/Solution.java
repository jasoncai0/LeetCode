package ConvertSortedArraytoBinarySearchTree;

import util.ListNode;
import util.TreeNode;

/**
 * Created by zhensheng on 2016/3/2.
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int size= nums.length;
        return Array2Tree(nums , 0 , size -1 );


    }
    public TreeNode Array2Tree(int []nums , int index1 , int index2 )
    {
        if(index1 > index2 ){
            return null ;
        }
        int mid =(index1 +index2 ) /2 ;
        TreeNode root = new TreeNode(nums[mid]);
        root.left =Array2Tree(nums, index1 , mid-1 );
        root.right= Array2Tree(nums,mid+1 , index2);
        return root;
    }
}
