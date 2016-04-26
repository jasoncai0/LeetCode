package RemoveDuplicateLetters;

import java.util.Stack;

/**
 * Created by zhensheng on 2015/12/29.
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        char [] ch = s.toCharArray();
        int [] times = new int[26];
        boolean[] visited = new boolean[26];

        for(char c : ch ){
            times[c-'a']++;
        }
        Stack<Character> st = new Stack<>();

        for(char c : ch ){
            int index = c- 'a';
            times[index]--;
            if(visited[index])
                continue;
            while(!st.isEmpty()&& c < st.peek() && times[st.peek()-'a'] != 0 ){
                visited[st.peek()-'a'] =false ;
                st.pop();

            }
            st.push(c );
            visited[index] =true;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0, st.peek());
            st.pop();

        }
        return sb.toString();
    }
    public static void main(String[] args){

        Solution s =new Solution();

        //int ret= s.InversePairs(array);
        System.out.println(s.removeDuplicateLetters("bcabc"));

    }
}
