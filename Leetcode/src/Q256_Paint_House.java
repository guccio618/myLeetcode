/*****
 * 
There are a row of n houses, each house can be painted with one of the three colors: 
red, blue or green. The cost of painting each house with a certain color is different. 
You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color red; 
costs[1][2] is the cost of painting house 1 with color green, and so on... 
Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

 * 
 * */


public class Q256_Paint_House {
	// solution 2: improve space, time O(n), space(1)
	public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        int len = costs.length;
        int[][] dp = new int[len][3];
        
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        
        return Math.min(dp[len - 1][0], Math.min(dp[len - 1][1], dp[len - 1][2]));
    }
	
	
	
	
	// solution 2: improve space, time O(n), space(1)
	public int minCost2(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        
        int n = costs.length;
        int preRed = costs[0][0];
        int preBlue = costs[0][1];
        int preGreen = costs[0][2];
        int curRed = preRed;
        int curBlue = preBlue;
        int curGreen = preGreen;
        
        for(int i = 1; i < n; i++){
            curRed = Math.min(preBlue, preGreen) + costs[i][0];
            curBlue = Math.min(preRed, preGreen) + costs[i][1];
            curGreen = Math.min(preRed, preBlue) + costs[i][2];
            preRed = curRed;
            preBlue = curBlue;
            preGreen = curGreen;
        }
        
        return Math.min(curRed, Math.min(curBlue, curGreen));
    }
}
