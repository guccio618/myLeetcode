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

public class Le_459_Repeated_Substring_Pattern {
	public boolean repeatedSubstringPattern(String str) {
        if(str == null || str.length() == 0) {
            return false;
        }
        
        int len = str.length();
        
        for(int subLen = 1; subLen <= len/2; subLen++) {
            if(len % subLen != 0) {
                continue;
            }
            
            int start = 0;
            String subStr = str.substring(start, start + subLen);
        
            while(start + subLen <= len) {
                int index = str.indexOf(subStr, start);
                
                if(index != start) {
                    break;
                } else {
                    start += subLen;
                }
            }
            
            if(start == len) {
                return true;
            }
        }
        
        return false;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	/********************** main function ******************************/
	
	public static void main(String[] args) {
		Le_459_Repeated_Substring_Pattern t = new Le_459_Repeated_Substring_Pattern();
		String str = "aa";
		System.out.println(t.repeatedSubstringPattern(str));
	}
}
