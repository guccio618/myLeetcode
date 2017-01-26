import java.util.Stack;


public class Other_Max_Stack {
	private Stack<Integer> stack;
	private Stack<Integer> maxStack;
	
	public Other_Max_Stack() {
		stack = new Stack();
		maxStack = new Stack();
	}
	
	public void push(int x) {
		stack.push(x);
		
		if(!maxStack.isEmpty()) {
			maxStack.push(Math.max(x, maxStack.peek()));
		} else {
			maxStack.push(x);
		}
	} 
	
	public void pop() {
		if(stack.isEmpty()) {
			return;
		} 
		
		stack.pop();
	}
	
	public int top() {
		if(stack.isEmpty()) {
			return -1;
		}
		
		return stack.peek();
	}
	
	public int getMin() {
		if(maxStack.isEmpty()) {
			return -1;
		}
		
		return maxStack.peek();
	}
}
