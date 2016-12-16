import java.util.HashMap;
import java.util.Map;


public class Q205_Isomorphic_Strings {
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
	
	
	
	/**********************************************************/
	// by Jackie using two maps
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
	
	
	
	/**********************************************************/
	// by other using hash[i], faster
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
