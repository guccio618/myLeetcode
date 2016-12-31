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

public class Q224_Basic_Calculator {
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
}
