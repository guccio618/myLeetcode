import java.util.LinkedList;
import java.util.Queue;

public class Q494_Implement_Stack_by_Two_Queues {
	/***************************************************************************/
	// by other using one queue
	Queue<Integer> q1 = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		q1.add(x);
		int num = q1.size();
		while (num-- > 1)
			q1.add(q1.poll());
	}

	// Removes the element on top of the stack.
	public void pop() {
		if (q1.size() <= 0)
			return;
		System.out.print(q1.poll() + ", ");
	}

	// Get the top element.
	public int top() {
		if (q1.size() <= 0)
			return -1;
		return q1.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q1.isEmpty();
	}

	// /***************************************************************************/
	// // by Jackie using two queue
	// private Queue<Integer> q1 = new LinkedList<Integer>();
	// private Queue<Integer> q2 = new LinkedList<Integer>();
	// private boolean q1_used = true, q2_used = false;
	//
	// public void push(int x) {
	// // Write your code here
	// if(q1_used == true){
	// q1.add(x);
	// }
	// else if(q2_used == true){
	// q2.add(x);
	// }
	// }
	//
	// // Pop the top of the stack
	// public void pop() {
	// // Write your code here
	// if(!q1.isEmpty() && q1_used == true){
	// int n = q1.size();
	// while(n-- > 1){
	// q2.add(q1.poll());
	// }
	// q1.poll();
	// q1_used = false;
	// q2_used = true;
	// }
	// else if(!q2.isEmpty() && q2_used == true){
	// int n = q2.size();
	// while(n-- > 1){
	// q1.add(q2.poll());
	// }
	// q2.poll();
	// q2_used = false;
	// q1_used = true;
	// } else{
	//	      return -1;
	//   }	
	// }
	//
	// // Return the top of the stack
	// public int top() {
	// // Write your code here
	// if(!q1.isEmpty() && q1_used == true){
	// int n = q1.size();
	// while(n-- > 1){
	// q2.add(q1.poll());
	// }
	// return q1.peek();
	// } else if(!q2.isEmpty() && q2_used == true){
	// int n = q2.size();
	// while(n-- > 1){
	// q1.add(q2.poll());
	// }
	// return q2.peek();
	// } else{
	// return -1;
	// }
	// }
	//
	// // Check the stack is empty or not.
	// public boolean isEmpty() {
	// // Write your code here
	// return (q1.isEmpty() && q2.isEmpty());
	// }
}
