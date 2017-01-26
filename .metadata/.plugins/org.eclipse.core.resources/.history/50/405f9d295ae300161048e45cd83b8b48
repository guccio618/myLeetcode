/*******
 * 
Given an input string, reverse the string word by word.

For example,
	Given s = "the sky is blue",
	return "blue is sky the".
 * 
 * */

public class Q151_Reverse_Words_in_a_String {
	// solution 1:
	public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        
        s = s.trim();
        String[] strs = s.split("\\s{1,}");
        StringBuffer sb = new StringBuffer();
        int n = strs.length;
        
        for(int i = n - 1; i > 0; --i){
            sb.append(strs[i]).append(" ");
        }
        
        if(strs.length > 0){
            sb.append(strs[0]);
        }
        
        return sb.toString();
    }
	
	
	
	// solution 2: faster
	public String reverseWords2(String s) {
        if(s == null || s.length() == 0){
            return "";
        }   
        
        s = s.trim();
        char[] array = s.toCharArray();
        int len = array.length;
        int front = 0, back = 0;
        StringBuilder builder = new StringBuilder();
        
        reverseArray(array, 0, len - 1);
        
        while(front < len){
            while(front < len && array[front] == ' '){
                front++;
            }
            
            back = front;
            
            while(front < len && array[front] != ' '){
                front++;
            }
            
            if(builder.length() > 0){
                builder.append(" ");
            }
            
            for(int i = front - 1; i >= back; i--){
                builder.append(array[i]);
            }
        }
        
        return builder.toString();
    }
    
    public void reverseArray(char[] array, int start, int end){
        while(start < end){
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
	
	
	
	/******************************************************/
	// by Jackie
	public String reverseWords3(String s) {
		if(s == null || s.length() == 0){
            return s;
        }
        
        s = s.trim();
        int len = s.length();
        char[] letters = s.toCharArray();
        int front = 0, back = 0;
        StringBuilder builder = new StringBuilder();
        
        reverseStr(letters, 0, len - 1);
        
        while(front < len){
            if(letters[front] == ' '){
                front++;
                continue;
            } else {
                back = front;
                
                while(front < len && letters[front] != ' '){
                    front++;
                }

                if(builder.length() != 0){
                    builder.append(" ");
                }
                
                for(int i = front - 1; i >= back; i--){
                    builder.append(letters[i]);
                }
            }
        }
        
        return builder.toString();
    }
    
    public void reverseStr(char[] letters, int start, int end){
        char temp = ' ';
        
        while(start < end){
            temp = letters[start];
            letters[start] = letters[end];
            letters[end] = temp;
            start++;
            end--;
        }
    }
	
	
    
    
    
    
    
    
    
    /****************************** main function ************************************/
    
	public static void main(String[] args){
		Q151_Reverse_Words_in_a_String t = new Q151_Reverse_Words_in_a_String();
		System.out.print("*");
//		System.out.println(t.reverseWords(" a b "));
		System.out.print(t.reverseWords3("   a   b "));    // test case: {" 1"}, {   a   b }
		System.out.print("*");
	}
}
