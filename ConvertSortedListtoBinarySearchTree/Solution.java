package ConvertSortedListtoBinarySearchTree;

import util.ListNode;
import util.TreeNode;

/**
 * Created by zhensheng on 2016/3/2.
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head  == null ) return null;
        return List2BST(head , null );
    }
    //tail budao

    /**
     *
     * @param head
     * @param tail
     * @return
     */
    public TreeNode List2BST(ListNode head ,ListNode tail){
        if(head == tail ) return null;
        ListNode fast = head ;
        ListNode slow = head ;
        while(fast!=tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left= List2BST(head ,slow);
        root.right = List2BST(slow.next, tail);
        return root;
    }
}
