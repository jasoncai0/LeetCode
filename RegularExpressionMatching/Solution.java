package RegularExpressionMatching;

/**
 * Created by zhensheng on 2015/11/16.
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        boolean [][]dp = new boolean[lens+1][lenp+1];
        dp[0][0] = true ;
        for(int i = 0 ; i<= lens ; i++ ){
            for(int j = 1 ; j<= lenp; j++ ){
                char ch = p.charAt(j-1);
                if(ch == '*'){
                    dp[i][j]= (j>=2 &&dp[i][j-2])||(i>=1 && j >=1 &&dp[i-1][j]&&(p.charAt(j-2) ==s.charAt(i-1)|| p.charAt(j-2) =='.')) ;
                }
                else {
                    dp[i][j]=(i>0 && dp[i-1][j-1] && (ch =='.'|| ch == s.charAt(i-1)));
                }
            }
        }
        return dp[lens][lenp];
    }
    public static void main(String[] args){

        Solution s =new Solution();

        //int ret= s.InversePairs(array);
        System.out.println(s.isMatch("aa","a*"));

    }
}
