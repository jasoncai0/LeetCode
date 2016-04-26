package BestTimeBuyandSellStockII;

/**
 * Created by zhensheng on 2016/2/23.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if( prices.length == 0 ) return 0 ;
        int total = 0 ;
        int profit =   0 ;
        int min = prices[0] ;
        for (int i = 0; i < prices.length-1 ; i++) {
            if(prices[i] - min > profit) {
                profit = prices[i] - min ;
            }
            if(min > prices[i]){
                min = prices[i] ;
            }
            if(prices[i ] > prices[i+1 ] ){
                // sell
                total += profit;
                profit = 0 ;
                min = prices[i];
            }

        }
        if(prices[prices.length-1 ] - min > profit ){
            profit= prices[prices.length-1 ] - min ;
        }
        total += profit ;
        return total ;

    }
    public static void main(String []args){
        Solution s = new Solution();
        int a[] = {1,2,3,4, 3, 4,5,5,4,7};
        System.out.println(s.maxProfit(a));
    }
}
