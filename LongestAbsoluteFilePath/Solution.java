package LongestAbsoluteFilePath;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by zhensheng on 2016/8/26.
 */
public class Solution {
    public int lengthLongestPath(String input) {
        String[] strs = input.split("\n");
        //System.out.println(Arrays.toString(strs));
        ArrayDeque<Integer> stk = new ArrayDeque<>();

        int max =0 ;
        for(String str: strs){
            int level=str.lastIndexOf("\t") +1;

            //System.out.println(level);
            while(stk.size() > level ){
                stk.pop();
            }
            //System.out.println(str.substring(index+2));
            int len = str.substring(level).length();
            if(stk.isEmpty()){
                stk.push(len);
            }else {
                stk.push(len+1 + stk.peek());
            }
            if(str.contains(".")){
                max= Math.max(max, stk.peek());
            }
        }



        return max ;

    }


    public int getlevel(String str){
        int level = 0 ;
        int i = 0 ;
        int len = str.length();
        while(i+1 <len){
            if(str.charAt(i) == '\\' && str.charAt(i+1) == 't'){
                level++;
                i+= 2 ;
            }
            else break;
        }
        return level;
    }
    public static void main(String[] args) {
        Solution s = new Solution();


       // System.out.println("\n\n\nsdsd".lastIndexOf("sd"));
        System.out.println(s.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}
