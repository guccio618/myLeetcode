import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Stack;

public class Q012_Min_Stack {
	protected Queue<Integer> heap;
	protected Comparator<Integer> ListNodeComparator = new Comparator<Integer>() {
    	public int compare(Integer left, Integer right) {
    		return left - right;
    	}
    };
    private Stack<Integer> myStack;
    
    public Q012_Min_Stack() {
        // do initialize if necessary
        heap = new PriorityQueue<Integer>(10, ListNodeComparator);
        myStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
    	myStack.add(number);
        heap.offer(number);
    }

    public int pop() {
        // write your code here
    	int num = myStack.pop();
    	heap.remove(num);
    	return num;
    }

    public int min() {
        // write your code here
    	return heap.peek();
    }
    
    
    
    public static void main(String[] args){
    	Q012_Min_Stack t = new Q012_Min_Stack();
    	t.push(1);
    	System.out.println(t.min());
    	t.pop();
    	t.push(2);
    	t.push(3);
    	System.out.println(t.min());
    	t.push(1);
    	System.out.println(t.min());
    	t.push(5);
    	System.out.println(t.min());
    	t.push(-1);
    	System.out.println(t.min());
    }
    
}
