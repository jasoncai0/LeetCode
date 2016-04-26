package baidu;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhensheng on 2016/4/21.
 */
public class FirstInOutPage {
    public  int countCacheMiss(int max_cache_size, int[] page_requests)
    {
        // INSERT YOUR CODE HERE
        Queue<Integer> q = new LinkedList<>();
        int mis = 0 ;
        for(int i =  0 ; i < page_requests.length ; i++ ){
            boolean exist = false;
            for(Integer page : q){
                if(page == page_requests[i]) {
                    exist = true;
                    break;
                }
            }
            if(exist == false){
                if(q.size() < max_cache_size){
                    q.offer(page_requests[i]);
                }else {
                    q.offer(page_requests[i]);
                    q.poll();
                }
                mis++;
            }

        }
        return mis;
    }
    public static void main(String args[]){
        FirstInOutPage f= new FirstInOutPage();
        int a[] ={1,2,1,3,1,2};
        System.out.println(f.countCacheMiss(2,a));
    }
}
