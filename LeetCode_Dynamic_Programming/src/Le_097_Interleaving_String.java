/******
 *
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

 *
 **/

public class Le_097_Interleaving_String {
	/******************************************************************************************************************
	 * 双序列动态规划 - (String类)
	 * 		state:      f[i][j] 表示str1的前i个字符和str2中的前j个字符是否能组成str3的前i+j个字符；
	 * 		function:   f[i][j] = (f[i-1][j] && str1[i] == str3[i+j]) || (f[i][j-1] && str2[j] == str3[i+j]);
	 * 		initial:    f[0][j] = (f[0][j-1] && str2[j] == str3[j]),  f[i][0] = (f[i-1][0] && str1[i] == str3[i]);
	 * 		answer:     f[str1.length][str2.length];
	 * 
	 ******************************************************************************************************************/
	
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s3 == null || s3.length() == 0) {
            return s1 == null || s1.length() == 0 && s2 == null || s2.length() == 0;
        } else if(s1 == null || s1.length() == 0) {
            return s3.equals(s2);
        } else if(s2 == null || s2.length() == 0) {
            return s3.equals(s1);
        } else if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
       
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        
        // 存储的是某一状态，dp[1][2]表示访问到str1的第1个char，str2的第2个char时的状态
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;       // dp[0][0] ＝ 0 必须为0
        
        for(int i = 1; i <= len1; ++i){     // 表示只s1的前i个字符组成s3的前i个字符
            if(s3.charAt(i - 1) == s1.charAt(i - 1)){
                dp[i][0] = true;
            } else{
                break;                      // 一旦发现有一个不同于s3，之后的就不需要判断了，均为false !!!
            }
        }
        
        for(int i = 1; i <= len2; ++i){
            if(s3.charAt(i - 1) == s2.charAt(i - 1)){
                dp[0][i] = true;
            } else{
                break;
            }
        }
        
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                int k = i + j;
                
                if(s3.charAt(k - 1) == s1.charAt(i - 1)){
                    dp[i][j] |= dp[i - 1][j];
                }          // 此处不可以用else, 因为有上下两种可能使得dp[i][j]＝true
                
                if(s3.charAt(k - 1) == s2.charAt(j - 1)){
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        
        return dp[len1][len2];
    }
}
