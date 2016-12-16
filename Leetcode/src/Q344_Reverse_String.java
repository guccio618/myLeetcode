/******
 * 
Write a function that takes a string as input and returns the string reversed.

Example:
	Given s = "hello", return "olleh".
 * 
 * */

public class Q344_Reverse_String {
	public String reverseString(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        
        char[] letters = s.toCharArray();
        int left = 0, right = letters.length - 1;
        
        while(left < right) {
            char temp = letters[left];
            letters[left] = letters[right];
            letters[right] = temp;
            left++;
            right--;
        }
        
        return new String(letters);
    }
}
