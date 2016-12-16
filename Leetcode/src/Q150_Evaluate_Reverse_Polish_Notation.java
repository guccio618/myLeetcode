import java.util.Stack;


public class Q150_Evaluate_Reverse_Polish_Notation {
	// by Jackie
	public int evalRPN(String[] tokens) {
		if(tokens.length == 0) return 0;
        Stack<Integer> s = new Stack<>();
        int str_len = tokens.length, oper1, oper2;
        for(int i = 0; i < str_len; i++){
            if(tokens[i].equals("+")) 
                s.push(s.pop() + s.pop());
            else if(tokens[i].equals("*")) 
                s.push(s.pop() * s.pop());
            else if(tokens[i].equals("-")) {
                oper2 = s.pop();
            	oper1 = s.pop();
            	s.push(oper1 - oper2);
            }
            else if(tokens[i].equals("/")) {
            	oper2 = s.pop();
            	oper1 = s.pop();
            	s.push(oper1 / oper2);
            }
            else s.push(Integer.parseInt(tokens[i]));  
        }
        
        System.out.println(Integer.MAX_VALUE + ", " + Integer.MIN_VALUE);
        return s.pop();
    }
	
	public static void main(String[] args){
		Q150_Evaluate_Reverse_Polish_Notation e = new Q150_Evaluate_Reverse_Polish_Notation();
		String[] strs = {"4", "13", "5", "/", "+"};
		System.out.println(e.evalRPN(strs));
	}
}
