/*****
 * 
Given n items with size Ai and value Vi, and a backpack with size m. 
What's the maximum value can you put into the backpack?

Example
	Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], 
	and a backpack with size 10. The maximum value is 9.
	
 * 
 * */


public class Li_125_Backpack_II {
	/************************************************************************
	 * 此题为92的follow up
	 * 
	 * Statement:  dp[i][j]: 前i个item, 填满j体积的背包，可以获得的最大价值
	 * Function:   dp[i][j] = dp[i - 1][j] || dp[i - 1][j - item[i]]
	 * 			   也许前i - 1个item已经将j体积的背包填满。
	 * Initial:    dp[i][0] = true;
	 * Answer:     寻找为true时的最大capacity
	 *  
	 ************************************************************************/
	
	public int backPackII(int capacity, int[] size, int[] value) {
        if(capacity <= 0 || size == null || size.length == 0 || value == null || value.length == 0 || size.length != value.length){
            return 0;
        }
        
        int len = size.length;
        int[][] dp = new int[2][capacity + 1];
        
        for(int i = 1; i <= len; ++i){
            for(int j = 1; j <= capacity; ++j){
                dp[i % 2][j] = dp[(i - 1) % 2][j];
                if(j - size[i - 1] >= 0){    // 时时update dp[i][j]的值
                    dp[i % 2][j] = Math.max(dp[i % 2][j], dp[(i - 1) % 2][j - size[i - 1]] + value[i - 1]);
                }
            }
        }
        
        return dp[len % 2][capacity];
	}
}
