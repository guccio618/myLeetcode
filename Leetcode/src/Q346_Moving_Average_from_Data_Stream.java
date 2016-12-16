import java.util.LinkedList;
import java.util.Queue;


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
