/*******
 * 
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
	isMatch("aa","a") → false	
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "a*") → true
	isMatch("aa", ".*") → true
	isMatch("ab", ".*") → true
	isMatch("aab", "c*a*b") → true

 * 
 * */


public class Le_010_Regular_Expression_Matching {
	/**************************************************************************************
	 * State: canMatch[i][j] means that s.substring(0, i) and p.substring(0, j) can match;
	 * Transfer function:  two situation, c == '*' or c != '*'
	 * initial: canMatch[0][j] = canMatch[0][j-2]
	 * answer:  canMatch[sLen][pLen] 
	 * 
	 * Two situations:
	 * (1) dp[i][j-2] is true, and there is 0 preceding element of '*';
	 * (2) The last character of s should match the preceding element of '*'; 
	 *     And, dp[i-1][j] should be true;
	 * (3). 此题应考虑：*不能出现在第一个位置！
	 * (4). 相似题目 44
	 **************************************************************************************/
	
	//test case: [abcd, d*]
	
	public boolean isMatch(String s, String p) {
		if(s == null && p == null) {
            return true;
        } else if(s == null || p == null) {
            return false;
        }
        
        int sLen = s.length(), pLen = p.length();
        boolean[][] canMatch = new boolean[sLen + 1][pLen + 1];
        canMatch[0][0] = true;
        
        for(int i = 2; i <= pLen; i++) {
            canMatch[0][i] = canMatch[0][i-2] && p.charAt(i-1) == '*';
        }
        
        for(int i = 1; i <= sLen; i++) {
            for(int j = 1; j <= pLen; j++) {
                char c = p.charAt(j-1);
                
                if(c != '*') {
                    canMatch[i][j] = canMatch[i-1][j-1] && (c == '.' || c == s.charAt(i-1));
                } else { // 第三部分test case: [a, a] [a, *]
                    canMatch[i][j] = (j >= 2 && canMatch[i][j-2]) || (canMatch[i][j-1]) || (canMatch[i-1][j] && (j >= 2 && p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)));
                }
            }
        }
        
        return canMatch[sLen][pLen];
    }
	
	
	
	
	
	
	
	/********************************** main function ***********************************/
	
	public static void main(String[] args){
		Le_010_Regular_Expression_Matching t = new Le_010_Regular_Expression_Matching();
		String str1 = "cb";
		String str2 = "c*";
		System.out.println(t.isMatch(str1, str2));
	}
}
