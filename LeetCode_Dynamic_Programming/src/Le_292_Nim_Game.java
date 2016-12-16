public class Le_292_Nim_Game {
	// by other
	public boolean canWinNim(int n) {
		return n % 4 != 0;
	}

	// by Jackie using DP, cannot reduce space complexity to O(1)
	public boolean canWinNim2(int n) {
		if (n <= 0) {
			return false;
		} else if (n <= 3) {
			return true;
		} else if (n == 4) {
			return false;
		}

		boolean[] dp = new boolean[n + 1];
		dp[0] = false;
		dp[1] = true;
		dp[2] = true;
		dp[3] = true;
		dp[4] = false;

		for (int i = 5; i < n; ++i) {
			dp[i] = (dp[i - 1] && dp[i - 2] && dp[i - 3])
					|| (dp[i - 2] && dp[i - 3] && dp[i - 4])
					|| (dp[i - 3] && dp[i - 4] && dp[i - 5]);
		}

		return dp[n];
	}
}
