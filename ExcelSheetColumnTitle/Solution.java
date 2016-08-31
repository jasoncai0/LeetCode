package ExcelSheetColumnTitle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhensheng on 2016/6/29.
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while(n>0 ){
            n--;
            char ch = (char)('A'+ (n%26) );
            sb.insert(0,ch);
            n = n/26;


        }
        
        return sb.toString();

    }
    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.convertToTitle(27));
        System.out.println(s.convertToTitle(26));
        System.out.println(s.convertToTitle(25));
    }
}
