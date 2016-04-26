package WordLadder;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by zhensheng on 2016/2/24.
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        //char[] begin = beginWord.toCharArray();
        char[] end = endWord.toCharArray();
        Queue<String > q = new LinkedList<>();
        q.add(beginWord);
        int count =1    ;
        wordList.add(endWord) ;
        while(!q.isEmpty()){
            count ++ ;
            int size = q.size();
            for (int i = 0; i <size  ; i++) {
                String curString = q.poll();
                char[] cur = curString.toCharArray();
                for (int j = 0; j <cur.length ; j++) {
                    char temp = cur[j];
                    for(int k =  0 ; k < 26 ; k++){
                        cur[j] = (char)( 'a' + k ) ;
                        String changed = new String(cur);
                        if(endWord.equals(changed)) {
                            return count ;
                        }
                        if(wordList.contains(changed)){
                            q.add(changed);
                            wordList.remove(changed);
                        }
                        cur[j] = temp;
                    }

                }

                /*
                boolean same = true ;
                for (int j = 0; j <cur.length ; j++) {

                    if(cur[j] != end[j]) same = false;

                }
                if (same ) return count ;
                for(String word : wordList){
                    int dif= 0 ;
                    char [] w =word.toCharArray();
                    for (int j = 0; j < w.length ; j++) {
                        if(w[j]!= cur[j]) dif++;
                    }
                    //if(dif ==0 ) return count;
                    if(dif ==1 ) q.add(word);
                }*/
            }
        }
        //bfs(beginWord ,endWord)
        return 0;
    }
    public static void bfs(String curWord, String endWord , Set<String>wordList, int length ){

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
        System.out.println(s.ladderLength("hit", "cog", set ));





    }
}
