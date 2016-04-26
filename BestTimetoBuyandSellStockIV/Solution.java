package BestTimetoBuyandSellStockIV;

import java.util.Arrays;

/**
 * Created by zhensheng on 2016/2/24.
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k == 0  ) return 0 ;
        if(prices.length ==0 ) return 0 ;
        if( k > prices.length/2 ){
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
        int []buys = new int[k] ;
        int []sells = new int [k];
        Arrays.fill(buys, Integer.MIN_VALUE);
        Arrays.fill(sells,0 ) ;

        for ( int price : prices){
            if( buys[0] < - price) buys[0] = -price;
            if(sells[0] < buys[0] + price) sells[0] = buys[0] + price;
            for(int i = 1 ; i < k ; i ++ ){
                if(buys[i]< sells[i-1] - price ) buys[i] = sells[i-1]- price;
                if(sells[i] < buys[i] + price ) sells[i] = buys[i] + price;
            }
        }
        return  sells[k-1] ;
    }
    public static void main(String []args){
        Solution s = new Solution();
        int a[] = {};
        System.out.println(s.maxProfit(2,a));
    }
}
