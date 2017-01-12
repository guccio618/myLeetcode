
public class Q077_Longest_Common_Subsequence {
	/**********************************************************
	 * state:     f[i][j]表示s1的前i个字符串和s2的前j个字符串是否可以...
	 * function:  f[i][j]
	 * initial:   
	 **********************************************************/
	// by ninechapter
	
	public int longestCommonSubsequence(String A, String B) {
        int n = A.length();
	    int m = B.length();
        int f[][] = new int[n + 1][m + 1];
        for(int i = 0; i < n; i++) f[i][0] = 0;
        for(int i = 0; i < m; i++) f[0][i] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if(A.charAt(i - 1) == B.charAt(j - 1))
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
            }
        }
        return f[n][m];
    }
}
