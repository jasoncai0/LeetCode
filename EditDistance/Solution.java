package EditDistance;

/**
 * Created by zhensheng on 2016/1/17.
 */
public class Solution {
    /*思考方向：
    字符串匹配
    动态规划
     */

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int [][]dp = new int[len1+1][len2+1 ];
        for (int i = 0; i <= len1  ; i++) {
            dp[i][0] =i ;

        }
        for (int i = 0; i <=len2 ; i++) {
            dp[0][i] = i  ;
        }
        for (int i = 1; i <=len1  ; i++) {
            for (int j = 1; j <=len2 ; j++) {
                char ch1 = word1.charAt(i-1);
                char ch2 = word2.charAt(j-1);

                if(ch1 == ch2 ){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1] ,Math.min(dp[i-1][j] , dp [i][j-1]))+1 ;
                }

            }

        }
        return dp[len1][len2];
    }
    public static void main(String[] args){

        Solution s =new Solution();

        //int ret= s.InversePairs(array);
        System.out.println(s.minDistance("aaa","a*"));

    }
}
