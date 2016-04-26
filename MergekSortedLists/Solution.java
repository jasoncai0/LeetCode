package MergekSortedLists;
import util.ListNode;
/**
 * Created by zhensheng on 2015/11/19.
 */
public class Solution {
    public static ListNode mergeTwo(ListNode l1 , ListNode l2 ){
        ListNode l3 = new ListNode(0);
        ListNode temp = l3;
        while(l1 !=null && l2 !=null){
            if(l1.val <= l2.val){
                temp.next= new ListNode(l1.val);
                temp =temp.next;
                l1= l1.next;
            }
            else {
                temp.next =new ListNode(l2.val);
                temp = temp.next;
                l2= l2.next;
            }
        }
        if(l1 ==null ) {
            temp.next = l2 ;

        }
        else temp.next= l1 ;
        return l3.next;


    }
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0 ) return null ;
        if (len == 1 ) return lists[0];
        int len2 = len/2 ;
        ListNode []ln = new ListNode[len2];
        for(int i= 0 ; i <len2 ; i ++){
            ln[i]= mergeTwo(lists[i*2 ] , lists[i*2 +1 ]);

        }
        if(len%2 ==1 ){
            ln[len2 -1 ] = mergeTwo(ln[len2-1] , lists[len-1 ]);
        }
        return mergeKLists(ln);
    }

    public static void main(String[] args){

        Solution s =new Solution();


    }
}
