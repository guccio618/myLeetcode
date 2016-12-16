public class Q188_Best_Time_to_Buy_and_Sell_Stock_IV {
	/******************************************************/
	// by ninechapter using DP, O(nk) with O(n^2) space
	public int maxProfit(int k, int[] prices) {
		if(prices == null || prices.length == 0){
            return 0;
        } else if(k >= prices.length / 2){
            int profit = 0;
            
            for(int i = 0; i < prices.length - 1; i++){
                if(prices[i] < prices[i + 1]){
                    profit += prices[i + 1] - prices[i];
                }
            }
            
            return profit;
        }
        
        int len = prices.length;
        int[][] global = new int[len][k + 1];         // mustSell[i][j]: 表示总交易次数为j截止到第i天并且在最后一天要做交易的情况下的最大获益
        int[][] mustSell = new int[len][k + 1];       // globalbest[i][j]: 表示总交易次数为j截止到第i天的最大获益;可以不sell
        
        for (int i = 0; i <= k; i++) {
			mustSell[0][i] = global[0][i] = 0;
		}
        
        for(int i = 1; i < len; i++){
            int gainOrLose = prices[i] - prices[i - 1];
            
            for(int j = 1; j <= k; j++){
                mustSell[i][j] = Math.max(mustSell[i - 1][j], global[i - 1][j - 1]) + gainOrLose;
                global[i][j] = Math.max(global[i - 1][j], mustSell[i][j]);
            }
        }
        
        return global[len - 1][k];
	}
	
	
	/******************************************************/
	// by other using DP, O(nk) with space O(n)
	public int maxProfit2(int k, int[] prices) {
		if (k >= prices.length / 2) {
			int maxProfit = 0;
			for (int i = 1; i < prices.length; i++) {
				if (prices[i] > prices[i - 1])
					maxProfit += prices[i] - prices[i - 1];
			}
			return maxProfit;
		}

		int[] maxProfit = new int[k + 1];    // 记录第i次操作的最大收益
		int[] lowPrice = new int[k + 1];     // 记录第i次操作前买入的最低花销
		for (int i = 0; i < lowPrice.length; i++)
			lowPrice[i] = Integer.MAX_VALUE;
		for (int p : prices) {
			for (int i = k; i >= 1; i--) {
				maxProfit[i] = Math.max(maxProfit[i], p - lowPrice[i]);  // p表示当天卖出的钱
				lowPrice[i] = Math.min(lowPrice[i], p - maxProfit[i - 1]);
			}
		}
		return maxProfit[k];
	}
	
	
	public static void main(String[] args){
		Q188_Best_Time_to_Buy_and_Sell_Stock_IV t = new Q188_Best_Time_to_Buy_and_Sell_Stock_IV();
		int[] prices = {6,1,3,2,4,7,6,5,9,12,2};
		System.out.println(t.maxProfit(4, prices));	
//		System.out.println(t.maxProfit2(2, prices));		
	}
}
