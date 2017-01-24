/********
 * 
Given a string, determine if a permutation of the string could form a palindrome.

For example,
	"code" -> False, "aab" -> True, "carerac" -> True.
	
 * 
 * */

public class Q266_Palindrome_Permutation {
	public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        
        int[] hash = new int[256];
        int count = 0;
        
        for (char c : s.toCharArray()) {
            hash[c]++;
        }
        
        for (int i = 0; i < 256; i++) {
            if (hash[i] % 2 == 1) {
                count++;
            }
        }
        
        return count <= 1;
    }
}
