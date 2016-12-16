import java.util.Stack;
/*****
 * 
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators 
and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
	"3+2*2" = 7
	" 3/2 " = 1
	" 3+5 / 2 " = 5

	Note: Do not use the eval built-in library function.

 * 
 * */

public class Le_227_Basic_Calculator_II {
	public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int n = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char preSign = ' ';
        
        for(int i = 0; i < n; ++i){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num * 10 + (int)(c - '0');
            }
            
            if(!Character.isDigit(c) && c != ' ' || i == n - 1){
                if(preSign == '+'){
                    stack.push(num);
                } else if(preSign == '-'){
                    stack.push(-num);
                } else if(preSign == '*'){
                    stack.push(stack.pop() * num);
                } else if(preSign == '/'){
                    stack.push(stack.pop() / num);
                } else {
                    stack.push(num);
                }
                preSign = c;
                num = 0;
            }
            
        }
        
        num = 0;
        while(!stack.isEmpty()){
            num += stack.pop();
        }
        
        return num;
    }
	
	
	
	/*************************************************/
	// by Jackie
	public int calculate2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int n = s.length();
        int index = 0;
        int num = 0;
        char flag = '+';
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                num = num * 10 + c - '0';
            }
            if(c == '+' || c == '-' || c == '*' || c == '/' || i == n - 1){
                if(flag == '+'){
                    stack.push(num);
                } else if(flag == '-'){
                    stack.push(-num);
                } else if(flag == '*'){
                    if(!stack.isEmpty()){
                        int num2 = stack.pop();
                        stack.push(num2 * num);
                    }
                } else if(flag == '/'){
                    if(!stack.isEmpty()){
                        int num2 = stack.pop();
                        stack.push(num2 / num);
                    }
                }
                flag = c;
                num = 0;
            } 
        }
        
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        
        return ans;
    }
	
	
	
	
	
	
	public static void main(String[] args){
		Le_227_Basic_Calculator_II b = new Le_227_Basic_Calculator_II();
		String a = "3+5 / 2 ";
        System.out.println("res = " + b.calculate(a));
	}
	
}
