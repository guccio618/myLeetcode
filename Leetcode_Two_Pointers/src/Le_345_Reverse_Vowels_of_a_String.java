/****
 * 
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
	Given s = "hello", return "holle".

Example 2:
	Given s = "leetcode", return "leotcede".

Note:
	The vowels does not include the letter "y".
 * 
 * */


public class Le_345_Reverse_Vowels_of_a_String {
	public String reverseVowels(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }
        
        String vowels = "aeiouAEIOU";
        char[] letters = s.toCharArray();
        int left = 0, right = s.length() - 1;
        
        while(left < right) {
            while(left < right && vowels.indexOf(letters[left]) == -1) {
                left++;
            }
        
            while(left < right && vowels.indexOf(letters[right]) == -1) {
                right--;
            }
        
            char temp = letters[left];
            letters[left] = letters[right];
            letters[right] = temp;
            left++;
            right--;
        }
        
        return new String(letters);
    }
}
