
public class Q079_Longest_Common_Substring {
	public int longestCommonSubstring(String str1, String str2) {
		if(str1.length() == 0 || str2.length() == 0) {
			return 0;
	    }
		int max = 0;
		int len1 = str1.length();
		int len2 = str2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		
		for(int i = 0; i <= len1; ++i){
			dp[i][0] = 0;
		}
		
		for(int j = 0; j <= len1; ++j){
			dp[0][j] = 0;
		}
		
		for(int i = 1; i <= len1; ++i){
			for(int j = 1; j <= len2; ++j){
				if(str1.charAt(i - 1) == str2.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}
}
