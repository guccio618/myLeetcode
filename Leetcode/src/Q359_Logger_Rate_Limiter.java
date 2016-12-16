import java.util.HashMap;
import java.util.Map;


public class Q359_Logger_Rate_Limiter {
	// by Jackie
	private Map<String, Integer> map;
    
    /** Initialize your data structure here. */
    public Q359_Logger_Rate_Limiter() {
        map = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(map.containsKey(message)){
            int preTimestamp = map.get(message);
            if(timestamp - preTimestamp >= 10){
                map.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        } else {
            map.put(message, timestamp);
            return true;
        }
    }
}
