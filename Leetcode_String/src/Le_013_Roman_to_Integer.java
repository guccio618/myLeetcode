import java.util.HashMap;
import java.util.Map;


public class Le_013_Roman_to_Integer {
	/*******************************************/
	// by Jackie using int[] hash
	public int romanToInt(String s) {
		if (s == null || s.length()==0) {
	    	return 0;
	    }
	    
	    int[] hash = new int[256];
	    hash[(int)('I')] = 1;
	    hash[(int)('V')] = 5;
	    hash[(int)('X')] = 10;
	    hash[(int)('L')] = 50;
	    hash[(int)('C')] = 100;
	    hash[(int)('D')] = 500;
	    hash[(int)('M')] = 1000;
	    
	    int len = s.length();
	    char[] letters = s.toCharArray();
	    int ans = hash[s.charAt(len - 1)];
	    
	    for(int i = len - 2; i >= 0; i--){
	        char c1 = s.charAt(i);
	        char c2 = s.charAt(i + 1);
	        
	        if(hash[c1] >= hash[c2]){      // 注意有等号 ！！！
	            ans += hash[c1];
	        } else {
	            ans -= hash[c1];
	        }
	    }
	    
	    return ans;
    }
	
	
	
	/*******************************************/
	// by other
	public int romanToInt2(String s) {
	    if (s == null || s.length()==0) {
	    	return 0;
	    }

	    Map<Character, Integer> m = new HashMap<Character, Integer>();
	    m.put('I', 1);
	    m.put('V', 5);
	    m.put('X', 10);
	    m.put('L', 50);
	    m.put('C', 100);
	    m.put('D', 500);
	    m.put('M', 1000);

	    int length = s.length();
	    int result = m.get(s.charAt(length - 1));
	    for (int i = length - 2; i >= 0; i--) {
	        if (m.get(s.charAt(i + 1)) <= m.get(s.charAt(i))) {
	            result += m.get(s.charAt(i));
	        } else {
	            result -= m.get(s.charAt(i));
	        }
	    }
	    return result;
	}
}
