package WildcardMatching;

/**
 * Created by zhensheng on 2016/1/7.
 */
public class Solution {
    public boolean isMatch(String s, String p) {

        int lens = s.length();
        int lenp = p.length();
        boolean [] dp = new boolean[lens+1 ];
        int count = 0 ;
        for (int i = 0; i < lenp; i++) {
            if (p.charAt(i) == '*') count++;
        }
        if (count==0 && lens != lenp ) return false;
        else if (lenp - count > lens) return false;
        dp[0] =true;
        for(int i = 0 ;i< lens ;i++ ){
            dp[i+1 ] =false;
        }
        for (int i= 0 ; i< lenp ; i++ ){
            if(p.charAt(i) == '*'){
                for(int j = 0 ; j< lens; j++){
                    dp[j+1 ] = dp[j+1]|| dp[j];
                }
            }
            else {
                for(int j = lens-1 ; j>=0 ; j-- ){
                    dp[j+1 ] = (p.charAt(i) =='?' || p.charAt(i)== s.charAt(j))&& dp[j];
                }
                dp[0]=false;
            }
        }
        return dp[lens] ;
    }
    public static void main(String[] args){

        Solution s =new Solution();

        //int ret= s.InversePairs(array);
        System.out.println(s.isMatch("aab","c*a*b"));

    }
}
