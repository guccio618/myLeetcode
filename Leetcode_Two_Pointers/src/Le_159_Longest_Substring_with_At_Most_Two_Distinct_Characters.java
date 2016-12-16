/*************************************************************
 * 
Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
 
 **************************************************************/

public class Le_159_Longest_Substring_with_At_Most_Two_Distinct_Characters {
	// Solution 1: two pointers, time O(n), space O(1)
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] hash = new int[256];
        int len = s.length();
        int back = 0;
        int maxLen = 0;
        int charCount = 0;
        
        for (int front = 0; front < len; front++) {
            if (hash[s.charAt(front)]++ == 0) {
                charCount++;
            }
            
            while(charCount > 2) {
                if(--hash[s.charAt(back++)] == 0) {
                    charCount--;
                }
            }

            maxLen = Math.max(maxLen, front - back + 1);
        }
        
        return maxLen;
    }
	
	
	// Solution 2: two pointers, time O(n), space O(256)
	public int lengthOfLongestSubstringTwoDistinct2(String s) {
        if(s == null){
            return 0;
        } 
        
        int maxLen = 0; 
        int n = s.length();
        int[] hash = new int[256];
        int slower = 0;
        
        for(int faster = 0; faster < n; ++faster){
            hash[s.charAt(faster)]++;
            while(slower < n && !isValid(hash, 2)){
                hash[s.charAt(slower)]--;
                slower++;
            }
            
            if(isValid(hash, 2)){
                maxLen = Math.max(maxLen, faster - slower + 1);
            }
        }
        
        return maxLen;
    }
    
    public boolean isValid(int[] hash, int k){
        int count = 0;
        for(int i = 0; i < hash.length; ++i){
            if(hash[i] > 0){
                count++;
            }
        }
        return (count <= k);
    }
}
