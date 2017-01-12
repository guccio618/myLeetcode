
public class Q151_Best_Time_to_Buy_and_Sell_Stock_III {
	/*****************************************************************************************************************
	 * 序列型动态规划
	 * 		state:     left[i]表示从左往右，截止到当前i天时最大的获利； 
	 * 			       right[i]表示从右往左，截止到当前i天时最大的获利；
	 * 		function:  left[i] = Math.max(left[i-1], prices[i] - min), 其中min表示到从0到第i天，股票的最低的价格
	 * 				   right[i] = Math.max(right[i+1], max - prices[i]), 其中max表示到从最后一天到第i天，股票的最高的价格
	 * 		initial:   left[0] = 0, right[prices.length - 1] = 0;  
	 * 		answer:    Math.max(maxProfit, left[i] + right[i]);
	 *****************************************************************************************************************/
	
	// by Jackie
	public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }
        int len = prices.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = prices[0];
        int maxPrice = prices[len-1];
        left[0] = 0;
        right[len-1] = 0;
        
        for(int i = 1; i < len; ++i){
            minPrice = Math.min(minPrice, prices[i]);
            left[i] = Math.max(left[i-1], prices[i] - minPrice);
        }
        for(int i = len-2; i >= 0; --i){
            maxPrice = Math.max(maxPrice, prices[i]);
            right[i] = Math.max(right[i+1], maxPrice - prices[i]);
        }
        for(int i = 1; i < len; ++i){
            maxProfit = Math.max(maxProfit, (left[i] + right[i]));
        }
        return maxProfit;
    }
}
