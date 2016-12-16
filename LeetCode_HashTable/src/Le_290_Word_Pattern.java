import java.util.HashMap;
import java.util.Map;


public class Le_290_Word_Pattern {
	// by Jackie using two maps
	public boolean wordPattern2(String pattern, String str) {
        if(pattern == null || pattern.length() == 0){
            if(str == null || str.length() == 0){
                return true;
            } else {
                return false;
            }
        }
        
        String[] strArray = str.split("\\s");
        int n = strArray.length;
        if(n != pattern.length()){
            return false;
        }
        
        Map<Character, String> map1 = new HashMap<Character, String>();
        Map<String, Character> map2 = new HashMap<String, Character>();
        
        for(int i = 0; i < n; i++){
            char c = pattern.charAt(i);
            if(map1.containsKey(c) && !map2.containsKey(strArray[i])){
                return false;
            } else if(!map1.containsKey(c) && map2.containsKey(strArray[i])){
                return false;
            } else if(!map1.containsKey(c)){
                map1.put(c, strArray[i]);
                map2.put(strArray[i], c);
            } else {
                if(!map1.get(c).equals(strArray[i]) || map2.get(strArray[i]) != c){
                    return false;
                }
            }
        }
        
        return true;
    }
	
	
	public static void main(String[] args){
		Le_290_Word_Pattern t = new Le_290_Word_Pattern();
		String str1 = "abba";
		String str2 = "dog cat cat dog";
		
		System.out.println(t.wordPattern2(str1, str2));
	}
}
