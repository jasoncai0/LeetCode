package UniquePathsII;

/**
 * Created by zhensheng on 2016/1/16.
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m==0 )return 0;
        int n = obstacleGrid[0].length;

        int[][] dp= new int[m][n];
        if(obstacleGrid[0][0] != 1 )dp[0][0] = 1 ;
        else dp[0][0] = 0;
        for( int i= 0 ; i< m ; i++ ){
            for (int j = 0 ;j< n ; j++ ){
                if(i> 0 && obstacleGrid[i-1][j]!=1 ){
                    dp[i][j]+= dp[i-1][j];
                }
                if(j>0 && obstacleGrid[i][j-1]!=1 ){
                    dp[i][j]+= dp[i][j-1];
                }
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }

            }
        }
        return dp[m-1][n-1];

    }
    public static void main(String[] args){

        Solution s =new Solution();

        //int ret= s.InversePairs(array);
        //int [][]a = {{0,0,0},{0,1,0},{0,0,0}};
        int [][]a = {{1}};
        System.out.println(s.uniquePathsWithObstacles(a));

    }

}
