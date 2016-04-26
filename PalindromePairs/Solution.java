package PalindromePairs;

import java.util.*;

/**
 * Created by zhensheng on 2016/3/23.
 */
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String , Integer> hm = new HashMap<>();
        for (int i = 0; i < words.length ; i++) {
            hm.put(words[i], i);
        }
        Set<List<Integer>> ret= new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            for(int j = 0 ; j<= words[i].length() ; j++ ){
                String pre= words[i].substring(0 , j ) ;
                String after = words[i].substring(j);
                if(isPalindrome(pre)){
                    String afreverse = new StringBuffer(after).reverse().toString();
                    if(hm.containsKey(afreverse) && hm.get(afreverse)!= i){
                        ret.add(Arrays.asList(hm.get(afreverse),i));
                    }
                }
                if(isPalindrome(after)){
                    String prereverse= new StringBuilder(pre).reverse().toString();
                    if(hm.containsKey(prereverse) && hm.get(prereverse)!= i ) ret.add(Arrays.asList(i,hm.get(prereverse)));
                }
            }

        }

        return new ArrayList<>(ret);
    }

    public boolean isPalindrome(String s){
        int len =s.length();
        for (int i = 0; i <len/2  ; i++) {
            if(s.charAt(i) != s.charAt(len-1 - i)) return false ;
        }
        return true;
    }

    public static void main(String args[])  {


    }
}
