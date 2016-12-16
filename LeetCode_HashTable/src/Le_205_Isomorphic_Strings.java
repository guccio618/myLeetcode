import java.util.HashMap;
import java.util.Map;
/*********************************************************
 * 用hash[256]代替map，适用于任何character的信息记录
 * 
 *********************************************************/

public class Le_205_Isomorphic_Strings {
	/**********************************************************/
	// by other using hash[i], faster
	public boolean isIsomorphic(String s1, String s2) {
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
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if(map1.containsKey(c1) && !map2.containsKey(c2)){
                return false;
            } else if(!map1.containsKey(c1) && map2.containsKey(c2)){
                return false;
            } else if(!map1.containsKey(c1)){
                map1.put(c1, c2);
                map2.put(c2, c1);
            } else {
                if(map1.get(c1) != c2 || map2.get(c2) != c1){
                    return false;
                }
            }
        }
        
        return true;
    }
}
