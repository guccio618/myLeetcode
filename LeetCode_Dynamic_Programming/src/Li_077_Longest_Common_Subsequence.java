/*****
 * 
Given two strings, find the longest common subsequence (LCS).

Your code should return the length of LCS.

Example
	For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.

	For "ABCD" and "EACB", the LCS is "AC", return 2.

 * 
 * */

public class Li_077_Longest_Common_Subsequence {
	/*******************************************************************
	 * 不连续的subsquence, 不同于substring
	 * 此题解法思路同72题，三态
	 *  
	 *******************************************************************/
	
	public int longestCommonSubsequence(String str1, String str2) {
        if(str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0){
            return 0;
        }
    
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        for(int i = 0; i <= len1; ++i){
            dp[i][0] = 0;
        }
        
        for(int i = 0; i <= len2; ++i){
            dp[0][i] = 0;
        }
        
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i - 1][j], dp[i][j - 1]));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[len1][len2];
    }
}
