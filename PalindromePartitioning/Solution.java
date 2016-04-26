package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhensheng on 2016/2/25.
 */
public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String >> ret= new ArrayList<>();
        partition(ret, new ArrayList<String>() , s );
        return ret;
    }
    public void partition(List<List<String >> ret, List<String> cur, String s){
        if(s.length() == 0 ) {
            ret.add(new ArrayList<>(cur)) ;
            return;
        }

        for (int i = 1 ; i <=  s.length() ; i++) {
            String temp = s.substring(0 , i );
            if(isPalindrome(temp) ){
                cur.add(temp);
                partition(ret,cur, s.substring(i,s.length()));
                cur.remove(cur.size()-1);
            }

        }

    }
    public boolean isPalindrome(String s ) {
        int size =s.length();
        int half = (  size +1 )/2 ;
        if(size == 0 || size ==1 ) return true;
        for (int i = 0; i < half ; i++) {
            if(s.charAt(i) != s.charAt(size - 1- i )) return  false ;
        }
        return true;
    }

    public static  void main(String[]args){
        Solution s= new Solution();
        System.out.println(s.partition("aab"));
    }
}
