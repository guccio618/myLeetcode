import java.util.*;
/********
 * 
 contains: +, -, *, /, (, )
 * 
 * */

public class Q224_Basic_Calculator_III {	
	public int Basic_Calculator_III(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		int len = str.length();
		int sum = 0;
		int num = 0;
		char prevSign = ' ';
		int index = 0;
		
		while (index < len) {
			char c = str.charAt(index);
			
			if (Character.isDigit(c)) {
				num = num * 10 + (int) (c - '0');
			} 
			
			if (!Character.isDigit(c) && c != ' ' || index == len - 1) {
				if (c == '(') {
					int endPos = findClosePosition(str, index);			
					String subStr = str.substring(index + 1, endPos);
					num = Basic_Calculator_III(subStr);	
					index = endPos + 1;
					continue;
				}
				
				if (prevSign == '+') {
					stack.push(num);
				} else if (prevSign == '-') {
					stack.push(-num);
				} else if (prevSign == '*') {
					if (!stack.isEmpty()) {
						stack.push(stack.pop() * num);
					} else {
						break;
					}
				} else if (prevSign == '/') {
					if (!stack.isEmpty()) {
						stack.push(stack.pop() / num);
					} else {
						break;
					}
				} else {
					stack.push(num);
				}
				
				prevSign = c;
				num = 0;
			}
			
			index++;
		}
		
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		
		if (num != 0) {
			if (prevSign == '+') {
				sum += num;
			} else if (prevSign == '-') {
				sum -= num;
			} else if (prevSign == '*') {
				sum *= num;
			} else if (prevSign == '/') {
				sum /= num;
			} else {            // when prevSign == ' '
				sum += num;
			}
		}
		
		return sum;
	}
	
	public int findClosePosition(String str, int start) {
		int count = 0;		
		int index = start;
		
		while (index < str.length()) {
			char c = str.charAt(index);
			
			if (c == '(') {
				count++;
			} else if (c == ')') {
				count--;
			}

			if (count == 0) {
				break;
			}
			
			index++;
		}
		
		return index;		
	}
	
	
	
	
	public static void main(String[] args) {
		Q224_Basic_Calculator_III t = new Q224_Basic_Calculator_III();
		String str = "3 * (3/(1+2))";
		System.out.println(t.Basic_Calculator_III(str));
	}
}
