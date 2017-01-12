
public class Q118_Distinct_Subsequences {
	/*******************************************************/
	// by ninechapter using DP
	public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }

        int[][] nums = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i <= S.length(); i++) {
            nums[i][0] = 1;
        }
        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                nums[i][j] = nums[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    nums[i][j] += nums[i - 1][j - 1];
                }
            }
        }
        return nums[S.length()][T.length()];
    }
	
	
	/*******************************************************/
	// by other using DP
	public int numDistinct2(String S, String T) {
		if (S == null || T == null) {
			return 0;
		}
		if (S.length() < T.length()) {
			return 0;
		}

		// 递推公式用的, 定义dp[i][j]为字符串i变换到j的变换方法
		int[][] dp = new int[S.length() + 1][T.length() + 1]; 
		dp[0][0] = 1;

		// 任意一个字符串变换成一个空串都只有一种变换方法
		for (int i = 0; i < S.length(); i++) {
			dp[i][0] = 1;
		}

		// 递推公式
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				// 如果S和T的当前字符相等，那么有两种选法；否则S的当前字符不能要
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					dp[i][j] += dp[i-1][j-1] + dp[i-1][j]; // 可以由dp[i-1][j]在字符串i上加一个和j最后一个字符相等的字符来构成，
				}										   // 也可以由dp[i-1][j-1]共同加上一个相等的字符来构成
				else{
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[S.length()][T.length()];
	}
}
