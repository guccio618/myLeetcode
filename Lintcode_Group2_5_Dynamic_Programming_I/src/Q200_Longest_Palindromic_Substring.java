
public class Q200_Longest_Palindromic_Substring {
	/****************************************************
	 * 区间型动态规划
	 * 		state:     dp[i][j]表示从i到j是否是Palindromic
	 * 		function:  dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]
	 * 		initial:   dp[i][j] = true, dp[i][i + 1] = (s[i] == s[j])
	 * 		answer:    maxLen
	 ****************************************************/
	// by Jackie using DP
	
	public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return new String();
        }
        if(s.length() == 1){
            return s;
        }
        if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1)){
                return s;
            } else {
                return new String();
            }
        }
        
        int maxLen = 1;
        int pos = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        
        for(int i = 0; i < len; ++i){
            dp[i][i] = true;
        }
        
        for(int i = 1; i < len; ++i){
            dp[i - 1][i] = (s.charAt(i - 1) == s.charAt(i));
            if(dp[i - 1][i] == true){
                maxLen = 2;
                pos = i - 1;
            }
        }
        
        for(int length = 2; length < len; ++length){
            for(int start = 0; start + length < len; ++start){
                dp[start][start + length] = dp[start + 1][start + length - 1] && ( s.charAt(start) == s.charAt(start + length) );
                if(dp[start][start + length] == true && maxLen <= length){
                    maxLen = length + 1;
                    pos = start;
                }
            }
        }
        
        return s.substring(pos, pos + maxLen);
    }
	
	
	
	/************************** main function ******************************/
	public static void main(String[] args){
		Q200_Longest_Palindromic_Substring t = new Q200_Longest_Palindromic_Substring();
		String s = "abb";
		System.out.println(t.longestPalindrome(s));
	}
}
