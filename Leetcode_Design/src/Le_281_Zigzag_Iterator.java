import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*********
 * 
Given two 1d vectors, implement an iterator to return their elements alternately.

For example, given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question - Update (2015-09-18):
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

[1,2,3]
[4,5,6,7]
[8,9]
It should return [1,4,8,2,5,9,3,6,7].
 * 
 * */

public class Le_281_Zigzag_Iterator {
	// 注意存入queue的时候，保证存入的队列有hasNext才入队;
	private Queue<Iterator> queue;  

    public Le_281_Zigzag_Iterator(List<Integer> v1, List<Integer> v2) {
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
            Iterator iter = queue.poll();
            int ans = (int) iter.next();
            
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
