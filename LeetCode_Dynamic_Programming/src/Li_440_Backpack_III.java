/*****
 * 
Given n kind of items with size Ai and value Vi( each item has an infinite number available) 
and a backpack with size m. What's the maximum value can you put into the backpack?

Example
	Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. 
	The maximum value is 15.
	
 * 
 * */


public class Li_440_Backpack_III {
	public int backPackIII(int[] A, int[] V, int m) {
		int n = A.length;
        int[] dp = new int[m + 1];
        
		for(int i = 0; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                if(i >= A[j]) {
                    dp[i] = Math.max(dp[i], dp[i - A[j]] + V[j]);
                }
            }
        }
		
		return dp[m];
    }
}
