import java.util.Stack;


public class Lecture8_Data_Structure_02_Implement_Queue_by_Two_Stacks {
	private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Lecture8_Data_Structure_02_Implement_Queue_by_Two_Stacks() {
       // do initialization if necessary
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    public int pop() {
        // write your code here
        if(stack2.isEmpty()){
    		while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}
    	}
    	return stack2.pop();
    }

    public int top() {     // 平均时间复杂度为O(1); 不是每次都执行O(n)的操作;
        // write your code here
        if(stack2.isEmpty()){
    		while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}
    	}
    	return stack2.peek();
    }
}
