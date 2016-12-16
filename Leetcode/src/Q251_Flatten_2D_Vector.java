import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Q251_Flatten_2D_Vector implements Iterator<Integer>{
	private Queue<Iterator<Integer>> queue;
	private Iterator<Integer> current;
	
	public Q251_Flatten_2D_Vector(List<List<Integer>> vec2d) {
        queue = new LinkedList<Iterator<Integer>>();
        
        for(int i = 0; i < vec2d.size(); i++){
        	queue.offer(vec2d.get(i).iterator());     // iterator的应用 ！！！
        }
        
        current = queue.poll();
    }

    @Override
    public Integer next() {       // 注意这部分的写法 ！！！
    	if(current.hasNext()){
            return current.next();
        } else {
            if(hasNext() == true){
                return current.next();
            } else {
                return -1;
            }
        }
    }

    @Override
    public boolean hasNext() {
    	if (current == null) {
    		return false;
    	}

        while (!current.hasNext()) {   // 防止test case [[1], [], []]情况的出现
            if (!queue.isEmpty()) {
                current = queue.poll();
            } else {
            	return false;
            }
        }

        return true;
    }
}
