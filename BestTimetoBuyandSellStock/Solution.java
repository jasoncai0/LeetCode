package BestTimetoBuyandSellStock;

/**
 * Created by zhensheng on 2016/2/23.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 ) return 0 ;
        int max = 0 ;
        int min = prices[0];
        for (int i = 0; i < prices.length ; i++) {
            if(prices[i] - min  > max ){
                max = prices[i] - min ;
            }
            if(prices[i] < min ){
                min = prices[i];
            }

        }
        return  max ;
    }
    public static void main(String []args){
        Solution s = new Solution();
        int a[] = {1,2,3,4};
        System.out.println(s.maxProfit(a));
    }
}
