
/*****
 * 
Given n distinct positive integers, integer k (k <= n) and a number target.

Find k numbers where sum is target. Calculate how many solutions there are?

Example
Given [1,2,3,4], k = 2, target = 5.

There are 2 solutions: [1,4] and [2,3].

Return 2.

 * 
 * */

public class Li_089_k_Sum {
	/************************************************************************
	 * 此题可以看成背包问题的follow up
	 * 可以进行空间优化
	 *  
	 ************************************************************************/
	// solution 1: time O(n^3), space O(n^3)
	public int  kSum(int A[], int k, int target) {
        int n = A.length;
        int[][][] dp = new int[n + 1][k + 1][target + 1];
        
        for (int i = 0; i < n + 1; i++) {  // should initial with 1, means there is 1 way to 
            dp[i][0][0] = 1;               // get 0 element from n elements whose sum is 0 
        }                       
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    dp[i][j][t] = dp[i - 1][j][t];
                    
                    if (t >= A[i - 1]) {
                        dp[i][j][t] += dp[i - 1][j - 1][t - A[i-1]];
                    }
                } 
            } 
        } 
        
        return dp[n][k][target];
    }
	
	
	
	// follow up, optimize the space: time O(n^3), space O(n^2)
	public int  kSum2(int A[], int k, int target) {
        int n = A.length;
        int[][][] dp = new int[2][k + 1][target + 1];
        
        for (int i = 0; i < 2; i++) {
            dp[i][0][0] = 1;
        }
        
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= k && j <= i; ++j){
                for(int t = 1; t <= target; ++t){
                    dp[i % 2][j][t] = dp[(i - 1) % 2][j][t];
                    
                    if(t >= A[i - 1]){
                        dp[i % 2][j][t] += dp[(i - 1) % 2][j - 1][t - A[i - 1]];
                    }
                }
            }
        }
        
        return dp[n % 2][k][target];
    }
}
