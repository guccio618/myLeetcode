import java.util.*;
/**********
 * 
Given a string, find the first non-repeating character in it and return it's index. 
If it doesn't exist, return -1.

Examples:

	s = "leetcode"
	return 0.

	s = "loveleetcode",
	return 2.

Note: 
	You may assume the string contain only lowercase letters.

 * 
 * 
 * */

public class Q387_First_Unique_Character_in_a_String {
	// using hashtable, time is O(2*n), space is O(n)
	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}

		int[] hash = new int[256];

		for (char c : s.toCharArray()) {
			hash[c]++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (hash[s.charAt(i)] == 1) {
				return i;
			}
		}

		return -1;
	}

	
	
	
	// using hashmap, time is O(n), space is O(n)
	public int firstUniqChar2(String s) {
        if(s == null || s.length() == 0) {
            return -1;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int ansPos = Integer.MAX_VALUE;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(map.containsKey(c)) {
                map.put(c, -1);
            } else {
                map.put(c, i);
            }
        }
        
        for(int i = 0; i < 256; i++) {
            char c = (char) i;
            
            if(map.containsKey(c) && map.get(c) > -1) {
                ansPos = Math.min(ansPos, map.get(c));
            }
        }
        
        return ansPos == Integer.MAX_VALUE ? -1 : ansPos;
    }
}
