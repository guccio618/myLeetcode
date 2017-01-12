import java.util.*;
/*******
 * 
Follow up: How would you extend your design to be generic and work with all types, not just integer?
Solution: do not give the type to the Iterator

 * 
 * */


public class Q284_Peeking_Iterator_FollowUp implements Iterator<Object> {
	
	private Object next = null;
    private Iterator<Object> iter;

	public Q284_Peeking_Iterator_FollowUp(Iterator<Object> iterator) {
	    // initialize any member here.
		iter = iterator;
		
		if(iter.hasNext()){
			next = iter.next();
		} 
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Object peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Object next() {
		Object ans = next;
	    
	    if(iter.hasNext()){
	    	next = iter.next();
	    } else {
	    	next = (Object) null;
	    }
	    
	    return ans;
	}

	@Override
	public boolean hasNext() {
		return next != (Object) null;
	}
	
	
	
	
	
	
	
	
	
	
	/****************************** main function ***********************************/
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator iter = list.iterator();		
		Q284_Peeking_Iterator_FollowUp t = new Q284_Peeking_Iterator_FollowUp(iter);
		
		while(t.hasNext()) {
			System.out.println(t.peek());
			System.out.println(t.next());
		}		
	}
}
