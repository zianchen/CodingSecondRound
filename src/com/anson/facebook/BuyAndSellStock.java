package com.anson.facebook;

/**
 * Created by chenzian on 8/19/16.
 */
public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] input = {7, 6, 4, 3, 1};
        BuyAndSellStock buyAndSellStock = new BuyAndSellStock();
        System.out.println(buyAndSellStock.maxProfit(input));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
}
