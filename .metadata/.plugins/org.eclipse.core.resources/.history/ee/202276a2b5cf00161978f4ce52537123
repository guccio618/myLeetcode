import java.util.Iterator;
/*********************************************
 * 因为要实现peek(), 因此需要提前存一个next
 * 
 *********************************************/

public class Q284_Peeking_Iterator {
	class PeekingIterator implements Iterator<Integer> {
		private Integer next = null;
	    private Iterator<Integer> iter;

		public PeekingIterator(Iterator<Integer> iterator) {
		    // initialize any member here.
			iter = iterator;
			
			if(iter.hasNext()){
				next = iter.next();
			} 
		}

	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
	        return next;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
		    int ans = next;
		    
		    if(iter.hasNext()){
		    	next = iter.next();
		    } else {
		    	next = (Integer) null;
		    }
		    
		    return ans;
		}

		@Override
		public boolean hasNext() {
			return next != (Integer) null;
		}
	}
}
