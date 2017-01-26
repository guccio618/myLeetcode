import java.util.Stack;
/*******
 * 
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  	["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  	["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  	
 * 
 * */

public class Le_150_Evaluate_Reverse_Polish_Notation {
	// solution 1: using stack
	public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(String str : tokens) {
            if(str.equals("+")) {
                if(stack.size() < 2) {
                    return -1;
                } else {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 + num2);
                }
            } else if(str.equals("-")) {
                if(stack.size() < 2) {
                    return -1;
                } else {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 - num2);
                }
            } else if(str.equals("*")) {
                if(stack.size() < 2) {
                    return -1;
                } else {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 * num2);
                }
            } else if(str.equals("/")) { 
                if(stack.size() < 2) {
                    return -1;
                } else {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 / num2);
                }
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        
        return stack.size() == 1 ? stack.pop() : -1;
    }
	
	
	
	
	
	
	
	
	
	
	/******************************* main function **********************************/
	
	public static void main(String[] args){
		Le_150_Evaluate_Reverse_Polish_Notation e = new Le_150_Evaluate_Reverse_Polish_Notation();
		String[] strs = {"4", "13", "5", "/", "+"};
		System.out.println(e.evalRPN(strs));
	}
}
