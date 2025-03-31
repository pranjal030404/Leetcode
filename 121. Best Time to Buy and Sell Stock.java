//  You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0

class Solution {
    public int maxProfit(int prices[]) {
        if (prices == null || prices.length < 2)
            return 0;

        int maxProfit = 0, bestBuy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - bestBuy);
            bestBuy = Math.min(bestBuy, prices[i]);
        }

        return maxProfit;
    }
}