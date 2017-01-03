/*****************************************************************************
 * 	此题为159题的follow up
 * 
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.
 *   
 *****************************************************************************/

public class Le_340_Longest_Substring_with_At_Most_K_Distinct_Characters {
	// solution 1: time O(256 * n), space O(1)
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k <= 0){
            return 0;
        }
        
        int n = s.length();
        int[] hash = new int[256];
        int slower = 0;
        int ans = 0;
        
        for(int faster = 0; faster < n; faster++){
            hash[s.charAt(faster)]++;
            
            while(!isValid(hash, k)){
                hash[s.charAt(slower)]--;
                slower++;
            }
            
            if(isValid(hash, k)){
                ans = Math.max(ans, faster - slower + 1);
            }
        }
        
        return ans;
    }
    
    public boolean isValid(int[] hash, int k){
        int count = 0;
        
        for(int i = 0; i < 256; i++){
            if(hash[i] > 0){
                count++;
            }
            if(count > k){
                return false;
            }
        }
        
        return true;
    }
    
    
    
    
    // solution 2: time O(n), space O(1)
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
    	if(s == null || s.length() == 0) {
            return 0;
        }
        
        int maxLen = 0;
        int[] hash = new int[256];
        int slower = 0;
        int count = 0;
        
        for(int faster = 0; faster < s.length(); faster++) {
            if(hash[s.charAt(faster)]++ == 0) {
                count++;
            }
            
            while(count > k) {
                if(hash[s.charAt(slower++)]-- == 1) {
                    count--;
                }
            }
            
            maxLen = Math.max(maxLen, faster - slower + 1);
        }
        
        return maxLen;
    }
}
