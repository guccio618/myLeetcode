
public class Lecture7_Array_Number_06_Best_Time_to_Buy_and_Sell_Stock_III {
	public int maxProfit(int[] prices) {
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
