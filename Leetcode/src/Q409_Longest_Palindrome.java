
public class Q409_Longest_Palindrome {
	public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        int[] hash = new int[256];
        int oddFlag = 0;
        int count = 0;
        
        for (char c : s.toCharArray()) {
            hash[c]++;
        }
        
        for (int i = 0; i < 256; i++) {
            if (hash[i] > 0) {
                count += hash[i] % 2 == 0 ? hash[i] : hash[i] - 1;
            }
            
            if (hash[i] % 2 == 1) {
                oddFlag = 1;
            }
        }
        
        return count + oddFlag;
    }
}
