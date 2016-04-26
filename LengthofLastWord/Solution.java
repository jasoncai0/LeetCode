package LengthofLastWord;
import java.util.*;
/**
 * Created by zhensheng on 2015/11/16.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        int len = strs.length;
        if (len== 0 ) return 0 ;
        return strs[len-1].length();
    }
    public static void main(String[] args){

        Solution s =new Solution();

        //int ret= s.InversePairs(array);
        System.out.println(s.lengthOfLastWord(""));
    }

}
