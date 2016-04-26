package RemoveNthNodeFromEndofList;
import util.ListNode;
/**
 * Created by zhensheng on 2015/11/19.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head ;
        int count = 0;
        while (temp !=null ){
            count ++;
            temp = temp.next;

        }
        int i = count - n ;
        if (i<0) return null;
        temp = head ;
        ListNode pre = null  ;

        while(i>0 ){
            i--;
            pre =temp;
            temp = temp.next;
        }
        if(pre ==null )return head.next;
        pre.next = temp.next;
        return head;

    }
    public static void main(String[] args){
    }
}
