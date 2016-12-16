/******
 * 
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example 1:
	Input: [7, 1, 5, 3, 6, 4]
	Output: 5
	max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

Example 2:
	Input: [7, 6, 4, 3, 1]
	Output: 0
	In this case, no transaction is done, i.e. max profit = 0.

 * 
 * */


public class Q121_Best_Time_to_Buy_and_Sell_Stock {
	// solution 1: time O(n), space O(n)
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        
        int len = prices.length;
        int[] minPrices = new int[len];
        minPrices[0] = prices[0];
        int maxProfit = 0;
        
        for(int i = 1; i < len; i++) {
            minPrices[i] = Math.min(minPrices[i-1], prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrices[i]);
        }
        
        return maxProfit;
    }
    
	
	
	
	
	// solution 2: using only one variable, time O(n), space O(1)
    public int maxProfit2(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        
        int len = prices.length;
        int curMinPrice = prices[0];
        int maxProfit = 0;
        
        for(int i = 1; i < len; i++) {
            curMinPrice = Math.min(curMinPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - curMinPrice);
        }
        
        return maxProfit;
    }
}
