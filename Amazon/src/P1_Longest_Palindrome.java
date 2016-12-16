
public class P1_Longest_Palindrome {
	public static String longestPalindrome(String s) {
		if(s == null || s.length() <= 1) {
			return s;
		}
		
		int[] array = new int[2];
		
		for(int i = 0; i < s.length() - 1; i++) {
			getPalindrome(array, s, i, i);
			getPalindrome(array, s, i, i+1);
		}
		
		return s.substring(array[0], array[0] + array[1]);
	}

	public static void getPalindrome(int[] array, String s, int start, int end) {
		while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;	
		}
		
		if(end - start - 1 > array[1]) {
			array[1] = end - start - 1;
			array[0] = start + 1;
		}
	}
}
