import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
/*******
 * 
Design a Phone Directory which supports the following operations:

get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.
Example:

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);

 * 
 * */

public class Le_379_Design_Phone_Directory {
	private Queue<Integer> numberPool = new LinkedList<Integer>();
    private Set<Integer> used = new HashSet<Integer>();
    private int capacity;
    
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public Le_379_Design_Phone_Directory(int maxNumbers) {
        capacity = maxNumbers;
        
        for(int i = 0; i < capacity; i++){
            numberPool.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
    	if(used.size() == capacity) {
            return -1;
        }
        
        int ans = numberPool.poll();
        used.add(ans);
        return ans;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        if(number < 0 || number >= capacity){
            return false;
        } else {
            return !used.contains(number);
        }
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
    	if(!used.contains(number)) {
            return;
        }
        
        used.remove(number);
        numberPool.offer(number);
    }
}
