public class Q21_1_Remove_Invalid_Parentheses {
	public String removeInvalidParentheses(String str) {
		if(str == null || str.length() == 0 || str.length() % 2 != 0) {
			return "";
		}
		
		char[] array = str.toCharArray();
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] == '(' && array[i + 1] == '(') {
				int endPos1 = getClosePos(str, i);
				int endPos2 = getClosePos(str, i + 1);
				
				if(endPos1 - 1 == endPos2) {
					array[i] = array[endPos1] = ' ';
				}
			}
		}
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] == ' ') {
				continue;
			}
			
			builder.append(array[i]);
		}
		
		return builder.toString();
	}
	
	public int getClosePos(String s, int start) {
		int count = 0;
		
		for(int i = start; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				count++;
			} else if(s.charAt(i) == ')') {
				count--;
			}
			
			if(count == 0) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/********************************** main function **************************************/
	
	public static void main(String[] args) {
		Q21_1_Remove_Invalid_Parentheses t = new Q21_1_Remove_Invalid_Parentheses();
		
		String[] strs = {
				"(()())",
				"((()))",
				"(()())(()())",
				"((()())(()()))",
				"())"
		};
		
		
		for(String str : strs) {
			System.out.println(t.removeInvalidParentheses(str));
		}
	}
}
