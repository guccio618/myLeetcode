import java.util.Stack;
/*
入队时，将元素压入s1。
出队时，判断s2是否为空，如不为空，则直接弹出顶元素；如为空，则将s1的元素逐个“倒入”s2，把最后一个元素弹出并出队。
这个思路，避免了反复“倒”栈，仅在需要时才“倒”一次。
*/

public class Q232_Implement_Queue_using_Stacks {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	if(s1.isEmpty() && s2.isEmpty()) return;
    	if(!s2.isEmpty()){
    		System.out.print(s2.pop() + ", ");
    	}
    	else{
    		int n = s1.size();
    		while(n-- > 1)
    			s2.push(s1.pop());
    		System.out.print(s1.pop() + ", ");
    	}
    }

    // Get the front element.
    public int peek() {
       if(s1.isEmpty() && s2.isEmpty()) return -1;
       else if(!s2.isEmpty())
    	   return s2.peek();
       else{
    	   int n = s1.size();
    	   while(n-- >= 1)
    		   s2.push(s1.pop());
    	   return s2.peek();
       }     
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(s1.isEmpty() && s2.isEmpty()) return true;
        else return false;
    }
    
    public static void main(String[] args){
    	Q232_Implement_Queue_using_Stacks s = new Q232_Implement_Queue_using_Stacks();
    	s.push(1);
    	s.push(2);  
    	s.pop();
    	s.push(3);
    	s.push(4);
    	s.pop();
    	System.out.println("result: " + s.peek());
    }
}
