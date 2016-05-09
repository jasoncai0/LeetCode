package TopKFrequentElements;

import java.util.*;

/**
 * Created by zhensheng on 2016/5/3.
 */
public class Solution {


    class entryComparator implements Comparator<Map.Entry<Integer,Integer>>{

        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {

            return o1.getValue()- o2.getValue();

        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqs = new HashMap<>();
        for(int num : nums){
            if(freqs.containsKey(num)){
                freqs.put(num, freqs.get(num)+1);
            }else {
                freqs.put(num,1);
            }
        }
        int [] minheap = new int[k];
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new entryComparator());
        Iterator<Map.Entry<Integer,Integer>> it = freqs.entrySet().iterator();
        for(Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            pq.offer(entry);
            if(pq.size() > k) pq.poll();
        }

        List<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }
        return res;
    }


    public void adjust(int [] heap, int pos){
        int temp=0 ;
        int len = heap.length;
        int child=0 ;
        for(temp = heap[pos] ; 2* pos +1 <= len ; pos=child){


        }
    }
    public static void main(String args[]){
        Double d = Double.valueOf(1);

    }

}
