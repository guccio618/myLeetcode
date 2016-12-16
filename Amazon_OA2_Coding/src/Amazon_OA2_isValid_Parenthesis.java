import java.util.*;

public class Amazon_OA2_isValid_Parenthesis {
	public boolean isValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == '('){
				stack.push(c);
			} else if(c == ')'){
				if(!stack.isEmpty() && stack.peek() == '('){
					stack.pop();
					continue;
				} else {
					return false;
				}
			}
		}
		
		return stack.empty();
	}
	
	
	
	public int longestValidParentheses(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		int len = s.length();
		Stack<Integer> stack = new Stack<Integer>();
		int maxLen = 0;
		int lastPos = -1;
		
		for(int i = 0; i < len; i++){
			char c = s.charAt(i);
			
			if(c == '('){
				stack.push(i);
			} else if(c == ')'){
				if(stack.isEmpty()){
					lastPos = i;
				} else {
					stack.pop();
					
					if(stack.isEmpty()){
						maxLen = Math.max(maxLen, i - lastPos);
					} else {
						maxLen = Math.max(maxLen, i - stack.peek());
					}
				}
			}
		}
		
		return maxLen;
	}
	
	
	public static void main(String[] args){
		Amazon_OA2_isValid_Parenthesis t = new Amazon_OA2_isValid_Parenthesis();
		String s = "((()))()";
		System.out.println(t.isValidParentheses(s));
		System.out.println(t.longestValidParentheses(s));
	}
}
