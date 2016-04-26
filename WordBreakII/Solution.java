package WordBreakII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhensheng on 2016/2/25.
 */
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String > ret= new ArrayList<>();
        if(isWordBreak(s,wordDict)){
            wordBreak(ret,"",s,wordDict);
            return ret;
        }
        else return ret;
    }
    public static void wordBreak(List<String > ret, String cur , String left , Set<String>wordDict){
        if(left.length()== 0 ) ret.add(cur);
        boolean flag = false ;
        for (int i = 1; i <=left.length() ; i++) {
            String temp = left.substring(0,i);
            if(wordDict.contains(temp)){
                flag =true;
                if(cur.length()== 0 ) {
                    wordBreak(ret,temp , left.substring(i,left.length()) ,wordDict);
                }
                else wordBreak(ret,cur+" "+ temp , left.substring(i,left.length()) ,wordDict);
            }
        }
        if(flag ==false ) return ;

    }
    public boolean isWordBreak(String s, Set<String> wordDict) {
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
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        System.out.println(s.wordBreak("catsanddog",set));
    }
}
