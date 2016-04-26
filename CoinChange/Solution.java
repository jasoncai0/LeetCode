package CoinChange;

/**
 * Created by zhensheng on 2015/12/29.
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        if(coins ==null && coins.length == 0 )return -1 ;

        int []changes  = new int[amount+1];
        for(int i = 0 ; i<= amount; i++ ){
            changes[i] = Integer.MAX_VALUE;
        }
        changes[0]=  0 ;
        for(int i = 1 ; i <= amount ;i++){
            for(int j = 0 ; j < coins.length; j++){
                int temp = i - coins[j];
                if(temp>=0 && changes[temp]!= Integer.MAX_VALUE){
                    changes[i] =Math.min (changes[temp]+1 , changes[i]) ;

                }
            }
        }
        if(changes[amount] == Integer.MAX_VALUE) return -1 ;
        else return changes[amount];
    }
    public static void main(String[]args){
        Solution s =new Solution();
        int a[] = {2};
        System.out.println(s.coinChange(a,5));
    }
}
