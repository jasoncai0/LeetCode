package GroupAnagrams;

import java.util.*;

/**
 * Created by zhensheng on 2015/12/10.
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String> >  ret = new ArrayList<List<String> >();
        Map<String , List<String>> hm = new HashMap<String, List<String>>();
        for(String str : strs){
            char[] c= str.toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if(hm.containsKey(s)){
                hm.get(s).add(str);
                Collections.sort(hm.get(s));
            }
            else
            {
                List<String> ls = new ArrayList<String>();
                ls.add(str);
                hm.put(s,ls);
            }
        }
        hm.values();
        for(List<String > ls :hm.values()){
            ret.add(ls);
        }
        return ret;
    }

    public static void main(String[] args){
        Solution s= new Solution();

        String[] ls = {"ate","eat","att"};

        System.out.println(s.groupAnagrams(ls));
    }

}
