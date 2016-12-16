/*****
 * 
There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left. The player who take the last coin wins.

Could you please decide the first play will win or lose?

Example
n = 1, return true.

n = 2, return true.

n = 3, return false.

n = 4, return true.

n = 5, return true.

 * 
 * */

public class Li_394_Coins_in_a_Line {
	public boolean firstWillWin(int n) {
        if(n <= 0){
            return false;
        } else if(n <= 2){
            return true;
        } else if(n == 3){
            return false;
        }
        
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = dp[2] = true;
        dp[3] = false;
        
        for(int i = 4; i <= n; i++){
            dp[i] = (dp[i - 2] && dp[i - 3]) || (dp[i - 3] && dp[i - 4]); 
        }
        
        return dp[n];
    }
}
