
public class Lecture5_DP_II_09_Longest_Common_Substring {
	/******************************************************************************************************************
	 * 双序列动态规划	
	 * 		state:      f[i][j] 表示str1的前i个字符和str2中的前j个字符中的公共子串长度；
	 * 		function:   f[i][j] = f[i-1][j-1] + 1     // str1.charAt(i) == str2.charAt(j);
	 * 							= 0                   // str1.charAt(i) != str2.charAt(j);
	 * 					分析： 当str1.charAt(i) == str2.charAt(j)时，此时的公共子串长度取决于f[i-1][j-1],是其数目的延续，即＋1，
	 * 					      当str1.charAt(i) != str2.charAt(j)时，由于公共子串必须是连续的，因此当前的f[i][j] = 0
	 * 		initial:    f[0][j] = 0,  f[i][0] = 0;
	 * 		answer:     Math.max(f[i][j]), 即f[i][j]中的最大值;
	 * 
	 ******************************************************************************************************************/
	
	public int longestCommonSubstring(String str1, String str2) {
        if(str1.length() == 0 || str2.length() == 0) {
        	return 0;
        }
        
        int m = str1.length();
        int n = str2.length();
        int[][] f = new int[m + 1][n + 1];
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < m; ++i){
        	f[i][0] = 0;
        }
        for(int j = 0; j < n; ++j){
        	f[0][j] = 0;
        }
        
        for(int i = 1; i <= m; ++i){
        	for(int j = 1; j <= n; ++j){
        		if(str1.charAt(i-1) == str2.charAt(j-1)){
        			f[i][j] = f[i-1][j-1] + 1;
        			max = Math.max(max, f[i][j]);
        		}
        	}
        }
        return max;
    }

	
	
	/************************************* main function **********************************************/
	public static void main(String[] args){
		Lecture5_DP_II_09_Longest_Common_Substring t = new Lecture5_DP_II_09_Longest_Common_Substring();
		String str1 = "www.lintcode.com code";
		String str2 = "www.ninechapter.com code";
//		String str1 = "abcdwww";
//		String str2 = "bcttwww";
		System.out.println(t.longestCommonSubstring(str1, str2));
	}
}
