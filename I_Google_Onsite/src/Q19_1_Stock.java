
public class Q19_1_Stock {
	public int getMaxProfit(int[] prices, int money) {
		if(prices == null || prices.length <= 1 || money <= 0) {
			return 0;
		}
		
		int len = prices.length;
		int minPrice = prices[0];
		int maxProfit = 0;
		
		for(int i = 1; i < len; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			int num = money / minPrice;
			maxProfit = Math.max(maxProfit, num * (prices[i] - minPrice));
		}
		
		return maxProfit + money;
	}
	
	
	
	
	
	
	
	
	/************************** main function *******************************/
	
	public static void main(String[] args) {
		Q19_1_Stock t = new Q19_1_Stock();
		int[] prices = {5, 8, 12, 9, 3, 1};
		int money = 100;
		System.out.println(t.getMaxProfit(prices, money));
	}
}
