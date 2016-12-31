import java.util.HashMap;


public class Lecture4_Two_Pointers_10_Longest_Substring_with_At_Most_K_Distinct_Characters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || k <= 0){
            return 0;
        } 
        int maxLen = 0;
        int slow = 0;
        char[] array = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int fast = 0; fast < array.length; ++fast){
            if(map.containsKey(array[fast])){
                map.put(array[fast], map.get(array[fast]) + 1);
            } else {
                map.put(array[fast], 1);
                while(map.size() > k){
                    char slowChar = array[slow++];
                    int count = map.get(slowChar);
                    if(count == 1){
                        map.remove(slowChar);
                    } else {
                        map.put(slowChar, count - 1);
                    }
                }
            }
            maxLen = Math.max(maxLen, fast - slow + 1);
        }
        
        return maxLen;
    }
}
