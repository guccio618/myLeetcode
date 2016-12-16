import java.util.*;
/*****
 * 
Given a string representing arbitrarily nested ternary expressions, 
calculate the result of the expression. You can always assume that 
the given expression is valid and only consists of 
digits 0-9, ?, :, T and F (T and F represent True and False respectively).

Note:
	The length of the given string is ≤ 10000.
	Each number will contain only one digit.
	The conditional expressions group right-to-left (as usual in most languages).
	The condition will always be either T or F. That is, the condition will never be a digit.
	The result of the expression will always evaluate to either a digit 0-9, T or F.

Example 1:
	Input: "T?2:3"
	Output: "2"
	Explanation: If true, then result is 2; otherwise result is 3.

Example 2:
	Input: "F?1:T?4:5"
	Output: "4"
	Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

             "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
          -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
          -> "4"                                    -> "4"

Example 3:
	Input: "T?T?F:5:3"
	Output: "F"
	Explanation: The conditional expressions group right-to-left. Using parenthesis, it is read/evaluated as:

             "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
          -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
          -> "F"                                    -> "F"
 
 * 
 * */

public class Q439_Ternary_Expression_Parser {
	public String parseTernary(String expression) {
        if(expression == null || expression.length() == 0) {
            return "";
        }
        
        Stack<String> stack = new Stack();
        stack.push(expression);
        
        while(!stack.isEmpty()) {
            String str = stack.pop();
            int start = str.indexOf("?", 0);
            
            if(start == -1) {
                return str;
            } else if(start != 1) {
                return "";
            }
            
            String part1 = str.substring(0, start);
            int end = findPos(str, start);
            
            if(end == -1) {
                return "";
            }
            
            String part2 = str.substring(start + 1, end);
            String part3 = str.substring(end + 1);           
            
            if(part1.equals("T")) {
                stack.push(part2);
            } else {
                stack.push(part3);
            }
        }
        
        return "";
    }
    
    public int findPos(String str, int start) {
        int count = 0;
        
        while(start < str.length()) {
            char c = str.charAt(start);
            
            if(c == '?') {
                count++;
            } else if(c == ':') {
                count--;
            }
            
            if(count == 0) {
                return start;
            }
            
            start++;
        }
        
        return -1;
    }
    
    
    
    
    
    
    
    /******************* main function ***********************/
    public static void main(String[] args) {
    	Q439_Ternary_Expression_Parser t = new Q439_Ternary_Expression_Parser();
    	String expression1 = "F?1:T?4:5";
    	String expression2 = "T?T?F:5:3";
    	System.out.println(t.parseTernary(expression2));
    }
}
