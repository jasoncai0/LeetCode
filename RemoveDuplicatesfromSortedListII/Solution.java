package RemoveDuplicatesfromSortedListII;

import util.ListNode;

import java.util.List;

/**
 * Created by zhensheng on 2016/3/2.
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode avatar = new ListNode(-1);
        avatar.next = head;
        ListNode cur = head ;
        ListNode pre = avatar;
        while(cur!=null && cur.next!=null){
            if(cur.val != cur.next.val){
                pre.next= cur;
                pre =pre.next;
            }
            else {
                while(cur.next != null && cur.val== cur.next.val){
                    cur =cur.next;
                }

            }
            cur=cur.next;
        }
        pre.next =cur;
        return avatar.next ;
    }
    public static  void main(String [] args){
        Solution s= new Solution();
        ListNode l =new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l.next =l2;
        l2.next =l3;
        l3.next= l4 ;
        l4.next=l5;
        System.out.println(s.deleteDuplicates(l));
    }
}
