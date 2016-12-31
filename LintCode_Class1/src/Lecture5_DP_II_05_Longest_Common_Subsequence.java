
public class Lecture5_DP_II_05_Longest_Common_Subsequence {
	/*********************************************************************************************************************************
	 * 双序列动态规划
	 * 		state:     f[i][j] 表示str1的前i个字符和str2的前j个字符的公共子串数 (LCS);
	 * 		function:  f[i][j] = MAX(f[i-1][j], f[i][j-1], f[i-1][j-1]+1)     // a[i] == b[j]时;
	 * 				        或 =  MAX(f[i-1][j], f[i][j-1])                     // a[i] != b[j]时;
	 * 				   分析： 当str1[i] == str2[j]时，f[i-1][j]表示str1[i]不作为LCS的一个字符串, f[i][j-1]表示str2[j]不作为LCS的一个字符串, 
	 * 											    f[i-1][j-1]+1 表示str1[i]和str2[j]都被用作为LCS的一个字符串;
	 * 						 当str1[i] ！= str2[j]时，f[i-1][j]表示str1[i]不作为LCS的一个字符串, f[i][j-1]表示str2[j]不作为LCS的一个字符串;
	 * 		initial:   f[0][j] = 0 && f[i][0] = 0;
	 *   	answer:    f[str1.length][str2.length];
	 *   
	 *********************************************************************************************************************************/

	public int longestCommonSubsequence(String A, String B) {
        int n = A.length();
	    int m = B.length();
        int f[][] = new int[n + 1][m + 1];
        
        // initial
        for(int i = 0; i < n; i++){
        	f[i][0] = 0;
        }
        for(int i = 0; i < m; i++){
        	f[0][i] = 0;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }
        
        return f[n][m];
    }
}
