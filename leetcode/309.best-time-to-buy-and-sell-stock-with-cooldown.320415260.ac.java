/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 *
 * algorithms
 * Medium (47.92%)
 * Total Accepted:    175.5K
 * Total Submissions: 366.3K
 * Testcase Example:  '[1,2,3,0,2]'
 *
 * Say you have an array for which the i^th element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * 
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1
 * day)
 * 
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3,0,2]
 * Output: 3 
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * 
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1)
            return 0;
        int n = prices.length;
        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];
        hold[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            rest[i] = sold[i-1];
            sold[i] = Math.max(sold[i-1], hold[i-1] + prices[i]);
            hold[i] = Math.max(hold[i-1], rest[i-1] - prices[i]);
        }
        return sold[n-1];
    }
}
