package LongestCommonPrefix;

/**
 * Created by zhensheng on 2016/1/7.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0 ) return  "";
        StringBuilder sb =  new StringBuilder();
        boolean flag = true;
        for(int i = 0 ; ;i++) {
            flag = true ;
            for(int j= 0 ; j< len ; j++ ){
                if(strs[j].length() < i+1  ){
                    flag = false ;
                    break;
                }
                if(strs[j].charAt(i) != strs[0].charAt(i)){
                    flag =false ;
                    break;
                }
            }
            if(flag ) sb.append(strs[0].charAt(i));
            else break;
        }
        return sb.toString();
    }
    public static void main(String[] args){

        Solution s =new Solution();

        String[] a = {"abc" , "abca","abc"};

        System.out.println(s.longestCommonPrefix(a));
    }
}
