package PopulatingNextRightPointersinEachNode;

import util.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhensheng on 2016/2/26.
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<>();
        if(root ==null ) return ;
        q.add(root);
        TreeLinkNode cur ;
        while(!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size ; i++) {
                cur = q.poll();
                if(i==size-1 )cur.next = null;
                else cur.next= q.peek();
                if(cur.left!=null) q.offer(cur.left);
                if(cur.right!=null )q.offer(cur.right);

            }
        }
    }

}
