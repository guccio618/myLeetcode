
public class Lecture7_Array_Number_04_Best_Time_to_Buy_and_Sell_Stock {
	public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        int len = prices.length;
        int maxProfit = Integer.MIN_VALUE;
        int minPrice = prices[0];
        
        for(int i = 1; i < len; ++i){
            maxProfit = Math.max(maxProfit, Math.max(0, prices[i] - minPrice));
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
