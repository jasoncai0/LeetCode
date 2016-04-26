package SwapNodesinPairs;
import util.ListNode;
/**
 * Created by zhensheng on 2015/11/20.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head ==null ) return null ;
        if(head.next ==null ) return head;


        ListNode tempNext = head.next;
        ListNode headNext = tempNext.next;
        tempNext.next=head;


        head.next = swapPairs(headNext);

        return tempNext;

    }
}
