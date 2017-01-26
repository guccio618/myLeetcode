import java.util.HashMap;
import java.util.Map;
/**********
 * 
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
	Given "egg", "add", return true.	
	Given "foo", "bar", return false.
	Given "paper", "title", return true.

Note:
	You may assume both s and t have the same length.
	
 * 
 * */

public class Q205_Isomorphic_Strings {
	// solution 1: 
	public boolean isIsomorphic(String s, String t) {
        if(s == null || s.length() == 0){
            if(t == null || t.length() == 0){
                return true;
            } else {
                return false;
            }
        } else if(t == null || t.length() != s.length()){
            return false;
        }
        
        Map<Character, Character> map = new HashMap<Character, Character>();
        int len = s.length();
        
        for(int i = 0; i < len; i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if(map.containsKey(c1)){
                if(map.get(c1) != c2){
                    return false;
                }
            } else if(map.containsValue(c2)){
                return false;
            } else {
                map.put(c1, c2);
            }
        }
        
        return true;
    }
	
	
	
	// solution 2: using two maps
	public boolean isIsomorphic2(String s, String t) {
        if(s == null || s.length() == 0){
            if(t == null || t.length() == 0){
                return true;
            } else {
                return false;
            }
        } else if(t == null || t.length() != s.length()){
            return false;
        }
        
        Map<Character, Character> map1 = new HashMap<Character, Character>();
        Map<Character, Character> map2 = new HashMap<Character, Character>();
        int len = s.length();
        
        for(int i = 0; i < len; i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if(map1.containsKey(c1)){
                if(map1.get(c1) != c2){
                    return false;
                } else if(!map2.containsKey(c2) || map2.get(c2) != c1){
                    return false;
                }
            } else {
                if(map2.containsKey(c2)){
                    return false;
                } else {
                    map1.put(c1, c2);
                    map2.put(c2, c1);
                }
            }
        }
        
        return true;
    }
	
	
	
	/*********************************************************
	 * 用hash[256]代替map，适用于任何character的信息记录
	 * 
	 *********************************************************/
	// solution 3: using hash[i], faster
	public boolean isIsomorphic3(String s1, String s2) {
        int[] hash = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (hash[c1] != hash[c2 + 256]) {
                return false;
            }
            hash[c1] = hash[c2 + 256] = i+1;   // 这里必须使用i+1，区别于hash数组默认的初始值0， 例如test case: aa, ab
        }
        return true;
    }
}
