import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Q379_Design_Phone_Directory {
	private Queue<Integer> available = new LinkedList<Integer>();
    private Set<Integer> used = new HashSet<Integer>();
    private int capacity;
    
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public Q379_Design_Phone_Directory(int maxNumbers) {
        capacity = maxNumbers;
        
        for(int i = 0; i < capacity; i++){
            available.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        Integer ans = available.poll();
        
        if(ans == null){
            return -1;
        } else {
            used.add(ans);
            return ans;
        }
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
        if(used.contains(number)){
            used.remove(number);
            available.offer(number);
        } 
    }
}
