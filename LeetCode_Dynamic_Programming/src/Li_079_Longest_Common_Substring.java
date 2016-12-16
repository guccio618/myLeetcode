/****
 * 
Given two strings, find the longest common substring.

Return the length of it.

Example
	Given A = "ABCD", B = "CBCE", return 2.

 * 
 * */

public class Li_079_Longest_Common_Substring {
	/************************************************************************
	 * 连续的substring, 不同于subsquence； 注意状态转移方程不同于77题
	 * 
	 * Statement:  dp[i][j]: str1的第i个字符开始，str2第j个字符开始，一起往前的
	 * 			   最大common substring数
	 * Function:   dp[i][j] = (str1[i] == str2[j]) && dp[i - 1][j - 1] + 1
	 * 			   只取决于他们的前一个字符时的对比状态。
	 * Initial:    dp[i][0] = 0, dp[0][j] = 0;
	 * Answer:     max(dp[i][j])
	 *  
	 ************************************************************************/
	
	public int longestCommonSubstring(String str1, String str2) {
        if(str1.length() == 0 || str2.length() == 0) {
        	return 0;
        }
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        int maxLen = 0;
        
        for(int i = 0; i <= len1; ++i){
            dp[i][0] = 0;
        }
        for(int i = 0; i <= len2; ++i){
            dp[0][i] = 0;
        }
        
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                } 
            }
        }
        
        return maxLen;
    }
}
