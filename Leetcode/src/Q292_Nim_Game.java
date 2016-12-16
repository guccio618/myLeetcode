
public class Q292_Nim_Game {
	// by other
	public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
	
	// by Jackie using DP, cannot reduce space complexity to O(1)	
	public boolean canWinNim2(int n) {
        if(n <= 0){
            return false;
        } else if(n <= 3 || n == 5){
            return true;
        } else if(n == 4){
            return false;
        }
        
        boolean[] dp = new boolean[n + 1];    // 表示当前还剩多少个stone
        dp[0] = false;
        dp[1] = dp[2] = dp[3] = true;
        dp[4] = false;
        dp[5] = true;
        
        for(int i = 6; i <= n; i++){
            dp[i] = (dp[i - 2] && dp[i - 3] && dp[i - 4]) || (dp[i - 3] && dp[i - 4] && dp[i - 5]) || (dp[i - 4] && dp[i - 5] && dp[i - 6]);
        }
        
        return dp[n];
    }
	
	
	public static void main(String[] args){
		Q292_Nim_Game t = new Q292_Nim_Game();
		System.out.println(t.canWinNim(521));
		System.out.println(t.canWinNim2(521));
	}
}
