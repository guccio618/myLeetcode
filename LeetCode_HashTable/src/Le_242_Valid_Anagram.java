import java.util.*;

public class Le_242_Valid_Anagram {
	// using sort, time is O(nlogn), space is O(n)
	public boolean isAnagram(String s, String t) {
        if(s == null && t == null) {
            return true;
        } else if(s == null || t == null) {
            return false;
        } else if(s.length() != t.length()) {
            return false;
        }
        
        char[] letters1 = s.toCharArray();
        char[] letters2 = t.toCharArray();
        Arrays.sort(letters1);
        Arrays.sort(letters2);
        
        for(int i = 0; i < letters1.length; i++) {
            if(letters1[i] != letters2[i]) {
                return false;
            }
        }
        
        return true;
    }
	
	
	
	// follow up: using hashtable, time is O(n), space is O(256)
	public boolean isAnagram2(String s, String t) {
        if(s == null && t == null) {
            return true;
        } else if(s == null || t == null) {
            return false;
        } else if(s.length() != t.length()) {
            return false;
        }
        
        int[] hash1 = new int[256];
        int[] hash2 = new int[256];
        
        for(int i = 0; i < s.length(); i++) {
            hash1[s.charAt(i)]++;
            hash2[t.charAt(i)]++;
        }
        
        for(int i = 0; i < 256; i++) {
            if(hash1[i] != hash2[i]) {
                return false;
            }
        }
        
        return true;
    }
	
	
}
