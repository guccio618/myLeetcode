import java.util.HashMap;
import java.util.Map;


public class Q386_Longest_Substring_with_At_Most_K_Distinct_Characters {
	// by ninechapter
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
   		int slow = 0;
		int maxLen = 0;

		// Key: letter;   value: the number of occurrences.
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int fast;
		for (fast = 0; fast < s.length(); ++fast) {
			char c = s.charAt(fast);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
				while (map.size() > k) {
					char slowChar = s.charAt(slow++);
					int count = map.get(slowChar);
					if (count > 1) {
						map.put(slowChar, count - 1);
					} else {
						map.remove(slowChar);
					}
				}
			}
			maxLen = Math.max(maxLen, fast - slow + 1);
		}

		return maxLen;
	}
	
	
	public static void main(String[] args){
		Q386_Longest_Substring_with_At_Most_K_Distinct_Characters t = new Q386_Longest_Substring_with_At_Most_K_Distinct_Characters();
		String s = "eqgkcwGFvjj";
		System.out.println(t.lengthOfLongestSubstringKDistinct(s, 5));
	}
}
