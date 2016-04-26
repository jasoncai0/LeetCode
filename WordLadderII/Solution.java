package WordLadderII;

import java.util.*;

/**
 * Created by zhensheng on 2016/2/24.
 */
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        char[] end = endWord.toCharArray();
        Queue<String > q = new LinkedList<>();
        q.add(beginWord);
        List<List<String >> ret= new ArrayList<>();
        List<String > curList = new ArrayList<>();

        wordList.add(endWord) ;
        helper(ret, curList , beginWord  , endWord , wordList , q );
        /*
        while(!q.isEmpty()){
            if (!ret.isEmpty())   break;
            int size = q.size();

            for (int i = 0; i <size  ; i++) {
                String curString = q.poll();
                curList.add(curString);
                char[] cur = curString.toCharArray();

                for (int j = 0; j < cur.length; j++) {
                    char temp = cur[j];
                    for (int k = 0; k < 26; k++) {
                        cur[j] = (char) ('a' + k);

                        String changed = new String(cur);
                        if (endWord.equals(changed)) {
                            curList.add(changed);
                            ret.add(new ArrayList<>(curList));
                            curList.remove(changed ) ;
                            //return count ;
                        }
                        if (wordList.contains(changed)) {
                            q.add(changed);
                            curList.add(changed);
                            wordList.remove(changed);
                        }
                        cur[j] = temp;
                    }
                }
                //curList.remove(curString) ;
                // 这里不能直接这样考虑， hit -> hot ->( dot , lot ) -> (dog , log )-> cog  一旦remove  则将hot删掉了
                //可以采用递归

            }
        }
        */
        return  ret;
    }

    public static void helper( List<List<String >> ret , List<String> curList , String curWord, String endWord , Set<String> wordList , Queue<String>q){
        curList.add(curWord);
        while (!q.isEmpty()){
            if (!ret.isEmpty())  return ;
            int size = q.size() ;

            for (int i = 0; i <size  ; i++) {
                String curString = q.poll();
                curList.add(curString);
                char[] cur = curString.toCharArray();

                for (int j = 0; j < cur.length; j++) {
                    char temp = cur[j];
                    for (int k = 0; k < 26; k++) {
                        cur[j] = (char) ('a' + k);

                        String changed = new String(cur);
                        if (endWord.equals(changed)) {
                            curList.add(changed);
                            ret.add(new ArrayList<>(curList));
                            curList.remove(changed ) ;
                            //return count ;
                        }
                        if (wordList.contains(changed)) {
                            q.add(changed);
                            curList.add(changed);
                            wordList.remove(changed);
                        }
                        cur[j] = temp;
                    }
                }

            }
        }

    }
    public static void main(String []args){
        /*
        String s = "abc";
        String b = s ;
        b= b.substring(0,2);
        System.out.println(s);
        System.out.println(b); */
        Solution s = new Solution();
        Set<String> set= new HashSet<>();
        set.add("hot");
        set.add("dot");
        set.add("dog");
        set.add("lot");
        set.add("log");
        System.out.println(s.findLadders("hit", "cog", set ));
    }
}
