import java.util.Stack;
/******
 * 
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), 
the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
	"1 + 1" = 2
	" 2-1 + 2 " = 3
	"(1+(4+5+2)-3)+(6+8)" = 23

Note: Do not use the eval built-in library function.

 * 
 * */

public class Le_224_Basic_Calculator {
	public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        char preSign = ' ';
        int ans = 0;
        int num = 0;
        
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num * 10 + (int)(c - '0');
            } 
            
            if(!Character.isDigit(c) && c != ' ' || i == len - 1){
                if(preSign == '+'){
                    stack.push(num);
                } else if(preSign == '-'){
                    stack.push(-num);
                } else if(preSign == '*'){
                    if(!stack.isEmpty()){
                        stack.push(stack.pop() * num);
                    } else {
                        break;
                    }
                } else if(preSign == '/'){
                    if(!stack.isEmpty()){
                        stack.push(stack.pop() / num);
                    } else {
                        break;
                    }
                } else {
                    stack.push(num);
                }
                
                preSign = c;
                num = 0;
            } 
        }
        
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        
        return ans;
    }
	
	
	
	// follow up, if str contains "(" and  ")" 
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
	
}
