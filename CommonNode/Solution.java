package CommonNode;
import util.ListNode;
import java.util.*;

/**
 * Created by zhensheng on 2015/11/5.
 */
public class Solution {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode node1  = pHead1;
        ListNode node2 = pHead2;
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (node1!=null){
            set.add(node1);
            node1= node1.next;

        }
        while (node2!=null){
            if(set.contains(node2 )){
                return node2;
            }
            node2 = node2.next;
        }


        return null;
    }

    public static void main(String[] args){
        int[]array = {9,3,2,5,1};


        Solution s =new Solution();
        //int ret= s.InversePairs(array);
        System.out.println();
    }
}
