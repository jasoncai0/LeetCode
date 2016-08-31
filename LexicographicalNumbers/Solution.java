package LexicographicalNumbers;

import PipeTest.Input;

import java.util.*;

/**
 * Created by zhensheng on 2016/8/25.
 */
public class Solution {
    public List<Integer> lexicalOrder(int n) {

        List<Integer> arr = new ArrayList<>();


        /*
        for (int i = 0; i < n ; i++) {
            arr.add(i+1);
        }
        Collections.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = String.valueOf(o1);
                String str2 = String.valueOf(o2);
                return str1.compareTo(str2);
            }
        });
        //System.out.println(arr);
        */

        for (int i = 1; i <10 ; i++) {
            dfs(arr,i, n);

        }

        return arr;
    }
    public void dfs(List<Integer> arr , int  cur, int n ){
        if(cur>n){
            return;
        }
        else {

            arr.add(cur);
            for (int i = 0; i <10 ; i++) {
                if(cur*10+i >n){
                    return;
                }
                dfs(arr,cur*10 +i ,n);

            }
        }

    }

    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.lexicalOrder(13));
    }
}
