import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Q004_Ugly_Number {
	// by ninechapter	
	public long kthPrimeNumber(int k) {
        // write your code here
        if(k <= 0){
            return Long.valueOf(0);
        }
        
        Queue<Long> myQueue = new PriorityQueue<Long>();
        Set<Long> mySet = new HashSet<Long>();
        long[] factors = new long[3];
        factors[0] = Long.valueOf(3);
        factors[1] = Long.valueOf(5);
        factors[2] = Long.valueOf(7);
        Long number = Long.valueOf(0);
        
        for(int i = 0; i < 3; ++i){
            mySet.add(factors[i]);
        }
        
        for(int i = 0; i < k; ++i){
            number = myQueue.poll();
            for(int j = 0; j < 3; ++j){
                if(!mySet.contains(factors[j] * number)){
                    mySet.add(factors[j] * number);
                    myQueue.add(factors[j] * number);
                }
            }
        }
        return number;
    }
}
