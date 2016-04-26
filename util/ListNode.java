package util;

/**
 * Created by zhensheng on 2015/11/5.
 */
public class ListNode {
    public int val;
    public ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString(){
        StringBuilder sb =new StringBuilder();
        sb.append(Integer.toString(val));
        sb.append(",");
        ListNode temp = next;
        while(temp !=null){
            sb.append(Integer.toString(temp.val));
            sb.append(",");
            temp = temp.next;
        }
        return sb.toString();
    }
}
