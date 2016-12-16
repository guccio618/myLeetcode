/*******
 * 
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
 * 
 * */


public class Le_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
	// solution 1: using DP, time O(n), space O(n)
	public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int len = prices.length;
        int[] buy = new int[len];     // 当天持股时的最大获利
        buy[0] = -prices[0];
        buy[1] = Math.max(-prices[0], -prices[1]);
        int[] sell = new int[len];    // 当天不持股时的最大获利
        sell[0] = 0;
        sell[1] = Math.max(0, prices[1] - prices[0]);
        
        for(int i = 2; i < len; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        
        return sell[len-1];
    }
	
	
	
	// solution 2: follow up, improve space, using DP, time O(n), space O(1)
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int len = prices.length;
        int preOneDayBuy = Math.max(-prices[0], -prices[1]);
        int preTwoDaySell = 0;
        int preOneDaySell = Math.max(0, prices[1] - prices[0]);
        int curBuy = preOneDayBuy;
        int curSell = preOneDaySell;
        
        for (int i = 2; i < len; i++) {
            curBuy = Math.max(preOneDayBuy, preTwoDaySell - prices[i]);
            curSell = Math.max(preOneDaySell, preOneDayBuy + prices[i]);
            preTwoDaySell = preOneDaySell;
            preOneDayBuy = curBuy;
            preOneDaySell = curSell;
        }
        
        return curSell;
    }
}
