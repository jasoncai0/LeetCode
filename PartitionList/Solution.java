package PartitionList;

import util.ListNode;

/**
 * Created by zhensheng on 2016/4/14.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null ) return head;
        ListNode preHead = null ;
        ListNode preTail= null;
        ListNode afterHead = null;
        ListNode afterTail = null;
        ListNode cur = head;
        while(cur != null ){
            ListNode next = cur.next;
            cur.next = null ;
            if(cur.val >= x ){
                if(afterHead == null ){
                    afterHead = cur ;
                    afterTail = afterHead;
                }
                else {
                    afterTail.next = cur;
                    afterTail = afterTail.next;
                }
            }else {
                if(preHead == null ){
                    preHead =cur ;
                    preTail = preHead;
                }
                else {
                    preTail.next=cur;
                    preTail= preTail.next;
                }
            }
            cur = next;
        }
        if( preHead ==null ){
            head = afterHead;
        }
        else {
            preTail.next= afterHead;
            head = preHead;
        }
        return head;

    }
    public static void main(String []args){

    }
}
