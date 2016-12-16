
public class Li_396_Coins_in_a_Line_III {
	/************************************************************************
	 * 此题选手每次可以从左右两边取1个coin，用dp[i][j]表示剩下i-j的硬币，选手1可以获得的
	 * 最大分数，选手2可能获得的分数为dp[i-1][j]或dp[i][j-1]，以此类推；由于决定dp[i][j]
	 *  
	 ************************************************************************/
	
	public boolean firstWillWin(int[] values) {
        if(values == null || values.length == 0){
            return false;
        } else if(values.length <= 2){
            return true;
        }
        
        int n = values.length;
        int sum = 0;
        int[][] dp = new int[n][n];
        
        for(int i = 0; i < n; ++i){
            sum += values[i];
        }
        
        for(int i = 0; i < n; ++i){
            dp[i][i] = values[i];
        }
        
        for(int i = 0; i < n - 1; ++i){
            dp[i][i + 1] = Math.max(values[i], values[i + 1]);
        }
        
        for(int length = 2; length < n; ++length){
            for(int start = 0; start + length < n; ++start){
                dp[start][start + length] = Math.max(Math.min(dp[start + 2][start + length], dp[start + 1][start + length - 1]) + values[start], Math.min(dp[start][start + length - 2], dp[start + 1][start + length - 1]) + values[start + length]);
            }
        }
        
        return dp[0][n - 1] * 2 > sum;
     }
}
