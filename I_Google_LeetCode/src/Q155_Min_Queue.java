import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;

/******
 * 
 * follow up for Q155_Min_Stack
 * 
 * */


public class Q155_Min_Queue {
	private Queue<Integer> queue = new LinkedList<>();
    private Deque<Integer> dq = new LinkedList<>();  
    
    public void add(int x) {
    	queue.offer(x);
    	
        while(!dq.isEmpty() && x < dq.peekLast()) {
        	dq.pollLast();
        }
        
        dq.offer(x);
    }

    public void poll() {
        if(queue.isEmpty()){
            return;
        }
        
        int num = queue.poll();
        
        if(dq.peekFirst() == num) {
        	dq.pollFirst();
        }
    }

    public int top() {
        if(queue.isEmpty()){
            return -1;
        }
        
        return queue.peek();
    }

    public int getMin() {
        if(dq.isEmpty()){
            return -1;
        }
        
        return dq.peekFirst();
    }
    
    
    
    
    
    
    
    
    
    /************ main function **************/
    public static void main(String[] args) {
    	Q155_Min_Queue t = new Q155_Min_Queue(); 
    	t.add(5);
    	System.out.println(t.getMin() + " " + t.top());
    	t.add(6);
    	System.out.println(t.getMin() + " " + t.top());
    	t.add(2);
    	System.out.println(t.getMin() + " " + t.top());
    	t.add(7);
    	System.out.println(t.getMin() + " " + t.top());
    	t.add(3);
    	System.out.println(t.getMin() + " " + t.top());
    	
    	System.out.println("*********");
    	
    	t.poll();
    	System.out.println(t.getMin() + " " + t.top());
    	t.poll();
    	System.out.println(t.getMin() + " " + t.top());
    	t.poll();
    	System.out.println(t.getMin() + " " + t.top());
    	t.poll();
    	System.out.println(t.getMin() + " " + t.top());
    	t.poll();
    	System.out.println(t.getMin() + " " + t.top());

    }
}
