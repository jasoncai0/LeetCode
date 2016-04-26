package MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhensheng on 2016/1/21.
 */
public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int lens= s.length();
        int lent = t.length();
        for (Character ch:t.toCharArray()) {
            map.put(ch,map.getOrDefault(ch,0) +1 ) ;
        }
        int start = 0 ;
        int end = 0 ;
        int left = t.length();
        int min= Integer.MAX_VALUE;
        int minstart = 0 ;
        for (int i = 0; i < lens ; i++) {
            end = i ;
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1 );
                if(map.get(ch) >= 0 ){
                    left--;
                }
                while(left == 0 ) {
                    if(end -start +1 < min){
                        min=end-start + 1;
                        minstart = start ;
                    }
                    char ch2= s.charAt(start );
                    if(map.containsKey(ch2)){
                        map.put(ch2,map.get(ch2)+1);
                        if(map.get(ch2)>0)
                            left++;
                    }
                    start++;
                }
            }
        }
        if(min> s.length()) return "";
        return s.substring(minstart,minstart+min);


    }
    public static void main(String []args){
        Solution s = new Solution();
        System.out.println(s.minWindow("ADOBECODEBANC","ABC"));
    }

}
