package Majiang;

import java.util.*;

/**
 * Created by zhensheng on 2016/3/31.
 */
public class Solution {
    /*
    public List<Integer> hupai(int [] pai){
        Map<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < pai.length; i++) {
            if(hm.containsKey(pai[i])){
                hm.put(pai[i] , hm.get(pai[i]+1));

            }
            else {
                hm.put(pai[i] , 1 );
            }
        }
        List<Integer> ret = new ArrayList<>();
        dfs(ret, hm);
        return ret;
    }
    public void dfs(List<Integer> ret, Map<Integer, Integer> hm){
        Iterator it = hm.entrySet().iterator();
        int count = 0 ;
        //Iterator itv = hm.values().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Integer>  entry= (Map.Entry<Integer, Integer>) it.next();
            if(entry.getValue() >0 ){
                count += entry.getValue();
            }else if(entry.getValue() == 0 ) {
                it.remove();
            }else {
                return;
            }
        }
        Iterator itk= hm.keySet().iterator();
        if(count ==1){
            ret.add((Integer) itk.next());
            return ;
        }
        //itv= hm.values().iterator();
        else if(count == 4 ){

            if(hm.size() == 1){
                return;
            }else if(hm.size()==4){

            }else {


            int a[] = new int [2]  ;
            int index =0 ;
            if(hm.size()== 2 ){
                it= hm.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry<Integer,Integer>  entry= (Map.Entry<Integer, Integer>) it.next();
                    if(entry.getValue() ==2) {
                        a[index ]  =entry.getKey();
                        index++ ;
                    }

                }
                if(a[0] != 0  && a[1] != 0 )
                ret.add(a[0]);
                ret.add(a[1]);
                return;
            }
            index =0 ;
            Arrays.fill(a, 0 );
            boolean flag = false ;
            it= hm.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<Integer,Integer>  entry= (Map.Entry<Integer, Integer>) it.next();
                if(entry.getValue() ==1 ) {
                    a[index ]  =entry.getKey();
                    index++ ;
                }
                if(entry.getValue() ==2 ){
                    flag = true;
                }
            }int c = 0 ;
            if(flag){
                int dif = Math.abs(a[0] - a[1] );
                if(dif ==1 ){
                    c = Math.min(a[0] , a[1])-1;
                    if(c> 0 )
                    {
                        ret.add(c);
                    }
                    c= Math.max(a[0],a[1])+1 ;
                    if (c <= 9) {
                        ret.add(c);
                    }
                    return;
                 }
                else if(dif ==2 ) {
                    ret.add((a[0]+a[1])/2  );
                }
            }}

        }
        it= hm.entrySet().iterator();
        while(it.hasNext()){

            Map.Entry<Integer,Integer>  entry= (Map.Entry<Integer, Integer>) it.next();
            if(entry.getValue()>= 0 ) {
                count += entry.getValue() ;
            }
            if(entry.getValue() >= 3 ) {
                entry.setValue(entry.getValue()-3 );
                dfs(ret, hm);
                entry.setValue(entry.getValue()+3 ) ;
            }
            if(entry.getValue()>0 ){
                if(hm.containsKey(entry.getKey() +1 ) && hm.containsKey(entry.getKey() +2 ) ){
                    entry.setValue(entry.getValue()-1);
                    hm.put(entry.getKey() +1 , hm.get(entry.getKey() +1) -1 );
                    hm.put(entry.getKey() +2 , hm.get(entry.getKey() +2) -1 );
                    dfs(ret, hm) ;
                    entry.setValue(entry.getValue()+1);
                   // hm.put(hm.containsKey(entry.getKey()) ? entry.getKey() +1 , hm.get(entry.getKey() +1) +1 );
                    //hm.put(entry.getKey() +2 , hm.get(entry.getKey() +2) +1 );
                }

            }else if(entry.getValue() ==0 ){
                it.remove();
            }
            else if(entry.getValue() < 0 ){
                return;
            }

        }

    }*/
    public List<Integer> hupai(int[] pai) {
        //int p [] = new int[9];
        int nums[] = new int[9];
        for (int i = 0; i < pai.length; i++) {
            nums[pai[i] - 1]++;
        }
        for (int i = 0; i < 9; i++) {
            if (nums[i] == 0) {

            }
        }
        return null;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
        Integer an[]= new Integer[4] ;
        int a[] = {1, 2, 3, 4};
        List<Integer> ret = s.hupai(a);
        ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(an));
        LinkedHashMap linkedHashMap;
        TreeMap tm;
        Queue<Integer> q= new LinkedList<>();
        Stack stack = new Stack();

        ret.forEach(System.out::println);
    }


}
