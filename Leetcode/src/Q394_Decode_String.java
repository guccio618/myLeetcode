import java.util.Stack;
/*****
 * 
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside 
the square brackets is being repeated exactly k times. Note that k is guaranteed 
to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, 
square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits 
and that digits are only for those repeat numbers, k. For example, there won't be 
input like 3a or 2[4].

Examples:
	s = "3[a]2[bc]", return "aaabcbc".
	s = "3[a2[c]]", return "accaccacc".
	s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

 * 
 * */

public class Q394_Decode_String {
	// test case:
	//	s = "3[a]2[bc]", return "aaabcbc".
	//	s = "3[a2[c]]", return "accaccacc".
	//	s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
	
	// using DFS
	public String decodeString(String s) {
		if(s == null || s.length() == 0) {
            return "";
        }
        
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c != ']') {
                stack.push(String.valueOf(c));
            } else {
                StringBuilder strBuilder = new StringBuilder();
                
                while(!stack.isEmpty() && !stack.peek().equals("[")) {
                    strBuilder.insert(0, stack.pop());
                }
                
                stack.pop();  // pop(): c = '['
                StringBuilder timeBuilder = new StringBuilder();
                
                // is a digit and the length is equal to 1
                while(!stack.isEmpty() && stack.peek().length() == 1 && Character.isDigit(stack.peek().charAt(0))) {
                    timeBuilder.insert(0, stack.pop());
                }
                
                int time = Integer.parseInt(timeBuilder.toString());
                String str = strBuilder.toString();
                
                for(int j = 1; j < time; j++) {  // j从1开始 ！！！
                    strBuilder.append(str);
                }
                
                stack.push(strBuilder.toString());
            }
        }
        
        StringBuilder sb = new StringBuilder();
		
		while (!stack.empty()) {
		    sb.insert(0, stack.pop());
		}
		
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	/************************* main function ******************************/
	// by other using stack, faster
	public String decodeString2(String s) {
		if(s == null || s.length() == 0){
        	return "";
        } else if(s.indexOf("[", 0) < 0){
			return s;
		}
		
		int len = s.length();
		Stack<Integer> countStack = new Stack<Integer>();
		Stack<String> stringStack = new Stack<String>();
		String current = "";
		int index = 0;
		
		while(index < len){
			char c = s.charAt(index);
			
			if(Character.isDigit(c)){
				int count = 0;
				
				while(index < len && Character.isDigit(s.charAt(index))){
					count = count * 10 + (s.charAt(index) - '0');
					index++;
				}
				
				countStack.push(count);
			} else if(c == '['){   
				if(current.length() > 0){
					stringStack.push(current);
					current = "";
				}
				
				index++;                // 即使current == ""， 保证指针继续往前移，防止test case: 3[a]2[bc]
			} else if(c == ']'){
				StringBuilder builder = new StringBuilder();
				int repeatTime = countStack.pop();
				
				if(!stringStack.isEmpty()){
					builder.append(stringStack.pop());
				}
				
				for(int i = 0; i < repeatTime; i++){
					builder.append(current);
				}
				
				current = builder.toString();
				index++;
			} else {
				current += s.charAt(index);
				index++;
			}
		}
		
		return current;
	}
	
	
	
	/*******************************************************/
	// by Jackie using recursion
	public String decodeString3(String s) {
        if(s == null || s.length() == 0){
        	return "";
        } else if(s.indexOf("[", 0) < 0){
			return s;
		}

		int startIndex = 0;
		StringBuilder builder = new StringBuilder();
				
		while(startIndex < s.length()){
			int numberStart = startIndex;
			startIndex = s.indexOf("[", startIndex);
			
			if(startIndex < 0){
				builder.append(s.substring(numberStart));
				break;
			} 
			
			while(!Character.isDigit(s.charAt(numberStart))){
				builder.append(s.charAt(numberStart));
				numberStart++;
			}
			
			int nextTime = 1;
			
			if(Character.isDigit(s.charAt(startIndex - 1))){
				nextTime = Integer.parseInt(s.substring(numberStart, startIndex));	
			}
			
			int count = 0;
			int endIndex = startIndex;
			
			while(endIndex < s.length()){
				char c = s.charAt(endIndex);
				
				if(c == '['){
					count++;
				} else if(c == ']'){
					count--;
				}
				
				if(count == 0){
					break;
				}
				
				endIndex++;
			}
			
			StringBuilder subBuilder = new StringBuilder();
			String subStr = decodeString(s.substring(startIndex + 1, endIndex));
			
			for(int i = 0; i < nextTime; i++){
				subBuilder.append(subStr);
			}
			
			builder.append(subBuilder);
			startIndex = endIndex + 1;
		}
		
        return builder.toString();
    }
	
	
	
	public static void main(String[] args){
		Q394_Decode_String t = new Q394_Decode_String();
		String s1 = "3[a]2[bc]";
		String s2 = "3[a2[c]]";
		String s3 = "ef2[abc]3[cd]ef";
		String s4 = "";
		System.out.println(t.decodeString(s1));
	}
}
