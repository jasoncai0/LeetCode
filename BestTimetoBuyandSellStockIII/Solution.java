package BestTimetoBuyandSellStockIII;

/**
 * Created by zhensheng on 2016/2/23.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;
        for (int price : prices) {
            if(firstBuy< - price ) firstBuy = - price;
            if(firstSell < price + firstBuy  ) firstSell = price + firstBuy;
            if(secondBuy < firstSell - price )  secondBuy = firstSell - price;
            if(secondSell< secondBuy + price ) secondSell = secondBuy + price;

        }
        return  secondSell;
    }
    public static void main(String []args){
        Solution s = new Solution();
        int a[] = {1};
        System.out.println(s.maxProfit(a));
    }
}
