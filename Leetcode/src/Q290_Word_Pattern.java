import java.util.HashMap;
import java.util.Map;


public class Q290_Word_Pattern {
	/***************************************/
	// by other using one hashmap
	public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null){
            if(pattern == null && str == null){
                return true;
            } else {
                return false;
            }
        }
        
        String[] array = str.split("\\s{1,}");
        
        if(pattern.length() != array.length){
            return false;
        }
        
        Map<Character, String> map = new HashMap<Character, String>();
        char[] letters = pattern.toCharArray();
        int len = letters.length;
        
        for(int i = 0; i < len; i++){
            if(map.containsKey(letters[i])){
                if(!map.get(letters[i]).equals(array[i])){
                    return false;
                }
            } else if(map.containsValue(array[i])){
                return false;
            } else {
                map.put(letters[i], array[i]);
            }
        }
        
        return true;
    }
	
	
	
	/***************************************/
	// by jackie using two hashmap
	public boolean wordPattern2(String pattern, String str) {
		if(pattern == null || pattern.length() == 0){
			return false;
		}
        if(str == null || str.length() == 0){
        	return false;
        }
        
        String[] arr= str.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
        if(arr.length!= pattern.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }    
        }
        return true;      
    }
	
	
	
	/**********************************************************/
	//by jackie
	public boolean wordPattern3(String pattern, String str) {
        if(pattern == null || pattern.length() == 0) return false;
        if(str == null || str.length() == 0) return false;
        
        String[] wordArray = str.split("\\s{1,}");
        if(pattern.length() != wordArray.length) return false;
        HashMap myMap1 = new HashMap<String, Integer>();
        HashMap myMap2 = new HashMap<Character, Integer>();
        for(int i = 0; i < wordArray.length; i++) {
            if(myMap1.containsKey(wordArray[i]) == myMap2.containsKey(pattern.charAt(i))){
                if(!myMap1.containsKey(wordArray[i])){
                    myMap1.put(wordArray[i], i);
                    myMap2.put(pattern.charAt(i), i);
                }
            }
            else
                return false;
        }
        return true;
    }
	
	public static void main(String[] args){
		Q290_Word_Pattern test = new Q290_Word_Pattern();
		String pattern = "abba";
		String str = "dog cat cat fish";
		System.out.println(test.wordPattern(pattern, str));
	}
}
