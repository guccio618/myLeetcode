/******
 * 
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 * 
 * */


public class Le_062_Unique_Paths {
	// solution 1: time O(m*n), space O(m*n)
	public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0){
            return 0;
        }
        
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; ++i){
            dp[i][0] = 1;
        }
        
        for(int i = 0; i < n; ++i){
            dp[0][i] = 1;
        }
        
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[m-1][n-1];
    }
	
	
	
	// solution 2: follow up, time O(m*n), 滚动数组空间优化 space O(n)
	public int uniquePaths2(int m, int n) {
        if(m <= 0 || n <= 0){
            return 0;
        }
        
        int[][] dp = new int[2][n];
        
        for(int i = 0; i < 2; ++i){
            dp[i][0] = 1;
        }
        
        for(int i = 0; i < n; ++i){
            dp[0][i] = 1;
        }
        
        for(int i = 1; i < m; ++i){
            for(int j = 1; j < n; ++j){
                dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
            }
        }
        
        return dp[(m - 1) % 2][n - 1];
	}
}
