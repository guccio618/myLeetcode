import java.util.*;

public class Other_Mini_Queue {
	private Queue<Integer> queue;
	private Deque<Integer> dq;
	
	public Other_Mini_Queue() {
		queue = new LinkedList<Integer>();
        dq = new LinkedList<Integer>();
    }
    
    public void add(int x) {
        queue.offer(x);
        
        while(!dq.isEmpty() && dq.peekLast() > x) {
        	dq.pollLast();
        }

        dq.offer(x);        
    }
    
    public void poll() {
        if(queue.isEmpty()) {
        	return ;
        }
        
        int num = queue.poll();
        
        if(num <= dq.peekFirst()) {
        	dq.pollFirst();
        }
    }
    
    public int peek() {
        if(queue.isEmpty()) {
        	return -1;
        } else {
        	return queue.peek();
        } 
    }
    
    public int getMin() {
        if(dq.isEmpty()) {
        	return -1;
        } else {
        	return dq.peekFirst();
        }
    }
    
    
    
    
    public static void main(String[] args) {
    	Other_Mini_Queue t = new Other_Mini_Queue();
    	
    	t.add(3);
    	System.out.println("peek is: " + t.peek() + ", min is: " + t.getMin());
    	t.add(2);
    	System.out.println("peek is: " + t.peek() + ", min is: " + t.getMin());
    	t.add(5);
    	System.out.println("peek is: " + t.peek() + ", min is: " + t.getMin());
    	t.add(1);
    	System.out.println("peek is: " + t.peek() + ", min is: " + t.getMin());
    	t.add(6);
    	System.out.println("peek is: " + t.peek() + ", min is: " + t.getMin());
    	
    	System.out.println();
    	
    	System.out.println("peek is: " + t.peek() + ", min is: " + t.getMin());
    	t.poll();
    	System.out.println("peek is: " + t.peek() + ", min is: " + t.getMin());
    	t.poll();
    	System.out.println("peek is: " + t.peek() + ", min is: " + t.getMin());
    	t.poll();
    	System.out.println("peek is: " + t.peek() + ", min is: " + t.getMin());
    	t.poll();
    	System.out.println("peek is: " + t.peek() + ", min is: " + t.getMin());
    	t.poll();
    	System.out.println("peek is: " + t.peek() + ", min is: " + t.getMin());
    	t.poll();
    	System.out.println("peek is: " + t.peek() + ", min is: " + t.getMin());
    	
    }
}
