/******
 * 
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
	S = "ADOBECODEBANC"
	T = "ABC"
	Minimum window is "BANC".

Note:
	If there is no such window in S that covers all characters in T, return the empty string "".

	If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

 * 
 * */


public class Le_076_Minimum_Window_Substring {
	// solution 1: time O(256 * n), space O(n)
	public String minWindow(String s, String t) {
        if(s == null || t == null || t.length() > s.length()) {
            return "";
        }
        
        int[] sHash = new int[256];
        int[] tHash = new int[256];
        
        for(char c : t.toCharArray()) {
            tHash[c]++;
        }
        
        int front = 0;
        int len = s.length();
        int minLen = Integer.MAX_VALUE;
        int startPos = 0;
        
        for(int back = 0; back < len; back++) {
            while(front < len && !isValid(sHash, tHash)) {
                sHash[s.charAt(front)]++;
                front++;
            }
            
            if(isValid(sHash, tHash) && minLen > front - back) {
                minLen = front - back;
                startPos = back;
            }
            
            sHash[s.charAt(back)]--;
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startPos, startPos + minLen);
    }
    
    public boolean isValid(int[] sHash, int[] tHash) {
        for(int i = 0; i < 256; i++) {
            if(sHash[i] < tHash[i]) {
                return false;
            }
        }
        
        return true;
    }
   
    
    // solution 2: time O(n), space O(n)
    public String minWindow2(String s, String t) {
        if(s == null || t == null || t.length() > s.length()) {
            return "";
        }
        
        int[] sHash = new int[256];
        int[] tHash = new int[256];
        int tDistinctCharCount = 0;
        
        for(char c : t.toCharArray()) {
            tHash[c]++;
            
            if(tHash[c] == 1) {
                tDistinctCharCount++;
            }
        }
        
        int curCount = 0;
        int front = 0;
        int len = s.length();
        int minLen = Integer.MAX_VALUE;
        int startPos = 0;
        
        for(int back = 0; back < len; back++) {
            while(front < len && curCount < tDistinctCharCount) {
                char c = s.charAt(front++);
                
                if(++sHash[c] == tHash[c]) {
                    curCount++;
                }
            }
            
            if(curCount == tDistinctCharCount && minLen > front - back) {
                minLen = front - back;
                startPos = back;
            }
            
            if(sHash[s.charAt(back)]-- == tHash[s.charAt(back)]) {
                curCount--;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startPos, startPos + minLen);
    }
   
    
    
    
    
    
    
    
    
    
    
    /*********************************** main function **************************************/
   
    public static void main(String[] args){
	   Le_076_Minimum_Window_Substring t = new Le_076_Minimum_Window_Substring();
	   String s = "a";
	   String target = "a";
	   
	   System.out.println(t.minWindow(s, target));
   }
}
