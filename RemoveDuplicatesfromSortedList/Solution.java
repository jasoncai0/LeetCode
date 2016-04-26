package RemoveDuplicatesfromSortedList;

import util.ListNode;

import java.util.List;

/**
 * Created by zhensheng on 2016/3/2.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head ;
        if(cur == null ) return cur ;
        ListNode pre =cur ;
        cur= cur.next;

        while(cur!=null ){
            if(cur.val == pre.val){
                pre.next = cur.next;

            }
            else {
                pre = cur ;
            }

            cur= cur.next;
        }
        return head ;
    }
    public static  void main(String [] args){
        Solution s= new Solution();
        ListNode l =new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        l.next =l2;
        l2.next =l3;
        l3.next= l4 ;
        System.out.println(s.deleteDuplicates(l));
    }
}
