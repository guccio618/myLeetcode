/*******
 * 
 * In the computer world, use restricted resource you have to generate maximum
 * benefit is what we always want to pursue.
 * 
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the
 * other hand, there is an array with strings consisting of only 0s and 1s.
 * 
 * Now your task is to find the maximum number of strings that you can form with
 * given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * 
 * Note: The given numbers of 0s and 1s will both not exceed 100 The size of
 * given string array won't exceed 600.
 * 
 * Example 1: Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4 Explanation: This are totally 4 strings can be formed by the using
 * of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 * 
 * Example 2: Input: Array = {"10", "0", "1"}, m = 1, n = 1 Output: 2
 * Explanation: You could form "10", but then you'd have nothing left. Better
 * form "0" and "1".
 * 
 * 
 */

public class Q474_Ones_and_Zeroes {
	// solution 1: using backtrack, but TLE
	private int maxLen = 0;

	public int findMaxForm(String[] strs, int m, int n) {
		if (strs == null || strs.length == 0) {
			return 0;
		}

		int len = strs.length;
		int[][] needs = new int[len][2];

		// build matrix
		for (int i = 0; i < len; i++) {
			for (char c : strs[i].toCharArray()) {
				if (c == '0') {
					needs[i][0]++;
				} else if (c == '1') {
					needs[i][1]++;
				}
			}
		}

		backtrack(needs, len, 0, 0, m, n);
		return maxLen;
	}

	public void backtrack(int[][] needs, int len, int start, int finishCount, int zeroLeft, int oneLeft) {
		if (start == len) {
			maxLen = Math.max(maxLen, finishCount);
			return;
		}

		for (int i = start; i < len; i++) {
			if (zeroLeft >= needs[i][0] && oneLeft >= needs[i][1]) {
				backtrack(needs, len, i + 1, finishCount + 1, zeroLeft - needs[i][0], oneLeft - needs[i][1]);
			}
		}
	}

	
	
	// solution 2: using DP, similar to backpack, time is O(len * m * n), space is O(m * n)
	public int findMaxForm2(String[] strs, int m, int n) {
		if (strs == null || strs.length == 0) {
			return 0;
		}

		int[][] dp = new int[m + 1][n + 1];

		for (String str : strs) {
			int[] needs = new int[2];

			for (char c : str.toCharArray()) {
				needs[c - '0']++;
			}

			// for(int i = needs[0]; i <= m; i++) {
			// for(int j = needs[1]; j <= n; j++) {
			for (int i = m; i >= needs[0]; i--) { // 一个个往里填充str, 因此必须从m,n开始
				for (int j = n; j >= needs[1]; j--) {
					dp[i][j] = Math.max(dp[i][j], dp[i - needs[0]][j - needs[1]] + 1);
				}
			}
		}

		return dp[m][n];
	}

	
	
	
	
	
	
	
	
	
	
	
	
	/***************************** main function ********************************/

	public static void main(String[] args) {
		Q474_Ones_and_Zeroes t = new Q474_Ones_and_Zeroes();
		// String[] strs = {"10", "0001", "111001", "1", "0"};
		// int m = 4, n = 3;

		String[] strs = { "0", "11", "1000", "01", "0", "101", "1", "1", "1", "0", "0", "0", "0", "1", "0", "0110101",
				"0", "11", "01", "00", "01111", "0011", "1", "1000", "0", "11101", "1", "0", "10", "0111" };
		// String[] strs =
		// {"0","1000","01","0","101","0","0","0","0","0","0110101","0","01","00","01111","0011","1000","0","11101","0","10","0111"};
		int m = 90, n = 66;

		System.out.println(t.findMaxForm(strs, m, n));
		System.out.println(t.findMaxForm2(strs, m, n));
	}
}
