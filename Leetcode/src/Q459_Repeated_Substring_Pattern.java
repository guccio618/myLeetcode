/******
 * 
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. 
You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.


Example 2:
Input: "aba"

Output: False


Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
Show Company Tags
Show Tags
Show Similar Problems

 * 
 * */

public class Q459_Repeated_Substring_Pattern {
	public boolean repeatedSubstringPattern(String str) {
        if(str == null || str.length() == 0) {
            return false;
        }
        
        int len = str.length();
        
        for(int i = 0; i < len / 2; i++) {
            if(len % (i + 1) != 0) {
                continue;
            }
            
            int start = 0;
            int subLen = i + 1;
            String newStr = str.substring(0, subLen);
            
            while(start > -1 && start + subLen < len) {
                int nextStart = str.indexOf(newStr, start + subLen);
                
                if(start + subLen != nextStart) {
                    break;
                } else {
                    start = nextStart;
                }
            }
            
            if(start + subLen == len) {
                return true;
            }
        }
        
        return false;
    }
	
	
	
	
	
	/********************** main function ******************************/
	
	public static void main(String[] args) {
		Q459_Repeated_Substring_Pattern t = new Q459_Repeated_Substring_Pattern();
		String str = "aa";
		System.out.println(t.repeatedSubstringPattern(str));
	}
}
