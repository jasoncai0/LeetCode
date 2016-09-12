package DecodeString;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by zhensheng on 2016/9/7.
 */
public class Solution {
    public String decodeString(String s) {
        Deque<Integer> stack= new ArrayDeque<>();
        Deque<Integer> mutip = new ArrayDeque<>();
        Deque<String> resStack = new ArrayDeque<>();
        //int mutip =0 ;
        String subStr;
        int begin= 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <  s.length(); i++) {
            if(s.charAt(i) -'0' >=0 && s.charAt(i)-'0'<=9 ){
                begin = i;
                while(s.charAt(i) -'0' >=0 && s.charAt(i)-'0'<=9 ) {
                    i++;
                }
                System.out.println(s.substring(begin,i));
                mutip.offer(Integer.valueOf(s.substring(begin,i)));
            }

            if(s.charAt(i) == '['){
                stack.offer(i);
                resStack.offer(sb.toString());
                sb = new StringBuilder();
            }
            else if(s.charAt(i)== ']'){
                StringBuilder temp = new StringBuilder(resStack.poll());
                int index = stack.poll();
                subStr= decodeString(s.substring(index,i));
                int num= mutip.poll();
                for (int j = 0; j < num; j++) {
                    sb.append(temp);
                }

            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.decodeString("3[a2[c]]"));
        //System.out.println(s.decodeString("2[abc]3[cd]ef"));
    }

}
