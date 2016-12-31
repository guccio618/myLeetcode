import java.util.Stack;
/*****
 * 
Design a stack that supports push, pop, top, 
and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 * 
 * */

public class Q155_Min_Stack {
	/**************************************************
	 * 如何用stack记录当前最小值
	 * 
	 **************************************************/
	
	// solution 1: using two stacks
	private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();  
    
    public void push(int x) {
    	stack.push(x);
        if(min.isEmpty()){
            min.push(x);
        } else {
            min.push(Math.min(x, min.peek()));
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        stack.pop();
        min.pop();
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if(min.isEmpty()){
            return -1;
        }
        return min.peek();
    }
    

    
    
   /*****
    // solution 2: using two lists
    
    private List<Integer> list1;
    private List<Integer> list2;
    
    public MinStack() {
        list1 = new LinkedList();
        list2 = new LinkedList();
    }
    
    public void push(int x) {
        list1.add(x);
        
        if(list2.size() == 0) {
            list2.add(x);
        } else {
            list2.add(Math.min(list2.get(list2.size() - 1), x));
        }
    }
    
    public void pop() {
        if(list1.size() == 0) {
            return ;
        }
        
        list1.remove(list1.size() - 1);
        list2.remove(list2.size() - 1);
    }
    
    public int top() {
        if(list1.size() == 0) {
            return -1;
        }
        
        return list1.get(list1.size() - 1);
    }
    
    public int getMin() {
        if(list2.size() == 0) {
            return -1;
        }
        
        return list2.get(list2.size() - 1);
    }
	
    
    ********/
    
    
    
    
    
    
    
    
    
    /*********************************** main function **************************************/
    
    public static void main(String[] args){
    	Q155_Min_Stack ms = new Q155_Min_Stack();
    	ms.push(395);
    	System.out.print(ms.getMin() + ", ");
    	System.out.print(ms.top() + ", ");
    	System.out.print(ms.getMin() + ", ");
    	ms.push(276);
    	ms.push(29);
    	System.out.print(ms.getMin() + ", ");
    	ms.push(-482);
    	System.out.print(ms.getMin() + ", ");
    	ms.pop();
    	ms.push(-108);
    	ms.push(-251);
    	System.out.print(ms.getMin() + ", ");
    	ms.push(-439);
    	System.out.print(ms.top() + ", ");
    	ms.push(370);
    	ms.pop();
    	ms.pop();
    	System.out.print(ms.getMin() + ", ");
    	ms.pop();
    	System.out.print(ms.getMin() + ", ");
    	System.out.print(ms.getMin() + ", ");
    	System.out.print(ms.top() + ", ");
    	
    }
}
