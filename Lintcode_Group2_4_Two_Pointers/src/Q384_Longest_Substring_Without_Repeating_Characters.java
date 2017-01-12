import java.util.HashMap;


public class Q384_Longest_Substring_Without_Repeating_Characters {
	// by Jackie
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] array = s.toCharArray();
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int prePos = 0;
        int maxLen = 1;
        
        for(int i = 0; i < len; ++i){
            if(!map.containsKey(array[i])){
                map.put(array[i], i);
            } else {
            	int temp = map.get(array[i]);
                if(temp < prePos){                       // 从prePos开始查重，prePos之前的重复不算
                    map.put(array[i], i);
                } else {
                    maxLen = Math.max(maxLen, i - prePos);
                    prePos = map.get(array[i]) + 1;      // 从发现重复的字符的下一个位置开始
                    map.put(array[i], i);
                }
            }
        }
        maxLen = Math.max(maxLen, len - prePos);
        return maxLen;
    }
	
	
	public static void main(String[] args){
		Q384_Longest_Substring_Without_Repeating_Characters t = new Q384_Longest_Substring_Without_Repeating_Characters();
		String s = "an++--viaj";
		System.out.println(t.lengthOfLongestSubstring(s));
	}
}
