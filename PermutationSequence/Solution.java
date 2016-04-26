package PermutationSequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhensheng on 2016/1/13.
 */
public class Solution {
    public String getPermutation(int n, int k) {
        k--;
        List<Integer> ret = new ArrayList<>();
        for(int i= 1 ; i<= n ; i++ ){
            ret.add(i);
        }
        int num= 1 ;
        for(int i = 1 ; i <= n ; i++ ){
            num *= i ;
        }
        StringBuilder sb = new StringBuilder();

        //a/b=c ...r
        int c = 0 ;
        int r = 0 ;
        while(n>=1 ){
            num = num/n ;
            n--;

            c= k /num ;
            r = k%num ;
            sb.append(ret.get(c));
            ret.remove(c);
            k =r  ;


        }
        return sb.toString();
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.getPermutation(3,6));
    }

}
