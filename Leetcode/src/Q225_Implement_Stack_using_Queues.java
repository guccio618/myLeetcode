import java.util.LinkedList;
import java.util.Queue;


public class Q225_Implement_Stack_using_Queues {
	Queue<Integer> q1 = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
        int num = q1.size();
        while(num-- > 1)
        	q1.add(q1.poll());
    }

    // Removes the element on top of the stack.
    public void pop() {
    	if(q1.size() <= 0) return;
        System.out.print(q1.poll() + ", ");
    }

    // Get the top element.
    public int top() {
    	if(q1.size() <= 0) return -1;
        return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
       return q1.isEmpty();
    }
	
//************* 以下用的是两个队列来完成 ***************/	
    
//	Queue<Integer> q1 = new LinkedList<Integer>();
//	Queue<Integer> q2 = new LinkedList<Integer>();
//    boolean q1_used = true, q2_used = false;
//    
//    // Push element x onto stack.
//    public void push(int x) {
//        if(q1_used)
//            q1.add(x);
//        else if(q2_used)
//            q2.add(x);
//    }
//
//    // Removes the element on top of the stack.
//    public void pop() {
//        if(!q1.isEmpty() && q1_used){
//            int n = q1.size();
//            while(n-- > 1){
//                q2.add(q1.poll());
//            }
//            q1.poll();
//            q1_used = false;
//            q2_used = true;
//        }
//        else if(!q2.isEmpty() && q2_used){
//            int n = q2.size();
//            while(n-- > 1){
//                q1.add(q2.poll());
//            }
//            q2.poll();
//            q2_used = false;
//            q1_used = true;
//        }
//    }
//
//    // Get the top element.
//    public int top() {
//        if(!q1.isEmpty() && q1_used){
//            int n = q1.size();
//        	while(n-- > 1)
//                q2.add(q1.poll());
//            return q1.peek();
//        }
//        else if(!q2.isEmpty() && q2_used){
//            int n = q2.size();
//        	while(n-- > 1)
//                q1.add(q2.poll());
//            return q2.peek();
//        }
//        else
//        	return -1;
//    }
//
//    // Return whether the stack is empty.
//    public boolean empty() {
//        if(q1.isEmpty() && q2.isEmpty())
//            return true;
//        else 
//        	return false;
//    }
    
    public static void main(String[] args){
    	Q225_Implement_Stack_using_Queues q = new Q225_Implement_Stack_using_Queues();
    	for(int i = 1; i < 10; i++){
    		q.push(i);
    	}
    	System.out.println(q.top());
    	for(int i = 1; i < 9; i++){
    		q.pop();
    	}
    	System.out.println("result: " + q.top());
    }
}
