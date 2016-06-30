package ExcelSheetColumnNumber;

/**
 * Created by zhensheng on 2016/6/29.
 */
public class Solution {
    public int titleToNumber(String s) {
        char [] chs = s.toCharArray();
        int sum  = 0 ;
        for(char ch : chs){
            sum*= 26;
            sum += (ch- 'A') +1 ;
        }
        return  sum ;

    }
    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.titleToNumber("AA"));
        System.out.println(s.titleToNumber("Z"));
    }
}
