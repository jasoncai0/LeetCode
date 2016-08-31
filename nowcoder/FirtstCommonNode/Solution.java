package nowcoder.FirtstCommonNode;

import util.ListNode;

/**
 * Created by zhensheng on 2016/7/11.
 */
public class Solution {
    public int getLen(ListNode node){
        int count = 0 ;
        while(node!= null){
            count++;
            node = node.next;
        }
        return count ;
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = getLen(pHead1);
        int len2 = getLen(pHead2);
        ListNode curNode1 = pHead1;
        ListNode curNode2 = pHead2;
        int dif;
        if(len1 >= len2){
            dif = len1 - len2 ;
            while (dif>0 ){
                curNode1 = curNode1.next;
                dif-- ;
            }
        }
        else {
            dif = len2- len1 ;
            while(dif>0 ){
                curNode2 = curNode2.next;
                dif-- ;
            }
        }
        while(curNode1 != null && curNode2 != null && curNode1 != curNode2 ){
            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
        }
        return curNode1;


    }
}
