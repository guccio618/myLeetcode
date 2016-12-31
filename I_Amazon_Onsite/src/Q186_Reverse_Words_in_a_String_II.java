/*****
 * 
Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

The input string does not contain leading or trailing spaces and the words are always separated by a single space.

For example,
	Given s = "the sky is blue",
	return "blue is sky the".

	Could you do it in-place without allocating extra space?
	
 * 
 * */


public class Q186_Reverse_Words_in_a_String_II {
	// test case:
    // how many blanks between two words
    // s is empty
    
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0) {
            return ;
        }
        
        reverse(s, 0, s.length - 1);
        int len = s.length;
        int front = 0, back = 0;
        
        while(back < len) {
            while(back < len && s[back] == ' ') {
                back++;
            }
            
            front = back;
            
            while(front < len && s[front] != ' ') {
                front++;
            }
            
            reverse(s, back, front - 1);
            back = front;
        }
    }
    
    public void reverse(char[] s, int start, int end) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    
    
    
    
    
    
    /********************************* main function ********************************/
    
    public static void main(String[] str){
    	Q186_Reverse_Words_in_a_String_II t = new Q186_Reverse_Words_in_a_String_II();
    	String s = "a, yqo! qjktum ym. .fumuhau";
    	char[] array = s.toCharArray();
    	t.reverseWords(array);
    	
    	for(int i = 0; i < array.length; i++){
    		System.out.print(array[i]);
    	}
    	System.out.println();
    }
}
