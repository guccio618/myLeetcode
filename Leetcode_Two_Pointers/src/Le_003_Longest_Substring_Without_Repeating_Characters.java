import java.util.Arrays;
import java.util.HashMap;
/*************************************************************************************

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
"pwke" is a subsequence and not a substring.

***************************************************************************************/


// Solution 1: two pointers, time O(n), space O(1)
public class Le_003_Longest_Substring_Without_Repeating_Characters {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int[] hash = new int[256];
        int back = 0;
        int len = s.length();
        int maxLen = 0;
        int duplicateCount = 0;
        
        for(int front = 0; front < len; front++) {
            if(hash[s.charAt(front)]++ == 1) {
                duplicateCount++;
            }
            
            while(duplicateCount > 0) {
            	if(--hash[s.charAt(back++)] == 1) {
            		duplicateCount--;
            	}
            }
            
            maxLen = Math.max(maxLen, front - back + 1);
        }
          
        return maxLen;
     }
	
	
	
	// Solution 2: two pointers, time O(n), space O(1)
	public int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int[] hash = new int[256];
        int back = 0;
        int len = s.length();
        int maxLen = 0;
        
        for(int front = 0; front < len; front++) {
            hash[s.charAt(front)]++;
            
            while(!isValid(hash)) {
                hash[s.charAt(back)]--;
                back++;
            }
            
            if(isValid(hash)) {
                maxLen = Math.max(maxLen, front - back + 1);
            }
        }
        
        return maxLen;
    }
    
    public boolean isValid(int[] hash) {
        for(int i = 0; i < 256; i++) {
            if(hash[i] > 1) {
                return false;
            }
        }
        
        return true;
    }

    
    
	// solution 3: using hashmap
	public int lengthOfLongestSubstring3(String s) {
        if(s == null || s.length() == 0){
            return s.length();
        } 
        
        HashMap<Character, Integer> myMap = new HashMap<Character, Integer>();
        char[] array = s.toCharArray();
        int maxLen = 1;
        int prePos = 0;
        int n = s.length();
        
        for(int i = 0; i < n; ++i){
            if(!myMap.containsKey(array[i])){
                myMap.put(array[i], i);
            } else {
                int tempPos = myMap.get(array[i]);
                if(tempPos < prePos){
                    myMap.put(array[i], i);
                } else {
                    maxLen = Math.max(maxLen, i - prePos);
                    prePos = tempPos + 1;
                    myMap.put(array[i], i);
                }
            }
        }
        
        maxLen = Math.max(maxLen, n - prePos);   // 清理最后的尾巴部分，如aabc, abcde
        
        return maxLen;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	/******************************* main function ****************************************/
	
	public static void main(String[] args){
		String s = "abcabcbb";// "dvdfdsffgrtujrerxgsdf";
		Le_003_Longest_Substring_Without_Repeating_Characters test = new Le_003_Longest_Substring_Without_Repeating_Characters();
		System.out.println(test.lengthOfLongestSubstring(s));
		System.out.println(test.lengthOfLongestSubstring2(s));
	}
}
