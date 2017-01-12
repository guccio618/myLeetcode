
public class Q150_Best_Time_to_Buy_and_Sell_Stock_II {
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
        	return 0;
        }
        int profit = 0;
        for(int i = 0; i < prices.length-1; i++){
            if(prices[i] < prices[i+1]){ 
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }
}
