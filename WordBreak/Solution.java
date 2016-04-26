package WordBreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhensheng on 2016/2/25.
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean cut[] = new boolean[s.length()];
        for (int i = 0; i <s.length() ; i++) {
            for (int j = 0; j <=i ; j++) {
                String temp = s.substring(j,i+1 );
                if(wordDict.contains(temp)){
                    if(j==0 ) cut[i] =true;
                    else if(cut[j-1]) cut[i] =true;
                }

            }

        }
        return cut[s.length()-1];
    }
    public static void main(String []args){
        Solution s= new Solution();
        Set<String> set= new HashSet<>();
        set.add("leet");
        set.add("code");
        System.out.println(s.wordBreak("leetcode",set));
    }
}
