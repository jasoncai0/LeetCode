package RotateList;

import util.ListNode;

/**
 * Created by zhensheng on 2016/1/14.
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        int len = 0 ;
        ListNode temp = head;

        while (temp!=null){
            len++ ;
            temp=temp.next;
        }

        if(len == 0 ) return head ;
        k = k% (len);

        temp = head ;
        for(int i= 0 ; i < len- k -1 ; i ++ ){
            temp= temp.next;
        }
        ListNode pre = temp ;

        for(int i = 0  ; i <  k ;  i ++ ){
            temp = temp.next ;
        }


        temp.next=head ;
        head=pre.next;
        pre.next=null;

        return head;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        ListNode head  = new ListNode(1 );
        ListNode l2 = new ListNode(2);
        ListNode l3= new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5= new ListNode(5);
        head.next= l2;
        l2.next = l3 ;
        l3.next= l4;
        l4.next= l5;
        System.out.println(s.rotateRight(head, 2));

    }
}
