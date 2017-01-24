/*******
 * 
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "*") → true
	isMatch("aa", "a*") → true
	isMatch("ab", "?*") → true
	isMatch("aab", "c*a*b") → false
	
 * 
 * */

public class Le_044_Wildcard_Matching {
	/*******************************************************************
	 * State: canMatch[i][j] means that s.substring(0, i) and p.substring(0, j) can match;
	 * Transfer function:  two situation, c == '*' or c != '*'
	 * initial: canMatch[0][j] = canMatch[0][j-1]
	 * answer:  canMatch[sLen][pLen] 
	 *  
	 *******************************************************************/
	// test case: "" 2
	
	// using DP, time complexity O(n^2), space O(n^2)
	public boolean isMatch(String s, String p) {
		if(s == null && p == null) {
            return true;
        } else if(s == null || p == null) {
            return false;
        }
        
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] canMatch = new boolean[sLen + 1][pLen + 1];
        canMatch[0][0] = true;
        
        for(int i = 1; i <= pLen; i++) {
            canMatch[0][i] = canMatch[0][i - 1] && p.charAt(i - 1) == '*';
        }
        
        for(int i = 1; i <= sLen; i++) {
            for(int j = 1; j <= pLen; j++) {
                char c = p.charAt(j - 1);
                
                if(c != '*') {
                    canMatch[i][j] = canMatch[i - 1][j - 1] && (c == '?' || c == s.charAt(i - 1));
                } else {
                    canMatch[i][j] = canMatch[i][j - 1] || canMatch[i - 1][j];
                }
            }
        }
        
        return canMatch[sLen][pLen];
    }
}
