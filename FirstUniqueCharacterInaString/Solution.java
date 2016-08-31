package FirstUniqueCharacterInaString;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

/**
 * Created by zhensheng on 2016/8/25.
 */
public class Solution {

    public int firstUniqChar(String s) {

        Map<Character,Integer> hm = new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            if(hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i) , -1);
            }else {
                hm.put(s.charAt(i) , i);
            }
        }
        //if(hm.size() == 0 ) return -1 ;
        List<Integer> l= new ArrayList<>();
        for(Integer i : hm.values()){
            if(i>=0){
                l.add(i);
            }
        }
        if(l.size()==0 ) return -1 ;
        Collections.sort(l);
        return l.get(0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstUniqChar("loveleetcode"));
    }

}
