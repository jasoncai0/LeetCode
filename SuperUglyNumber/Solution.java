package SuperUglyNumber;

import java.util.*;
import java.util.jar.Pack200;

/**
 * Created by zhensheng on 2016/2/27.
 */
public class Solution {
    /*
    public int nthSuperUglyNumber(int n, int[] primes) {
        int size =primes.length;
        List<Queue<Integer>> l = new ArrayList<>(size);
        for (int i = 0; i <size  ; i++) {
            Queue<Integer> temp = new LinkedList<>();
            temp.add(1);
            l.add(temp);
        }

        int ret = 0 ;
        for (int i = 0; i < n ; i++) {
            ret = l.get(0).peek();
            for (int j = 0; j <size  ; j++) {
                ret=Math.min(ret, l.get(j).peek());
            }
            for (int j = 0; j < size; j++) {
                if(ret== l.get(j).peek()) l.get(j).poll();

            }
            for (int j = 0; j < size; j++) {
                l.get(j).add(ret* primes[j]);

            }

        }
        return  ret;

    }*/
    public int nthSuperUglyNumber(int n, int[] primes){
        int size = primes.length;
        int indexs[] = new int[size];
        int res[]= new int [n];
        res[0] =1 ;

        for (int i = 1; i < n; i++) {
            int val = Integer.MAX_VALUE;
            for (int j = 0; j <size  ; j++) {
                val = Math.min(val,res[indexs[j]]* primes[j]);
            }

            for (int j = 0; j <size ; j++) {
                if(val == res[indexs[j]] * primes[j]) indexs[j]++;
            }
            res[i] = val;

        }
        return res[n-1];
    }
    public static void main(String[]args){
        List<String > ret = new ArrayList<>();
        ret.add("a");
        ret.add("b");
        List<String >ret2 = ret.subList(0,1) ;
        ret2.add("c");
        for(String s :ret){
            System.out.println(s);
        }
        for(String s :ret2){
            System.out.println(s);
        }
        System.out.println();
        LinkedList<String >  l = new LinkedList<>();
        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
        for(String s :l){
            System.out.println(s);
        }
        l.remove();
        for(String s :l){
            System.out.println(s);
        }
        l.addFirst("5");
        for(String s :l){
            System.out.println(s);
        }
        l.addLast("6");
        for(String s :l){
            System.out.println(s);
        }


        System.out.println();


        Hashtable<String, Integer> ht = new Hashtable<>();
        ht.put("1",1);
        ht.put("2",2);
        ht.put("1",3);
        Iterator it = ht.keySet().iterator();
        while(it.hasNext()){
            String k = (String) it.next();
            Integer val = ht.get(k);
            System.out.println(k+" "+ val.toString());
        }
        for(Map.Entry<String ,Integer> entry : ht.entrySet()){
            System.out.println(entry.getKey()+ entry.getValue());
        }

        System.out.println();
        HashMap<String ,Integer> hm = new HashMap<>();

        hm.put("1",1 );
        hm.put("2",2 );
        hm.put("1",3 );
        for(Map.Entry<String ,Integer> entry : hm.entrySet()){
            System.out.println(entry.getKey()+ entry.getValue());
        }




        Solution s = new Solution();
        int a[] = {2,3,5};
        System.out.println(s.nthSuperUglyNumber(10,a));
    }
}
