package ReverseNodesinkGroup;
import util.ListNode;
/**
 * Created by zhensheng on 2015/11/20.
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0 ;
        ListNode temp= head;
        if (k<=1 ) return  head;
        while(temp !=null ){
            count ++;
            temp=temp.next;
        }

        if (count < k) return  head ;
        int r = count /k ;
        ListNode ret = new ListNode(0);
        ret.next =head ;
        //ListNode tempRet = ret ;
        ListNode list  = ret ;
        for(int i= 0 ; i< r ; i++){
            temp = list.next;
            for(int j = 0 ; j < k ; j++){
                ListNode p = temp.next;
                temp.next = p.next;
                p.next = list.next;
                list.next = p;
            }
            list = temp;
        }
        return ret.next;
    }
    public static void main(String[] args){
        ListNode l = new ListNode(0) ;
        l.next = new ListNode(1);

    }
}
