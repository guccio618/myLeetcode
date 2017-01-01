import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Q281_Zigzag_Iterator {
	private Queue<Iterator> queue;  // 注意存入queue的时候，保证存入的队列有hasNext才入队;

    public Q281_Zigzag_Iterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<Iterator>();
        
        if(!v1.isEmpty()){
            queue.offer(v1.iterator());
        }
        if(!v2.isEmpty()){
            queue.offer(v2.iterator());
        }
    }

    public int next() {
        if(!hasNext()){
            return -1;
        } else {
            Iterator<Integer> iter = queue.poll();
            int ans = (Integer) iter.next();
            
            if(iter.hasNext()){
                queue.offer(iter);
            }
            
            return ans;
        }
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
