package ReverseLinkedListII;

import util.ListNode;

import java.util.List;

/**
 * Created by zhensheng on 2016/1/27.
 */
public class Solution {

    //1-2-3-4-5 ,1,5 --------> 5-2-3-4-1 wrong
    //1-2-3-4-5, 1,5 --------> 5-4-3-2-1 right
    /*
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //m=2 , n =4 ;
        // m = 1, n =3 , n-m = 2 ;
        //pre = m -1 = 0 ,
        int interval = n-m;
        int between = n-m ;
        ListNode temp = new ListNode(0);
        ListNode realHead = temp;
        temp.next=head;
        while (m-1 > 0 ){
            temp= temp.next;
            m-- ;
        }
        ListNode prem = temp ;
        //temp=temp.next;
        ListNode nodem= temp.next;
        ListNode afterm= nodem.next;
        while(between > 0 ){
            temp = temp.next;
            between--;
        }
        ListNode pren = temp;
        //temp=temp.next;
        ListNode noden = temp.next;
        ListNode aftern=noden.next;

        if(interval ==1 ){
            prem.next= noden;
            noden.next=nodem;
            nodem.next=aftern;
            return realHead.next;
        }
        prem.next=noden;
        noden.next= afterm;
        pren.next=nodem;
        nodem.next=aftern;
        return realHead.next;
    }*/
    public ListNode reverseBetween(ListNode head, int m, int n) {
        return null;
    }

    public static void main(String[] args){
        Solution s = new Solution() ;
        ListNode head  = new ListNode(1 );
        ListNode l2 = new ListNode(2);
        ListNode l3= new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5= new ListNode(5);
        head.next= l2;
        l2.next = l3 ;
        l3.next= l4;
        l4.next= l5;
        System.out.println(s.reverseBetween(head,3,4));
    }
}
