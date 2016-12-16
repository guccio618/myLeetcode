import java.util.*;
/******
 * 
Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. 
t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting 
some (can be none) of the characters without disturbing the relative positions of the remaining 
characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one 
by one to see if T has its subsequence. In this scenario, how would you change your code?
 * 
 * */

public class Q392_Is_Subsequence {
	// solution 1: using str.indexOf(), time O(n*m), space O(1)
	public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0) {
            return true;
        } else if(t == null || t.length() == 0) {
            return false;
        }
        
        int startIndex = 0;
        
        for(char c : s.toCharArray()) {
            startIndex = t.indexOf(c, startIndex);
            
            if(startIndex == -1) {
                return false;
            } else {
                startIndex++;
            }
        }
        
        return true;
    }
	
	
	
	// solution 2: using DP, time O(n*m), space O(n*m)
	public boolean isSubsequence2(String s, String t) {
        if(s == null || s.length() == 0) {
            return true;
        } else if(t == null || t.length() == 0) {
            return false;
        }
        
        int sLen = s.length();
        int tLen = t.length();
        boolean[][] dp = new boolean[sLen+1][tLen+1];
        dp[0][0] = true;
        
        for(int i = 1; i <= tLen; i++) {
            dp[0][i] = true;
        }
        
        for(int i = 1; i <= sLen; i++) {
            for(int j = 1; j <= tLen; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] || dp[i][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        return dp[sLen][tLen];
    }
	
	
	
	// follow up: if s is an array of string, using map to record the position of each character 
	/**
	 * Follow-up
	 * If we check each sk in this way, then it would be O(kn) time where k is the number of s and t is the length of t. 
	 * This is inefficient. 
	 * Since there is a lot of s, it would be reasonable to preprocess t to generate something that is easy to search for if a character of s is in t. 
	 * Sounds like a HashMap, which is super suitable for search for existing stuff. 
	 */	
	public boolean isSubsequence3(String s, String t) {
        if(s == null || s.length() == 0) {
            return true;
        } else if(t == null || t.length() == 0) {
            return false;
        }
        
        Map<Character, List<Integer>> map = new HashMap();
        
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            
            if(!map.containsKey(c)) {
                map.put(c, new ArrayList<Integer>());
            }
            
            map.get(c).add(i);
        }
        
        int startIndex = 0;
        
        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                List<Integer> list = map.get(c);     
                
                System.out.println("1: c = " + c + ", " + startIndex);
                
                startIndex = binarySearch(list, startIndex);
                
                System.out.println("2: c = " + c + ", " + startIndex);
                
                if(startIndex > -1) {
                    startIndex++;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return true;
    }
    
    public int binarySearch(List<Integer> list, int target) {
        if(target > list.get(list.size() - 1)) {
        	return -1;
        }
        
        int start = 0, end = list.size() - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            
            if(list.get(mid) < target) {
               start = mid; 
            } else {
                end = mid;
            } 
        }
        
        if(list.get(start) >= target) {
            return list.get(start);
        } else {
            return list.get(end);
        }
    }
	
    
    
    
    
    
    
    
    
	
	/******* main function *******/
	public static void main(String[] args){
		Q392_Is_Subsequence t = new Q392_Is_Subsequence();
		String str1 = "abc";
		String str2 = "ahbgdc";
		System.out.println(t.isSubsequence3(str1, str2));
	}
}
