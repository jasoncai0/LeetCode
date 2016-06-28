package RussianDollEnvelopes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by zhensheng on 2016/6/26.
 */

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]- o2[0];
            }
        });

        int max = 0 ;
        int []dp = new int[envelopes.length];
        for(int i = 0 ; i < envelopes.length ;i++){
            dp[i] = 1 ;
            for (int j = 0; j < i; j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i]= Math.max(dp[i] ,dp[j]+1 );
                }
            }
            max = Math.max(dp[i],max);

        }
        return max ;
    }
    public static  void main(String[] args ){
        Solution s = new Solution() ;
        int a[][] = {{5,4} ,{ 6,4 },{ 6,7 } , { 2,3 }};
        System.out.println(s.maxEnvelopes(a));
    }
}
