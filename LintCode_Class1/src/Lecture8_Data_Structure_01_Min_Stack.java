import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class Lecture8_Data_Structure_01_Min_Stack {
	protected Queue<Integer> heap;
	protected Comparator<Integer> ListNodeComparator = new Comparator<Integer>() {
    	public int compare(Integer left, Integer right) {
    		return left - right;
    	}
    };
    private Stack<Integer> myStack;
    
    public Lecture8_Data_Structure_01_Min_Stack() {
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
    
    
    
    /******************************************************/
    // 方法2: 使用两个stack来处理，一个存数据，一个存当前对应的最小值 
}
