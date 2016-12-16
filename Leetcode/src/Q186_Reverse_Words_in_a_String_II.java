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
	public void reverseWords(char[] s) {
        if(s == null || s.length <= 1){
            return;
        }
        
        int len = s.length;
        reverseStr(s, 0, len - 1);
        int front = 0, back = 0;
        
        while(front < len){
            if(s[front] == ' '){
                front++;
                back++;
            } else {
                while(front < len && s[front] != ' '){
                    front++;
                }
                reverseStr(s, back, front - 1);
                back = front;
            }
        }
    }
    
    public void reverseStr(char[] s, int start, int end){
        char temp = ' ';
        
        while(start < end){
            temp = s[start];
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
