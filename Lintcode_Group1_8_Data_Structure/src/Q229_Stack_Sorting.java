import java.util.Stack;


public class Q229_Stack_Sorting {
	// by Jackie
	public void stackSorting(Stack<Integer> stack) {
        if(stack == null || stack.size() == 0){
            return;
        }
        
        Stack<Integer> s2 = new Stack<Integer>();
        s2.push(Integer.MAX_VALUE);
        int memory = 0;
        
        while(!stack.isEmpty()){
            if(stack.peek() <= s2.peek()){
                s2.push(stack.pop());
            } else{
                memory = stack.pop();
                while(s2.peek() < memory){
                    stack.push(s2.pop());
                }
                s2.push(memory);
            }
        }
        
        while(s2.size() > 1){
            stack.push(s2.pop());
        }
    }
}
