import java.util.LinkedList;
import java.util.Queue;
/******
 * 
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
	MovingAverage m = new MovingAverage(3);
	m.next(1) = 1
	m.next(10) = (1 + 10) / 2
	m.next(3) = (1 + 10 + 3) / 3
	m.next(5) = (10 + 3 + 5) / 3
	
 * 
 * */

public class Q346_Moving_Average_from_Data_Stream {
	private Queue<Integer> q;
    private int size = 0;
    private double sum = 0;

    /** Initialize your data structure here. */
    public Q346_Moving_Average_from_Data_Stream(int size) {
        if(size <= 0){
            return;
        }
        q = new LinkedList<Integer>();
        this.size = size;
    }
    
    public double next(int val) {
        if(size == 0){
            return 0;
        }
        
        if(q.size() >= size){
            sum -= q.poll();
        }
        sum += val;
        q.offer(val);
        return sum / q.size();
    }
}
