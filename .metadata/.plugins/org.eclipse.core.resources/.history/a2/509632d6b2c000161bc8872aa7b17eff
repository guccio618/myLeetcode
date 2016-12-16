import java.util.*;
/***********
 * 
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

 * 
 * */
public class Q438_Find_All_Anagrams_in_a_String {
	// solution 1: using hashmap, time is O(n*k), space is O(256)
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        if(s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return ans;
        }
        
        int sLen = s.length(), pLen = p.length();
        int[] pHash = new int[256];
        
        for(char c : p.toCharArray()) {
            pHash[c]++;
        }
        
        for(int i = 0; i <= sLen - pLen; i++) {
            int[] hash = new int[256];
            boolean found = true;
            
            for(int j = i; j < i + pLen; j++) {
                hash[s.charAt(j)]++;
            }
            
            for(int k = 0; k < 256; k++) {
                if(hash[k] != pHash[k]) {
                    found = false;
                    break;
                }
            }
            
            if(found == true) {
                ans.add(i);
            }
        }
        
        return ans;
    }
	
	
	
	
	// follow up: solution 2: using two pointers, time is O(n), space is O(256)
	public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        if(s == null || s.length() == 0 || p == null || p.length() == 0 || s.length() < p.length()) {
            return ans;
        }
        
        int sLen = s.length(), pLen = p.length();
        int[] pHash = new int[256];
        
        for(char c : p.toCharArray()) {
            pHash[c]++;
        }
        
        int[] hash = new int[256];
        int front = pLen, back = 0;
        
        for(int i = 0; i < pLen; i++) {
            hash[s.charAt(i)]++;
        }
        
        while(front < sLen) {
            if(isAnagram(pHash, hash)) {
                ans.add(back);
            }
            
            hash[s.charAt(front++)]++;
            hash[s.charAt(back++)]--;
        }
        
        if(isAnagram(pHash, hash)) {
            ans.add(back);
        }
        
        return ans;
    }
    
    public boolean isAnagram(int[] pHash, int[] hash) {
        for(int i = 0; i < 256; i++) {
            if(pHash[i] != hash[i]) {
                return false;
            }
        }
        
        return true;
    }
}
